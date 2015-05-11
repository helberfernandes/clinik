package br.com.wofsolutions.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.schedule.Schedule;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.TreeNode;

import br.com.wofsolutions.dao.AtendimentoDAOImpl;
import br.com.wofsolutions.dao.ConvenioDAOImpl;
import br.com.wofsolutions.dao.ExameDAOImpl;
import br.com.wofsolutions.dao.MedicoDAOImpl;
import br.com.wofsolutions.dao.ModuloDAOImpl;
import br.com.wofsolutions.dao.PacienteDAOImpl;
import br.com.wofsolutions.dao.WorkflowDAOImpl;
import br.com.wofsolutions.helper.BaseControllerHelper;
import br.com.wofsolutions.util.FacesUtil;
import br.com.wofsolutions.util.MaiaUtil;
import br.com.wofsolutions.vo.Atendimento;
import br.com.wofsolutions.vo.EstadoWorkflow;
import br.com.wofsolutions.vo.ExameConvenio;
import br.com.wofsolutions.vo.Medico;
import br.com.wofsolutions.vo.Modulo;

@ViewScoped
@ManagedBean
public class AtendimentoController extends
		BaseControllerHelper<Atendimento, AtendimentoDAOImpl> implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String CSS_FALTA_GUIA="faltaguia";
	private static String CSS_DEFAULT="faltaguia";
	private ScheduleModel eventModel;
	private ScheduleModel eventModelAtendidos;
	private ScheduleEvent event = new DefaultScheduleEvent();
	private TreeNode root;
	private TreeNode selectedNode;
	private MedicoDAOImpl daoImpl = new MedicoDAOImpl();
	private PacienteDAOImpl pacienteDAOImpl = new PacienteDAOImpl();
	private ConvenioDAOImpl convenioDAOImpl = new ConvenioDAOImpl();
	private ExameDAOImpl exameDAOImpl = new ExameDAOImpl();
	private List<Medico> solicitantes = new ArrayList<Medico>();
	private Medico medico;
	private MedicoDAOImpl medicoDAOImpl = new MedicoDAOImpl();
	private WorkflowDAOImpl workflowDAOImpl = WorkflowDAOImpl.getInstancia();
	private List<EstadoWorkflow> estadoWorkflows = new ArrayList<EstadoWorkflow>();
	private ModuloDAOImpl moduloDAOImpl = new ModuloDAOImpl();
	private Boolean disabilita=false;
	
	@Override
	public void init() {
		super.init(BaseControllerHelper.NAO_EXECUTA_FIND_ALL);
		log.info("Iniciando a data para a agenda...");
		try {
			obj.setDataAtendimento(MaiaUtil.StringToDate(MaiaUtil
					.DateToStringDataSomente(new Date())
					+ " "
					+ usuarioOnline.getEmpresa().getHorarioMinimo() + ":00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (usuarioOnline.isMedico()) {
			log.info("Pegando o medico celecionado....");
			medico = medicoDAOImpl.getObjetoPelaChave(usuarioOnline
					.getUsuarioId());
			log.info("Medico carrregado...");
			log.info("Carregando agenda dos atendidos...");			
			atualizaAgendaAtendidos();
			log.info("Agenda carregada dos atendidos...");
		} else {
			log.info("Carregando os medicos...");
			carregaMedicos();
			log.info("Medicos carregados....");
			if (selectedNode != null) {
				medico = (Medico) selectedNode.getData();
			}
		 	obj.setMedico(medico);
		}
		log.info("Carregando agendas...");
		atualizaAgenda();
		log.info("Agenda carregada...");
		log.info("Obtendo os medicos solicitantes...");
		solicitantes = daoImpl.getTotosMedicosSolicitante(usuarioOnline
				.getEmpresa());
		log.info("Medicos solicitantes carregados");
		// if(obj.getStatus().getEstadoWorkflowId()!=null){

		log.info("Carregando os status...");
		estadoWorkflows.add(workflowDAOImpl.getStatusInicial(moduloDAOImpl
				.getObjetoPelaChave(Modulo.AGENDA)));
		log.info("Status carregados.");
		// }
		
	}

	@Override
	public void salvar() {
		System.out.println("Teste  "+obj);
		super.salvar();
		atualizaAgenda();
		
	}

	private void atualizaAgenda() {
		if (medico != null) {
			lista = dao.getTotosAtendimentos(medico);
			eventModel = new DefaultScheduleModel();
		
			for (Atendimento atendimento : lista) {
				
				DefaultScheduleEvent event = new DefaultScheduleEvent(
						  atendimento.getPaciente().getNome()
								+ "\n  "
								+ atendimento.getExame().getNome(),
						atendimento.getDataAtendimento(),
						atendimento.getDataAtendimento(), atendimento);

				if (atendimento.isFaltaGuia()) {
					event.setStyleClass(CSS_DEFAULT);
				} else {
					event.setStyleClass(CSS_FALTA_GUIA);
				}

				eventModel.addEvent(event);
			}
		}
	}

	private void atualizaAgendaAtendidos() {
		lista = dao.getTotosAtendimentos(medico);
		eventModelAtendidos = new DefaultScheduleModel();
		for (Atendimento atendimento : lista) {
			DefaultScheduleEvent event = new DefaultScheduleEvent(
					atendimento.getPaciente().getNome() + "\n  "
					+ atendimento.getExame().getNome(),
					atendimento.getDataAtendimento(),
					atendimento.getDataAtendimento(), atendimento);

			if (atendimento.isFaltaGuia()) {
				event.setStyleClass(CSS_DEFAULT);
			}
			eventModelAtendidos.addEvent(event);
		}
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public void onEventSelectProntuario(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
		novoObjeto();
		obj = (Atendimento) event.getData();
		FacesUtil.redirect("/clinik/paciente/"
				+ obj.getPaciente().getPacienteId() + "/");
	}

	public void addEvent(ActionEvent actionEvent) {
		if (event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);
		event = new DefaultScheduleEvent();
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
		novoObjeto();
		obj = (Atendimento) event.getData();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(),
				(Date) selectEvent.getObject());
		Schedule schedule = (Schedule) selectEvent.getSource();
		// System.out.println(obj);
		novoObjeto();
		obj.setMedico(medico);
		// obj=(Atendimento)
		// schedule.getValue().getEvent(schedule.getDefaultEventName()).getData();
		
		
		obj.setDataAtendimento((Date) selectEvent.getObject());
		
		if(MaiaUtil.diferencaEmHoras((Date) selectEvent.getObject(), new Date())<=0){
		
			RequestContext.getCurrentInstance().execute("PF('eventDialog').show()");
		}else{
			System.out.println("Não pode marcar");
		}
		
		
	
		
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {

		Schedule schedule = (Schedule) event.getSource();
		novoObjeto();
		obj.setMedico(medico);
		obj = (Atendimento) event.getScheduleEvent().getData();

		// Calendar calendar = new GregorianCalendar();
		// calendar.setTime(obj.getDataAtendimento());
		// calendar.add(Calendar.DAY_OF_MONTH, (event.getDayDelta())-2);
		// obj.setDataAtendimento(calendar.getTime());

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event moved" + obj.getDataAtendimento(), "Day delta:"
						+ event.getDayDelta() + ", Minute delta:"
						+ event.getMinuteDelta());
		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		Schedule schedule = (Schedule) event.getSource();
		obj = (Atendimento) event.getScheduleEvent().getData();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event resized " + obj.getDataAtendimento(), "Day delta:"
						+ event.getDayDelta() + ", Minute delta:"
						+ event.getMinuteDelta());
		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	private void carregaMedicos() {
		root = new DefaultTreeNode("Médicos", null);
		List<Medico> list = daoImpl.getTotosMedicosEquipe(usuarioOnline
				.getEmpresa());
		TreeNode node;
		boolean primeiro = true;
		for (Medico medico : list) {
			node = new DefaultTreeNode("medico", medico, root);
			if (primeiro) {
				node.setSelected(true);
				selectedNode = node;
				primeiro = false;
			}
		}
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public void onNodeSelect(NodeSelectEvent event) {
		medico = (Medico) selectedNode.getData();
		obj.setMedico(medico);
		atualizaAgenda();
	}

	public void incluirPaciente() {
		if (facesUtil.getParammeter("pacienteId") != null) {
			obj.setPaciente(pacienteDAOImpl.getObjetoPelaChave(facesUtil
					.getParammeterASInteger("pacienteId")));
		}
	}

	public void incluirConvenio() {
		if (facesUtil.getParammeter("convenioId") != null) {
			obj.setConvenio(convenioDAOImpl.getObjetoPelaChave(facesUtil
					.getParammeterASInteger("convenioId")));

			for (ExameConvenio exameConvenio : obj.getConvenio()
					.getExameConvenios()) {
				if (obj.getConvenio().getConvenioId() != null) {
					if (obj.getConvenio().equals(
							exameConvenio.getExameConvenioPK().getConvenio())) {
						obj.setValor(exameConvenio.getValor());
					}
				}
			}
		}
	}

	public void incluirSolicitante() {
		if (facesUtil.getParammeter("solicitanteId") != null) {
			obj.setSolicitante(daoImpl.getObjetoPelaChave(facesUtil
					.getParammeterASInteger("solicitanteId")));
			;
		}
	}

	public void incluirExame() {
		if (facesUtil.getParammeter("exameId") != null) {
			obj.setExame(exameDAOImpl.getObjetoPelaChave(facesUtil
					.getParammeterASInteger("exameId")));

			for (ExameConvenio exameConvenio : obj.getExame()
					.getExameConvenios()) {
				if (obj.getConvenio().getConvenioId() != null) {
					if (obj.getConvenio().equals(
							exameConvenio.getExameConvenioPK().getConvenio())) {
						obj.setValor(exameConvenio.getValor());
					}
				}
			}

		}
	}
	
	
	/**
	 * Desabilitando todos os status exceto o atual
	 * pois ja passou o atendimento	 
	 * @return
	 */
	public Boolean getDisabilita() {
		if(MaiaUtil.diffData(obj.getDataAtendimento(), new Date())<0){
			disabilita= true;
		}else{
			disabilita= false;
		}
		return disabilita;
	}

	public void setDisabilita(Boolean disabilita) {
		this.disabilita = disabilita;
	}

	public List<Medico> getSolicitantes() {
		return solicitantes;
	}

	public void setSolicitantes(List<Medico> solicitantes) {
		this.solicitantes = solicitantes;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public ScheduleModel getEventModelAtendidos() {
		return eventModelAtendidos;
	}

	public void setEventModelAtendidos(ScheduleModel eventModelAtendidos) {
		this.eventModelAtendidos = eventModelAtendidos;
	}

	public List<EstadoWorkflow> getEstadoWorkflows() {
		return estadoWorkflows;
	}

	public void setEstadoWorkflows(List<EstadoWorkflow> estadoWorkflows) {
		this.estadoWorkflows = estadoWorkflows;
	}

}