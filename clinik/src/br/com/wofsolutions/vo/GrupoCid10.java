package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wof_grupo")
public class GrupoCid10 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "grupo_id")
	private Integer grupoId;

	@Column(length = 1000, name = "cat_inic")
	private String catInic;

	@Column(length = 1000, name = "cat_fim")
	private String catFim;

	/**
	 * descrição (nome) da categoria;
	 */

	@Column(length = 1000)
	private String descricao;

	/**
	 * descrição (nome) abreviado da categoria, com até 50 caracteres (inclui o
	 * código da categoria);
	 */
	@Column(name = "descricao_abreviada")
	private String descAbrev;

	@ManyToOne
	@JoinColumn(name = "num_cap", referencedColumnName = "num_cap")
	private CapituloCid10 capitulo = new CapituloCid10();
	
	public GrupoCid10() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GrupoCid10(String catInic, String catFim, String descricao,
			String descAbrev) {
		super();
		this.catInic = catInic;
		this.catFim = catFim;
		this.descricao = descricao;
		this.descAbrev = descAbrev;
	}

	public Integer getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}

	public String getCatInic() {
		return catInic;
	}

	public void setCatInic(String catInic) {
		this.catInic = catInic;
	}

	public String getCatFim() {
		return catFim;
	}

	public void setCatFim(String catFim) {
		this.catFim = catFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescAbrev() {
		return descAbrev;
	}

	public void setDescAbrev(String descAbrev) {
		this.descAbrev = descAbrev;
	}

	public CapituloCid10 getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(CapituloCid10 capitulo) {
		this.capitulo = capitulo;
	}

}
