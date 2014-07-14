package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.vo.Convenio;
import br.com.wofsolutions.vo.Empresa;

public class ConvenioDAOImpl extends HibernateDAOImpl<Convenio, Object, Object>
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Convenio getConvenioPeloNome(Convenio convenio) {

		Criteria criteria = getSession().createCriteria(Convenio.class);

		criteria.add(Restrictions.and(
				Restrictions.eq("empresa", convenio.getEmpresa()),
				Restrictions.eq("nome", convenio.getNome())));

		Convenio usuario = (Convenio) criteria.uniqueResult();

		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Convenio> getTotosConvenios(Empresa empresa) {

		Criteria criteria = getSession().createCriteria(Convenio.class);
		criteria.add(Restrictions.eq("empresa", empresa));
		criteria.addOrder(Order.asc("nome"));
		List<Convenio> list = criteria.list();

		return list;
	}

	public List<String> getTotosConveniosAsString() {

		Criteria criteria = getSession().createCriteria(Convenio.class);
		criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<Convenio> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Convenio convenio : list) {
			strings.add(convenio.getNome());
		}
		return strings;
	}

	public List<Convenio> getTotosConveniosPelaPesquisa(String pesq) {

		Criteria criteria = getSession().createCriteria(Convenio.class);
		criteria.add(Restrictions.or(
				Restrictions.like("nome", "%" + pesq + "%"),
				Restrictions.like("nome", "%" + pesq + "%")));
		criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<Convenio> list = criteria.list();

		return list;
	}
}
