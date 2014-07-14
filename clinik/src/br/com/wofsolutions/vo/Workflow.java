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
@Table(name="wof_workflow")
public class Workflow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 561791252773556106L;
	@Id
	@GeneratedValue
	@Column(name="workflow_id")
	private Integer workflowId;	
	@Column(length=80)
	private String nome;
	
	@Column(length=255) 
	private String descricao;
	
	 
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="modulo_id", referencedColumnName="modulo_id")
	private Modulo modulo = new Modulo();
	
	private boolean ativo;

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="workflow_id", referencedColumnName="workflow_id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<EstadoWorkflow> estadoWorkflows = new ArrayList<EstadoWorkflow>();
	
	
	
	public Workflow(Integer workflowId) {
		super();
		this.workflowId = workflowId;
	}

	public Workflow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
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

	

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<EstadoWorkflow> getEstadoWorkflows() {
		return estadoWorkflows;
	}

	public void setEstadoWorkflows(List<EstadoWorkflow> estadoWorkflows) {
		this.estadoWorkflows = estadoWorkflows;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((workflowId == null) ? 0 : workflowId.hashCode());
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
		Workflow other = (Workflow) obj;
		if (workflowId == null) {
			if (other.workflowId != null)
				return false;
		} else if (!workflowId.equals(other.workflowId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Workflow [workflowId=" + workflowId + "]";
	}
	
	
	
}
