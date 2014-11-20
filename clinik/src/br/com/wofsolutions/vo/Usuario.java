package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.wofsolutions.interfaces.ObjectBase;

@Entity
@Table(name = "wof_usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable, ObjectBase {
	public static final String USUARIO_SYSTEM = "system";
	public static final String USUARIO_KEY = "usuario";
	/** 
	 *  
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "usuario_id")
	protected Integer usuarioId;
	@Column(length = 80)
	private String nome;
	@Column(length = 20)
	@OrderBy(value = "ASC")
	private String login;
	@Column(length = 80)
	private String senha;
	@Column(length = 80)
	private String email;
	@Column(length = 13)
	private String telefone;
	private boolean status = true;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_ultimo_acesso")
	private Date dataUltimoAcesso;
	@Temporal(TemporalType.TIME)
	@Column(name = "hora_ultimo_acesso")
	private Date horaUltimoAcesso;
	
	@Transient
    private byte[] fotoPerfil;
	
	
	private String foto="/midia/imagens/photo.png";
	@Column(name="foto_tumb")
	private String fotoTumb="/midia/imagens/foto-user.png";
	

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_cadastro")
	private Date horaCadastro;
	@XmlTransient
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	@Fetch(value = FetchMode.JOIN)
	private Role role = new Role();

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	@Fetch(value = FetchMode.JOIN)
	private Empresa empresa = new Empresa();

	
	@Column(name = "cor", length = 7)
	private String cor = "#444";

	@Column(name = "sessao_id", length = 255)
	private String sessaoId;

	@Column(name = "quantidade_de_acessos")
	private Integer quantidadeDeAcessos = 0;

	@Column(name = "quantidade_de_falhas_no_login")
	private Integer quantidadeDeFahasNoLogin = 0;
	
	
	private boolean medico=false;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer usuarioId) {
		super();
		this.usuarioId = usuarioId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getUsuarioId()
	 */

	public Integer getUsuarioId() {
		return usuarioId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setUsuarioId(java.lang.Integer)
	 */

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getNome()
	 */

	public String getNome() {
		return nome;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setNome(java.lang.String)
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getLogin()
	 */

	public String getLogin() {
		return login;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setLogin(java.lang.String)
	 */

	public void setLogin(String login) {
		this.login = login;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getSenha()
	 */

	public String getSenha() {
		return senha;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setSenha(java.lang.String)
	 */

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getEmail()
	 */

	public String getEmail() {
		return email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setEmail(java.lang.String)
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getTelefone()
	 */

	public String getTelefone() {
		return telefone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setTelefone(java.lang.String)
	 */

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#isStatus()
	 */

	public boolean isStatus() {
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setStatus(boolean)
	 */

	public void setStatus(boolean status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getDataCadastro()
	 */

	public Date getDataCadastro() {
		return dataCadastro;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setDataCadastro(java.util.Date)
	 */

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getHoraCadastro()
	 */

	public Date getHoraCadastro() {
		return horaCadastro;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setHoraCadastro(java.util.Date)
	 */

	public void setHoraCadastro(Date horaCadastro) {
		this.horaCadastro = horaCadastro;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getRole()
	 */

	public Role getRole() {
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.wofsolutions.vo.TesteInter#setRole(br.com.wofsolutions.vo.Role)
	 */

	public void setRole(Role role) {
		this.role = role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getDataUltimoAcesso()
	 */

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.wofsolutions.vo.TesteInter#setDataUltimoAcesso(java.util.Date)
	 */

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getFoto()
	 */

	public String getFoto() {
		return foto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setFoto(java.lang.String)
	 */

	public void setFoto(String foto) {
		this.foto = foto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getFotoTumb()
	 */

	public String getFotoTumb() {
		return fotoTumb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setFotoTumb(java.lang.String)
	 */

	public void setFotoTumb(String fotoTumb) {
		this.fotoTumb = fotoTumb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getHoraUltimoAcesso()
	 */

	public Date getHoraUltimoAcesso() {
		return horaUltimoAcesso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.wofsolutions.vo.TesteInter#setHoraUltimoAcesso(java.util.Date)
	 */

	public void setHoraUltimoAcesso(Date horaUltimoAcesso) {
		this.horaUltimoAcesso = horaUltimoAcesso;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getCor()
	 */

	public String getCor() {
		return cor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setCor(java.lang.String)
	 */

	public void setCor(String cor) {
		this.cor = cor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getSessaoId()
	 */

	public String getSessaoId() {
		return sessaoId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#setSessaoId(java.lang.String)
	 */

	public void setSessaoId(String sessaoId) {
		this.sessaoId = sessaoId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getQuantidadeDeAcessos()
	 */

	public Integer getQuantidadeDeAcessos() {
		return quantidadeDeAcessos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.wofsolutions.vo.TesteInter#setQuantidadeDeAcessos(java.lang.Integer
	 * )
	 */

	public void setQuantidadeDeAcessos(Integer quantidadeDeAcessos) {
		this.quantidadeDeAcessos = quantidadeDeAcessos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getQuantidadeDeFahasNoLogin()
	 */

	public Integer getQuantidadeDeFahasNoLogin() {
		return quantidadeDeFahasNoLogin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.wofsolutions.vo.TesteInter#setQuantidadeDeFahasNoLogin(java.lang
	 * .Integer)
	 */

	public void setQuantidadeDeFahasNoLogin(Integer quantidadeDeFahasNoLogin) {
		this.quantidadeDeFahasNoLogin = quantidadeDeFahasNoLogin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#getEmpresa()
	 */

	public Empresa getEmpresa() {
		return empresa;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.wofsolutions.vo.TesteInter#setEmpresa(br.com.wofsolutions.vo.Empresa
	 * )
	 */

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wofsolutions.vo.TesteInter#hashCode()
	 */

	public boolean isMedico() {
		return medico;
	}

	public void setMedico(boolean medico) {
		this.medico = medico;
	}
	
	
	

	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((usuarioId == null) ? 0 : usuarioId.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		return true;
	}

	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + "]";
	}

	@Override
	public void setId(Integer id) {
		usuarioId = id;

	}
}
