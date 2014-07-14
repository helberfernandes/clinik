package br.com.wofsolutions.model.webservice;

import java.io.Serializable;


public class Equipamento implements Serializable{
	

	private Integer equipamentoId;

	private String  descricao;

	private double  precoCusto;


	private String    dataAquisicao;


	private String    dataDesatiacao;
	
	private Boolean ativo;

	private Integer codEtiqueta;

	private String numSerie;

	private Boolean emManutencao;

	private String  observacao;
	
	private Integer tipo;
	
	
	public Integer getEquipamentoId() {
		return equipamentoId;
	}
	public void setEquipamentoId(Integer equipamentoId) {
		this.equipamentoId = equipamentoId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public String getDataAquisicao() {
		return dataAquisicao;
	}
	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	public String getDataDesatiacao() {
		return dataDesatiacao;
	}
	public void setDataDesatiacao(String dataDesatiacao) {
		this.dataDesatiacao = dataDesatiacao;
	}
	public Boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Integer getCodEtiqueta() {
		return codEtiqueta;
	}
	public void setCodEtiqueta(Integer codEtiqueta) {
		this.codEtiqueta = codEtiqueta;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public Boolean isEmManutencao() {
		return emManutencao;
	}
	public void setEmManutencao(Boolean emManutencao) {
		this.emManutencao = emManutencao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Equipamento [equipamentoId=" + equipamentoId + ", descricao="
				+ descricao + ", precoCusto=" + precoCusto + ", dataAquisicao="
				+ dataAquisicao + ", dataDesatiacao=" + dataDesatiacao
				+ ", ativo=" + ativo + ", codEtiqueta=" + codEtiqueta
				+ ", numSerie=" + numSerie + ", emManutencao=" + emManutencao
				+ ", observacao=" + observacao + ", tipo=" + tipo + "]";
	}
	
	
	
	
	
}
