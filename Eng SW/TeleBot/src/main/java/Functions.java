import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.exceptions.ToolInvocationException;
import io.github.ollama4j.tools.OllamaToolsResult;
import io.github.ollama4j.tools.Tools;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;

public class Functions {
    public String teste(OllamaAPI ollamaAPI, String prompt) throws Exception {
        Tools.ToolSpecification fuelPriceToolSpecification = Tools.ToolSpecification.builder()
                .functionName("current-fuel-price")
                .functionDescription("Get current fuel price")
                .properties(
                        new Tools.PropsBuilder()
                                .withProperty("location", Tools.PromptFuncDefinition.Property.builder().type("string").description("The city, e.g. New Delhi, India").required(true).build())
                                .withProperty("fuelType", Tools.PromptFuncDefinition.Property.builder().type("string").description("The fuel type.").enumValues(Arrays.asList("petrol", "diesel")).required(true).build())
                                .build()
                )
                .toolDefinition(SampleTools::getCurrentFuelPrice)
                .build();

        ollamaAPI.registerTool(fuelPriceToolSpecification);

        String response = "";
        if (prompt.equals("Qual é o preço do petróleo no Brasil?")) {
            String promptBuilt = new Tools.PromptBuilder()
                    .withToolSpecification(fuelPriceToolSpecification)
                    .withPrompt(prompt)
                    .build();
            response = ask(ollamaAPI, promptBuilt);
//            response = promptBuilt;
        }

        return response;
    }

    public static String ask(OllamaAPI ollamaAPI, String prompt) throws OllamaBaseException, IOException, InterruptedException, ToolInvocationException {
        try {
            ollamaAPI.pullModel("gemma2:2b");
        } catch (OllamaBaseException | IOException | URISyntaxException | InterruptedException e) {
            System.out.println("Erro ao baixar o modelo: " + e.getMessage());
        }
        String model = "gemma2:2b";

        System.out.println("chegou aqui");
        OllamaToolsResult toolsResult = ollamaAPI.generateWithTools(model, prompt, new OptionsBuilder().build());
        System.out.println("passou do tools aqui");

        StringBuilder resultBuilder = new StringBuilder();
        for (OllamaToolsResult.ToolResult r : toolsResult.getToolResults()) {
            resultBuilder.append(String.format("[Result of executing tool '%s']: %s%n", r.getFunctionName(), r.getResult().toString()));
        }
        System.out.println("resultBuilder" + resultBuilder);

        return resultBuilder.toString();
    }
}

class SampleTools {
    public static String getCurrentFuelPrice(Map<String, Object> arguments) {
        // Get details from fuel price API
        String location = arguments.get("location").toString();
        String fuelType = arguments.get("fuelType").toString();
        return "O preço do " + fuelType + " no " + location + " é de R$10/L";
    }
}
