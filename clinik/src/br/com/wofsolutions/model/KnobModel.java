package br.com.wofsolutions.model;

import java.io.Serializable;

public class KnobModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cor;
	private Integer total;
	
	public KnobModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KnobModel(String nome, String cor, Integer total) {
		super();
		this.nome = nome;
		this.cor = cor;
		this.total = total;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
