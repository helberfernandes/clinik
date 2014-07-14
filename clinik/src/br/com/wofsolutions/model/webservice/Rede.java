package br.com.wofsolutions.model.webservice;

import java.io.Serializable;


public class Rede implements Serializable{
	
	private Integer redeId;	

	private String nome;

	private String contato;

	private String telefone;

	private String cnpj;

	private String rasaoSocial;
	
	
	
	public Integer getRedeId() {
		return redeId;
	}
	public void setRedeId(Integer redeId) {
		this.redeId = redeId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRasaoSocial() {
		return rasaoSocial;
	}
	public void setRasaoSocial(String rasaoSocial) {
		this.rasaoSocial = rasaoSocial;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((redeId == null) ? 0 : redeId.hashCode());
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
		Rede other = (Rede) obj;
		if (redeId == null) {
			if (other.redeId != null)
				return false;
		} else if (!redeId.equals(other.redeId))
			return false;
		return true;
	}
	
	
	
}
