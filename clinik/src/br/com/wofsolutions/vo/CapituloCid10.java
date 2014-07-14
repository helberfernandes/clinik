package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wof_capitulo")
public class CapituloCid10 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "num_cap")
	private Integer numCap;

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

	
	
	public CapituloCid10() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CapituloCid10(String catInic, String catFim, String descricao,
			String descAbrev) {
		super();
		this.catInic = catInic;
		this.catFim = catFim;
		this.descricao = descricao;
		this.descAbrev = descAbrev;
	}



	public CapituloCid10(Integer numCap, String catInic, String catFim,
			String descricao, String descAbrev) {
		super();
		this.numCap = numCap;
		this.catInic = catInic;
		this.catFim = catFim;
		this.descricao = descricao;
		this.descAbrev = descAbrev;
	}



	public Integer getNumCap() {
		return numCap;
	}

	public void setNumCap(Integer numCap) {
		this.numCap = numCap;
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

}
