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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Subselect;

import br.com.wofsolutions.interfaces.ObjectBase;

@Entity
@Table(name="wof_exames")
public class Exame implements Serializable, ObjectBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6402213372747784904L;
	@Id
	@GeneratedValue
	@Column(name="exame_id")
	private Integer exameId;
	@Column(length=80)
	private String nome;	
	private double honorarios;	
	
	@ManyToMany
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name="wof_exames_medicos",
	joinColumns=@JoinColumn(name="exame_id"),
	inverseJoinColumns=@JoinColumn(name="medico_id"))	
	private List<Medico> medicos = new ArrayList<Medico>();
	
		
	@OneToMany(fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "exame_id", referencedColumnName = "exame_id")
	private List<ExameConvenio> exameConvenios = new ArrayList<ExameConvenio>();
	
	
	@ManyToOne
	//@Cascade(CascadeType.ALL)
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa = new Empresa();
	
	
	public Integer getExameId() {
		return exameId;
	}
	public void setExameId(Integer exameId) {
		this.exameId = exameId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	public List<ExameConvenio> getExameConvenios() {
		return exameConvenios;
	}
	public void setExameConvenios(List<ExameConvenio> exameConvenios) {
		this.exameConvenios = exameConvenios;
	}
	public double getHonorarios() {
		return honorarios;
	}
	public void setHonorarios(double honorarios) {
		this.honorarios = honorarios;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void setId(Integer id) {
		exameId=id;		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exameId == null) ? 0 : exameId.hashCode());
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
		Exame other = (Exame) obj;
		if (exameId == null) {
			if (other.exameId != null)
				return false;
		} else if (!exameId.equals(other.exameId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Exame [exameId=" + exameId + "]";
	}	
}