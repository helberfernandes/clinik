package br.com.wofsolutions.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.com.wofsolutions.dao.ConvenioDAOImpl;
import br.com.wofsolutions.dao.ExameDAOImpl;
import br.com.wofsolutions.dao.MedicoDAOImpl;
import br.com.wofsolutions.util.FacesUtil;
import br.com.wofsolutions.util.RelatorioUtil;
import br.com.wofsolutions.vo.Convenio;
import br.com.wofsolutions.vo.Exame;
import br.com.wofsolutions.vo.Medico;
import br.com.wofsolutions.vo.Usuario;

@ManagedBean
@ViewScoped
public class RelatorioController implements Serializable {

	@ManagedProperty(value = "#{sessaoController.usuarioSessao}")
	protected Usuario usuarioOnline;

	private Date dataDe = new Date();
	private Date dataAte = new Date();
	private boolean faltaGuia = false;
	private MedicoDAOImpl medicoDAOImpl = new MedicoDAOImpl();
	private List<Medico> medicosEquipe = new ArrayList<Medico>();
	private Medico medicoEquipe;
	private boolean mostrarMedico = false;
	
	private List<Medico> medicosSolicitante = new ArrayList<Medico>();
	private Medico medicoSolicitante;
	private boolean mostrarSolicitante = false;
	
	private ExameDAOImpl exameDAOImpl = new ExameDAOImpl();
	private List<Exame> exames = new ArrayList<Exame>();
	private Exame exame = new Exame();
	private boolean mostrarExame = false;
	
	private ConvenioDAOImpl convenioDAOImpl = new ConvenioDAOImpl();
	private Convenio convenio = new Convenio();
	private List<Convenio> convenios = new ArrayList<Convenio>();
	private boolean mostrarConvenio = false;
	
	private static final String EXAME_ID    = "exameId";
	private static final String MEDICO_ID   = "medicoId";
	private static final String CONVENIO_ID = "convenioId";
	
	private static String DATA_DE= "dataDe";
	
	@PostConstruct
	public void init() {
		medicosEquipe = medicoDAOImpl.getTotosMedicosEquipe(usuarioOnline
				.getEmpresa());
		
		medicosSolicitante = medicoDAOImpl.getTotosMedicosSolicitante(usuarioOnline
				.getEmpresa());
		
		exames = exameDAOImpl.getTotosExames(getUsuarioOnline().getEmpresa());
		convenios = convenioDAOImpl.getTotosConvenios(getUsuarioOnline().getEmpresa());

	}

	public void imprimeRelatorioAtendimento() {

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		parametros.put(MEDICO_ID,
				mostrarMedico == true ? medicoEquipe.getMedicoId() : 0);
		//parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath("midia/imagens/"+usuarioOnline.getEmpresa().getLogo()));
		parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath(usuarioOnline.getEmpresa().getLogo()));
		parametros.put("usuario", usuarioOnline.getNome());

		parametros.put(DATA_DE, getDataDe());
		parametros.put("dataAte", getDataAte());
		parametros.put("faltaGuia", faltaGuia);

		RelatorioUtil.teste("relProcedimentos.jasper", parametros);
	}

	public void imprimeRelatorioProcedimentoPorExame() {

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		parametros.put(EXAME_ID, mostrarExame == true ? exame.getExameId()
				: 0);
		
		parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath("midia/imagens/"+usuarioOnline.getEmpresa().getLogo()));

		parametros.put("usuario", usuarioOnline.getNome());

		parametros.put(DATA_DE, getDataDe());
		parametros.put("dataAte", getDataAte());
		parametros.put("faltaGuia", faltaGuia);

		RelatorioUtil.teste("relAtendimentosporExames.jasper", parametros);
	}

	public void imprimeRelatorioGeralProcedimentoPorExame() {

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		parametros.put(EXAME_ID, mostrarExame == true ? exame.getExameId()
				: 0);
		parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath("midia/imagens/"+usuarioOnline.getEmpresa().getLogo()));

		//parametros.put("usuario", usuarioOnline.getNome());

		parametros.put(DATA_DE, getDataDe());
		parametros.put("dataAte", getDataAte());
		

		RelatorioUtil.teste("relQTDProcedimentosPorExames.jasper", parametros);
	}
	
	
	
	
	public void imprimeRelatorioQtdProcedimentoPorConvenio() {

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		parametros.put(EXAME_ID, mostrarExame == true ? exame.getExameId()
				: 0);

		parametros.put(CONVENIO_ID, mostrarConvenio == true ? convenio.getConvenioId()
				: 0);
		
		parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath("midia/imagens/"+usuarioOnline.getEmpresa().getLogo()));
		
		//parametros.put("usuario", usuarioOnline.getNome());

		parametros.put(DATA_DE, getDataDe());
		parametros.put("dataAte", getDataAte());
	 

		RelatorioUtil.teste("relQTDExamesPorConvenio.jasper", parametros);
	}
	
	
	
	public void imprimeRelatorioQtdMensalExame() {

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		parametros.put(EXAME_ID, mostrarExame == true ? exame.getExameId()
				: 0);

		parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath("midia/imagens/"+usuarioOnline.getEmpresa().getLogo()));
		//parametros.put("usuario", usuarioOnline.getNome());

		parametros.put(DATA_DE, getDataDe());
		parametros.put("dataAte", getDataAte());
		

		RelatorioUtil.teste("relTotalProcedimentosPorMes.jasper", parametros);
	}

	public void imprimeRelatorioQtdProcedimentoSolicitante() {

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		parametros.put(MEDICO_ID, mostrarSolicitante == true ? medicoSolicitante.getMedicoId()
				: 0);

		//parametros.put("usuario", usuarioOnline.getNome());
		parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath("midia/imagens/"+usuarioOnline.getEmpresa().getLogo()));
		parametros.put(DATA_DE, getDataDe());
		parametros.put("dataAte", getDataAte());
		

		RelatorioUtil.teste("relQTDProcedimentosPorSolicitante.jasper", parametros);
	}
	
	
	
	
	public void imprimeRelatorioTotalProcedimentoSolicitante() {

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		parametros.put(EXAME_ID, mostrarExame == true ? exame.getExameId()
				: 0);
		parametros.put(MEDICO_ID, mostrarSolicitante == true ? medicoSolicitante.getMedicoId()
				: 0);

		parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath("midia/imagens/"+usuarioOnline.getEmpresa().getLogo()));
		//parametros.put("usuario", usuarioOnline.getNome());

		parametros.put(DATA_DE, getDataDe());
		parametros.put("dataAte", getDataAte());
		

		RelatorioUtil.teste("relTotalProcedimentosPorMedico.jasper", parametros);
	}
	public void imprimeRelatorioTotalProcedimentoJuan() {

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		parametros.put(MEDICO_ID, mostrarSolicitante == true ? medicoSolicitante.getMedicoId()
				: 0);

		
		parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath("midia/imagens/"+usuarioOnline.getEmpresa().getLogo()));
		//parametros.put("usuario", usuarioOnline.getNome());

		parametros.put(DATA_DE, getDataDe());
		parametros.put("dataAte", getDataAte());
		

		RelatorioUtil.teste("relQTDProcedimentosPorDRJuan.jasper", parametros);
	}
	
	
	
	public void imprimeRelatorioTotalProcedimentoKalil() {

		HashMap<String, Object> parametros = new HashMap<String, Object>();

		parametros.put(MEDICO_ID, mostrarSolicitante == true ? medicoSolicitante.getMedicoId()
				: 0);

		//parametros.put("usuario", usuarioOnline.getNome());
		parametros.put("logoEmpresa",FacesUtil.getExternalContext().getRealPath("midia/imagens/"+usuarioOnline.getEmpresa().getLogo()));
		parametros.put(DATA_DE, getDataDe());
		parametros.put("dataAte", getDataAte());
		

		RelatorioUtil.teste("relQTDProcedimentosPorDRKalil.jasper", parametros);
	}
	
	public Date getDataDe() {
		return dataDe;
	}

	public void setDataDe(Date dataDe) {
		this.dataDe = dataDe;
	}

	public Date getDataAte() {
		return dataAte;
	}

	public void setDataAte(Date dataAte) {
		this.dataAte = dataAte;
	}

	public boolean isFaltaGuia() {
		return faltaGuia;
	}

	public void setFaltaGuia(boolean faltaGuia) {
		this.faltaGuia = faltaGuia;
	}

	public Usuario getUsuarioOnline() {
		return usuarioOnline;
	}

	public void setUsuarioOnline(Usuario usuarioOnline) {
		this.usuarioOnline = usuarioOnline;
	}

	public MedicoDAOImpl getMedicoDAOImpl() {
		return medicoDAOImpl;
	}

	public void setMedicoDAOImpl(MedicoDAOImpl medicoDAOImpl) {
		this.medicoDAOImpl = medicoDAOImpl;
	}

	public List<Medico> getMedicosEquipe() {
		return medicosEquipe;
	}

	public void setMedicosEquipe(List<Medico> medicosEquipe) {
		this.medicosEquipe = medicosEquipe;
	}

	public Medico getMedicoEquipe() {
		return medicoEquipe;
	}

	public void setMedicoEquipe(Medico medicoEquipe) {
		this.medicoEquipe = medicoEquipe;
	}

	public boolean isMostrarMedico() {
		return mostrarMedico;
	}

	public void setMostrarMedico(boolean mostrarMedico) {
		this.mostrarMedico = mostrarMedico;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public boolean isMostrarExame() {
		return mostrarExame;
	}

	public void setMostrarExame(boolean mostrarExame) {
		this.mostrarExame = mostrarExame;
	}

	public ExameDAOImpl getExameDAOImpl() {
		return exameDAOImpl;
	}

	public void setExameDAOImpl(ExameDAOImpl exameDAOImpl) {
		this.exameDAOImpl = exameDAOImpl;
	}

	public ConvenioDAOImpl getConvenioDAOImpl() {
		return convenioDAOImpl;
	}

	public void setConvenioDAOImpl(ConvenioDAOImpl convenioDAOImpl) {
		this.convenioDAOImpl = convenioDAOImpl;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public List<Convenio> getConvenios() {
		return convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

	public boolean isMostrarConvenio() {
		return mostrarConvenio;
	}

	public void setMostrarConvenio(boolean mostrarConvenio) {
		this.mostrarConvenio = mostrarConvenio;
	}

	public List<Medico> getMedicosSolicitante() {
		return medicosSolicitante;
	}

	public void setMedicosSolicitante(List<Medico> medicosSolicitante) {
		this.medicosSolicitante = medicosSolicitante;
	}

	public Medico getMedicoSolicitante() {
		return medicoSolicitante;
	}

	public void setMedicoSolicitante(Medico medicoSolicitante) {
		this.medicoSolicitante = medicoSolicitante;
	}

	public boolean isMostrarSolicitante() {
		return mostrarSolicitante;
	}

	public void setMostrarSolicitante(boolean mostrarSolicitante) {
		this.mostrarSolicitante = mostrarSolicitante;
	}
	
	

}
