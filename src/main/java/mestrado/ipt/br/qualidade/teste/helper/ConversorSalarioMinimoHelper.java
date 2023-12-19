package mestrado.ipt.br.qualidade.teste.helper;

import java.math.BigDecimal;

public class ConversorSalarioMinimoHelper {
	
	public static final BigDecimal VALOR_SALARIO_MINIMO = new BigDecimal(1.320);
	
	public static double converter(BigDecimal rendaFamiliar) {
		return rendaFamiliar.divide(VALOR_SALARIO_MINIMO).doubleValue();
	}

}
