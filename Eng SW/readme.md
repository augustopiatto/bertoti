1. We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.<br><br>
    R: Os pontos que irão definir um engenheiro de software e a forma que este será cobrado durante seu trabalho, são tempo, escalabilidade e negociações do produto. A visão que um engenheiro de software deve ter é global sobre seu produto, imaginando ele como um todo, para que possa ter noção de prazos, imprevistos e tamanho que este irá tomar. Esta visão é necessária, pois é preciso pensar muito bem antes de começar a efetivamente escrevero código, para evitar mudanças do projeto.

2. Citar 3 exemplos de trade-off.<br>
   R: 1. Em um projeto que necessita de refatoração, seguir a opção de criar um novo projeto em uma outra linguagem mais conhecida e rotear o usuário corretamente entre esses dois sistemas, de acordo com as APIs acessadas. Assim, temos uma maior complexidade de arquitetura, mas conseguimos avançar mais rapidamente e facilmente na refatoração, além de melhor manutenção em longo prazo.<br>
      2. Escolha entre: criação de um aplicativo nativo e um site web; ou a criação de um site web com uso de WebApp. O aplicativo nativo pode ser mais performático, possuir mais funcionalidades e coleta de dados que o site web, mas exige que a empresa mantenha dois funcionários, um para o aplicativo e um para o site web, além de uma arquitetura maior e também atualização e criação de features em ambos aplicativos, enquanto o site web com WebView unifica todas as features em um só local.<br>
      3. Escolha entre uma linguagem tipada e uma não tipada para o desenvolvimento do projeto. Enquanto a linguagem tipada oferece claros benefícios de prevenção à erros, a não tipada oferece uma maior velocidade de produção, e possibilita que os desenvolvedores tenham nível de conhecimento menor (apesar disto ocasionar em maior possibilidade de erros)<br>

3. Repetir as classes SalaAula e Aula com um exemplo seu. Com testes automatizados.<br>
    R:
```
// import das classes utilitárias
import java.util.List;<br>
import java.util.LinkedList;<br><br>

// definição da classe da sala<br>
public class SalaAula {<br>
    // atributo da classe<br>
    private List<Aluno> alunos = new LinkedList<Aluno>();<br>
    // métodos para acessar o atributo da classe por fora da classe<br>
    public void cadastrarAluno(Aluno aluno) {<br>
	this.alunos.add(aluno);<br>
    }<br>
    public List<Aluno> getAlunos() {<br>
	return this.alunos;<br>
    }<br>
}
```

```
// definição da classe do aluno<br>
public class Aluno {<br>
    // atributos da classe<br>
    private String nome;<br>
    private String ra;<br>
    // construtor da classe<br>
    public Aluno(String nome, String ra) {<br>
	this.nome = nome;<br>
	this.ra = ra;<br>
    }<br>
    // métodos para acessar o atributo da classe por fora da classe<br>
    public String getNome() {<br>
	return this.nome;<br>
    }<br>
    public String getRa() {<br>
	return this.ra;<br>
    }<br>
}
```

```
// import das classes utilitárias<br>
import static org.junit.jupiter.api.Assertions.*;<br>
import org.junit.jupiter.api.Test;<br>
// definição da classe teste<br>
class AlunoTeste {<br>
    // decorator do teste
    @Test<br>
    void testCadastrarDoisAlunos() {<br>
        // instancia uma sala
	SalaAula sala2BD = new SalaAula();<br>
        // instancia alunos
	Aluno joao = new Aluno("Joao", "12345");<br>
	Aluno jose = new Aluno("Jose", "54321");<br>
 	// cadastra os alunos na sala
	sala2BD.cadastrarAluno(joao);<br>
	sala2BD.cadastrarAluno(jose);<br>
 	// verificase a sala tem os dois alunos cadastrados
	assertEquals(sala2BD.getAlunos().size(), 2);<br>
    }<br><br>

    @Test<br>
    void testTrazPrimeiroAlunoDaLista() {<br>
	SalaAula sala2BD = new SalaAula();<br>
	Aluno augustoJose = new Aluno("Augusto Jose", "123");<br>
	Aluno joseAugusto = new Aluno("Jose Augusto", "321");<br>
	sala2BD.cadastrarAluno(augustoJose);<br>
	sala2BD.cadastrarAluno(joseAugusto);<br>
 	// associa todos alunos da sala em uma variável
	List<Aluno> todosAlunos = sala2BD.getAlunos();<br>
 	// verifica se o primeiro aluno é o primeiro aluno cadastrado
	assertEquals(todosAlunos.get(0).getRa(), augustoJose.getRa());<br>
    }<br><br>

    @Test<br>
    void testAlunosSaoDiferentes() {<br>
	SalaAula sala2BD = new SalaAula();<br>
	Aluno augustoJose = new Aluno("Augusto Jose", "123");<br>
	Aluno joseAugusto = new Aluno("Jose Augusto", "321");<br>
	sala2BD.cadastrarAluno(augustoJose);<br>
	sala2BD.cadastrarAluno(joseAugusto);<br>
	List<Aluno> todosAlunos = sala2BD.getAlunos();<br>
 	// verifica se os dois alunos são diferentes
	assertNotEquals(todosAlunos.get(0).getNome(), todosAlunos.get(1).getNome());<br>
    }<br>
}
```
