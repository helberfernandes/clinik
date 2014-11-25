package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.util.ConexaoUtil;
import br.com.wofsolutions.util.HibernateUtil;
import br.com.wofsolutions.vo.Empresa;
import br.com.wofsolutions.vo.Medico;

public class MedicoDAOImpl extends HibernateDAOImpl<Medico, Object, Object>
		implements Serializable {
	ConexaoUtil conexaoUtil = new ConexaoUtil();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public Medico getMedico(Integer medicoId){
		HibernateUtil.doBeginTransaction();
		Medico medico=getObjetoPelaChave(medicoId);
		HibernateUtil.doCommit();
		return medico;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.MedicoDAO#getMedicoPeloNome(java.lang.String)
	 */

	public Medico getMedicoPeloNome(Medico medico) {

		Criteria criteria = getSession().createCriteria(Medico.class);
		criteria.add(Restrictions.and(
				Restrictions.eq("empresa", medico.getEmpresa()),
				Restrictions.eq("nome", medico.getNome())));
		Medico usuario = (Medico) criteria.uniqueResult();

		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.MedicoDAO#getTotosMedicos()
	 */

	@SuppressWarnings("unchecked")
	public List<Medico> getTotosMedicos(Empresa empresa) {

		Criteria criteria = getSession().createCriteria(Medico.class);
		
		criteria.add(Restrictions.eq("empresa", empresa));
		
		criteria.addOrder(Order.asc("nome"));
		List<Medico> list = criteria.list();

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.MedicoDAO#getTotosMedicosAsString()
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosMedicosAsString() {

		Criteria criteria = getSession().createCriteria(Medico.class);
		criteria.addOrder(Order.asc("nome"));
		List<Medico> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Medico medico : list) {
			strings.add(medico.getNome());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.supermaia.dao.MedicoDAO#getTotosMedicosEquipeAsString(java.lang
	 * .Integer)
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosMedicosEquipeAsString(Integer exameId) {
		Criteria criteria = getSession().createCriteria(Medico.class);
		criteria.createAlias("exames", "e");
		criteria.add(Restrictions.and(Restrictions.eq("equipe", true),
				Restrictions.eq("e.exameId", exameId)));
		criteria.addOrder(Order.asc("nome"));
		List<Medico> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Medico medico : list) {
			strings.add(medico.getNome());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.MedicoDAO#getTotosMedicosEquipeAsString2()
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosMedicosEquipeAsString2() {
		Criteria criteria = getSession().createCriteria(Medico.class);
		criteria.createAlias("exames", "e");
		criteria.add(Restrictions.eq("equipe", true));
		criteria.addOrder(Order.asc("nome"));
		List<Medico> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Medico medico : list) {
			strings.add(medico.getNome());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.MedicoDAO#getTotosMedicosSolicitanteAsString()
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosMedicosSolicitanteAsString() {
		Criteria criteria = getSession().createCriteria(Medico.class);
		criteria.add(Restrictions.eq("solicitante", true));
		criteria.addOrder(Order.asc("nome"));
		List<Medico> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Medico medico : list) {
			strings.add(medico.getNome());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.supermaia.dao.MedicoDAO#getTotosMedicosPelaPesquisa(java.lang.
	 * String)
	 */

	public List<Medico> getTotosMedicosPelaPesquisa(String pesq) {
		Criteria criteria = getSession().createCriteria(Medico.class);
		criteria.add(Restrictions.or(
				Restrictions.like("nome", "%" + pesq + "%"),
				Restrictions.like("nome", "%" + pesq + "%")));
		criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<Medico> list = criteria.list();

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.MedicoDAO#getTotosMedicosSolicitante()
	 */

	@SuppressWarnings("unchecked")
	public List<Medico> getTotosMedicosSolicitante(Empresa empresa) {
		Criteria criteria = getSession().createCriteria(Medico.class);
		criteria.add(Restrictions.and(Restrictions.eq("empresa", empresa),Restrictions.eq("solicitante", true)));
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.MedicoDAO#getTotosMedicosEquipe()
	 */

	@SuppressWarnings("unchecked")
	public List<Medico> getTotosMedicosEquipe(Empresa empresa) {
		Transaction tr=getSession().beginTransaction();
		Criteria criteria = getSession().createCriteria(Medico.class);
		criteria.add(Restrictions.and(Restrictions.eq("empresa", empresa),Restrictions.eq("equipe", true)));
		criteria.addOrder(Order.asc("nome"));
		List<Medico> medicos=criteria.list();
		tr.commit();
		return medicos;
	}
}
