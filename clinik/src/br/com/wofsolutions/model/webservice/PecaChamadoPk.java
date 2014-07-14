package br.com.wofsolutions.model.webservice;

import java.io.Serializable;



public class PecaChamadoPk implements Serializable {

	

	private Chamado chamado = new Chamado();
	
	 

	private Peca  peca = new Peca();

 
	
	
	public PecaChamadoPk() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PecaChamadoPk(Chamado chamado, Peca peca) {
		super();
		this.chamado = chamado;
		this.peca = peca;
	}


	public Chamado getChamado() {
		return chamado;
	}


	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}


	public Peca getPeca() {
		return peca;
	}


	public void setPeca(Peca peca) {
		this.peca = peca;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chamado == null) ? 0 : chamado.hashCode());
		result = prime * result + ((peca == null) ? 0 : peca.hashCode());
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
		PecaChamadoPk other = (PecaChamadoPk) obj;
		if (chamado == null) {
			if (other.chamado != null)
				return false;
		} else if (!chamado.equals(other.chamado))
			return false;
		if (peca == null) {
			if (other.peca != null)
				return false;
		} else if (!peca.equals(other.peca))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PecaChamadoPk [chamado=" + chamado + ", peca=" + peca + "]";
	}
	
	
	
	
	
}
