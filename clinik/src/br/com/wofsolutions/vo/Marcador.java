package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="wof_marcador")
public class Marcador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8038986237718170335L;
	@Id
	@GeneratedValue
	@Column(name="marcador_id")
	private Integer marcadorId;	
	@Column(length=80)
	private String nome;
	@Column(length=80)
	private String pagina; 
	
	
	@ManyToOne
	@JoinColumn(name="marcador_pai_id", referencedColumnName="marcador_id")
	private Marcador marcadorPai;
	@OneToMany 
	@JoinColumn(name="marcador_pai_id", referencedColumnName="marcador_id")
	private List<Marcador> marcadoresFilhos = new ArrayList<Marcador>();
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="usuario_id")
	private Usuario usuario = new Usuario();
	
	
	
	

	@ManyToOne
	@JoinColumn(name = "tecnico_id", referencedColumnName = "usuario_id")
	private Usuario tecnico;

	private String status;
	
	
	
	private String empresa;
	

	public Integer getMarcadorId() {
		return marcadorId;
	}

	public void setMarcadorId(Integer marcadorId) {
		this.marcadorId = marcadorId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marcador getMarcadorPai() {
		return marcadorPai;
	}

	public void setMarcadorPai(Marcador marcadorPai) {
		this.marcadorPai = marcadorPai;
	}

	public List<Marcador> getMarcadoresFilhos() {
		return marcadoresFilhos;
	}

	public void setMarcadoresFilhos(List<Marcador> marcadoresFilhos) {
		this.marcadoresFilhos = marcadoresFilhos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	
	



	public Usuario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((marcadorId == null) ? 0 : marcadorId.hashCode());
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
		Marcador other = (Marcador) obj;
		if (marcadorId == null) {
			if (other.marcadorId != null)
				return false;
		} else if (!marcadorId.equals(other.marcadorId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + marcadorId ;
	}
	
}
