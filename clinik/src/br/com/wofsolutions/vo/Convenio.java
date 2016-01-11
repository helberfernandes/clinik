package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.wofsolutions.interfaces.ObjectBase;

@Entity
@Table(name="wof_convenios")
public class Convenio implements Serializable, ObjectBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2761187058260388186L;
	@Id
	@GeneratedValue
	@Column(name="convenio_id")
	private Integer convenioId;
	@Column(length=80)
	private String nome;
	@OneToMany
	//@Cascade(CascadeType.ALL)
	@JoinColumn(name = "convenio_id", referencedColumnName = "convenio_id")
	private List<ExameConvenio> exameConvenios = new ArrayList<ExameConvenio>(); 
	@OneToMany( targetEntity=Atendimento.class)
	//@Cascade(CascadeType.ALL)
	@JoinColumn(name = "convenio_id", referencedColumnName = "convenio_id")
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();	
	@ManyToOne
	//@Cascade(CascadeType.ALL)
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa = new Empresa();
	
	public Integer getConvenioId() {
		return convenioId;
	}
	public void setConvenioId(Integer convenioId) {
		this.convenioId = convenioId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<ExameConvenio> getExameConvenios() {
		return exameConvenios;
	}
	public void setExameConvenios(List<ExameConvenio> exameConvenios) {
		this.exameConvenios = exameConvenios;
	}
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}
	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void setId(Integer id) {
		convenioId=id;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((convenioId == null) ? 0 : convenioId.hashCode());
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
		Convenio other = (Convenio) obj;
		if (convenioId == null) {
			if (other.convenioId != null)
				return false;
		} else if (!convenioId.equals(other.convenioId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "" + convenioId ;
	}
	
}