package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.wofsolutions.interfaces.ObjectBase;

@Entity
@Table(name= "wof_tipos_atendimentos")
public class TipoAtendimento implements Serializable, ObjectBase  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "tipo_atendimento_id")
	private Integer tipoAtendimentoId;

	@Column(length = 255)
	private String descricao;
	@Column(name = "tipo_atendimento")
	
	private boolean retorno;
	
	@ManyToOne
	//@Cascade(CascadeType.ALL)
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa = new Empresa();
	

	public Integer getTipoAtendimentoId() {
		return tipoAtendimentoId;
	}

	public void setTipoAtendimentoId(Integer tipoAtendimentoId) {
		this.tipoAtendimentoId = tipoAtendimentoId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
	public boolean isRetorno() {
		return retorno;
	}

	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}
	
	

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((tipoAtendimentoId == null) ? 0 : tipoAtendimentoId
						.hashCode());
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
		TipoAtendimento other = (TipoAtendimento) obj;
		if (tipoAtendimentoId == null) {
			if (other.tipoAtendimentoId != null)
				return false;
		} else if (!tipoAtendimentoId.equals(other.tipoAtendimentoId))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "TipoAtendimento [tipoAtendimentoId=" + tipoAtendimentoId + "]";
	}

	@Override
	public void setId(Integer id) {
		tipoAtendimentoId=id;
		
	}
}