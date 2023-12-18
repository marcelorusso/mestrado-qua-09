package mestrado.ipt.br.qualidade.teste.sut.mutation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mestrado.ipt.br.qualidade.teste.impl.AvaliacaoHipossuficiencia;

public class AvaliacaoHipossuficienciaMutationTest {
	
	
	@Test
	public void assertConcessao() {
		assertTrue(new AvaliacaoHipossuficiencia(false, 1, 1, false).isAtendimentoConcedido());
	}

}
