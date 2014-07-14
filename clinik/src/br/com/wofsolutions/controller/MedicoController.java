package br.com.wofsolutions.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.wofsolutions.annotation.Parammeter;
import br.com.wofsolutions.dao.MedicoDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.model.MedicoDataModel;
import br.com.wofsolutions.util.MaiaUtil;
import br.com.wofsolutions.vo.Medico;
import br.com.wofsolutions.vo.Modulo;

@ViewScoped
@ManagedBean
@Parammeter(nome = "medicoId")
public class MedicoController extends
		BaseControllerHelper<Medico, MedicoDAOImpl> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String GO_PAGE = "/clinik/medico/";

	@Override
	public void salvar() {
		obj.setSenha(MaiaUtil.md5(obj.getSenha()));
		obj.setMedico(true);
		super.salvar();
	}
	
	
	public String novo() {
		novoObjeto();
		// FacesUtil.redirect(GO_CADASTRO + "0/");
		return "pretty:medicoCadastro";
	}

	public String cancelar() {
		novoObjeto();
		return "pretty:medicoList";
	}
	
	public void editar() {
		super.editar(GO_PAGE);
	}
	
}