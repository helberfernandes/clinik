package br.com.wofsolutions.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import br.com.wofsolutions.annotation.Parammeter;
import br.com.wofsolutions.dao.MedicoDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.util.FacesUtil;
import br.com.wofsolutions.util.MaiaUtil;
import br.com.wofsolutions.vo.Medico;

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
	private static final String PASTA_IMAGENS = "/midia/imagens/";
	private String senhaTemp;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		senhaTemp = obj.getSenha();
		log.info("Senha " + senhaTemp);
	}
	@Override
	public void salvar() {

		if (!obj.getSenha().trim().isEmpty() && obj.getSenha() != null) {

			obj.setSenha(MaiaUtil.md5(obj.getSenha()));
		} else {
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

	@Override
	public void postProcessXLS(Object document) {

		super.initProcessXLS(document);
		wb.setSheetName(0, "Medicos");
		header.setHeightInPoints(45);
		HSSFCell titleCell = header.createCell(0);
		titleCell.setCellValue("Nº");
		titleCell = header.createCell(1);
		titleCell.setCellValue("Nome");
		titleCell = header.createCell(2);
		titleCell.setCellValue("Equipe");
		titleCell = header.createCell(3);
		titleCell.setCellValue("Solicitante");

		super.postProcessXLS(document);
		//

	}
}