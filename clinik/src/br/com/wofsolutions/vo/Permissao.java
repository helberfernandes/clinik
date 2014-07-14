package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "wof_permissao")
public class Permissao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9200680918867207684L;

	@Id
	@GeneratedValue
	@Column(name = "permissao_id")
	private Integer permissaoId;

	/*************************************************************
	 *  Permicoes gerais
	 */ 
	@Column(name = "add_user")
	public boolean addUser ;
	
	public Integer getPermissaoId() {
		return permissaoId;
	}
	
	public void setPermissaoId(Integer permissaoId) {
		this.permissaoId = permissaoId;
	}
	

	public boolean isAddUser() {
		return addUser;
	}

	public void setAddUser(boolean addUser) {
		this.addUser = addUser;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((permissaoId == null) ? 0 : permissaoId.hashCode());
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
		Permissao other = (Permissao) obj;
		if (permissaoId == null) {
			if (other.permissaoId != null)
				return false;
		} else if (!permissaoId.equals(other.permissaoId))
			return false;
		return true;
	}
	
	
}
