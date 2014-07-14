package br.com.wofsolutions.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;

import br.com.wofsolutions.dao.AtendimentoDAOImpl;
import br.com.wofsolutions.dao.UsuarioDAOImpl;
import br.com.wofsolutions.filtros.SessionCounterListener;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.mensagens.FacesMessages;
import br.com.wofsolutions.mensagens.MensagensKey;
import br.com.wofsolutions.util.FacesUtil;
import br.com.wofsolutions.vo.Atendimento;
import br.com.wofsolutions.vo.Paginas;
import br.com.wofsolutions.vo.Usuario;
import br.com.wofsolutions.vo.Usuario;

@ManagedBean
@RequestScoped
public class LoginController extends
		BaseControllerHelper<Usuario, UsuarioDAOImpl> implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private static final String GO_SENHA = "/senha.xhtml?faces-redirect=true";
	public boolean lembrar = false;
	public String foto;
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(LoginController.class);

	// ********************************************************//
	// cHAT

	@PostConstruct
	public void init() {	
		 buscaImagem();		 
		 if(foto==null){
			 foto="/midia/imagens/photo.png";
		 }
	}
	
	private void buscaImagem(){
		String cookieName = null;
		Cookie cookie[] = FacesUtil.getRequest().getCookies();

		if (getUsuarioSessao() == null) {
			if (cookie != null && cookie.length > 0) {

				for (int i = 0; i < cookie.length; i++) {
					cookieName = cookie[i].getName();
					if (cookieName.equals("user")) {
						log.info("pegando a foto do usuario");
						Usuario usuarioFoto=dao.getUsuarioPeloNome(cookie[i].getValue());
						obj.setLogin(cookie[i].getValue());
						log.info("Foto encontrada "+usuarioFoto.getFoto());
						foto= usuarioFoto.getFoto();
					}
				}
			}
		}	
	}

	public void logar(ActionEvent e) {
		logar();

		obj = null;
		obj = new Usuario();

	}

	public Usuario logar() {
		Usuario objTmp = dao.getUsuarioPeloNome(obj.getLogin());
		if (objTmp != null) {
			if (objTmp.getSenha().equals(FacesUtil.md5(obj.getSenha()))) {

				if (objTmp.isStatus()) {
					objTmp.setDataUltimoAcesso(new Date());
					objTmp.setHoraUltimoAcesso(new Date());
					objTmp.setQuantidadeDeAcessos(objTmp
							.getQuantidadeDeAcessos() + 1);
					objTmp.setSessaoId(FacesUtil.getSession().getId());

					dao.salvar(objTmp);
					FacesUtil.setAttribute(Usuario.USUARIO_KEY, objTmp);

					SessionCounterListener.usuarisoOnline.add(objTmp);

					if (lembrar) {
						Cookie cklogin = new Cookie("user", obj.getLogin());
						Cookie cksenha = new Cookie("senha", obj.getSenha());
						Cookie cklembrar = new Cookie("lembrar", "" + lembrar);
						cklogin.setMaxAge(3600);
						cksenha.setMaxAge(3600);

						FacesUtil.addCookie(cklogin);
						FacesUtil.addCookie(cksenha);
						FacesUtil.addCookie(cklembrar);
					}

					if (objTmp.isMedico()) {
						FacesUtil.redirect(Paginas.PAGE_HOME_MEDICO);
					} else {
						FacesUtil.redirect(Paginas.PAGE_HOME);
					}

				} else {
					FacesMessages
							.addMessage(MensagensKey.SYSTEM_MSG_USUARIO_INATIVO);
				}

			} else {
				FacesMessages
						.addMessage(MensagensKey.SYSTEM_USUARIO_OU_SENHA_INVALIDO);
			}
		}

		return objTmp;
	}

	public String recuperarSenha() {
		return GO_SENHA;
	}

	public void defineNovaSenha() {

		Usuario objTmp = dao.getUsuarioPeloNome(obj.getLogin());
		if (objTmp != null) {
			objTmp.setSenha(FacesUtil.md5("123456"));
			dao.salvar(objTmp);

			// WOFEmailUtil emailUtil = new WOFEmailUtil();
			// EmailVO email = new EmailVO();
			// email.setAssunto("Nova senha");
			// email.setDe("chamados@supermaia.com.br");
			// email.setPara(objTmp.getEmail());
			// email.setMensagem("Sua nova senha é: 123456<br/><br/><br/><br/><br/>");
			//
			// emailUtil.enviarEmailHTML(email);
			// FacesMessages.addMessage(null,
			// "Uma nova senha foi enviada para seu e-mail");

		}
	}

	public Usuario getUsuarioSessao() {
		return (Usuario) FacesUtil.getAttribute(Usuario.USUARIO_KEY);
	}

	public Usuario getUsuario() {
		return obj;
	}

	public void setUsuario(Usuario obj) {
		this.obj = obj;
	}

	public boolean isLembrar() {
		return lembrar;
	}

	public void setLembrar(boolean lembrar) {
		this.lembrar = lembrar;
	}

	public void idleListener() {

		if (getUsuarioSessao() == null) {
			removerUsuarioLogado();
		}
	}

	public void logout(ActionEvent e) {
		removerUsuarioLogado();
	}

	private void removerUsuarioLogado() {
		Cookie cookie[] = FacesUtil.getRequest().getCookies();

		if (cookie != null && cookie.length > 0) {
			for (int i = 0; i < cookie.length; i++) {

				if (cookie[i].getName().equals("user")
						|| cookie[i].getName().equals("senha")
						|| cookie[i].getName().equals("lembrar")) {

					cookie[i].setValue("");
					cookie[i].setMaxAge(0);

					FacesUtil.addCookie(cookie[i]);
				}

			}
		}

		FacesUtil.getSession().invalidate();
		FacesUtil.redirect(Paginas.LOGIN);

		obj = null;
		obj = new Usuario();                
	}
	
	

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		dao = null;
		obj = null;
	}
}