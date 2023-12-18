package mestrado.ipt.br.qualidade.teste.sut;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import mestrado.ipt.br.qualidade.teste.impl.AvaliacaoHipossuficiencia;

public interface AvaliacaoTest {
	
	public static final Boolean ATENDIMENTO_CONCEDIDO = Boolean.TRUE;
	public static final Boolean ATENDIMENTO_NEGADO = Boolean.FALSE;
	
	@ParameterizedTest
	@MethodSource("provideTestCaseConcessao")
	default void testAvaliacaoHipossuficiencia(String name, double rendaFamiliar, int numMembros, boolean possuiCondicaoEspecial,
			boolean atendimentoExcepcional, boolean expectedResult) {
		AvaliacaoHipossuficiencia avaliacao = new AvaliacaoHipossuficiencia(atendimentoExcepcional, rendaFamiliar,
				numMembros, possuiCondicaoEspecial);
		boolean atendimentoConcedido = avaliacao.isAtendimentoConcedido();
		assertEquals(expectedResult, atendimentoConcedido);
	}
	
	@ParameterizedTest
	@MethodSource("provideTestCaseInvarianteMembros")
	default void testAvaliacaoHipossuficienciaInvarianteMembros(String name, double rendaFamiliar, int numMembros,
			boolean possuiCondicaoEspecial, boolean atendimentoExcepcional) {
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new AvaliacaoHipossuficiencia(atendimentoExcepcional, rendaFamiliar, numMembros, possuiCondicaoEspecial);
		});

		Assertions.assertEquals("O n�mero de membros da fam�lia deve ser maior que zero.", thrown.getMessage());
	}
	
	
	@ParameterizedTest
	@MethodSource("provideTestCaseInvarianteRenda")
	default void testAvaliacaoHipossuficienciaInvarianteRenda(String name, double rendaFamiliar, int numMembros,
			boolean possuiCondicaoEspecial, boolean atendimentoExcepcional) {
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new AvaliacaoHipossuficiencia(atendimentoExcepcional, rendaFamiliar, numMembros, possuiCondicaoEspecial);
		});

		Assertions.assertEquals("A renda familiar n�o pode ser negativa.", thrown.getMessage());
	}

}
