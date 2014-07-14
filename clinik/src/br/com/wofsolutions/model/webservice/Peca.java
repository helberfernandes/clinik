package br.com.wofsolutions.model.webservice;

import java.io.Serializable;



public class Peca implements Serializable {
	

	private Integer pecaId;
  
	public String codigo;

	public String descricao;
	 
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "wof_pecas_chamados", joinColumns = @JoinColumn(name = "peca_id"), inverseJoinColumns = @JoinColumn(name = "chamado_id"))
	
	
	
	
	public Peca(Integer pecaId) {
		super();
		this.pecaId = pecaId;
	}
	public Peca(String codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Peca() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Integer getPecaId() {
		return pecaId;
	}
	public void setPecaId(Integer pecaId) {
		this.pecaId = pecaId;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Peca [pecaId=" + pecaId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pecaId == null) ? 0 : pecaId.hashCode());
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
		Peca other = (Peca) obj;
		if (pecaId == null) {
			if (other.pecaId != null)
				return false;
		} else if (!pecaId.equals(other.pecaId))
			return false;
		return true;
	}
	
	
	
}
