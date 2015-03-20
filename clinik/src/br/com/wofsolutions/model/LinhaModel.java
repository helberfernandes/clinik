package br.com.wofsolutions.model;

import java.util.ArrayList;
import java.util.List;

public class LinhaModel {
	
	private String labels;
	private List<LinhaDataSet> dataSets = new ArrayList<LinhaDataSet>();
	private String dataDe;
	private String dataAte;
	private String dataAntDe;
	private String dataAntAte;
	
	public LinhaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

	public LinhaModel(String labels) {
		super();
		this.labels = labels;
	}






	public LinhaModel(String labels, String dataDe, String dataAte,
			String dataAntDe, String dataAntAte) {
		super();
		this.labels = labels;
		this.dataDe = dataDe;
		this.dataAte = dataAte;
		this.dataAntDe = dataAntDe;
		this.dataAntAte = dataAntAte;
	}






	public LinhaModel(String labels, List<LinhaDataSet> dataSets,
			String dataDe, String dataAte, String dataAntDe, String dataAntAte) {
		super();
		this.labels = labels;
		this.dataSets = dataSets;
		this.dataDe = dataDe;
		this.dataAte = dataAte;
		this.dataAntDe = dataAntDe;
		this.dataAntAte = dataAntAte;
	}






	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}



	public String getDataDe() {
		return dataDe;
	}

	public void setDataDe(String dataDe) {
		this.dataDe = dataDe;
	}

	public String getDataAte() {
		return dataAte;
	}

	public void setDataAte(String dataAte) {
		this.dataAte = dataAte;
	}

	public String getDataAntDe() {
		return dataAntDe;
	}

	public void setDataAntDe(String dataAntDe) {
		this.dataAntDe = dataAntDe;
	}

	public String getDataAntAte() {
		return dataAntAte;
	}

	public void setDataAntAte(String dataAntAte) {
		this.dataAntAte = dataAntAte;
	}






	public List<LinhaDataSet> getDataSets() {
		return dataSets;
	}






	public void setDataSets(List<LinhaDataSet> dataSets) {
		this.dataSets = dataSets;
	}

	
	
	
}
