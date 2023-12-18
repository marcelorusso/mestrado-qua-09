package mestrado.ipt.br.qualidade.teste.sut;

import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.provider.Arguments;

public class AvaliacaoHipossuficienciaCCETest implements AvaliacaoTest {

	
	@SuppressWarnings("unused")
	private static Stream<Arguments> provideTestCaseConcessao() {
		return Stream.of(
				Arguments.of(Named.of("Caso 2", null), 0, 1, true, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 3", null), 1, 2, true, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 4", null), 2, 3, true, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 5", null), 3, 4, false, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 6", null), 4, 4, false, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 7", null), 5, 6, false, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),
				Arguments.of(Named.of("Caso 9", null), 5, 4, false, false, AvaliacaoTest.ATENDIMENTO_NEGADO)); 
	}

	/**
	 * Concentra todos os casos de quebra de contrato da invariante 
	 * numeroDeMembrosFamiliares > 0
	 * @return Stream de argumentos
	 */
	private static Stream<Arguments> provideTestCaseInvarianteMembros() {
		return Stream.of(Arguments.of(Named.of("Caso 8", null), 0, 0,  false, false)); 
	}
	
	/**
	 * Concentra todos os casos de quebra de contrato da invariante 
	 * rendaFamiliar < 0
	 * @return Stream de argumentos
	 */
	private static Stream<Arguments> provideTestCaseInvarianteRenda() {
		return Stream.of(
				Arguments.of(Named.of("Caso 1", null), -1, 0,  true, false)
				); 
	}
}
