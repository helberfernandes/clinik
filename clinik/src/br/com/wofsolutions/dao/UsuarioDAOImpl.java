/**
 * 
 */
package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.wofsolutions.vo.Permissao;
import br.com.wofsolutions.vo.Role;
import br.com.wofsolutions.vo.Usuario;
import br.com.wofsolutions.vo.Usuario;

/**
 * @author hfernandes
 * 
 */
public class UsuarioDAOImpl extends HibernateDAOImpl<Usuario, Role, Permissao>
		implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9008347922669834166L;
	private static UsuarioDAOImpl instancia = null;
	protected Criteria criteria;

	public UsuarioDAOImpl() {
		super();
	}

	public static UsuarioDAOImpl getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioDAOImpl();
		} 
		return instancia;
	}

	public Usuario getUsuarioPelaChave(Integer key) {
//		StringBuilder sb = new StringBuilder();
//	      sb.append(" select distinct u from Usuario u");
//	      sb.append("  inner join fetch u.role r");
//	      sb.append("  inner join fetch u.loja l");
//	      sb.append("   inner join fetch r.permissao p");
//	      //sb.append("   join fetch l.usuario u2");
//	      //sb.append("   join fetch a.status");
//	     // sb.append("   join fetch a.comentarios");
//	      
//	      sb.append(" where u.usuarioId = :usuarioId");
//	      Query query = getSession().createQuery(sb.toString());
//	      query.setParameter("usuarioId", key);
//	      return (Usuario) query.uniqueResult(); 
		
		
		return (Usuario) getSession().get(Usuario.class, key);
	}

	public Usuario getUsuarioPeloNome(String login) {
		criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", login));
		return (Usuario) criteria.uniqueResult();
	}

	public List<Usuario> getObjectList(Usuario instancia) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getTodasUsuarios() {
		criteria = getSession().createCriteria(Usuario.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarioListSuporte() {
		criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("status", true));
		criteria.createCriteria("role").add(
				Restrictions.eq("nome", Role.ROLE_SUPORTE));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarioListSuporteSeguranca() {
		criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("status", true));
		criteria.createCriteria("role").add(
				Restrictions.eq("nome", Role.ROLE_SUPORTE_SEGURANCA));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarioListSuporteFilizola() {
		criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("status", true));
		criteria.createCriteria("role").add(
				Restrictions.and(Restrictions.eq("nome", Role.ROLE_SUPORTE),
						Restrictions.eq("descricao", "Suporte Filizola")));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarioListSuportePlantao() {

		criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("plantao", true));
		criteria.createCriteria("role").add(
				Restrictions.eq("nome", Role.ROLE_SUPORTE));

		return criteria.list();
	}

	public Role getRole(String nome) {

		criteria = getSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("nome", nome));
		return (Role) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Role> getTodasAsRoles() {
		criteria = getSession().createCriteria(Role.class);
		return criteria.list();
	}

	public Role getRolePelaChave(Integer key) {
		return (Role) getSession().get(Role.class, key);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getObjectList(String pesq) {
		criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.or(
				Restrictions.like("nome", "%" + pesq + "%"),
				Restrictions.like("login", "%" + pesq + "%")));
		return criteria.list();
	}

	
	public Usuario getUsuario(String login, String senha) {
		criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.and(Restrictions.eq("login", login),
				Restrictions.eq("senha", senha)));
		return (Usuario) criteria.uniqueResult();
	}
	
	@Override
	protected void finalize() throws Throwable {		
		super.finalize();
		criteria=null;
	}
}