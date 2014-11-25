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
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.com.wofsolutions.interfaces.ObjectBase;

@Entity
@Table(name = "wof_medicos")
@PrimaryKeyJoinColumn(name = "medico_id")
public class Medico extends Usuario implements Serializable, ObjectBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4705344552926234032L;
	public static final int EQUIPE = 0;
	public static final int SOLICITANTE = 1;
	// @Id
	// @GeneratedValue
	// @Column(name = "medico_id")
	// private Integer usuarioId;
	@Column(length = 80)
	@OrderBy(value = "ASC")
	private String nome;
	private boolean equipe = true;
	private boolean solicitante;

	// @ManyToMany(fetch=FetchType.EAGER)
	// //@Cascade(CascadeType.ALL)
	// @JoinTable(name = "wof_exames_medicos", joinColumns = @JoinColumn(name =
	// "medico_id"), inverseJoinColumns = @JoinColumn(name = "exame_id"))
	// private List<Exame> exames = new ArrayList<Exame>();

	// @OneToMany(targetEntity = Atendimento.class)
	// //@Cascade(CascadeType.ALL)
	// @JoinColumn(name = "medico_id", referencedColumnName = "medico_id")
	// private List<Atendimento> atendimentos = new ArrayList<Atendimento>();

	// @OneToMany(targetEntity = Atendimento.class)
	// //@Cascade(CascadeType.ALL)
	// @JoinColumn(name = "solicitante_id", referencedColumnName = "medico_id")
	// private List<Atendimento> atendimentosSolicitante = new
	// ArrayList<Atendimento>();

	// @ManyToOne
	// @JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	// private Empresa empresa = new Empresa();

	public Medico(String nome) {
		super();
		this.nome = nome;
	}

	public Medico(Integer usuarioId, String nome, boolean equipe,
			boolean solicitante) {
		super();
		this.nome = nome;
		this.equipe = equipe;
		this.solicitante = solicitante;
		this.usuarioId = usuarioId;
	}

	public Medico() {
		super();
	}

	public Integer getMedicoId() {
		return usuarioId;
	}

	public void setMedicoId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isEquipe() {
		return equipe;
	}

	public void setEquipe(boolean equipe) {
		this.equipe = equipe;
	}

	public boolean isSolicitante() {
		return solicitante;
	}

	public void setSolicitante(boolean solicitante) {
		this.solicitante = solicitante;
	}

	// public List<Exame> getExames() {
	// return exames;
	// }
	//
	// public void setExames(List<Exame> exames) {
	// this.exames = exames;
	// }

	// public Empresa getEmpresa() {
	// return empresa;
	// }
	//
	// public void setEmpresa(Empresa empresa) {
	// this.empresa = empresa;
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((usuarioId == null) ? 0 : usuarioId.hashCode());
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
		Medico other = (Medico) obj;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  String.valueOf(usuarioId);
	}

	// public List<Atendimento> getAtendimentos() {
	// return atendimentos;
	// }
	//
	// public void setAtendimentos(List<Atendimento> atendimentos) {
	// this.atendimentos = atendimentos;
	// }
	//
	// public List<Atendimento> getAtendimentosSolicitante() {
	// return atendimentosSolicitante;
	// }
	//
	// public void setAtendimentosSolicitante(
	// List<Atendimento> atendimentosSolicitante) {
	// this.atendimentosSolicitante = atendimentosSolicitante;
	// }

	@Override
	public void setId(Integer id) {
		usuarioId = id;

	}
}
