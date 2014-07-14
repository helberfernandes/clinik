package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.vo.Convenio;
import br.com.wofsolutions.vo.Empresa;
import br.com.wofsolutions.vo.Exame;
import br.com.wofsolutions.vo.ExameConvenio;

public class ExameDAOImpl extends
		HibernateDAOImpl<Exame, ExameConvenio, Convenio> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Exame getExamePeloNome(Exame exame) {

		Criteria criteria = getSession().createCriteria(Exame.class);

		criteria.add(Restrictions.and(
				Restrictions.eq("empresa", exame.getEmpresa()),
				Restrictions.eq("nome", exame.getNome())));
		Exame usuario = (Exame) criteria.uniqueResult();

		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Exame> getTotosExames(Empresa empresa) {

		Criteria criteria = getSession().createCriteria(Exame.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("empresa", empresa));
		criteria.addOrder(Order.asc("nome"));
		List<Exame> list = criteria.list();

		return list;
	}

	public List<String> getTotosExamesAsString() {

		Criteria criteria = getSession().createCriteria(Exame.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		System.out.println();
		criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<Exame> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (Exame exame : list) {
			strings.add(exame.getNome());
		}
		return strings;
	}

	public List<Exame> getTotosExamesPelaPesquisa(String pesq) {

		Criteria criteria = getSession().createCriteria(Exame.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.or(
				Restrictions.like("nome", "%" + pesq + "%"),
				Restrictions.like("nome", "%" + pesq + "%")));
		criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<Exame> list = criteria.list();

		return list;
	}

	public List<ExameConvenio> getTotosExamesConvenios() {

		Criteria criteria = getSession().createCriteria(ExameConvenio.class);
		// criteria.createAlias("exameConvenioPK.convenio","convenio",CriteriaSpecification.LEFT_JOIN);
		//

		// Query query =
		// getSession().createQuery("SELECT e FROM ExameConvenio e RIGHT JOIN fetch e.exameConvenioPK.convenio convenio");

		// criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<ExameConvenio> list = criteria.list();

		return list;
	}

	public List<ExameConvenio> getTotosExamesConveniosPeloExameId(
			Integer exameId) {

		Criteria criteria = getSession().createCriteria(ExameConvenio.class);
		criteria.add(Restrictions.eq("exameConvenioPK.exame.exameId", exameId));
		@SuppressWarnings("unchecked")
		List<ExameConvenio> list = criteria.list();

		return list;
	}

	public ExameConvenio getTotosExamesConveniosPeloExameIdEPeloConvenioId(
			Integer exameId, Integer convenioId) {

		Criteria criteria = getSession().createCriteria(ExameConvenio.class);
		criteria.add(Restrictions.and(Restrictions.eq(
				"exameConvenioPK.exame.exameId", exameId), Restrictions.eq(
				"exameConvenioPK.convenio.convenioId", convenioId)));
		ExameConvenio exameConvenio = (ExameConvenio) criteria.uniqueResult();

		return exameConvenio;
	}
}
