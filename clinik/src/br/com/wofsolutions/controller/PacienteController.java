package br.com.wofsolutions.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFCell;

import br.com.wofsolutions.annotation.Parammeter;
import br.com.wofsolutions.dao.PacienteDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.mensagens.FacesMessages;
import br.com.wofsolutions.vo.Alergia;
import br.com.wofsolutions.vo.Diagnostico;
import br.com.wofsolutions.vo.Medicamento;
import br.com.wofsolutions.vo.Paciente;

@ViewScoped
@ManagedBean
public class PacienteController extends
		BaseControllerHelper<Paciente, PacienteDAOImpl> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String GO_PAGE = "/clinik/paciente/";
	private Alergia alergia = new Alergia();
	private List<Alergia> alergiasSelecionadas = new ArrayList<Alergia>();

	private Medicamento medicamento = new Medicamento();
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	private Diagnostico diagnostico = new Diagnostico();
	
	
	public String novo() {
		novoObjeto();
		// FacesUtil.redirect(GO_CADASTRO + "0/");
		return "pretty:pacienteCadastro";
	}

	public String cancelar() {
		novoObjeto();
		return "pretty:pacienteList";
	}

	public void editar() {
		// super.PARAMMETER_KEY = "pacienteId";
		super.editar(GO_PAGE);
	}

	@Override
	public void init() {
		// super.PARAMMETER_KEY = "pacienteId";
		super.init();
	}

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	
	public void novaAlergia(){
		alergia = null;
		alergia= new Alergia();
	}
	
	public void salvarAlergia() {
		alergia.setPaciente(obj);
		alergia.setEmpresa(obj.getEmpresa());
		boolean resp=dao.salvarObjeto(alergia);
		FacesMessages.setMessageSuccessOrFailure(resp);
		alergia = null;
		alergia= new Alergia();
		carregaParammter();
	}
	
	public void excluirAlergia(Alergia alergia){
		alergia.setExcluido(true);
		boolean resp=dao.salvarObjeto(alergia);
		FacesMessages.setMessageSuccessOrFailure(resp);
		alergia = null;
		alergia= new Alergia();
		carregaParammter();
	}
	
	
	public void editarAlergia(Alergia alergia){		
		this.alergia=alergia;
	}

	public List<Alergia> getAlergiasSelecionadas() {
		return alergiasSelecionadas;
	}

	public void setAlergiasSelecionadas(List<Alergia> alergiasSelecionadas) {
		this.alergiasSelecionadas = alergiasSelecionadas;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	
	
	public void novoMedicamento(){
		medicamento = null;
		medicamento= new Medicamento();
	}
	
	public void salvarMedicamento() {
		medicamento.setPaciente(obj);
		
		boolean resp=dao.salvarObjeto(medicamento);
		FacesMessages.setMessageSuccessOrFailure(resp);
		novoMedicamento();
		carregaParammter();
	}
	
	public void excluirMedicamento(Medicamento medicamento){
		//medicamento.setExcluido(true);
//		boolean resp=dao.salvarObjeto(alergia);
//		FacesMessages.setMessageSuccessOrFailure(resp);
//		alergia = null;
//		alergia= new Alergia();
//		carregaParammter();
	}
	
	
	public void editarMedicamento(Medicamento medicamento){		
		this.medicamento= medicamento;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	
	
	public void novoDiagnostico(){
		diagnostico = null;
		diagnostico= new Diagnostico();
	}
	
	public void salvarDiagnostico() {
		diagnostico.setPaciente(obj);
		
		boolean resp=dao.salvarObjeto(diagnostico);
		FacesMessages.setMessageSuccessOrFailure(resp);
		novoDiagnostico();
		carregaParammter();
	}
	
	public void excluirDiagnostic(Diagnostico diagnostico){
		//medicamento.setExcluido(true);
//		boolean resp=dao.salvarObjeto(alergia);
//		FacesMessages.setMessageSuccessOrFailure(resp);
//		alergia = null;
//		alergia= new Alergia();
//		carregaParammter();
	}
	
	
	public void editarDiagnostico(Diagnostico diagnostico){		
		this.diagnostico = diagnostico;
	}
	
	
	@Override
	public void postProcessXLS(Object document) {

		super.initProcessXLS(document);
		wb.setSheetName(0, "Pacientes");
		header.setHeightInPoints(45);
		HSSFCell titleCell = header.createCell(0);
		titleCell.setCellValue("Nº");
		titleCell = header.createCell(1);
		titleCell.setCellValue("Nome");
		titleCell = header.createCell(2);
		titleCell.setCellValue("CPF");
		titleCell = header.createCell(3);
		titleCell.setCellValue("Telefone");
		titleCell = header.createCell(4);

		super.postProcessXLS(document);
		//

	}
}