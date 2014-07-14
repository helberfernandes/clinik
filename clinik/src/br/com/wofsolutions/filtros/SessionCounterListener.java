package br.com.wofsolutions.filtros;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import br.com.wofsolutions.util.FacesUtil;
import br.com.wofsolutions.util.HibernateUtil;
import br.com.wofsolutions.vo.Paginas;
import br.com.wofsolutions.vo.Usuario;
import br.com.wofsolutions.vo.Usuario;

public class SessionCounterListener implements HttpSessionListener {

	/** The Constant activeSessions. */
	public static final List<Usuario> usuarisoOnline = new ArrayList<Usuario>();
	public static final WeakHashMap<String, HttpSession> sessions = new WeakHashMap<String, HttpSession>();

	/**
	 * Log the created session.
	 * 
	 * @param event
	 *            the http session event
	 */
	public final void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		sessions.put(session.getId(), session);
	}

	/**
	 * Discard the destroyed session.
	 * 
	 * @param event
	 *            the http session event
	 */
	public final void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		Usuario usuario = (Usuario) session.getAttribute(Usuario.USUARIO_KEY);
		if (usuario != null) {
			usuarisoOnline.remove(usuario);
			sessions.remove(usuario.getSessaoId());
		}
	}
}