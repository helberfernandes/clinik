/**
 * 
 */
package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.vo.EstadoWorkflow;
import br.com.wofsolutions.vo.Modulo;
import br.com.wofsolutions.vo.Role;
import br.com.wofsolutions.vo.Workflow;

/**
 * @author hfernandes
 * 
 */
public class WorkflowDAOImpl extends HibernateDAOImpl<Workflow, Object, Object>
		implements  Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -967357133050957747L;
	private static WorkflowDAOImpl instancia = null;
	protected Criteria criteria;
	
	

	private WorkflowDAOImpl() {
		super();
	}


	public static WorkflowDAOImpl getInstancia() {
		if(instancia ==null){
			instancia = new WorkflowDAOImpl();
		}
		return instancia;
	}


	public Workflow getWorkflowPelaChave(Integer key) {
		return (Workflow) getSession().get(Workflow.class, key);
	}
	
	
	public EstadoWorkflow getEstadoWorkflowPelaChave(Integer key) {
		return (EstadoWorkflow) getSession().get(EstadoWorkflow.class, key);
	}
	
	
	
	public EstadoWorkflow getEstadoWorkflowPeloNome(String nome) {
		criteria = getSession().createCriteria(EstadoWorkflow.class);
		criteria.add(Restrictions.eq("nome", nome));
		return (EstadoWorkflow) criteria.uniqueResult();
	}
	

	public Workflow getWorkflowPeloNome(String nome) {
		criteria = getSession().createCriteria(Workflow.class);
		criteria.add(Restrictions.eq("nome", nome));
		return (Workflow) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Workflow> getTodasWorkflows() {
		criteria = getSession().createCriteria(Workflow.class);
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}
	
	
	public EstadoWorkflow getStatusInicial(Modulo modulo) {
		getSession().clear();getSession().flush();		
		criteria=getSession().createCriteria(EstadoWorkflow.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//criteria.createAlias("roles", "r");
		criteria.createAlias("workflow", "w");
		criteria.add(Restrictions.and(Restrictions.and(Restrictions.eq("w.modulo", modulo), Restrictions.eq("w.ativo", true)),
				Restrictions.eq("estadoInicial", true)));		
				
		return (EstadoWorkflow) criteria.uniqueResult();
	}
	
	
	public EstadoWorkflow getWorkflowPeloModulo(Modulo modulo, EstadoWorkflow estadoWorkflow, Role role) {
		criteria=getSession().createCriteria(EstadoWorkflow.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createAlias("roles", "r");
		criteria.createAlias("workflow", "w");
		criteria.add(Restrictions.and(Restrictions.and(Restrictions.and(Restrictions.eq("w.modulo", modulo), Restrictions.eq("w.ativo", true)),
				Restrictions.eq("nome", estadoWorkflow.getNome())), Restrictions.eq("r.roleId", role.getRoleId())));
		return (EstadoWorkflow) criteria.uniqueResult();
	}
	
	
	/**
	 * Obtendo o status inicial
	 * @param modulo
	 * @return
	 */
	
	public EstadoWorkflow getWorkflowPeloModulo(Modulo modulo) {
		criteria=getSession().createCriteria(EstadoWorkflow.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//criteria.createAlias("roles", "r");
		criteria.createAlias("workflow", "w");
		criteria.add(Restrictions.and(Restrictions.and(Restrictions.eq("w.modulo", modulo), Restrictions.eq("w.ativo", true)),
				Restrictions.eq("estadoInicial", true)));
		return (EstadoWorkflow) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<EstadoWorkflow> getStatusPermitidosAVisualizacao(Modulo modulo, Role role) {
		criteria=getSession().createCriteria(EstadoWorkflow.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createAlias("rolesVisualiza", "rv");
		criteria.createAlias("workflow", "w");
		criteria.add(Restrictions.and(Restrictions.and(Restrictions.eq("w.modulo", modulo), Restrictions.eq("w.ativo", true)),
				Restrictions.eq("rv.roleId", role.getRoleId())));
		return  criteria.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EstadoWorkflow> getStatusPermitidosAVisualizacao(Integer moduloId, Integer roleId) {
		criteria=getSession().createCriteria(EstadoWorkflow.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createAlias("rolesVisualiza", "rv");
		criteria.createAlias("workflow", "w");
		criteria.add(Restrictions.and(Restrictions.and(Restrictions.eq("w.modulo.moduloId", moduloId), Restrictions.eq("w.ativo", true)),
				Restrictions.eq("rv.roleId", roleId)));
		return  criteria.list();
	}
	@Override
	protected void finalize() throws Throwable {		
		super.finalize();
		criteria=null;
	}
}