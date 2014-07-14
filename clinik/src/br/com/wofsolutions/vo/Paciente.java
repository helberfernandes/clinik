package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

import br.com.wofsolutions.interfaces.ObjectBase;

@Entity
@Table(name="wof_pacientes")
public class Paciente implements Serializable, ObjectBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="paciente_id")
	private Integer pacienteId;
	
	@Column(name="nome", length=80)
	private String nome;
	
	
	@Column(name="foto", length=80)
	private String foto="/midia/imagens/foto.png";
	
	@Column(name="cpf", length=80)
	private String cpf;

	@Column(name="endereco", length=255)
	private String endereco;
	
	@Column(name="telefone", length=80)
	private String telefone;
	
	@Column(name="data_nascimento", length=80)
	private Date dataNascimento;
	
	@Column(name="naturalidade", length=80)
	private String naturalidade;
	
	@Column(name="estado_civil", length=80)
	private String estadoCivil;
	
	@Column(name="sexo", length=80)
	private String sexo;
	
	
	@ManyToOne	
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa = new Empresa();
	

	@OneToMany(targetEntity = Atendimento.class)
	@JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	
	
	@OneToMany(targetEntity = Alergia.class)
	@JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
	private List<Alergia> alergias = new ArrayList<Alergia>();
	
	
	@OneToMany(targetEntity = Medicamento.class)
	@JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	

	@OneToMany(targetEntity = Diagnostico.class)
	@JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
	private List<Diagnostico> diagnosticos = new ArrayList<Diagnostico>();
	
	public Integer getPacienteId() {
		return pacienteId;
	}


	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public Empresa getEmpresa() {
		return empresa;
	}
	
	


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getNaturalidade() {
		return naturalidade;
	}


	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}


	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	
	

	public List<Alergia> getAlergias() {
		return alergias;
	}


	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}


	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}


	public List<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}


	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	
	

	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pacienteId == null) ? 0 : pacienteId.hashCode());
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
		Paciente other = (Paciente) obj;
		if (pacienteId == null) {
			if (other.pacienteId != null)
				return false;
		} else if (!pacienteId.equals(other.pacienteId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Paciente [pacienteId=" + pacienteId + "]";
	}


	

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	@Override
	public void setId(Integer id) {
		pacienteId=id;
		
	}
	
	
	
}
