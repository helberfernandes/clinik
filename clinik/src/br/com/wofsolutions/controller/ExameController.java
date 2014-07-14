package br.com.wofsolutions.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wofsolutions.dao.ExameDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.vo.Convenio;
import br.com.wofsolutions.vo.Exame;
import br.com.wofsolutions.vo.ExameConvenio;
import br.com.wofsolutions.vo.ExameConvenioPK;

@ViewScoped
@ManagedBean
public class ExameController extends BaseControllerHelper<Exame, ExameDAOImpl> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private List<Convenio> convenios;
	private static final String GO_PAGE = "/clinik/exame/";
		
	
	
	
	public String novo() {
		novoObjeto();
		// FacesUtil.redirect(GO_CADASTRO + "0/");
		return "pretty:exameCadastro";
	}

	public String cancelar() {
		novoObjeto();
		return "pretty:exameList";
	}


	@Override
	public void init() {
		super.init();
		convenios = dao.findAll3(getUsuarioOnline().getEmpresa());
		
		if(obj.getExameId()==null){
			for (Convenio convenio : convenios) {
				obj.getExameConvenios().add(
						new ExameConvenio(new ExameConvenioPK(obj, convenio), 0.0));
			}
		}else{
			for (Convenio convenio : convenios) {
				if(!obj.getExameConvenios().contains(new ExameConvenio( new ExameConvenioPK(obj, convenio)))){
				
					obj.getExameConvenios().add(
							new ExameConvenio(new ExameConvenioPK(obj, convenio), 0.0));
				}
			}
		}
			
		

	}
	
	public void editar() {
		super.editar(GO_PAGE);
	}
}