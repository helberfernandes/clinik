package br.com.wofsolutions.model;

import java.util.Date;

public class RadarModel {
	private String labels;
	private String data1;
	private String data2;
	private String dataDe;
	private String dataAte;
	private String dataAntDe;
	private String dataAntAte;

	public RadarModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RadarModel(String labels, String data1, String data2) {
		super();
		this.labels = labels;
		this.data1 = data1;
		this.data2 = data2;
	}

	
	
	public RadarModel(String labels, String data1, String data2, String dataDe,
			String dataAte, String dataAntDe, String dataAntAte) {
		super();
		this.labels = labels;
		this.data1 = data1;
		this.data2 = data2;
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

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
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
	
	
}
