package br.com.wofsolutions.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFCell;

import br.com.wofsolutions.dao.ConvenioDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.vo.Convenio;

@ViewScoped
@ManagedBean
public class ConvenioController extends
		BaseControllerHelper<Convenio, ConvenioDAOImpl> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String GO_PAGE = "/clinik/convenio/";

	public String novo() {
		novoObjeto();
		// FacesUtil.redirect(GO_CADASTRO + "0/");
		return "pretty:convenioCadastro";
	}

	public String cancelar() {
		novoObjeto();
		return "pretty:convenioList";
	}	
	
	
	public void editar() {
		super.editar(GO_PAGE);
	}
	
	@Override
	public void postProcessXLS(Object document) {

		super.initProcessXLS(document);
		wb.setSheetName(0, "Convenio");
		header.setHeightInPoints(45);
		HSSFCell titleCell = header.createCell(0);
		titleCell.setCellValue("Nº");
		titleCell = header.createCell(1);
		titleCell.setCellValue("Nome");
		titleCell = header.createCell(2);
		

		super.postProcessXLS(document);
		//

	}
}