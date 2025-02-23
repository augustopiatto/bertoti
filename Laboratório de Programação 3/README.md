## Exemplo

A pasta "exemplo" contém apenas o método GET do HTTP, trazendo todas as informações do mock da sua classe.
O intuito desta página é exibir de forma simplificada como realizar o fluxo de uma requisição, partindo do front-end até o back-end

## Projeto

A pasta "projeto" contém o CRUD com front-end pedido pelo professor em sala de aula. No meu caso, substitui o exemplo de classe "Café" por "Bolacha" e adicionei outros atributos na classe

### Como rodar

#### Front-end

Vá até a pasta do seu arquivo "index.html", localizada na pasta de front e clique 2x nele para abrir no navegador

#### Back-end

Abra o terminal da sua IDE (VsCode, IntelliJ, etc...), navegue até a pasta ".../java/sbur-rest-demo", que é onde está a sua pasta "target" e rode o comando:

```
mvn spring-boot:run
```

O comando irá instalar as dependências, gerar a pasta "target", caso não esteja criada, e irá executar o seu back-end.

OBS: Para conseguir acessar o endpoint através do front-end, é necessário colocar o código:

```
@CrossOrigin(origins = "*")
```

Acima do método do back-end que deseja acessar, para que não tome erro de CORS
