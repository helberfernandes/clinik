package br.com.wofsolutions.model.webservice;

import java.io.Serializable;


public class Loja implements Serializable{


	private Integer lojaId;	

	private String nome;

	private String recebedor;


	
	public Integer getLojaId() {
		return lojaId;
	}
	public void setLojaId(Integer lojaId) {
		this.lojaId = lojaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRecebedor() {
		return recebedor;
	}
	public void setRecebedor(String recebedor) {
		this.recebedor = recebedor;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lojaId == null) ? 0 : lojaId.hashCode());
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
		Loja other = (Loja) obj;
		if (lojaId == null) {
			if (other.lojaId != null)
				return false;
		} else if (!lojaId.equals(other.lojaId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Loja [lojaId=" + lojaId + ", nome=" + nome + ", recebedor="
				+ recebedor + "]";
	}

}
