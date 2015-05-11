package br.com.wofsolutions.controller;

import java.io.File;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import br.com.wofsolutions.annotation.Parammeter;
import br.com.wofsolutions.dao.EmpresaDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.util.FacesUtil;
import br.com.wofsolutions.util.RandomIntGenerator;
import br.com.wofsolutions.vo.Empresa;

@ViewScoped
@ManagedBean
@Parammeter(nome = "empresaId")
public class EmpresaController extends
		BaseControllerHelper<Empresa, EmpresaDAOImpl> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String GO_PAGE = "/clinik/empresa/";
	private static final String PASTA_IMAGENS = "/midia/imagens/";

	@Override
	public void salvar() {
		obj.setDataCadastro(new Date());
		super.salvar();
	}
	
	public String novo() {
		novoObjeto();
		// FacesUtil.redirect(GO_CADASTRO + "0/");
		return "pretty:empresaCadastro";
	}

	public String cancelar() {
		novoObjeto();
		return "pretty:empresaList";
	}
	public void init() {
		super.init(BaseControllerHelper.FINDALL_SEM_EMPRESA);
	}	
	
	public void editar() {
		super.editar(GO_PAGE);
	}
	
	
	public void uploadLogo(FileUploadEvent event) {

		RandomIntGenerator r1 = new RandomIntGenerator(1, 10);

		String logo = FacesUtil.getCaminho(PASTA_IMAGENS) + File.separator
				+ event.getFile().getFileName();
		obj.setLogo(PASTA_IMAGENS+event.getFile().getFileName());
		

				log.info("Criando o arquivo... " + logo);
		facesUtil.criaArquivo(event.getFile().getContents(), new File(
				logo));
		
		FacesUtil.redimensiona(logo, 260, 120, logo);
	}
}