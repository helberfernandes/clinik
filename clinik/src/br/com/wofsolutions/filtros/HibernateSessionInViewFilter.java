package br.com.wofsolutions.filtros;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import br.com.wofsolutions.dao.PaginaDAOImpl;
import br.com.wofsolutions.mensagens.Messages;
import br.com.wofsolutions.util.HibernateUtil;
import br.com.wofsolutions.vo.Paginas;
import br.com.wofsolutions.vo.Usuario;
import br.com.wofsolutions.vo.Usuario;

//@WebFilter(servletNames={"Faces Servlet"})
public class HibernateSessionInViewFilter implements Filter {

	private static final String PAGINA_INICIAL    = Messages.getString("system.pagina.home"); //$NON-NLS-1$
	private static final String PAGINA_LOGIN      = Messages.getString("system.pagina.login"); //$NON-NLS-1$
	private static final String PAGINA_TEMPLATE   = Messages.getString("system.pagina.template"); //$NON-NLS-1$
	private static final String KEY_USUARIO       = Messages.getString("system.key.usuario"); //$NON-NLS-1$
	
	private final Logger log      = Logger.getLogger(this.getClass().getName());
	private PaginaDAOImpl daoImpl = PaginaDAOImpl.getInstancia();	
	private Usuario usuario;
	
	
	@Override
	public void destroy() {
		
		HibernateUtil.doCloseSession();
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		String queryString = request2.getRequestURI();
		HttpSession session = ((HttpServletRequest) request).getSession();

//		boolean isLoginPage = (queryString.lastIndexOf("index.xhtml") > -1);

		// verificando se o usuario estalogado
		if (session.getMaxInactiveInterval() == 30) {
			log.info(Messages.getString("system.msg.usuario.initivo")); //$NON-NLS-1$
			log.info(Messages.getString("system.msg.invalidando.sessao")); //$NON-NLS-1$
			session.invalidate();
			log.info(Messages.getString("system.msg.redirecionando.usuairo")); //$NON-NLS-1$
			response2.sendRedirect(PAGINA_INICIAL);
		}

//		if (queryString.equals(Messages.getString("system.page.inicial.com.index"))) { //$NON-NLS-1$
//			queryString = PAGINA_INICIAL;
//		}
//
//		if (queryString.equals(Messages.getString("system.page.login.completa"))) { //$NON-NLS-1$
//			queryString = PAGINA_LOGIN;
//		}
//
//		if (session.getAttribute(KEY_USUARIO) != null
//				&& ((queryString.equals(PAGINA_INICIAL)) || (queryString.equals(PAGINA_LOGIN)))) {
//			session.invalidate();
//		}
//
//		
//		
//		
//		try {
//			usuario=(Usuario) session.getAttribute(KEY_USUARIO);
//		} catch (IllegalStateException e) {
//			if (e.getMessage().contains(Messages.getString("system.erro.sessao.invalida"))) { //$NON-NLS-1$
//				log.info(Messages.getString("system.error.sessao.existe")); //$NON-NLS-1$
//				session = ((HttpServletRequest) request).getSession(true);
//				response2.sendRedirect(PAGINA_INICIAL);
//			}
//		}
//
//		if (session.getAttribute(KEY_USUARIO) == null
//				&& ((!queryString.equals(PAGINA_INICIAL) 
//						&& !queryString.equals(PAGINA_LOGIN))
//				&& !queryString.contains(PAGINA_TEMPLATE))
//				) {			
//			response2.sendRedirect(PAGINA_INICIAL);
//			session.invalidate();
//		}

		HibernateUtil.getCurrentSession();

		//HibernateUtil.doBeginTransaction();
		// try {
		// if( HibernateUtil.getCurrentSession()!=null){
		// try{
		// HibernateUtil.doBeginTransaction();
		// }catch (SessionException e) {
		// if(e.getMessage().contains("Session is closed!")){
		// HibernateUtil.doCloseSession();
		//
		// HibernateUtil.getCurrentSession();
		// HibernateUtil.doBeginTransaction();
		//
		// }
		// e.printStackTrace();
		// }
		// }

		// System.out.println("Filtro");

		request.setCharacterEncoding(Messages.getString("system.utf8")); //$NON-NLS-1$
		response.setCharacterEncoding(Messages.getString("system.utf8")); //$NON-NLS-1$

		HibernateUtil.getCurrentSession().clear();
		HibernateUtil.getCurrentSession().flush();

		
		
		//remove os parametro e procura somente a pagina
		Pattern p = Pattern.compile("/\\d*/"); //$NON-NLS-1$
		Matcher m = p.matcher(queryString);
		while (m.find()) {
			queryString=queryString.replaceAll(m.group(), "/"); //$NON-NLS-1$
		}
		
		
		
		// verifica se o usuario tem permissao para acessar a pagina
		/*if (!queryString.endsWith(".jpg") && !queryString.endsWith(".png") && !queryString.endsWith(".gif") && !queryString.endsWith(".css") && 
				!queryString.endsWith(".js") && !queryString.endsWith(".js.xhtml")  && !queryString.endsWith(".css.xhtml") && !queryString.contains("chat.xhtml")  
				
				
				
				&& !queryString.equals("/clinik/index.xhtml")
				&& !queryString.equals("/clinik/")
				&& usuario != null) {
			
			
			log.info("Verificando se o usuario: "+usuario.getLogin()+" tem permissao para acessar a pagina: "+queryString);
			HistoricoAcesso historicoAcesso = new HistoricoAcesso();
			historicoAcesso.setUsuario(usuario);
			historicoAcesso.setPagina(queryString);
			historicoAcesso.setNavegador((String) request2.getHeader("user-agent"));
			historicoAcesso.setIp((String) request2.getRemoteAddr());
			historicoAcesso.setSessaoId(usuario.getSessaoId());
		
			if(!queryString.equals("/clinik/")&& !queryString.equals("/clinik/chamado/")){
				queryString=queryString.replace("/clinik", "");
			}
			Pagina pagina = daoImpl.getPaginaPeloLink(new Pagina(queryString));

			if (pagina == null) {
				log.info("Não foi localizada a pagina: "+queryString+" então verificando se é um módulo.");
				Modulo modulo= moduloDAOImpl.getModuloPeloLink(queryString);
				
				if(modulo!=null){
					
					log.info("Modulo encontrado.");
					historicoAcesso.setTipoAcesso(HistoricoAcesso.AUTORIZADO);
					daoImpl.salvarObjeto2(historicoAcesso);
					
					if(modulo.getNome().equals("Chamados")){
							
					}else if(modulo.getNome().equals("Cliente Amigo")){
						
					}else if(modulo.getNome().equals("Cadastro")){
						
					}else if(modulo.getNome().equals("Notas")){
						
					}else{
						response2.sendRedirect("/clinik/");
						session.invalidate();
					}
				}else{
					log.info("Modulo não  encontrado redirecionando o usuário para a home.");
					
					historicoAcesso.setTipoAcesso(HistoricoAcesso.NAO_AUTORIZADO);
					daoImpl.salvarObjeto2(historicoAcesso);
					redirecionaParaAHome(usuario, response2);
				}
			} else {
				for (PermissaoPaginaRole paginaRole : pagina.getPaginaRoles()) {
					if (paginaRole.getPermissaoPaginaRolePk().getRole()
							.equals(usuario.getRole())) {
						if (!paginaRole.isAutorizado()) {
							historicoAcesso.setTipoAcesso(HistoricoAcesso.AUTORIZADO);
							daoImpl.salvarObjeto2(historicoAcesso);
							redirecionaParaAHome(usuario, response2);
						}
					}
				}
			}
		}
*/
		
		
		
		
		
		filterChain.doFilter(request, response);
		
		
		
		
		HibernateUtil.getCurrentSession().clear();
		HibernateUtil.getCurrentSession().flush();

		// System.out.println("Filtro acabou a requisição");
		// if( HibernateUtil.getCurrentSession()!=null){
		HibernateUtil.doCloseSession();
		// }
		// HibernateUtil.doCommit();

		// } catch (Exception e) {
		// throw new ServletException(e);
		// } finally {
		//
		// }
		
	}
	
	
	public void redirecionaParaAHome(Usuario usuario, HttpServletResponse response2) throws IOException{
		
//		if (usuario.getRole().getPermissao().homeCockpitNotas) {
//			response2.sendRedirect(Paginas.HOME_COCKPIT.toString());
//		} else if (usuario.getRole().getPermissao().homeChamados) {
			response2.sendRedirect(Paginas.PAGE_HOME.toString());
//		} 
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
