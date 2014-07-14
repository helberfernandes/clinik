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
@Table(name="wof_diagnosticos")
public class Diagnostico implements Serializable, ObjectBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="diagnostico_id")
	private Integer diagnosticoId;
	
	@Column(length=1000)
	private String descricao;
	
	
	@Temporal(TemporalType.DATE)
	private Date data = new Date();
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
	private Paciente paciente = new Paciente();
	
	

	public Integer getDiagnosticoId() {
		return diagnosticoId;
	}




	public void setDiagnosticoId(Integer diagnosticoId) {
		this.diagnosticoId = diagnosticoId;
	}



	public Date getData() {
		return data;
	}




	public void setData(Date data) {
		this.data = data;
	}



	public Paciente getPaciente() {
		return paciente;
	}




	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	@Override
	public void setId(Integer id) {
		diagnosticoId=id;

	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((diagnosticoId == null) ? 0 : diagnosticoId.hashCode());
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
		Diagnostico other = (Diagnostico) obj;
		if (diagnosticoId == null) {
			if (other.diagnosticoId != null)
				return false;
		} else if (!diagnosticoId.equals(other.diagnosticoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Diagnostico [diagnosticoId=" + diagnosticoId + "]";
	}




	@Override
	public void setEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}
}