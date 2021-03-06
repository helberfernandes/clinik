package br.com.wofsolutions.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;

import br.com.wofsolutions.dao.CockpitDAO;
import br.com.wofsolutions.model.KnobModel;
import br.com.wofsolutions.model.LinhaModel;
import br.com.wofsolutions.model.RadarModel;
import br.com.wofsolutions.model.cockpit.QTDCategoriaValor;
import br.com.wofsolutions.model.cockpit.QtdMes;

@ManagedBean
@ViewScoped
public class CockpitController implements Serializable {
	private CockpitDAO cockpitDAO = new CockpitDAO();
	private List<QtdMes> list = new ArrayList<QtdMes>();
	private CartesianChartModel barModel;
	private CartesianChartModel barModel2;
	private PieChartModel pieModel1;
	private PieChartModel pieModel2;
	private MeterGaugeChartModel totalDeProcedimentos;
	
	private List<KnobModel> knobModels = new ArrayList<KnobModel>();
	private RadarModel radarModel;
	private RadarModel radarModelMedico;
	private LinhaModel linhaModel;
	@PostConstruct
	public void init() {

//		barModel = initBarModel();
//		barModel2 = initBarModel2();
//		createPieModel1();
//		createPieModel2();
//		createMeterGaugeModel();
		
		knobModels.add(new KnobModel("Procedimentos", "#C57A75", cockpitDAO.getQtdProcedimentos()));
		knobModels.add(new KnobModel("Procedimentos Falta Guia", "#6994A2", cockpitDAO.getQtdProcedimentosFaltaGuia()));
		knobModels.add(new KnobModel("Wagner", "#B7D5AF", cockpitDAO.getQtdProcedimentosMedicos(1)));
		knobModels.add(new KnobModel("Juan", "#11A1D0", cockpitDAO.getQtdProcedimentosMedicos(10)));
		knobModels.add(new KnobModel("Kalil", "#FF6600", cockpitDAO.getQtdProcedimentosMedicos(37)));
		knobModels.add(new KnobModel("Bertone", "#FFD401", cockpitDAO.getQtdProcedimentosMedicos(4)));
		radarModel=cockpitDAO.getQtdProcedimentosExame();
		
		radarModelMedico = cockpitDAO.getQtdProcedimentosMedico();
		linhaModel       = cockpitDAO.getTotalProcedimentosRealizadosPorMes();
	}

	private CartesianChartModel initBarModel2() {
		barModel2 = new CartesianChartModel();

		List<QTDCategoriaValor> list = cockpitDAO.getQtdGeralProcedimentos();

		ChartSeries boys;
		for (QTDCategoriaValor mes : list) {
			boys = new ChartSeries();
			boys.setLabel(mes.getNome());
			boys.set("Quantidade", mes.getQtd());
			boys.set("Valor", mes.getValor());

			barModel2.addSeries(boys);
		}

		return barModel2;
	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		List<QTDCategoriaValor> list = cockpitDAO
				.getQtdProcedimentosSolicitante();

		for (QTDCategoriaValor mes : list) {
			pieModel1.set(mes.getNome(), mes.getQtd());
		}
	}
	
	
	
	
	private void createPieModel2() {
		pieModel2 = new PieChartModel();

		List<QTDCategoriaValor> list = cockpitDAO
				.getQtdProcedimentosConvenio();

		for (QTDCategoriaValor mes : list) {
			pieModel2.set(mes.getNome(), mes.getQtd());
		}
	}

	public List<KnobModel> getKnobModels() {
		return knobModels;
	}

	public void setKnobModels(List<KnobModel> knobModels) {
		this.knobModels = knobModels;
	}

	public RadarModel getRadarModel() {
		return radarModel;
	}

	public void setRadarModel(RadarModel radarModel) {
		this.radarModel = radarModel;
	}

	public RadarModel getRadarModelMedico() {
		return radarModelMedico;
	}

	public void setRadarModelMedico(RadarModel radarModelMedico) {
		this.radarModelMedico = radarModelMedico;
	}



	public LinhaModel getLinhaModel() {
		return linhaModel;
	}



	public void setLinhaModel(LinhaModel linhaModel) {
		this.linhaModel = linhaModel;
	}
	
}