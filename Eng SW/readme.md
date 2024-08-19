1. We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.<br><br>
    R: Os pontos que irão definir um engenheiro de software e a forma que este será cobrado durante seu trabalho, são tempo, escalabilidade e negociações do produto. A visão que um engenheiro de software deve ter é global sobre seu produto, imaginando ele como um todo, para que possa ter noção de prazos, imprevistos e tamanho que este irá tomar. Esta visão é necessária, pois é preciso pensar muito bem antes de começar a efetivamente escrevero código, para evitar mudanças do projeto.

2. Citar 3 exemplos de trade-off.<br>
   R: 1. Em um projeto que necessita de refatoração, seguir a opção de criar um novo projeto em uma outra linguagem mais conhecida e rotear o usuário corretamente entre esses dois sistemas, de acordo com as APIs acessadas. Assim, temos uma maior complexidade de arquitetura, mas conseguimos avançar mais rapidamente e facilmente na refatoração, além de melhor manutenção em longo prazo.<br>
      2. Escolha entre: criação de um aplicativo nativo e um site web; ou a criação de um site web com uso de WebApp. O aplicativo nativo pode ser mais performático, possuir mais funcionalidades e coleta de dados que o site web, mas exige que a empresa mantenha dois funcionários, um para o aplicativo e um para o site web, além de uma arquitetura maior e também atualização e criação de features em ambos aplicativos, enquanto o site web com WebView unifica todas as features em um só local.<br>
      3. Escolha entre uma linguagem tipada e uma não tipada para o desenvolvimento do projeto. Enquanto a linguagem tipada oferece claros benefícios de prevenção à erros, a não tipada oferece uma maior velocidade de produção, e possibilita que os desenvolvedores tenham nível de conhecimento menor (apesar disto ocasionar em maior possibilidade de erros)<br>

3. Repetir as classes SalaAula e Aula com um exemplo seu. Com testes automatizados<br>
    R:
// import das classes utilitárias
import java.util.List;
import java.util.LinkedList;

// definição da classe da sala
public class SalaAula {
    // atributo da classe
	private List<Aluno> alunos = new LinkedList<Aluno>();
    // métodos para acessar o atributo da classe por fora da classe
	public void cadastrarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	public List<Aluno> getAlunos() {
		return this.alunos;
	}
}

// definição da classe do aluno
public class Aluno {
    // atributos da classe
	private String nome;
	private String ra;
	// construtor da classe
	public Aluno(String nome, String ra) {
		this.nome = nome;
		this.ra = ra;
	}
	// métodos para acessar o atributo da classe por fora da classe
	public String getNome() {
		return this.nome;
	}
	public String getRa() {
		return this.ra;
	}
}
