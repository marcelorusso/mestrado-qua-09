package mestrado.ipt.br.qualidade.teste.sut;

import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.provider.Arguments;

class AvaliacaoHipossuficienciaPairwiseTest implements AvaliacaoTest {

	


	@SuppressWarnings("unused")
	private static Stream<Arguments> provideTestCaseConcessao() {
		return Stream.of(
				Arguments.of(Named.of("Caso 1", null), 4, 6, false, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO), 
				Arguments.of(Named.of("Caso 3", null), 3, 6, false, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO), 
				Arguments.of(Named.of("Caso 5", null), 0, 5, false, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO), 
				Arguments.of(Named.of("Caso 6", null), 0, 5, false, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO), 
				Arguments.of(Named.of("Caso 7", null), 5, 5, true, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),   	 
				Arguments.of(Named.of("Caso 8", null), 5, 4, false, false, AvaliacaoTest.ATENDIMENTO_NEGADO),	 
				Arguments.of(Named.of("Caso 11", null), 4, 1, true, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),	
				Arguments.of(Named.of("Caso 12", null), 4, 6, false, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),	
				Arguments.of(Named.of("Caso 14", null), 3, 5, true, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 16", null), 0, 1, false, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 17", null), 5, 1, true, false, AvaliacaoTest.ATENDIMENTO_NEGADO),
				Arguments.of(Named.of("Caso 18", null), 5, 6, false, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 21", null), 4, 4, false, false, AvaliacaoTest.ATENDIMENTO_NEGADO),
				Arguments.of(Named.of("Caso 22", null), 4, 5, true, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 23", null), 3, 4, false, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 24", null), 3, 1, true, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 25", null), 0, 6, true, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO)); 
	}

	/**
	 * Concentra todos os casos de quebra de contrato da invariante 
	 * numeroDeMembrosFamiliares > 0
	 * @return Stream de argumentos
	 */
	@SuppressWarnings("unused")
	private static Stream<Arguments> provideTestCaseInvarianteMembros() {
		return Stream.of(
				Arguments.of(Named.of("Caso 2", null), 4, 0, false, false), 
				Arguments.of(Named.of("Caso 4", null), 3, 0, false, false),
				Arguments.of(Named.of("Caso 15", null), 0, 0, false, false),
				Arguments.of(Named.of("Caso 13", null), 3, 0, false, false),
				Arguments.of(Named.of("Caso 26", null), 5, 0, false, false)
				); 
	}
	
	/**
	 * Concentra todos os casos de quebra de contrato da invariante 
	 * rendaFamiliar < 0
	 * @return Stream de argumentos
	 */
	@SuppressWarnings("unused")
	private static Stream<Arguments> provideTestCaseInvarianteRenda() {
		return Stream.of(
				Arguments.of(Named.of("Caso 9", null), -1, 1, false, true),
				Arguments.of(Named.of("Caso 10", null), -1, 6, true, false),
				Arguments.of(Named.of("Caso 19", null), -1, 5, true, false),
				Arguments.of(Named.of("Caso 20", null), -1, 4, true, true),
				Arguments.of(Named.of("Caso 27", null), -1, 0, true, true)
				); 
	}

}
