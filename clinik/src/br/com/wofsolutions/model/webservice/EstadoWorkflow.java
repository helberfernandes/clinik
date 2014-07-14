package br.com.wofsolutions.model.webservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class EstadoWorkflow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2345510537230110048L;

	private Integer estadoWorkflowId; 
	private String nome;
	private String descricao;
	private boolean estadoInicial=false;
	private List<EstadoWorkflow> estadoWorkflows = new ArrayList<EstadoWorkflow>();
	private List<Role> roles = new ArrayList<Role>();
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
