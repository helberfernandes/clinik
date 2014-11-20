package br.com.wofsolutions.model.cockpit;

import java.io.Serializable;

public class QTDCategoriaValor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int qtd;
	private  double valor;
	
	
	
	public QTDCategoriaValor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QTDCategoriaValor(String nome, int qtd, double valor) {
		super();
		this.nome = nome;
		this.qtd = qtd;
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
