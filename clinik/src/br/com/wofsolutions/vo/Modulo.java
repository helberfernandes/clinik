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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.wofsolutions.interfaces.ObjectBase;
import br.com.wofsolutions.interfaces.ObjectBaseAdapter;

@Entity
@Table(name="wof_modulo")
public class Modulo extends ObjectBaseAdapter implements Serializable {    
    public static int CLIENTE_AMIGO=2;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4862108582699690981L;
	@Id 
	@GeneratedValue
	@Column(name="modulo_id")
	private Integer moduloId;	 
	@Column(length=80)
	private String nome;
	
	@Column(length=255)
	private String descricao;

	@Column(length=255)
	private String link;
	
	
	
	
	private boolean permissao=false;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade= {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="modulo_id", referencedColumnName="modulo_id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Pagina> paginas  = new ArrayList<Pagina>();
	
	
	
	public Modulo(Integer moduloId) {
		super();
		this.moduloId = moduloId;
	}

	public Modulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getModuloId() {
		return moduloId;
	}

	public void setModuloId(Integer moduloId) {
		this.moduloId = moduloId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	
	
	public List<Pagina> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
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
				+ ((moduloId == null) ? 0 : moduloId.hashCode());
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
		Modulo other = (Modulo) obj;
		if (moduloId == null) {
			if (other.moduloId != null)
				return false;
		} else if (!moduloId.equals(other.moduloId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modulo [moduloId=" + moduloId + "]";
	}

	@Override
	public void setId(Integer id) {
		moduloId=id;
		
	}
	
	
}
