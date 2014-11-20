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
	

	@PostConstruct
	public void init() {

		barModel = initBarModel();
		barModel2 = initBarModel2();
		createPieModel1();
		createPieModel2();
		createMeterGaugeModel();
	}

	private CartesianChartModel initBarModel() {
		barModel = new CartesianChartModel();

		List<QtdMes> list = cockpitDAO.getTotalProcedimentosRealizadosPorMes();

		ChartSeries boys;
		for (QtdMes mes : list) {
			boys = new ChartSeries();
			boys.setLabel(mes.getNome());
			boys.set("Janeiro", mes.getJaneiro());
			boys.set("Fevereiro", mes.getFevereiro());
			boys.set("Marco", mes.getMarco());
			boys.set("Abril", mes.getAbril());
			boys.set("Maio", mes.getMaio());
			boys.set("Junho", mes.getJunho());
			boys.set("Julho", mes.getJulho());
			boys.set("Agosto", mes.getAgosto());
			boys.set("Setembro", mes.getSetembro());
			boys.set("Outubro", mes.getOutubro());
			boys.set("Novembro", mes.getNovembro());
			boys.set("Dezembro", mes.getDezembro());
			barModel.addSeries(boys);
			
		}

		return barModel;
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
	
	
	private void createMeterGaugeModel() {

		List<Number> intervals = new ArrayList<Number>() {
			{
				add(5);
				add(200);
				add(500);
				add(8000);
				add(30000);
				add(90090);
			}
		};
		
		


		totalDeProcedimentos = new MeterGaugeChartModel( cockpitDAO.getQtdProcedimentos(),
				intervals);
	}
	

	public List<QtdMes> getList() {
		return list;
	}

	public void setList(List<QtdMes> list) {
		this.list = list;
	}

	public CartesianChartModel getBarModel() {

		return barModel;
	}

	public void setBarModel(CartesianChartModel barModel) {
		this.barModel = barModel;
	}

	public CartesianChartModel getBarModel2() {
		return barModel2;
	}

	public void setBarModel2(CartesianChartModel barModel2) {
		this.barModel2 = barModel2;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	public MeterGaugeChartModel getTotalDeProcedimentos() {
		return totalDeProcedimentos;
	}

	public void setTotalDeProcedimentos(MeterGaugeChartModel totalDeProcedimentos) {
		this.totalDeProcedimentos = totalDeProcedimentos;
	}

	
	
}

