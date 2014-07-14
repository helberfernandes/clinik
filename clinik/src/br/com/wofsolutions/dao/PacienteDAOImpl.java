package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.vo.Empresa;
import br.com.wofsolutions.vo.Paciente;

public class PacienteDAOImpl extends HibernateDAOImpl<Paciente, Object, Object>
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.PacienteDAO#getPacientePeloNome(java.lang.String)
	 */

	public Paciente getPacientePeloNome(Paciente paciente) {

		Criteria criteria = getSession().createCriteria(Paciente.class);
		criteria.add(Restrictions.and(
				Restrictions.eq("empresa", paciente.getEmpresa()),
				Restrictions.eq("nome", paciente.getNome())));
		Paciente usuario = (Paciente) criteria.uniqueResult();

		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.PacienteDAO#getTotosPacientes()
	 */

	@SuppressWarnings("unchecked")
	public List<Paciente> getTotosPacientes(Empresa empresa) {

		Criteria criteria = getSession().createCriteria(Paciente.class);
		criteria.createAlias("alergia", "a");
		criteria.add(Restrictions.and(Restrictions.eq("empresa", empresa), Restrictions.eq("a.excluido", false)));
		
		criteria.addOrder(Order.asc("nome"));
		List<Paciente> list = criteria.list();

		return list;
	}
	
	
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.PacienteDAO#getTotosPacientesAsString()
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosPacientesAsString() {

		Criteria criteria = getSession().createCriteria(Paciente.class);
		criteria.addOrder(Order.asc("nome"));
		List<Paciente> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Paciente paciente : list) {
			strings.add(paciente.getNome());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.supermaia.dao.PacienteDAO#getTotosPacientesEquipeAsString(java.lang
	 * .Integer)
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosPacientesEquipeAsString(Integer exameId) {
		Criteria criteria = getSession().createCriteria(Paciente.class);
		criteria.createAlias("exames", "e");
		criteria.add(Restrictions.and(Restrictions.eq("equipe", true),
				Restrictions.eq("e.exameId", exameId)));
		criteria.addOrder(Order.asc("nome"));
		List<Paciente> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Paciente paciente : list) {
			strings.add(paciente.getNome());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.PacienteDAO#getTotosPacientesEquipeAsString2()
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosPacientesEquipeAsString2() {
		Criteria criteria = getSession().createCriteria(Paciente.class);
		criteria.createAlias("exames", "e");
		criteria.add(Restrictions.eq("equipe", true));
		criteria.addOrder(Order.asc("nome"));
		List<Paciente> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Paciente paciente : list) {
			strings.add(paciente.getNome());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.PacienteDAO#getTotosPacientesSolicitanteAsString()
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosPacientesSolicitanteAsString() {
		Criteria criteria = getSession().createCriteria(Paciente.class);
		criteria.add(Restrictions.eq("solicitante", true));
		criteria.addOrder(Order.asc("nome"));
		List<Paciente> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Paciente paciente : list) {
			strings.add(paciente.getNome());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.supermaia.dao.PacienteDAO#getTotosPacientesPelaPesquisa(java.lang.
	 * String)
	 */

	public List<Paciente> getTotosPacientesPelaPesquisa(String pesq) {
		Criteria criteria = getSession().createCriteria(Paciente.class);
		criteria.add(Restrictions.or(
				Restrictions.like("nome", "%" + pesq + "%"),
				Restrictions.like("nome", "%" + pesq + "%")));
		criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<Paciente> list = criteria.list();

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.PacienteDAO#getTotosPacientesSolicitante()
	 */

	@SuppressWarnings("unchecked")
	public List<Paciente> getTotosPacientesSolicitante() {
		Criteria criteria = getSession().createCriteria(Paciente.class);
		criteria.add(Restrictions.eq("solicitante", true));
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.PacienteDAO#getTotosPacientesEquipe()
	 */

	@SuppressWarnings("unchecked")
	public List<Paciente> getTotosPacientesEquipe() {
		Criteria criteria = getSession().createCriteria(Paciente.class);
		criteria.add(Restrictions.eq("equipe", true));
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}
}
