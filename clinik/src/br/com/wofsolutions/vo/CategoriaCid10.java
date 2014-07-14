package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wof_categorias")
public class CategoriaCid10 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * código da categoria;
	 */
	@Id
	private String cat;
	/**
	 * indica se a situação da categoria em relação à classificação
	 * cruz/asterisco: em branco: não tem dupla classificação; +: classificação
	 * por etiologia; e *: classificação por manifestação.
	 */
	private String classif;
	/**
	 * descrição (nome) da categoria;
	 */

	private String descricao;

	/**
	 * descrição (nome) abreviado da categoria, com até 50 caracteres (inclui o
	 * código da categoria);
	 */
	@Column(name="descricao_abreviada")
	private String descAbrev;

	/**
	 * contém, quando a categoria tiver dupla classificação, o código da
	 * categoria segundo a outra classificação (nem todos os casos de dupla
	 * classificação contém este campo); e
	 */
	private String refer;
	
	/**
	 * contém o(s) código(s) de categorias excluídas que agora fazem parte desta categoria.
	 */
	private String excluidos;
	
	
	@ManyToOne
	@JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")
	private GrupoCid10 grupoCid10 = new GrupoCid10();
	

	public CategoriaCid10() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaCid10(String cat) {
		super();
		this.cat = cat;
	}

	public CategoriaCid10(String cat, String classif, String descricao,
			String descAbrev, String refer, String excluidos) {
		super();
		this.cat = cat;
		this.classif = classif;
		this.descricao = descricao;
		this.descAbrev = descAbrev;
		this.refer = refer;
		this.excluidos = excluidos;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getClassif() {
		return classif;
	}

	public void setClassif(String classif) {
		this.classif = classif;
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

	public String getRefer() {
		return refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	public String getExcluidos() {
		return excluidos;
	}

	public void setExcluidos(String excluidos) {
		this.excluidos = excluidos;
	}

	public GrupoCid10 getGrupoCid10() {
		return grupoCid10;
	}

	public void setGrupoCid10(GrupoCid10 grupoCid10) {
		this.grupoCid10 = grupoCid10;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat == null) ? 0 : cat.hashCode());
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
		CategoriaCid10 other = (CategoriaCid10) obj;
		if (cat == null) {
			if (other.cat != null)
				return false;
		} else if (!cat.equals(other.cat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriaCid10 [cat=" + cat + "]";
	}

	
	
	
}
