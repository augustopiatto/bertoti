public class WeatherDisplayCoupled {
    private String name;

    public WeatherDisplayCoupled(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return name;
    }

    public void showData(float temperature, float humidity, float pressure) {
        System.out.println(name + " recebeu novos dados:");
        System.out.println("Temperatura: " + temperature + "°C");
        System.out.println("Umidade: " + humidity + "%");
        System.out.println("Pressão: " + pressure + " hPa\n");
    }
}
