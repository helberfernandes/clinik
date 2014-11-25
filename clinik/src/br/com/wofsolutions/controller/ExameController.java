package br.com.wofsolutions.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Hibernate;

import br.com.wofsolutions.dao.ExameDAOImpl;
import br.com.wofsolutions.dao.MedicoDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.util.HibernateUtil;
import br.com.wofsolutions.vo.Convenio;
import br.com.wofsolutions.vo.Exame;
import br.com.wofsolutions.vo.ExameConvenio;
import br.com.wofsolutions.vo.ExameConvenioPK;
import br.com.wofsolutions.vo.Medico;

@ViewScoped
@ManagedBean
public class ExameController extends BaseControllerHelper<Exame, ExameDAOImpl> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private List<Convenio> convenios;
	private static final String GO_PAGE = "/clinik/exame/";
	private List<Medico> medicos = new ArrayList<Medico>();
	private MedicoDAOImpl medicoDAOImpl = new MedicoDAOImpl();
	
	
	@Override
	public void salvar() {
		
		super.salvar();
	}
	
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
//		
//		for (int i = 0; i < obj.getExameConvenios().size(); i++) {  
//            Hibernate.initialize(obj.getExameConvenios().get(i));  
//        }  
//		
//        
//        for (int i = 0; i < obj.getMedicos().size(); i++) {  
//            Hibernate.initialize(obj.getMedicos().get(i));  
//        }  
		
		
		medicos = medicoDAOImpl.getTotosMedicosEquipe(getUsuarioOnline().getEmpresa());
		
		
		 
         
         
		if(obj.getExameId()==null){
			convenios = dao.findAll3(getUsuarioOnline().getEmpresa());
			
			for (Convenio convenio : convenios) {
				obj.getExameConvenios().add(
						new ExameConvenio(new ExameConvenioPK(obj, convenio), 0.0));
			}
		}else{
			
//			for (Convenio convenio : convenios) {
//				if(!obj.getExameConvenios().contains(new ExameConvenio( new ExameConvenioPK(obj, convenio)))){
//				
//					obj.getExameConvenios().add(
//							new ExameConvenio(new ExameConvenioPK(obj, convenio), 0.0));
//				}
//			}
		}
			
		

	}
	
	
	
	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public void editar() {
		super.editar(GO_PAGE);
	}
}