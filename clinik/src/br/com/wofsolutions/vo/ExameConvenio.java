package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="wof_exame_convenio")
public class ExameConvenio implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4295656070541765293L;


	@EmbeddedId
	private ExameConvenioPK exameConvenioPK = new ExameConvenioPK();
	
	
	private double valor;


	public ExameConvenio() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExameConvenio(ExameConvenioPK exameConvenioPK, double valor) {
		super();
		this.exameConvenioPK = exameConvenioPK;
		this.valor = valor;
	}
	
	


	public ExameConvenio(ExameConvenioPK exameConvenioPK) {
		super();
		this.exameConvenioPK = exameConvenioPK;
	}


	public ExameConvenioPK getExameConvenioPK() {
		return exameConvenioPK;
	}


	public void setExameConvenioPK(ExameConvenioPK exameConvenioPK) {
		this.exameConvenioPK = exameConvenioPK;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((exameConvenioPK == null) ? 0 : exameConvenioPK.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExameConvenio other = (ExameConvenio) obj;
		if (exameConvenioPK == null) {
			if (other.exameConvenioPK != null)
				return false;
		} else if (!exameConvenioPK.equals(other.exameConvenioPK))
			return false;
		return true;
	}


	
	
	
}
