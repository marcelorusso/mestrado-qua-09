package mestrado.ipt.br.qualidade.teste.sut;

import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.provider.Arguments;

public class AvaliacaoHipossuficienciaTDTest implements AvaliacaoTest {
	
	/**
	 * Tabela de decisão
		Valores        1   2   3   4   5   6   7   8   9   10
		Condições
		            R -1   0   1   3   4   4   4   4   5   5
		            M  1  -1   1   5   5   6   2   6   1   1
		            C  F   T   F   T   F   F   T   T   T   F
		            E  T   F   F   F   F   F   F   F   F   T
		
		Ações          F   F   T   T   F   T   T   T   F   T
	
	**/
	
	
	@SuppressWarnings("unused")
	private static Stream<Arguments> provideTestCaseConcessao() {
		return Stream.of(
				Arguments.of(Named.of("Caso 3", null), 1, 1, false, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO), 
				Arguments.of(Named.of("Caso 4", null), 3, 5, true, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO), 
				Arguments.of(Named.of("Caso 5", null), 4, 5, false, false, AvaliacaoTest.ATENDIMENTO_NEGADO), 
				Arguments.of(Named.of("Caso 6", null), 4, 6, false, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO), 
				Arguments.of(Named.of("Caso 7", null), 4, 2, true, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),   	 
				Arguments.of(Named.of("Caso 8", null), 4, 6, true, false, AvaliacaoTest.ATENDIMENTO_CONCEDIDO),	 
				Arguments.of(Named.of("Caso 9", null), 5, 1, true, false, AvaliacaoTest.ATENDIMENTO_NEGADO),	
				Arguments.of(Named.of("Caso 10", null), 5, 1, false, true, AvaliacaoTest.ATENDIMENTO_CONCEDIDO)); 
	}

	/**
	 * Concentra todos os casos de quebra de contrato da invariante 
	 * numeroDeMembrosFamiliares > 0
	 * @return Stream de argumentos
	 */
	@SuppressWarnings("unused")
	private static Stream<Arguments> provideTestCaseInvarianteMembros() {
		return Stream.of(
				Arguments.of(Named.of("Caso 2", null), 0, -1, false, false)); 
	}
	
	/**
	 * Concentra todos os casos de quebra de contrato da invariante 
	 * rendaFamiliar < 0
	 * @return Stream de argumentos
	 */
	@SuppressWarnings("unused")
	private static Stream<Arguments> provideTestCaseInvarianteRenda() {
		return Stream.of(
				Arguments.of(Named.of("Caso 1", null), -1, 1, false, true)); 
	}


}
