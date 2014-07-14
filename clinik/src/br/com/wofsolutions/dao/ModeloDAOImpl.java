package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.vo.Empresa;
import br.com.wofsolutions.vo.Modelo;

public class ModeloDAOImpl extends HibernateDAOImpl<Modelo, Object, Object>
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.ModeloDAO#getModeloPeloNome(java.lang.String)
	 */

	public Modelo getModeloPeloNome(Modelo modelo) {

		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.add(Restrictions.and(
				Restrictions.eq("empresa", modelo.getEmpresa()),
				Restrictions.eq("nome", modelo.getTitulo())));
		Modelo usuario = (Modelo) criteria.uniqueResult();

		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.ModeloDAO#getTotosModelos()
	 */

	@SuppressWarnings("unchecked")
	public List<Modelo> getTotosModelos(Empresa empresa) {

		Criteria criteria = getSession().createCriteria(Modelo.class);
		
		criteria.add(Restrictions.eq("empresa", empresa));
		
		criteria.addOrder(Order.asc("nome"));
		List<Modelo> list = criteria.list();

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.ModeloDAO#getTotosModelosAsString()
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosModelosAsString() {

		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.addOrder(Order.asc("nome"));
		List<Modelo> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Modelo modelo : list) {
			strings.add(modelo.getTitulo());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.supermaia.dao.ModeloDAO#getTotosModelosEquipeAsString(java.lang
	 * .Integer)
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosModelosEquipeAsString(Integer exameId) {
		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.createAlias("exames", "e");
		criteria.add(Restrictions.and(Restrictions.eq("equipe", true),
				Restrictions.eq("e.exameId", exameId)));
		criteria.addOrder(Order.asc("nome"));
		List<Modelo> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Modelo modelo : list) {
			strings.add(modelo.getTitulo());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.ModeloDAO#getTotosModelosEquipeAsString2()
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosModelosEquipeAsString2() {
		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.createAlias("exames", "e");
		criteria.add(Restrictions.eq("equipe", true));
		criteria.addOrder(Order.asc("nome"));
		List<Modelo> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Modelo modelo : list) {
			strings.add(modelo.getTitulo());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.ModeloDAO#getTotosModelosSolicitanteAsString()
	 */

	@SuppressWarnings("unchecked")
	public List<String> getTotosModelosSolicitanteAsString() {
		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.add(Restrictions.eq("solicitante", true));
		criteria.addOrder(Order.asc("nome"));
		List<Modelo> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Modelo modelo : list) {
			strings.add(modelo.getTitulo());
		}
		return strings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.supermaia.dao.ModeloDAO#getTotosModelosPelaPesquisa(java.lang.
	 * String)
	 */

	public List<Modelo> getTotosModelosPelaPesquisa(String pesq) {
		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.add(Restrictions.or(
				Restrictions.like("nome", "%" + pesq + "%"),
				Restrictions.like("nome", "%" + pesq + "%")));
		criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<Modelo> list = criteria.list();

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.ModeloDAO#getTotosModelosSolicitante()
	 */

	@SuppressWarnings("unchecked")
	public List<Modelo> getTotosModelosSolicitante() {
		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.add(Restrictions.eq("solicitante", true));
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.supermaia.dao.ModeloDAO#getTotosModelosEquipe()
	 */

	@SuppressWarnings("unchecked")
	public List<Modelo> getTotosModelosEquipe() {
		Criteria criteria = getSession().createCriteria(Modelo.class);
		criteria.add(Restrictions.eq("equipe", true));
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}
}
