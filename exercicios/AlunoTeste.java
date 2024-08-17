import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlunoTeste {
	@Test
	void test() {
		SalaAula fatec = new SalaAula();
		Aluno joao = new Aluno("Joao", "12345");
		fatec.cadastrarAluno(joao);
		assertEquals(fatec.getAlunos().size(), 1);
	}

}
