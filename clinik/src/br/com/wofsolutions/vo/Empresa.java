package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.wofsolutions.interfaces.ObjectBase;

@Entity
@Table(name="wof_empresas")
public class Empresa implements Serializable , ObjectBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	@Column(name="empresa_id")
	private Integer empresaId;
	
	
	@Column(name="nome")
	private String nome;
	
	@Column(length=255)
	private String logo;
	
	@Column(name="foto_perfil", length=900000)
    private byte[] logoMarca;
	
	private String cnpj;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="empresa_id", referencedColumnName="empresa_id")
	@OrderBy(value="nome")
	@Fetch(FetchMode.SUBSELECT)
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro")
	private Date dataCadastro = new Date();
	
	@Column(name="horario_minimo", length=2)
	private Integer horarioMinimo=8;

	@Column(name="horario_maximo", length=2)
	private Integer horarioMaximo=17;
	
	@Column(name="mostrar_final_de_semana")
	private Boolean mostrarFimDeSemana=false;
	
	@Column(name="mostrar_cabecalho")
	private Boolean mostrarCabecalho=true;

	@Column(name="view_padao")
	private String viewPadrao="agendaWeek";
	
	@Column(name="tempo_medio_procedimento", length=2)
	private Integer tempoMedioProcedimento=30;
	
	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
		

	public Integer getHorarioMinimo() {
		return horarioMinimo;
	}

	public void setHorarioMinimo(Integer horarioMinimo) {
		this.horarioMinimo = horarioMinimo;
	}

	public Integer getHorarioMaximo() {
		return horarioMaximo;
	}

	public void setHorarioMaximo(Integer horarioMaximo) {
		this.horarioMaximo = horarioMaximo;
	}

	public Boolean getMostrarFimDeSemana() {
		return mostrarFimDeSemana;
	}

	public void setMostrarFimDeSemana(Boolean mostrarFimDeSemana) {
		this.mostrarFimDeSemana = mostrarFimDeSemana;
	}

	public Boolean getMostrarCabecalho() {
		return mostrarCabecalho;
	}

	public void setMostrarCabecalho(Boolean mostrarCabecalho) {
		this.mostrarCabecalho = mostrarCabecalho;
	}

	
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	

	public String getViewPadrao() {
		return viewPadrao;
	}

	public void setViewPadrao(String viewPadrao) {
		this.viewPadrao = viewPadrao;
	}
	
	

	public Integer getTempoMedioProcedimento() {
		return tempoMedioProcedimento;
	}

	public void setTempoMedioProcedimento(Integer tempoMedioProcedimento) {
		this.tempoMedioProcedimento = tempoMedioProcedimento;
	}

	
	
	public byte[] getLogoMarca() {
		return logoMarca;
	}

	public void setLogoMarca(byte[] logoMarca) {
		this.logoMarca = logoMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((empresaId == null) ? 0 : empresaId.hashCode());
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
		Empresa other = (Empresa) obj;
		if (empresaId == null) {
			if (other.empresaId != null)
				return false;
		} else if (!empresaId.equals(other.empresaId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [empresaId=" + empresaId + "]";
	}

	@Override
	public void setEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setId(Integer id) {
		empresaId=id;		
	}	
}