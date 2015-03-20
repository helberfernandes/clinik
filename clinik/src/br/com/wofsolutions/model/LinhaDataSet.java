package br.com.wofsolutions.model;

import java.io.Serializable;

public class LinhaDataSet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String label;
	private String data1;
	private String cor;


	

	
	

	public LinhaDataSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinhaDataSet(String label, String data1) {
		super();
		this.label = label;
		this.data1 = data1;
		
	}
	

	public LinhaDataSet(String label, String data1, String cor) {
		super();
		this.label = label;
		this.data1 = data1;
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}


}
