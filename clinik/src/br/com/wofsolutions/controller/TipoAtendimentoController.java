package br.com.wofsolutions.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wofsolutions.dao.TipoAtendimentoDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.vo.TipoAtendimento;

@ViewScoped
@ManagedBean
public class TipoAtendimentoController extends
		BaseControllerHelper<TipoAtendimento, TipoAtendimentoDAOImpl> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private static final String GO_PAGE = "/clinik/tipoatendimento/";
	public String novo() {
		novoObjeto();		
		return "pretty:tipoatendimentoCadastro";
	}

	public String cancelar() {
		novoObjeto();
		return "pretty:tipoatendimentoList";
	}
	public void editar() {
		super.editar(GO_PAGE);
	}
	
	
}