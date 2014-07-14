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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.wofsolutions.interfaces.ObjectBase;

@Entity
@Table(name="wof_atendimento")
public class Atendimento implements Serializable, ObjectBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2783862389260656872L;
	@Id
	@GeneratedValue
	@Column(name="atendimento_id")
	private Integer atendimentoId;
	@Temporal(TemporalType.DATE)
	@Column(name="data_lancamento")
	private Date dataLancamento = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_atendimento")
	private Date dataAtendimento = new Date();
		
	
	@Column(name="falta_guia")
	private boolean faltaGuia=false;
	private boolean deletado=false;
	
	
	@ManyToOne
	@JoinColumn(name = "convenio_id", referencedColumnName = "convenio_id")	
	private Convenio  convenio = new Convenio();
	@ManyToOne
	@JoinColumn(name = "exame_id", referencedColumnName = "exame_id")
	private Exame  exame = new Exame();
	
	@ManyToOne
	@JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
	private Medico medico = new Medico();
	
	@ManyToOne
	@JoinColumn(name = "solicitante_id", referencedColumnName = "medico_id")
	private Medico solicitante = new Medico();
	
	@ManyToOne
	@JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
	private Paciente paciente = new Paciente();
	
	
	
	private double valor;
	
	@ManyToOne
	//@Cascade(CascadeType.ALL)
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa = new Empresa();
	
	@ManyToOne
	@JoinColumn(name = "estado_workflow_id", referencedColumnName = "estado_workflow_id")
	@Fetch(value = FetchMode.JOIN)
	private EstadoWorkflow status = new EstadoWorkflow();
	
	@ManyToOne
	@JoinColumn(name = "tipo_atendimento_id", referencedColumnName = "tipo_atendimento_id")
	
	private TipoAtendimento tipoAtendimento = new TipoAtendimento();

	public Integer getAtendimentoId() {
		return atendimentoId;
	}

	public void setAtendimentoId(Integer atendimentoId) {
		this.atendimentoId = atendimentoId;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}



	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Medico getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Medico solicitante) {
		this.solicitante = solicitante;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isFaltaGuia() {
		return faltaGuia;
	}

	public void setFaltaGuia(boolean faltaGuia) {
		this.faltaGuia = faltaGuia;
	}
	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}	
	
	@Override
	public void setId(Integer id) {
		atendimentoId=id;
		
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	

	public EstadoWorkflow getStatus() {
		return status;
	}

	public void setStatus(EstadoWorkflow status) {
		this.status = status;
	}

	
	
	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atendimentoId == null) ? 0 : atendimentoId.hashCode());
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
		Atendimento other = (Atendimento) obj;
		if (atendimentoId == null) {
			if (other.atendimentoId != null)
				return false;
		} else if (!atendimentoId.equals(other.atendimentoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atendimento [atendimentoId=" + atendimentoId + "]";
	}
	
	
	
	
	
}