/**
 * 
 */
package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.vo.Marcador;
import br.com.wofsolutions.vo.Pagina;
import br.com.wofsolutions.vo.PermissaoPaginaRole;
import br.com.wofsolutions.vo.Role;
import br.com.wofsolutions.vo.Usuario;
 
/**
 * @author hfernandes
 * 
 */
public class PaginaDAOImpl extends HibernateDAOImpl<Marcador, PermissaoPaginaRole, Object> implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PaginaDAOImpl instancia= null;
	protected Criteria criteria;
	
	
	private  PaginaDAOImpl() {
		super();
	
	}


	public static PaginaDAOImpl getInstancia() {
		if(instancia == null){
			instancia = new PaginaDAOImpl();
		}
		return instancia;
	}


	public Marcador getMarcadorPelaChave(Integer key) {
		return (Marcador) getSession().get(Marcador.class, key);
	}

	
	public Marcador getMarcadorPeloNome(String nome) {
		criteria = getSession().createCriteria(Marcador.class);
		criteria.add(Restrictions.eq("nome", nome));
		return (Marcador) criteria.uniqueResult();
	}
	
	
	public Marcador getMarcadorPeloNome(String nome,String pagina, Usuario usuario) {
		 criteria = getSession().createCriteria(Marcador.class);
		criteria.add(Restrictions.and(Restrictions.eq("nome", nome),Restrictions.and(Restrictions.eq("pagina", pagina), Restrictions.eq("usuario", usuario))));
		return (Marcador) criteria.uniqueResult();
	}


	@SuppressWarnings("unchecked")
	public List<Marcador> getTodosMarcadoresParaAPagina(String pagina, Usuario usuario) {
		criteria = getSession().createCriteria(Marcador.class);
		criteria.add(Restrictions.and(Restrictions.eq("pagina", pagina), Restrictions.eq("usuario", usuario)));
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}

	
	
	public PermissaoPaginaRole getPermissaoParaAPaginaERole(Pagina pagina, Role role) {
		criteria = getSession().createCriteria(PermissaoPaginaRole.class);
		criteria.createAlias("permissaoPaginaRolePk.pagina", "pa");
		criteria.createAlias("permissaoPaginaRolePk.role", "ro");
		criteria.add(Restrictions.and(Restrictions.eq("pa.paginaId", pagina.getPaginaId()),Restrictions.eq("ro", role.getRoleId())));
		return (PermissaoPaginaRole) criteria.uniqueResult();
	}
	
	
	public Pagina getPaginaPeloLink(Pagina pagina) {
		criteria = getSession().createCriteria(Pagina.class);		
		criteria.add(Restrictions.eq("link", pagina.getLink()));
		return (Pagina) criteria.uniqueResult();
	}


	@Override
	protected void finalize() throws Throwable {		
		super.finalize();
		criteria=null;
	}
	
	
	


}
