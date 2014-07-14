package br.com.wofsolutions.model.webservice;

import java.io.Serializable;


public class PecaChamado implements Serializable {


	private PecaChamadoPk chamadoPk = new PecaChamadoPk();
	
	public double valor=0.0;

	
	
	  
	
	public PecaChamado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PecaChamado(PecaChamadoPk chamadoPk) {
		super();
		this.chamadoPk = chamadoPk;
	}

	public PecaChamadoPk getChamadoPk() {
		return chamadoPk;
	}

	public void setChamadoPk(PecaChamadoPk chamadoPk) {
		this.chamadoPk = chamadoPk;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((chamadoPk == null) ? 0 : chamadoPk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PecaChamado other = (PecaChamado) obj;
		if (chamadoPk == null) {
			if (other.chamadoPk != null)
				return false;
		} else if (!chamadoPk.equals(other.chamadoPk))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PecaChamado [chamadoPk=" + chamadoPk + "]";
	}
}
