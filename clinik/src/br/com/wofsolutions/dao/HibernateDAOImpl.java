/**
 * 
 */
package br.com.wofsolutions.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.interfaces.HibernateDAO;
import br.com.wofsolutions.util.HibernateUtil;
import br.com.wofsolutions.vo.Empresa;

/**
 * @author hfernandes
 * 
 */
public abstract class HibernateDAOImpl<E , H, I> implements HibernateDAO<E, H, I> {
	public static final int OP_EQUAL=0;
	public static final int OP_OR=1;
	public static final int OP_LIKE=2;
	@SuppressWarnings("unused")
	private static  Session session=null;
	@SuppressWarnings("rawtypes")
	private Class classe;
	private Class classeI;
	
	
	@SuppressWarnings("unchecked")
	public HibernateDAOImpl() {
		super();
		this.classe = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.classeI = (Class<I>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
	}
	
	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#salvar(E)
	 */
	@Override
	public boolean salvar(E obj) {
//		Transaction tx = null;
		// try {

		HibernateUtil.getCurrentSession().flush();
		HibernateUtil.getCurrentSession().clear();
		HibernateUtil.doBeginTransaction();
		// tx = getSession().getTransaction();

		// getSession().merge(obj);
		getSession().saveOrUpdate(obj);

		HibernateUtil.doCommit();
		// tx.commit();
		// HibernateUtil.getThreadtransaction().get().commit();
		// } catch (Exception e) {
		// tx.rollback();
		// HibernateUtil.doRollback();
		// e.printStackTrace();
		// } finally {
		// }

		return true;
	}
	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#salvarObjeto(H)
	 */

	@Override
	public boolean salvarObjeto(H obj) {
//		Transaction tx = null;
		try {

			HibernateUtil.doBeginTransaction();
			// tx = getSession().beginTransaction();

			getSession().saveOrUpdate(obj);
			HibernateUtil.doCommit();
		} catch (Exception e) {
			// tx.rollback();
			HibernateUtil.doRollback();
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#salvarObjeto2(I)
	 */
	@Override
	public boolean salvarObjeto2(I obj) {
//		Transaction tx = null;
		try {
			HibernateUtil.getCurrentSession().flush();
			HibernateUtil.getCurrentSession().clear();
			HibernateUtil.doBeginTransaction();
			// tx = getSession().beginTransaction();

			getSession().saveOrUpdate(obj);
		  HibernateUtil.doCommit();
		} catch (Exception e) {
			// tx.rollback();
			HibernateUtil.doRollback();
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#excluir(E)
	 */
	@Override
	public boolean excluir(E obj) {

		//Transaction tx = null;
		try {
			HibernateUtil.doBeginTransaction();

			getSession().delete(obj);
			HibernateUtil.doCommit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

		}
		return false;
	}

	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#excluirObjecto(H)
	 */
	@Override
	public boolean excluirObjecto(H obj) {
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			getSession().delete(obj);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
		}

		return tx.wasCommitted();
	}

	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#getSession()
	 */
	@Override
	public Session getSession() {
		return HibernateUtil.getCurrentSession();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#getObjetoPelaChave(java.lang.Integer)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public E getObjetoPelaChave(Integer key) {
		return (E) getSession().get(classe, key);
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
	//	getSession().beginTransaction();
		Criteria criteria = getSession().createCriteria(classe).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
		//criteria.addOrder(Order.asc("nome"));
		List<E> list=criteria.list();
		
		getSession().flush();
		getSession().clear();
	//	getSession().close();
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<E> findAll(Empresa empresa ) {
	//	getSession().beginTransaction();
		Criteria criteria = getSession().createCriteria(classe).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
		criteria.add(Restrictions.eq("empresa", empresa));
		
		
		
		//criteria.addOrder(Order.asc("nome"));
List<E> list=criteria.list();
		
		//getSession().flush();
		//getSession().clear();
		//getSession().close();
		return list;
	}

	
	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#findAll()
	 */
	
	@SuppressWarnings("unchecked")
	public List<I> findAll3(Empresa empresa ) {
	//	getSession().beginTransaction();
		Criteria criteria = getSession().createCriteria(classeI);
		criteria.add(Restrictions.eq("empresa", empresa));
		
		//criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#findBy(java.lang.String, java.lang.String, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public E findBy(String property, String value, int operador) {
		//getSession().beginTransaction();
		Criteria criteria = getSession().createCriteria(classe);
		switch (operador) {
		case OP_EQUAL:
			criteria.add(Restrictions.eq(property, value));	
			break;
		case OP_LIKE:
			criteria.add(Restrictions.like(property, value));	
			break;
		default:
			break;
		}				
		return (E) criteria.uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see br.com.wofsolutions.dao.HibernateDAO#findAllBy(java.lang.String, java.lang.String, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<E> findAllBy(String property, String value, int operador) {
		getSession().beginTransaction();
		Criteria criteria = getSession().createCriteria(classe);
		switch (operador) {
		case OP_EQUAL:
			criteria.add(Restrictions.eq(property, value));	
			break;
		case OP_LIKE:
			criteria.add(Restrictions.like(property, value));	
			break;
		default:
			break;
		}		
		return criteria.list();
	}

}
