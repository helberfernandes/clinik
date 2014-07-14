package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Embeddable
public class PermissaoPaginaRolePk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "pagina_id", referencedColumnName = "pagina_id")
	@Fetch(value = FetchMode.JOIN)
	private Pagina pagina = new Pagina();
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	@Fetch(value = FetchMode.JOIN)
	private Role role = new Role();

	
	
	
	public PermissaoPaginaRolePk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermissaoPaginaRolePk(Pagina pagina, Role role) {
		super();
		this.pagina = pagina;
		this.role = role;
	}

	public Pagina getPagina() {
		return pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pagina == null) ? 0 : pagina.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		PermissaoPaginaRolePk other = (PermissaoPaginaRolePk) obj;
		if (pagina == null) {
			if (other.pagina != null)
				return false;
		} else if (!pagina.equals(other.pagina))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PermissaoPaginaRolePk [pagina=" + pagina + ", role=" + role
				+ "]";
	}

}
