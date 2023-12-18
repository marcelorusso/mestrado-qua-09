package mestrado.ipt.br.qualidade.teste.main;

import mestrado.ipt.br.qualidade.teste.impl.AvaliacaoHipossuficiencia;
import mestrado.ipt.br.qualidade.teste.interfaces.Avaliacao;

public class Run {

	public static void main(String[] args) {
		Avaliacao avaliacao = new AvaliacaoHipossuficiencia(false, 0, 1, false);
		System.out.println("Atendimento concedido: " + avaliacao.avaliarElegibilidade());
	}

}
