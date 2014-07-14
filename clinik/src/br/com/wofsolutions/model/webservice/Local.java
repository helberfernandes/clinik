package br.com.wofsolutions.model.webservice;

import java.io.Serializable;



public class Local implements Serializable {


	private Integer localId;	 

	private String descricao;
	public Integer getLocalId() {
		return localId;
	}
	public void setLocalId(Integer localId) {
		this.localId = localId;
	} 
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Local() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Local(Integer localId) {
		super();
		this.localId = localId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localId == null) ? 0 : localId.hashCode());
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
		Local other = (Local) obj;
		if (localId == null) {
			if (other.localId != null)
				return false;
		} else if (!localId.equals(other.localId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Local [localId=" + localId + "]";
	}
	
	
}
