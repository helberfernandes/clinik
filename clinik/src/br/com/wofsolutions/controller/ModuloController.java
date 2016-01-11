package br.com.wofsolutions.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wofsolutions.annotation.Parammeter;
import br.com.wofsolutions.dao.ModuloDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.vo.Modulo;

@ManagedBean
@ViewScoped
@Parammeter(nome="moduloId")
public class ModuloController extends
		BaseControllerHelper<Modulo , ModuloDAOImpl> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ORDER_DEFAULT="descricao";
	
	@PostConstruct
	public void init() {
		super.init(ModuloController.NAO_EXECUTA_FIND_ALL);
		lista= dao.findAll(ORDER_DEFAULT);		
	}
	public String novo() {
		novoObjeto();
		return "pretty:moduloCadastro";
	}
	public String cancelar() {
		novoObjeto();
		return "pretty:moduloList";
	}	
}