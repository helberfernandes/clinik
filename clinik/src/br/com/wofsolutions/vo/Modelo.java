package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.wofsolutions.interfaces.ObjectBase;
@Entity
@Table(name="wof_modelos")
public class Modelo implements Serializable, ObjectBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="modelo_id")
	private Integer modeloId;
	
	@Column(name="titulo", length=80)
	private String titulo;
	
	
	@Column(name="descricao", length=255)
	private String descricao;
	
	
	@Column(name="texto", length=255)
	private String texto;
	
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa = new Empresa();
	
	
	
	public Integer getModeloId() {
		return modeloId;
	}

	public void setModeloId(Integer modeloId) {
		this.modeloId = modeloId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	

	@Override
	public void setId(Integer id) {
		modeloId=id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((modeloId == null) ? 0 : modeloId.hashCode());
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
		Modelo other = (Modelo) obj;
		if (modeloId == null) {
			if (other.modeloId != null)
				return false;
		} else if (!modeloId.equals(other.modeloId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modelo [modeloId=" + modeloId + "]";
	}
	
}
