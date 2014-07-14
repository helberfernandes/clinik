/**
 * 
 */
package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.vo.Configuracao;
 
/**
 * @author hfernandes
 * 
 */
public class ConfiguracaoDAOImpl extends HibernateDAOImpl<Configuracao, Object, Object> implements Serializable {
 
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4742968506651323968L;
	private static ConfiguracaoDAOImpl instancia =null;
	protected Criteria criteria;
	

	
	
	private ConfiguracaoDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static ConfiguracaoDAOImpl getInstancia() {
		if(instancia ==null){
			 instancia = new ConfiguracaoDAOImpl();
		}
		return instancia;
	}


	public Configuracao getObject(Integer key) {
		return (Configuracao) getSession().get(Configuracao.class, key);
	}

	
	public Configuracao getObject() {
		criteria = getSession().createCriteria(Configuracao.class);		
		return (Configuracao) criteria.uniqueResult();
	}
	
	
	public Configuracao getObject(String nome) {
		 criteria = getSession().createCriteria(Configuracao.class);
		criteria.add(Restrictions.eq("nome", nome));
		return (Configuracao) criteria.uniqueResult();
	}

	public List<Configuracao> getObjectList(Configuracao instancia) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Configuracao> getObjectList() {
		 criteria = getSession().createCriteria(Configuracao.class);		
		return criteria.list();
	}

	
	@SuppressWarnings("unchecked")
	public List<Configuracao> getObjectList(String pesq) {		
		criteria = getSession().createCriteria(Configuracao.class);
		criteria.add(Restrictions.like("nome", "%"+pesq+"%"));
		return criteria.list();
	}

	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		criteria = null;
	}


}
