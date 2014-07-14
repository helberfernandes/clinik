package br.com.wofsolutions.model.webservice;

import java.io.Serializable;


public class Usuario implements Serializable{
	 

	private Integer usuarioId;	

	private String nome;

	private String login;

	private String senha;

	private String email;

	private String telefone="";
	private boolean status;


	private String dataCadastro;


	private String dataUltimoAcesso;
	private String foto="/midia/imagens/foto-user.png";

	private String fotoTumb="/midia/imagens/foto-user.png";
	

	private String horaCadastro;

	private Role role = new Role();
	

	private Loja loja = new Loja();
	
	

	private Rede rede = new Rede();
	
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(String horaCadastro) {
		this.horaCadastro = horaCadastro;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}
	public void setDataUltimoAcesso(String dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public Rede getRede() {
		return rede;
	}
	public void setRede(Rede rede) {
		this.rede = rede;
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getFotoTumb() {
		return fotoTumb;
	}
	public void setFotoTumb(String fotoTumb) {
		this.fotoTumb = fotoTumb;
	}
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
		Usuario other = (Usuario) obj;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", nome=" + nome
				+ ", login=" + login + ", senha=" + senha + ", email=" + email
				+ ", telefone=" + telefone + ", status=" + status
				+ ", dataCadastro=" + dataCadastro + ", dataUltimoAcesso="
				+ dataUltimoAcesso + ", foto=" + foto + ", fotoTumb="
				+ fotoTumb + ", horaCadastro=" + horaCadastro + ", role="
				+ role + ", loja=" + loja + ", rede=" + rede + "]";
	}
	
}
