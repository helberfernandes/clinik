package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.util.MaiaUtil;
import br.com.wofsolutions.vo.Atendimento;
import br.com.wofsolutions.vo.Empresa;
import br.com.wofsolutions.vo.EstadoWorkflow;
import br.com.wofsolutions.vo.Medico;

public class AtendimentoDAOImpl extends
		HibernateDAOImpl<Atendimento, Medico, Object> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Atendimento getAtendimentoPeloNome(String paciente, Empresa empresa) {

		Criteria criteria = getSession().createCriteria(Atendimento.class);

		criteria.add(Restrictions.and(Restrictions.eq("empresa", empresa),
				Restrictions.and(Restrictions.eq("paciente", paciente),
						Restrictions.eq("deletado", false))));

		Atendimento usuario = (Atendimento) criteria.uniqueResult();

		return usuario;
	}

	public Atendimento getAtendimentoPeloNome(Atendimento atendimento) {

		Criteria criteria = getSession().createCriteria(Atendimento.class);
		criteria.add(Restrictions.and(Restrictions.eq("paciente",
				atendimento.getPaciente().getNome()), Restrictions.and(Restrictions.eq(
				"deletado", false), Restrictions.and(Restrictions.eq(
				"dataLancamento", atendimento.getDataLancamento()),
				Restrictions.eq("exame.exameId", atendimento.getExame()
						.getExameId())))));
		Atendimento usuario = (Atendimento) criteria.uniqueResult();

		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Atendimento> getTotosAtendimentos(Medico medico) {
		
System.out.println("Data ultima "+MaiaUtil.ultimoDiaDoMesDate());
		Criteria criteria = getSession().createCriteria(Atendimento.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createAlias("status", "s");
		
		criteria.add(Restrictions.and(
				Restrictions.and(Restrictions.between("dataAtendimento",  MaiaUtil.primeirodiaDoMesDate(), MaiaUtil.ultimoDiaDoMesDate()),Restrictions.and(Restrictions.ne("s.nome", EstadoWorkflow.STATUS_CANCELADO),Restrictions.eq("empresa", medico.getEmpresa()))),
				Restrictions.and(Restrictions.eq("deletado", false), Restrictions.eq("medico", medico))));
		criteria.addOrder(Order.asc("paciente"));
		

		return criteria.list();
	}

	public List<Atendimento> getTotosAtendimentosPelaPesquisa(String pesq) {
		Criteria criteria = getSession().createCriteria(Atendimento.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.and(Restrictions.eq("deletado", false),
				Restrictions.or(
						Restrictions.like("paciente", "%" + pesq + "%"),
						Restrictions.like("paciente", "%" + pesq + "%"))));
		criteria.addOrder(Order.asc("paciente"));
		@SuppressWarnings("unchecked")
		List<Atendimento> list = criteria.list();

		return list;
	}
}
