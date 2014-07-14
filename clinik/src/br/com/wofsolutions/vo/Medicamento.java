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
@Table(name="wof_medicamentos")
public class Medicamento implements Serializable, ObjectBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="medicamento_id")
	private Integer medicamentoId;
	
	@Column(length=1000)
	private String medicamento;
	
	@Column(length=255)
	private String concentracao;
	
	private Integer quantidade=0;
	
	@Column(length=255)
	private String uso;
	
	
	@Column(length=10000)
	private String instrucoes;
	
	
	
	@Column(name="em_uso")
	private boolean emUso=false;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
	private Paciente paciente = new Paciente();
	
	

	public Integer getMedicamentoId() {
		return medicamentoId;
	}




	public void setMedicamentoId(Integer medicamentoId) {
		this.medicamentoId = medicamentoId;
	}




	public String getMedicamento() {
		return medicamento;
	}




	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
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


 





	public String getConcentracao() {
		return concentracao;
	}




	public void setConcentracao(String concentracao) {
		this.concentracao = concentracao;
	}




	public Integer getQuantidade() {
		return quantidade;
	}




	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}




	public String getUso() {
		return uso;
	}




	public void setUso(String uso) {
		this.uso = uso;
	}




	public boolean isEmUso() {
		return emUso;
	}




	public void setEmUso(boolean emUso) {
		this.emUso = emUso;
	}




	public String getInstrucoes() {
		return instrucoes;
	}




	public void setInstrucoes(String instrucoes) {
		this.instrucoes = instrucoes;
	}




	@Override
	public void setId(Integer id) {
		medicamentoId=id;

	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((medicamentoId == null) ? 0 : medicamentoId.hashCode());
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
		Medicamento other = (Medicamento) obj;
		if (medicamentoId == null) {
			if (other.medicamentoId != null)
				return false;
		} else if (!medicamentoId.equals(other.medicamentoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medicamento [medicamentoId=" + medicamentoId + "]";
	}




	@Override
	public void setEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}
}