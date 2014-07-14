package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Embeddable
public class ExameConvenioPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	//@Cascade(CascadeType.ALL)
	@JoinColumn(name = "exame_id", referencedColumnName = "exame_id")
	private Exame exame = new Exame();
	
	@ManyToOne
	//@Cascade(CascadeType.ALL)
	@JoinColumn(name = "convenio_id", referencedColumnName = "convenio_id")
	private Convenio convenio = new Convenio();
	
	

	public ExameConvenioPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExameConvenioPK(Exame exame, Convenio convenio) {
		super();
		this.exame = exame;
		this.convenio = convenio;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((convenio == null) ? 0 : convenio.hashCode());
		result = prime * result + ((exame == null) ? 0 : exame.hashCode());
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
		ExameConvenioPK other = (ExameConvenioPK) obj;
		if (convenio == null) {
			if (other.convenio != null)
				return false;
		} else if (!convenio.equals(other.convenio))
			return false;
		if (exame == null) {
			if (other.exame != null)
				return false;
		} else if (!exame.equals(other.exame))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExameConvenioPK [exame=" + exame + ", convenio=" + convenio
				+ "]";
	}
	
	
}
