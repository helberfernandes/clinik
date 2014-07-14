package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "wof_roles")
public class Role implements Serializable{
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	@Transient
	public static String ROLE_CONVIDADO = "ROLE_CONVIDADO";
	@Transient
	public static String ROLE_GERENTE = "ROLE_GERENTE";
	@Transient 
	public static String ROLE_FRENTE = "ROLE_FRENTE";
	@Transient
	public static String ROLE_SUPORTE = "ROLE_SUPORTE";
	@Transient
	public static String ROLE_SUPORTE_FILIZOLA = "ROLE_SUPORTE_FILIZOLA";

	
	 
	public static String ROLE_SUPORTE_SEGURANCA = "ROLE_SUPORTE_SEGURANCA";
	
	@Transient
	public static String ROLE_ADMINISTRADOR = "ROLE_ADMINISTRADOR";
	@Transient
	public static String ROLE_GERENTE_SEGURANCA = "ROLE_GERENTE_SEGURANCA";
	
	@Transient
	public static String ROLE_SUB_ADMINISTRADOR = "ROLE_SUB_ADMINISTRADOR";

	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private Integer roleId;
	@Column(length = 80)
	private String descricao;
	@Column(length = 30)
	private String nome;
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="permissao_id", referencedColumnName="permissao_id")
	@Fetch(value = FetchMode.JOIN)
	private Permissao permissao = new Permissao();

	
	
	
	public Role(Integer roleId) {
		super();
		this.roleId = roleId;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		Role other = (Role) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + "]";
	}	
}