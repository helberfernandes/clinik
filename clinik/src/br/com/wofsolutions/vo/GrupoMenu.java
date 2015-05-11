package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="wof_grupos_menus")
public class GrupoMenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue
	@Column(name="grupo_menu_id")
	private Integer grupoMenuId;	 
	@Column(length=80)
	private String nome;
	

	@OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="grupo_menu_id", referencedColumnName="grupo_menu_id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Pagina> paginas  = new ArrayList<Pagina>();
	@ManyToOne
	@JoinColumn(name = "modulo_id", referencedColumnName = "modulo_id")
	private Modulo modulo = new Modulo();

	public Integer getGrupoMenuId() {
		return grupoMenuId;
	}


	public void setGrupoMenuId(Integer grupoMenuId) {
		this.grupoMenuId = grupoMenuId;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Pagina> getPaginas() {
		return paginas;
	}


	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}


	public Modulo getModulo() {
		return modulo;
	}


	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	
	
}