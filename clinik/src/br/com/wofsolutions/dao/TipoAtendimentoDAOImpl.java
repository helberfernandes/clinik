package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.vo.TipoAtendimento;
import br.com.wofsolutions.vo.Empresa;

public class TipoAtendimentoDAOImpl extends HibernateDAOImpl<TipoAtendimento, Object, Object>
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TipoAtendimento getTipoAtendimentoPeloNome(TipoAtendimento tipoAtendimento) {

		Criteria criteria = getSession().createCriteria(TipoAtendimento.class);

		criteria.add(Restrictions.and(
				Restrictions.eq("empresa", tipoAtendimento.getEmpresa()),
				Restrictions.eq("nome", tipoAtendimento.getDescricao())));

		TipoAtendimento usuario = (TipoAtendimento) criteria.uniqueResult();

		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<TipoAtendimento> getTotosTipoAtendimentos(Empresa empresa) {

		Criteria criteria = getSession().createCriteria(TipoAtendimento.class);
		criteria.add(Restrictions.eq("empresa", empresa));
		criteria.addOrder(Order.asc("nome"));
		List<TipoAtendimento> list = criteria.list();

		return list;
	}

	public List<String> getTotosTipoAtendimentosAsString() {

		Criteria criteria = getSession().createCriteria(TipoAtendimento.class);
		criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<TipoAtendimento> list = criteria.list();

		List<String> strings = new ArrayList<String>();
		for (TipoAtendimento tipoAtendimento : list) {
			strings.add(tipoAtendimento.getDescricao());
		}
		return strings;
	}

	public List<TipoAtendimento> getTotosTipoAtendimentosPelaPesquisa(String pesq) {

		Criteria criteria = getSession().createCriteria(TipoAtendimento.class);
		criteria.add(Restrictions.or(
				Restrictions.like("nome", "%" + pesq + "%"),
				Restrictions.like("nome", "%" + pesq + "%")));
		criteria.addOrder(Order.asc("nome"));
		@SuppressWarnings("unchecked")
		List<TipoAtendimento> list = criteria.list();

		return list;
	}
}
