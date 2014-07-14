package br.com.wofsolutions.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wofsolutions.util.FacesUtil;
import br.com.wofsolutions.vo.Usuario;
import br.com.wofsolutions.vo.Usuario;
/**
 * Controla a sessao do sistema 
 * @author Helber
 *
 */
@ManagedBean
@ViewScoped
public class SessaoController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return usuario logado no momento
	 */
	public Usuario getUsuarioSessao() {
		return (Usuario) FacesUtil.getAttribute(Usuario.USUARIO_KEY);
	}
}
