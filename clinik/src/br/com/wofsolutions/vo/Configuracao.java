package br.com.wofsolutions.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="wof_configuracoes")
public class Configuracao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5210262986686574663L;
	@Id
	@GeneratedValue
	@Column(name="configuracao_id")
	private Integer configuracaoId;	
	@Column(length=80)
	private String url;
	@Column(length=4)
	private String porta; 
	@Column(length=80) 
	private String smsc;
	private String marca;
	private String modelo;
	private int portaAparelho;
	private boolean manutencao=true;
	private String proxy;
	@Column(name="proxy_porta")
	private String proxyPorta;
	@Column(name="proxy_usuario")
	private String proxyUsuario;
	@Column(name="proxy_senha")
	private String proxySenha;
	@Column(name="requer_autenticacao")
	private boolean requerAutenticacao=false;
	
	
	
	@Column(name="caminho_arquivo_telefonia")
	private String caminhoArquivoTelefonia;
	
	@Column(name = "atribuir_chamado_da_loja_automaticamente")
	public boolean atribuirChamadoDaLojaAutomaticamente = false;
	
	@Column(name = "plantao_atribuir_chamado_da_loja_automaticamente")
	public boolean plantaoAtribuirChamadoDaLojaAutomaticamente = false;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "primeiro_dia_util_da_semana")
	public Date primeiroDiaUtilDaSemana= new Date();
	
	@Column(name="dias_para_resposta_do_gerente")
	private Integer diasParaRespostaDoGerente;	
	
	@Column(name="dias_para_aguardar_resposta_do_cliente")
	private Integer diasParaAguardarRespostaDoCliente;
	
	
	@Column(name="qtdMaximaChamadosAtribuido")
	private Integer qtdMaximaChamadoAtribuido;
	
	@Column(name="qtdMaximaChamadosAtribuidoAutomaticamente")
	private Integer qtdMaximaChamadoAtribuidoAutomaticamente;
	
	@Column(name="qtd_maxima_chamados_com_codigo_generico_por_loja")
	private Integer qtdMaximaChamadoComCaodigoGenericoPorLoja;
	
	
	
	@Column(name="largura_do_site")
	private Integer larguraDoSite=800;	
	
	
	/***
	 * Email
	 */
	
	private String smtp;
	private Integer portaSmtp;
		
	private String pop;
	private Integer portaPop;
	
	
	@Column(name="email_sistema")
	private String emailSistema;
	
	@Column(name="email_envio_sistema")
	private String emailEnvioSistema;
	
	@Column(name="senha_email_sistema")
	private String senhaEmailSistema;
	
	
	
	
	
	
	
	public Integer getConfiguracaoId() {
		return configuracaoId;
	}
	public void setConfiguracaoId(Integer configuracaoId) {
		this.configuracaoId = configuracaoId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getSmsc() {
		return smsc;
	}
	public void setSmsc(String smsc) {
		this.smsc = smsc;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getPortaAparelho() {
		return portaAparelho;
	}
	public void setPortaAparelho(int portaAparelho) {
		this.portaAparelho = portaAparelho;
	}
	public boolean isAtribuirChamadoDaLojaAutomaticamente() {
		return atribuirChamadoDaLojaAutomaticamente;
	}
	public void setAtribuirChamadoDaLojaAutomaticamente(
			boolean atribuirChamadoDaLojaAutomaticamente) {
		this.atribuirChamadoDaLojaAutomaticamente = atribuirChamadoDaLojaAutomaticamente;
	}
	public boolean isPlantaoAtribuirChamadoDaLojaAutomaticamente() {
		return plantaoAtribuirChamadoDaLojaAutomaticamente;
	}
	public void setPlantaoAtribuirChamadoDaLojaAutomaticamente(
			boolean plantaoAtribuirChamadoDaLojaAutomaticamente) {
		this.plantaoAtribuirChamadoDaLojaAutomaticamente = plantaoAtribuirChamadoDaLojaAutomaticamente;
	}
	public Date getPrimeiroDiaUtilDaSemana() {
		return primeiroDiaUtilDaSemana;
	}
	public void setPrimeiroDiaUtilDaSemana(Date primeiroDiaUtilDaSemana) {
		this.primeiroDiaUtilDaSemana = primeiroDiaUtilDaSemana;
	}
	public Integer getDiasParaRespostaDoGerente() {
		return diasParaRespostaDoGerente;
	}
	public void setDiasParaRespostaDoGerente(Integer diasParaRespostaDoGerente) {
		this.diasParaRespostaDoGerente = diasParaRespostaDoGerente;
	}
	public Integer getQtdMaximaChamadoAtribuido() {
		return qtdMaximaChamadoAtribuido;
	}
	public void setQtdMaximaChamadoAtribuido(Integer qtdMaximaChamadoAtribuido) {
		this.qtdMaximaChamadoAtribuido = qtdMaximaChamadoAtribuido;
	}
	public Integer getQtdMaximaChamadoAtribuidoAutomaticamente() {
		return qtdMaximaChamadoAtribuidoAutomaticamente;
	}
	public void setQtdMaximaChamadoAtribuidoAutomaticamente(
			Integer qtdMaximaChamadoAtribuidoAutomaticamente) {
		this.qtdMaximaChamadoAtribuidoAutomaticamente = qtdMaximaChamadoAtribuidoAutomaticamente;
	}
	public boolean isManutencao() {
		return manutencao;
	}
	public void setManutencao(boolean manutencao) {
		this.manutencao = manutencao;
	}
	public Integer getQtdMaximaChamadoComCaodigoGenericoPorLoja() {
		return qtdMaximaChamadoComCaodigoGenericoPorLoja;
	}
	public void setQtdMaximaChamadoComCaodigoGenericoPorLoja(
			Integer qtdMaximaChamadoComCaodigoGenericoPorLoja) {
		this.qtdMaximaChamadoComCaodigoGenericoPorLoja = qtdMaximaChamadoComCaodigoGenericoPorLoja;
	}
	public String getProxy() {
		return proxy;
	}
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}
	public String getProxyPorta() {
		return proxyPorta;
	}
	public void setProxyPorta(String proxyPorta) {
		this.proxyPorta = proxyPorta;
	}
	
	public String getProxyUsuario() {
		return proxyUsuario;
	}
	public void setProxyUsuario(String proxyUsuario) {
		this.proxyUsuario = proxyUsuario;
	}
	public String getProxySenha() {
		return proxySenha;
	}
	public void setProxySenha(String proxySenha) {
		this.proxySenha = proxySenha;
	}
	public boolean isRequerAutenticacao() {
		return requerAutenticacao;
	}
	public void setRequerAutenticacao(boolean requerAutenticacao) {
		this.requerAutenticacao = requerAutenticacao;
	}
	public Integer getLarguraDoSite() {
		return larguraDoSite;
	}
	public void setLarguraDoSite(Integer larguraDoSite) {
		this.larguraDoSite = larguraDoSite;
	}
	public String getSmtp() {
		return smtp;
	}
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	public Integer getPortaSmtp() {
		return portaSmtp;
	}
	public void setPortaSmtp(Integer portaSmtp) {
		this.portaSmtp = portaSmtp;
	}
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}
	public Integer getPortaPop() {
		return portaPop;
	}
	public void setPortaPop(Integer portaPop) {
		this.portaPop = portaPop;
	}
	public String getEmailSistema() {
		return emailSistema;
	}
	public void setEmailSistema(String emailSistema) {
		this.emailSistema = emailSistema;
	}
	public String getSenhaEmailSistema() {
		return senhaEmailSistema;
	}
	public void setSenhaEmailSistema(String senhaEmailSistema) {
		this.senhaEmailSistema = senhaEmailSistema;
	}
	public String getEmailEnvioSistema() {
		return emailEnvioSistema;
	}
	public void setEmailEnvioSistema(String emailEnvioSistema) {
		this.emailEnvioSistema = emailEnvioSistema;
	}
	public Integer getDiasParaAguardarRespostaDoCliente() {
		return diasParaAguardarRespostaDoCliente;
	}
	public void setDiasParaAguardarRespostaDoCliente(
			Integer diasParaAguardarRespostaDoCliente) {
		this.diasParaAguardarRespostaDoCliente = diasParaAguardarRespostaDoCliente;
	}
	public String getCaminhoArquivoTelefonia() {
		return caminhoArquivoTelefonia;
	}
	public void setCaminhoArquivoTelefonia(String caminhoArquivoTelefonia) {
		this.caminhoArquivoTelefonia = caminhoArquivoTelefonia;
	}
}