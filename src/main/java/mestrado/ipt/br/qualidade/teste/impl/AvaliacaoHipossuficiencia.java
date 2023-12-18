package mestrado.ipt.br.qualidade.teste.impl;

import mestrado.ipt.br.qualidade.teste.interfaces.Avaliacao;

public class AvaliacaoHipossuficiencia implements Avaliacao {

	private static final double LIMITE_SALARIO_NORMAL = 3.0;
	private static final double LIMITE_SALARIO_EXCECAO = 4.0;
	public static final String ILLEGAL_ARGUMENT_MEMBROS = "O número de membros da família deve ser maior que zero.";
	public static final String ILLEGAL_ARGUMENT_RENDA = "A renda familiar não pode ser negativa.";
	

	private final boolean atendimentoExcepcional;
	private final double rendaFamiliar;
	private final int numeroDeMembrosFamiliares;
	private final boolean possuiCondicaoEspecial;
	private boolean atendimentoConcedido;

	public AvaliacaoHipossuficiencia(boolean atendimentoExcepcional, double rendaFamiliar,
			int numeroDeMembrosFamiliares, boolean possuiCondicaoEspecial) {
		verificarRendaFamiliar(rendaFamiliar);
		verificarNumeroDeMembrosFamiliares(numeroDeMembrosFamiliares);

		this.atendimentoExcepcional = atendimentoExcepcional;
		this.rendaFamiliar = rendaFamiliar;
		this.numeroDeMembrosFamiliares = numeroDeMembrosFamiliares;
		this.possuiCondicaoEspecial = possuiCondicaoEspecial;

		this.atendimentoConcedido = avaliarElegibilidade();
	}

	public boolean avaliarElegibilidade() {
		return processarExcepcionalidades() || verificarLimiteRenda();
	}

	private boolean processarExcepcionalidades() {
		return atendimentoExcepcional;
	}

	private boolean verificarLimiteRenda() {
		return rendaFamiliar <= LIMITE_SALARIO_NORMAL || verificarExcecoesRenda();
	}

	private boolean verificarExcecoesRenda() {
		return rendaFamiliar <= LIMITE_SALARIO_EXCECAO && (numeroDeMembrosFamiliares > 5 || possuiCondicaoEspecial);
	}

	private void verificarRendaFamiliar(double renda) {
		if (renda < 0) {
			throw new IllegalArgumentException(this.ILLEGAL_ARGUMENT_RENDA);
		}
	}

	private void verificarNumeroDeMembrosFamiliares(int numMembros) {
		if (numMembros <= 0) {
			throw new IllegalArgumentException(this.ILLEGAL_ARGUMENT_MEMBROS);
		}
	}

	public boolean isAtendimentoExcepcional() {
		return atendimentoExcepcional;
	}

	public double getRendaFamiliar() {
		return rendaFamiliar;
	}

	public int getNumeroDeMembrosFamiliares() {
		return numeroDeMembrosFamiliares;
	}

	public boolean isPossuiCondicaoEspecial() {
		return possuiCondicaoEspecial;
	}

	public boolean isAtendimentoConcedido() {
		return atendimentoConcedido;
	}

}
