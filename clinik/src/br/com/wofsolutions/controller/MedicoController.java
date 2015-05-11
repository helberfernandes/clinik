package br.com.wofsolutions.controller;

import java.util.ArrayList;
import java.util.List;

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
	private String senhaTemp;
	
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		senhaTemp=obj.getSenha();
		log.info("Senha "+senhaTemp);
	}


	@Override
	public void salvar() {
		
		if(!obj.getSenha().trim().isEmpty() && obj.getSenha()!=null){
			
			obj.setSenha(MaiaUtil.md5(obj.getSenha()));
		}else{
			obj.setSenha(senhaTemp);
		}
		obj.setMedico(true);
		super.salvar();
	}
	
	
	public String novo() {
		novoObjeto();		
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