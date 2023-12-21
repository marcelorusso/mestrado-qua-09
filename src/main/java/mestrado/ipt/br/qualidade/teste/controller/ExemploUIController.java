package mestrado.ipt.br.qualidade.teste.controller;

import java.math.BigDecimal;

import mestrado.ipt.br.qualidade.teste.helper.ConversorSalarioMinimoHelper;
import mestrado.ipt.br.qualidade.teste.impl.AvaliacaoHipossuficiencia;

public class ExemploUIController {

	// Propriedades referentes a atendimento excepcional
	// Mapeado por meio de componente html select ou radio
	public boolean isViolenciaDomestica = Boolean.FALSE;
	public boolean isDefesaCriminal = Boolean.FALSE;
	public boolean isCuradoria = Boolean.FALSE;

	// Mapeado por meio de componente html textbox
	public BigDecimal rendaFamiliar;
	public int quantidadeMembros;

	// Propriedades referente a condições especiais
	// Mapeado por meio de componente htmt checkbox
	public boolean possuiGastosMedicosMedicamentos = Boolean.FALSE;
	public boolean possuiPessoaComTGD = Boolean.FALSE;
	public boolean possuiPessoaIdosaEgressaPrisional = Boolean.FALSE;

	public ExemploUIController(boolean isViolenciaDomestica, boolean isDefesaCriminal, boolean isCuradoria,
			boolean possuiGastosMedicosMedicamentos, boolean possuiPessoaComTGD,
			boolean possuiPessoaIdosaEgressaPrisional, BigDecimal rendaFamiliar, int quantidadeMembros) {
		this.isViolenciaDomestica = isViolenciaDomestica;
		this.isDefesaCriminal = isDefesaCriminal;
		this.isCuradoria = isCuradoria;
		this.possuiGastosMedicosMedicamentos = possuiGastosMedicosMedicamentos;
		this.possuiPessoaComTGD = possuiPessoaComTGD;
		this.possuiPessoaIdosaEgressaPrisional = possuiPessoaIdosaEgressaPrisional;
		this.rendaFamiliar = rendaFamiliar;
		this.quantidadeMembros = quantidadeMembros;
	}
	
	
	public boolean seraAtendido() {
		AvaliacaoHipossuficiencia avaliacaoHipossuficiencia = new AvaliacaoHipossuficiencia(
				this.isAtendimentoExcepcional(), ConversorSalarioMinimoHelper.converter(rendaFamiliar),
				this.quantidadeMembros, this.isCondicaoEspecial());
		
		return avaliacaoHipossuficiencia.isAtendimentoConcedido();
	}

	private boolean isAtendimentoExcepcional() {
		return isViolenciaDomestica || isDefesaCriminal || isCuradoria;
	}

	private boolean isCondicaoEspecial() {
		return possuiGastosMedicosMedicamentos || possuiPessoaComTGD || possuiPessoaIdosaEgressaPrisional;
	}

}
