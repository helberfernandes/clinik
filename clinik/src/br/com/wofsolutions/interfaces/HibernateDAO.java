package br.com.wofsolutions.interfaces;

import java.util.List;

import org.hibernate.Session;

import br.com.wofsolutions.vo.Empresa;

public interface HibernateDAO<E, H, I> {

	
	

	public abstract boolean salvar(E obj);

	/**
	 * 
	 * @param H obj
	 * @return
	 */

	public abstract boolean salvarObjeto(H obj);

	public abstract boolean salvarObjeto2(I obj);

	public abstract boolean excluir(E obj);

	public abstract boolean excluirObjecto(H obj);

	public abstract Session getSession();

	@SuppressWarnings("unchecked")
	public abstract E getObjetoPelaChave(Integer key);

	@SuppressWarnings("unchecked")
	public abstract List<E> findAll();
	
	public abstract List<E> findAll(String order);
	
	@SuppressWarnings("unchecked")
	public abstract List<E> findAll(Empresa empresa);
	
	/**
	 * 
	 * @see 	 * 
	 *  <code>HibernateDAOImpl<Usuario, Object, Object> impl = new HibernateDAOImpl<Usuario, Object, Object>() {
		};
		System.out.println(impl.findBy("login", "root", HibernateDAOImpl.OP_EQUAL).getNome());
		</code>
	 * @param property - campo pesquisado
	 * @param value - valor pesquisado
	 * @param operador neste caso so e possivel HibernateDAOImpl.OP_EQUAL ou HibernateDAOImpl.OP_LIKE
	 * @return se encontrar o objeto do tipo E ou null caso contrario
	 */
	@SuppressWarnings("unchecked")
	public abstract E findBy(String property, String value, int operador);

	@SuppressWarnings("unchecked")
	public abstract List<E> findAllBy(String property, String value,
			int operador);

}