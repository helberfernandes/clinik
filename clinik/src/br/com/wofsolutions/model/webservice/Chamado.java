package br.com.wofsolutions.model.webservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Chamado implements Serializable {

	/** 
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	
	

	
	private Integer chamadoId;


	private String numChamado;
	

	private String numChamadoArupado;
	


	private String data = new String();


	private String dateForFilter;
	
	
	private String hora;


	
	private String dataFechamento = new String();
	
	
	private String dataPendenteParaAprovacao= new String();
	
	

	
	private String dataVisualizadoAdmin= new String();
	

	private String dataVisualizadoFrente= new String();
	
	
	private String dataVisualizadoGerente= new String();
	
	

	private String dataVisualizadoTecnico= new String();
	
	

	private Loja loja;
	
	

	private Local local;
	

	private Usuario solicitante;
	

	private Usuario tecnico;

	
	
	private Usuario tecnicoSolicitente;
	
	
	private Usuario tecnicoTerceiro;

	
	private Equipamento equipamento = new Equipamento();

	
	private Equipamento equipamentoSubistituto;	
	
	private String empresa = "Patrimônio";

	
	private String numSerie;
	
	
	private String numSerieSubistituto;
	
	
	private String descricaoProblema;
	
	private String status;
	
	private Integer atribuido = 0;
	
	
	
	private Integer prioridade;
	
	
	private String descricaoFechamento;
	
	
	private String observacaoGerente;
	
	
	private String motivoCancelamento;
	
	
	private String descricaoOrcamento;
	
	
	private String descricaoOrcamentoAprovado;
	
	
	private String observacao;
	
	
	
	private Double valorVisitaTecnica=0.0;

	
//	
//	@OneToMany
//	@JoinColumn(name = "chamado_id", referencedColumnName = "chamado_id")
//	@Cascade(CascadeType.ALL)
//	@Fetch(FetchMode.JOIN)
//	private List<HistoricoChamado> historicoChamados = new ArrayList<HistoricoChamado>();
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "wof_pecas_chamados", joinColumns = @JoinColumn(name = "chamado_id"), inverseJoinColumns = @JoinColumn(name = "peca_id"))
//	
	
	private List<PecaChamado> pecaChamados = new ArrayList<PecaChamado>();
	
	
	
	
	private boolean selected;

	private String atribuidoNome;

	
	private Integer tipoNunSerieEtiqueta= 0;
	
	
	
	public Chamado() {
		// data = format.format(new String());

		
		

	}
	




	public Chamado(Integer chamadoId, String numChamado, String data,
			String hora, Loja loja, Usuario solicitante, Usuario tecnico,
			Equipamento equipamento, String empresa, String numSerie,
			String descricaoProblema, String status,
			String descricaoFechamento, String observacaoGerente,
			String observacao) {
		super();
		this.chamadoId = chamadoId;
		this.numChamado = numChamado;
		this.data = data;
		this.hora = hora;
		this.loja = loja;
		this.solicitante = solicitante;
		this.tecnico = tecnico;
		this.equipamento = equipamento;
		this.empresa = empresa;
		this.numSerie = numSerie;
		this.descricaoProblema = descricaoProblema;
		this.status = status;
		this.descricaoFechamento = descricaoFechamento;
		this.observacaoGerente = observacaoGerente;
		this.observacao = observacao;
	}





	public Chamado(Integer chamadoId) {
		this.chamadoId = chamadoId;
	}

	public Integer getChamadoId() {
		return chamadoId;
	}

	public void setChamadoId(Integer chamadoId) {
		this.chamadoId = chamadoId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public Usuario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Integer getAtribuido() {
		return atribuido;
	}

	public void setAtribuido(Integer atribuido) {
		this.atribuido = atribuido;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public String getNumChamado() {
		return numChamado;
	}

	public void setNumChamado(String numChamado) {
		this.numChamado = numChamado;
	}

	

	public String getDescricaoFechamento() {
		return descricaoFechamento;
	}

	public void setDescricaoFechamento(String descricaoFechamento) {
		this.descricaoFechamento = descricaoFechamento;
	}

	public String getAtribuidoNome() {
		return atribuidoNome;
	}

	public void setAtribuidoNome(String atribuidoNome) {
		this.atribuidoNome = atribuidoNome;
	}

	public String getObservacaoGerente() {
		return observacaoGerente;
	}

	public void setObservacaoGerente(String observacaoGerente) {
		this.observacaoGerente = observacaoGerente;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Usuario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}

	public Usuario getTecnicoTerceiro() {
		return tecnicoTerceiro;
	}

	public void setTecnicoTerceiro(Usuario tecnicoTerceiro) {
		this.tecnicoTerceiro = tecnicoTerceiro;
	}





	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}





	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}





	public String getDescricaoOrcamento() {
		return descricaoOrcamento;
	}





	public void setDescricaoOrcamento(String descricaoOrcamento) {
		this.descricaoOrcamento = descricaoOrcamento;
	}





	




	public String getDescricaoOrcamentoAprovado() {
		return descricaoOrcamentoAprovado;
	}





	public void setDescricaoOrcamentoAprovado(String descricaoOrcamentoAprovado) {
		this.descricaoOrcamentoAprovado = descricaoOrcamentoAprovado;
	}





	public Integer getTipoNunSerieEtiqueta() {
		return tipoNunSerieEtiqueta;
	}





	public void setTipoNunSerieEtiqueta(Integer tipoNunSerieEtiqueta) {
		this.tipoNunSerieEtiqueta = tipoNunSerieEtiqueta;
	}





	public String getDataPendenteParaAprovacao() {
		return dataPendenteParaAprovacao;
	}





	public void setDataPendenteParaAprovacao(String dataPendenteParaAprovacao) {
		this.dataPendenteParaAprovacao = dataPendenteParaAprovacao;
	}





	public String getDataVisualizadoAdmin() {
		return dataVisualizadoAdmin;
	}





	public void setDataVisualizadoAdmin(String dataVisualizadoAdmin) {
		this.dataVisualizadoAdmin = dataVisualizadoAdmin;
	}





	public String getDataVisualizadoFrente() {
		return dataVisualizadoFrente;
	}





	public void setDataVisualizadoFrente(String dataVisualizadoFrente) {
		this.dataVisualizadoFrente = dataVisualizadoFrente;
	}





	public String getDataVisualizadoGerente() {
		return dataVisualizadoGerente;
	}





	public void setDataVisualizadoGerente(String dataVisualizadoGerente) {
		this.dataVisualizadoGerente = dataVisualizadoGerente;
	}





	public String getDataVisualizadoTecnico() {
		return dataVisualizadoTecnico;
	}





	public void setDataVisualizadoTecnico(String dataVisualizadoTecnico) {
		this.dataVisualizadoTecnico = dataVisualizadoTecnico;
	}











	public Equipamento getEquipamentoSubistituto() {
		return equipamentoSubistituto;
	}





	public void setEquipamentoSubistituto(Equipamento equipamentoSubistituto) {
		this.equipamentoSubistituto = equipamentoSubistituto;
	}





	public String getNumSerieSubistituto() {
		return numSerieSubistituto;
	}





	public void setNumSerieSubistituto(String numSerieSubistituto) {
		this.numSerieSubistituto = numSerieSubistituto;
	}










	public List<PecaChamado> getPecaChamados() {
		return pecaChamados;
	}





	public void setPecaChamados(List<PecaChamado> pecaChamados) {
		this.pecaChamados = pecaChamados;
	}





	public Local getLocal() {
		return local;
	}





	public void setLocal(Local local) {
		this.local = local;
	}





	public String getNumChamadoArupado() {
		return numChamadoArupado;
	}





	public void setNumChamadoArupado(String numChamadoArupado) {
		this.numChamadoArupado = numChamadoArupado;
	}





	public Double getValorVisitaTecnica() {
		return valorVisitaTecnica;
	}





	public void setValorVisitaTecnica(Double valorVisitaTecnica) {
		this.valorVisitaTecnica = valorVisitaTecnica;
	}





	public String getDataFechamento() {
		return dataFechamento;
	}





	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}





	public String getStringForFilter() {
		return dateForFilter;
	}





	public void setStringForFilter(String dateForFilter) {
		this.dateForFilter = dateForFilter;
	}





	public Usuario getTecnicoSolicitente() {
		return tecnicoSolicitente;
	}





	public void setTecnicoSolicitente(Usuario tecnicoSolicitente) {
		this.tecnicoSolicitente = tecnicoSolicitente;
	}





	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Chamado other = (Chamado) obj;
		if (this.chamadoId != other.chamadoId
				&& (this.chamadoId == null || !this.chamadoId
						.equals(other.chamadoId))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash
				+ (this.chamadoId != null ? this.chamadoId.hashCode() : 0);
		return hash;
	}





	@Override
	public String toString() {
		return "Chamado [chamadoId=" + chamadoId + "]";
	}

	
}
