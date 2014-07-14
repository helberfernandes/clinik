package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "wof_permissao_pagina_role")
public class PermissaoPaginaRole implements Serializable {

	
	@EmbeddedId
	private PermissaoPaginaRolePk permissaoPaginaRolePk = new PermissaoPaginaRolePk();
	
	private boolean autorizado;

	public PermissaoPaginaRole(PermissaoPaginaRolePk permissaoPaginaRolePk,
			boolean autorizado) {
		super();
		this.permissaoPaginaRolePk = permissaoPaginaRolePk;
		this.autorizado = autorizado;
	}

	public PermissaoPaginaRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermissaoPaginaRolePk getPermissaoPaginaRolePk() {
		return permissaoPaginaRolePk;
	}

	public void setPermissaoPaginaRolePk(PermissaoPaginaRolePk permissaoPaginaRolePk) {
		this.permissaoPaginaRolePk = permissaoPaginaRolePk;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (autorizado ? 1231 : 1237);
		result = prime
				* result
				+ ((permissaoPaginaRolePk == null) ? 0 : permissaoPaginaRolePk
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
		PermissaoPaginaRole other = (PermissaoPaginaRole) obj;
		if (autorizado != other.autorizado)
			return false;
		if (permissaoPaginaRolePk == null) {
			if (other.permissaoPaginaRolePk != null)
				return false;
		} else if (!permissaoPaginaRolePk.equals(other.permissaoPaginaRolePk))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PermissaoPaginaRole [permissaoPaginaRolePk="
				+ permissaoPaginaRolePk + ", autorizado=" + autorizado + "]";
	}
	
	
	
}
