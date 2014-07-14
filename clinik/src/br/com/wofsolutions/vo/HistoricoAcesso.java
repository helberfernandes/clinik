package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="wof_historico_acesso")
public class HistoricoAcesso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8630766014884096043L;
	public static Integer AUTORIZADO=0;
	public static Integer NAO_AUTORIZADO=1;
	@Id
	@GeneratedValue
	@Column(name="historico_id")
	private Integer historicoId;	
	
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="usuario_id")
	private Usuario usuario = new Usuario();
	
	private String pagina;
	
	@Column(name="sessao_id",length=255)
	private String sessaoId;
	
	@Column(length=255)
	private String navegador;
	
	@Column(length=255)
	private String ip;
	
	@Column(length=255)
	private String so;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_acesso")
	private Date dataAcesso = new Date();
	
	
	@Column(name="tipo_acesso")
	private Integer tipoAcesso;


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getPagina() {
		return pagina;
	}


	public void setPagina(String pagina) {
		this.pagina = pagina;
	}


	public String getSessaoId() {
		return sessaoId;
	}


	public void setSessaoId(String sessaoId) {
		this.sessaoId = sessaoId;
	}


	public String getNavegador() {
		return navegador;
	}


	public void setNavegador(String navegador) {
		this.navegador = navegador;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getSo() {
		return so;
	}


	public void setSo(String so) {
		this.so = so;
	}


	public Date getDataAcesso() {
		return dataAcesso;
	}


	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}


	public Integer getTipoAcesso() {
		return tipoAcesso;
	}


	public void setTipoAcesso(Integer tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}


	public Integer getHistoricoId() {
		return historicoId;
	}


	public void setHistoricoId(Integer historicoId) {
		this.historicoId = historicoId;
	}
	
	
	
	
}
