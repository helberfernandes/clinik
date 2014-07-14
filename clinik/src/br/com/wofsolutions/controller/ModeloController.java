package br.com.wofsolutions.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wofsolutions.annotation.Parammeter;
import br.com.wofsolutions.dao.ModeloDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.vo.Modelo;

@ViewScoped
@ManagedBean
@Parammeter(nome = "modeloId")
public class ModeloController extends
		BaseControllerHelper<Modelo, ModeloDAOImpl> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private static final String GO_PAGE = "/clinik/modelo/";
	public String novo() {
		novoObjeto();
		// FacesUtil.redirect(GO_CADASTRO + "0/");
		return "pretty:modeloCadastro";
	}

	public String cancelar() {
		novoObjeto();
		return "pretty:modeloList";
	}
	public void editar() {
		super.editar(GO_PAGE);
	}
	
}