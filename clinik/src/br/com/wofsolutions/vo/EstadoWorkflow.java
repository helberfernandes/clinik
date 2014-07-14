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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="wof_estado_workflow")
@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement(name="estadoWorkflows")
public class EstadoWorkflow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2345510537230110048L;
	public static String STATUS_AGENDADO="STATUS_AGENDADO";
	public static String STATUS_CANCELADO="STATUS_CANCELADO";
	
	
	@Id
	@GeneratedValue
	@Column(name="estado_workflow_id")
	private Integer estadoWorkflowId;	
	@Column(length=80) 
	private String nome;
	 
	@Column(length=255)
	private String descricao;
	
	@Column(length=255)
	private String cor;
	
	@Column(name="estado_inicial")
	private boolean estadoInicial=false;
	
	
	@ManyToOne
	@JoinColumn(name="workflow_id", referencedColumnName="workflow_id")
	@Fetch(value = FetchMode.JOIN)
	private Workflow workflow = new Workflow();
	
	/**
	 * Retorna todos os proximos status
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "wof_proximo_estado_workflow", joinColumns = @JoinColumn(name = "estado_workflow_id"), inverseJoinColumns = @JoinColumn(name="proximo_estado_workflow_id", referencedColumnName="estado_workflow_id"))	
	@Fetch(value = FetchMode.SUBSELECT)
	private List<EstadoWorkflow> estadoWorkflows = new ArrayList<EstadoWorkflow>();
	
	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "wof_estado_workflow_roles", joinColumns = @JoinColumn(name = "estado_workflow_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Role> roles = new ArrayList<Role>();

	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "wof_estado_workflow_roles_visualiza", joinColumns = @JoinColumn(name = "estado_workflow_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Role> rolesVisualiza = new ArrayList<Role>();
	
	
	

	public EstadoWorkflow(String nome) {
		super();
		this.nome = nome;
	}


	public EstadoWorkflow(Integer estadoWorkflowId) {
		super();
		this.estadoWorkflowId = estadoWorkflowId;
	}


	public EstadoWorkflow() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getEstadoWorkflowId() {
		return estadoWorkflowId;
	}


	public void setEstadoWorkflowId(Integer estadoWorkflowId) {
		this.estadoWorkflowId = estadoWorkflowId;
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


	public Workflow getWorkflow() {
		return workflow;
	}


	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}




	public List<EstadoWorkflow> getEstadoWorkflows() {
		return estadoWorkflows;
	}


	public void setEstadoWorkflows(List<EstadoWorkflow> estadoWorkflows) {
		this.estadoWorkflows = estadoWorkflows;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	
	public boolean isEstadoInicial() {
		return estadoInicial;
	}


	public void setEstadoInicial(boolean estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	
	
	


	public List<Role> getRolesVisualiza() {
		return rolesVisualiza;
	}


	public void setRolesVisualiza(List<Role> rolesVisualiza) {
		this.rolesVisualiza = rolesVisualiza;
	}

	
	



	
	

	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((estadoWorkflowId == null) ? 0 : estadoWorkflowId.hashCode());
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
		EstadoWorkflow other = (EstadoWorkflow) obj;
		if (estadoWorkflowId == null) {
			if (other.estadoWorkflowId != null)
				return false;
		} else if (!estadoWorkflowId.equals(other.estadoWorkflowId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "EstadoWorkflow [estadoWorkflowId=" + estadoWorkflowId + "]";
	}


	
}

