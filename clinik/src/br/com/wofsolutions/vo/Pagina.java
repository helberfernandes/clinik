package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "wof_pagina")
public class Pagina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "pagina_id")
	private Integer paginaId;

	@Column(length = 255)
	private String descricao;
	/**
	 * Link da pagina
	 */
	@Column(length = 255)
	private String link;
	/**
	 * Nem todas as paginas sao de fato paginas 
	 * algumas soa apenas janelas (dialogs) modais
	 * que aparecem na pagina, portanto e utilizado 
	 * o evento onclik para chamalas, caso uma janela nao
	 * necessite deste evento entao o valor fica nulo
	 */
	@Column(length = 255)	
	private String onClik;

	private boolean permissao = false;

	@ManyToOne
	@JoinColumn(name = "modulo_id", referencedColumnName = "modulo_id")
	private Modulo modulo = new Modulo();

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "pagina_id", referencedColumnName = "pagina_id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PermissaoPaginaRole> paginaRoles = new ArrayList<PermissaoPaginaRole>();

	public Pagina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pagina(String link) {
		super();
		this.link = link;
	}

	public Pagina(Integer paginaId) {
		super();
		this.paginaId = paginaId;
	}

	public Pagina(Integer paginaId, String descricao, String link,
			String onClik, boolean permissao, Modulo modulo,
			List<PermissaoPaginaRole> paginaRoles) {
		super();
		this.paginaId = paginaId;
		this.descricao = descricao;
		this.link = link;
		this.onClik = onClik;
		this.permissao = permissao;
		this.modulo = modulo;
		this.paginaRoles = paginaRoles;
	}

	public Integer getPaginaId() {
		return paginaId;
	}

	public void setPaginaId(Integer paginaId) {
		this.paginaId = paginaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getOnClik() {
		return onClik;
	}

	public void setOnClik(String onClik) {
		this.onClik = onClik;
	}

	public List<PermissaoPaginaRole> getPaginaRoles() {
		return paginaRoles;
	}

	public void setPaginaRoles(List<PermissaoPaginaRole> paginaRoles) {
		this.paginaRoles = paginaRoles;
	}

	public boolean isPermissao() {
		return permissao;
	}

	public void setPermissao(boolean permissao) {
		this.permissao = permissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((paginaId == null) ? 0 : paginaId.hashCode());
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
		Pagina other = (Pagina) obj;
		if (paginaId == null) {
			if (other.paginaId != null)
				return false;
		} else if (!paginaId.equals(other.paginaId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pagina [paginaId=" + paginaId + "]";
	}

}
