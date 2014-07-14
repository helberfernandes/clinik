package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.wofsolutions.interfaces.ObjectBase;

@Entity
@Table(name="wof_alergia")
public class Alergia implements Serializable, ObjectBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="alergia_id")
	private Integer alergiaId;
	
	@Column(length=255)
	private String alergia;
	@Column(length=255)
	private String reacao;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private boolean excluido=false;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa = new Empresa();
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
	private Paciente paciente = new Paciente();
	
	

	public Integer getAlergiaId() {
		return alergiaId;
	}




	public void setAlergiaId(Integer alergiaId) {
		this.alergiaId = alergiaId;
	}




	public String getAlergia() {
		return alergia;
	}




	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}




	public String getReacao() {
		return reacao;
	}




	public void setReacao(String reacao) {
		this.reacao = reacao;
	}




	public Date getData() {
		return data;
	}




	public void setData(Date data) {
		this.data = data;
	}




	public Empresa getEmpresa() {
		return empresa;
	}




	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}




	public Paciente getPaciente() {
		return paciente;
	}




	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


 

	public boolean isExcluido() {
		return excluido;
	}




	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}




	@Override
	public void setId(Integer id) {
		alergiaId=id;

	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alergiaId == null) ? 0 : alergiaId.hashCode());
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
		Alergia other = (Alergia) obj;
		if (alergiaId == null) {
			if (other.alergiaId != null)
				return false;
		} else if (!alergiaId.equals(other.alergiaId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alergia [alergiaId=" + alergiaId + "]";
	}
}