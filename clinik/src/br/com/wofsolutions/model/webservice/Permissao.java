package br.com.wofsolutions.model.webservice;

import java.io.Serializable;


public class Permissao implements Serializable{

	private Integer permissaoId;

	private String descricao;

	public boolean addUser ;

	public boolean excluirUser ;

	public boolean editarUser ;


	public boolean addRole ;

	public boolean addNotas ;

	public boolean verNotas ;

	public boolean verCockpit ;
	
	
	

	public boolean abrirChamado ;

	public boolean excluirChamado ;

	public boolean editarChamado ;	

	public boolean atribuirChamado ;

	public boolean verChamado ;

	public boolean verChamadoFilizola ;

	public boolean encaminharChamadoFilizola ;

	public boolean exportarChamado ;

	public boolean atribuirChamadoItauTec ;
	
	

	public boolean atribuirChamadoTrix ;
	
	
	public boolean addRede ;


	public boolean verFornecedor ;

	public boolean addFornecedor ;

	public boolean podeExcluirFornecedor ;

	public boolean podeEditarFornecedor ;

	public boolean exportarFornecedor ;


	public boolean verCentroDeCusto ;

	public boolean addCentroDeCusto ;

	public boolean podeExcluirCentroDeCusto ;

	public boolean podeEditarCentroDeCusto ;

	public boolean exportarCentroDeCusto ;
	
	
	

	public boolean verLoja ;

	public boolean addLoja ;

	public boolean podeExcluirLoja ;

	public boolean podeEditarLoja ;

	public boolean exportarLoja ;
	
	
	


	public boolean lancarNota ;


	public boolean verChamadosSomenteDaLoja ;

	public boolean verTodosChamados ;

	public boolean emitirRelatorios ;

	public boolean emitirLaudoTecnico ;

	public boolean darFeedback ;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "permissao_id", referencedColumnName = "permissao_id")
//	private List<Role> roles = new ArrayList<Role>();

	
	
	public Integer getPermissaoId() {
		return permissaoId;
	}

	public void setPermissaoId(Integer permissaoId) {
		this.permissaoId = permissaoId;
	}

//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAddUser() {
		return addUser;
	}

	public void setAddUser(boolean addUser) {
		this.addUser = addUser;
	}

	public boolean isAddRole() {
		return addRole;
	}

	public void setAddRole(boolean addRole) {
		this.addRole = addRole;
	}

	public boolean isAddNotas() {
		return addNotas;
	}

	public void setAddNotas(boolean addNotas) {
		this.addNotas = addNotas;
	}

	public boolean isVerCockpit() {
		return verCockpit;
	}

	public void setVerCockpit(boolean verCockpit) {
		this.verCockpit = verCockpit;
	}

	public boolean isAbrirChamado() {
		return abrirChamado;
	}

	public void setAbrirChamado(boolean abrirChamado) {
		this.abrirChamado = abrirChamado;
	}

	public boolean isAtribuirChamado() {
		return atribuirChamado;
	}

	public void setAtribuirChamado(boolean atribuirChamado) {
		this.atribuirChamado = atribuirChamado;
	}

	public boolean isVerChamado() {
		return verChamado;
	}

	public void setVerChamado(boolean verChamado) {
		this.verChamado = verChamado;
	}

	public boolean isVerChamadoFilizola() {
		return verChamadoFilizola;
	}

	public void setVerChamadoFilizola(boolean verChamadoFilizola) {
		this.verChamadoFilizola = verChamadoFilizola;
	}

	public boolean isEncaminharChamadoFilizola() {
		return encaminharChamadoFilizola;
	}

	public void setEncaminharChamadoFilizola(boolean encaminharChamadoFilizola) {
		this.encaminharChamadoFilizola = encaminharChamadoFilizola;
	}

	public boolean isAddRede() {
		return addRede;
	}

	public void setAddRede(boolean addRede) {
		this.addRede = addRede;
	}

	public boolean isAddFornecedor() {
		return addFornecedor;
	}

	public void setAddFornecedor(boolean addFornecedor) {
		this.addFornecedor = addFornecedor;
	}

	public boolean isVerFornecedor() {
		return verFornecedor;
	}

	public void setVerFornecedor(boolean verFornecedor) {
		this.verFornecedor = verFornecedor;
	}

	public boolean isPodeExcluirFornecedor() {
		return podeExcluirFornecedor;
	}

	public void setPodeExcluirFornecedor(boolean podeExcluirFornecedor) {
		this.podeExcluirFornecedor = podeExcluirFornecedor;
	}

	public boolean isPodeEditarFornecedor() {
		return podeEditarFornecedor;
	}

	public void setPodeEditarFornecedor(boolean podeEditarFornecedor) {
		this.podeEditarFornecedor = podeEditarFornecedor;
	}

	public boolean isVerChamadosSomenteDaLoja() {
		return verChamadosSomenteDaLoja;
	}

	public void setVerChamadosSomenteDaLoja(boolean verChamadosSomenteDaLoja) {
		this.verChamadosSomenteDaLoja = verChamadosSomenteDaLoja;
	}

	public boolean isVerTodosChamados() {
		return verTodosChamados;
	}

	public void setVerTodosChamados(boolean verTodosChamados) {
		this.verTodosChamados = verTodosChamados;
	}

	public boolean isEmitirRelatorios() {
		return emitirRelatorios;
	}

	public void setEmitirRelatorios(boolean emitirRelatorios) {
		this.emitirRelatorios = emitirRelatorios;
	}

	public boolean isEmitirLaudoTecnico() {
		return emitirLaudoTecnico;
	}

	public void setEmitirLaudoTecnico(boolean emitirLaudoTecnico) {
		this.emitirLaudoTecnico = emitirLaudoTecnico;
	}

	public boolean isDarFeedback() {
		return darFeedback;
	}

	public void setDarFeedback(boolean darFeedback) {
		this.darFeedback = darFeedback;
	}

	public boolean isLancarNota() {
		return lancarNota;
	}

	public void setLancarNota(boolean lancarNota) {
		this.lancarNota = lancarNota;
	}

	public boolean isExcluirUser() {
		return excluirUser;
	}

	public void setExcluirUser(boolean excluirUser) {
		this.excluirUser = excluirUser;
	}

	public boolean isEditarUser() {
		return editarUser;
	}

	public void setEditarUser(boolean editarUser) {
		this.editarUser = editarUser;
	}

	public boolean isExportarFornecedor() {
		return exportarFornecedor;
	}

	public void setExportarFornecedor(boolean exportarFornecedor) {
		this.exportarFornecedor = exportarFornecedor;
	}

	
	
	public boolean isVerCentroDeCusto() {
		return verCentroDeCusto;
	}

	public void setVerCentroDeCusto(boolean verCentroDeCusto) {
		this.verCentroDeCusto = verCentroDeCusto;
	}

	public boolean isAddCentroDeCusto() {
		return addCentroDeCusto;
	}

	public void setAddCentroDeCusto(boolean addCentroDeCusto) {
		this.addCentroDeCusto = addCentroDeCusto;
	}

	public boolean isPodeExcluirCentroDeCusto() {
		return podeExcluirCentroDeCusto;
	}

	public void setPodeExcluirCentroDeCusto(boolean podeExcluirCentroDeCusto) {
		this.podeExcluirCentroDeCusto = podeExcluirCentroDeCusto;
	}

	public boolean isPodeEditarCentroDeCusto() {
		return podeEditarCentroDeCusto;
	}

	public void setPodeEditarCentroDeCusto(boolean podeEditarCentroDeCusto) {
		this.podeEditarCentroDeCusto = podeEditarCentroDeCusto;
	}

	public boolean isExportarCentroDeCusto() {
		return exportarCentroDeCusto;
	}

	public void setExportarCentroDeCusto(boolean exportarCentroDeCusto) {
		this.exportarCentroDeCusto = exportarCentroDeCusto;
	}
	
	public boolean isVerLoja() {
		return verLoja;
	}

	public void setVerLoja(boolean verLoja) {
		this.verLoja = verLoja;
	}

	public boolean isAddLoja() {
		return addLoja;
	}

	public void setAddLoja(boolean addLoja) {
		this.addLoja = addLoja;
	}

	public boolean isPodeExcluirLoja() {
		return podeExcluirLoja;
	}

	public void setPodeExcluirLoja(boolean podeExcluirLoja) {
		this.podeExcluirLoja = podeExcluirLoja;
	}

	public boolean isPodeEditarLoja() {
		return podeEditarLoja;
	}

	public void setPodeEditarLoja(boolean podeEditarLoja) {
		this.podeEditarLoja = podeEditarLoja;
	}

	public boolean isExportarLoja() {
		return exportarLoja;
	}

	public void setExportarLoja(boolean exportarLoja) {
		this.exportarLoja = exportarLoja;
	}

	
	
	public boolean isAtribuirChamadoItauTec() {
		return atribuirChamadoItauTec;
	}

	public void setAtribuirChamadoItauTec(boolean atribuirChamadoItauTec) {
		this.atribuirChamadoItauTec = atribuirChamadoItauTec;
	}

	public boolean isAtribuirChamadoTrix() {
		return atribuirChamadoTrix;
	}

	public void setAtribuirChamadoTrix(boolean atribuirChamadoTrix) {
		this.atribuirChamadoTrix = atribuirChamadoTrix;
	}

	public boolean isExcluirChamado() {
		return excluirChamado;
	}

	public void setExcluirChamado(boolean excluirChamado) {
		this.excluirChamado = excluirChamado;
	}

	public boolean isEditarChamado() {
		return editarChamado;
	}

	public void setEditarChamado(boolean editarChamado) {
		this.editarChamado = editarChamado;
	}

	public boolean isVerNotas() {
		return verNotas;
	}

	public void setVerNotas(boolean verNotas) {
		this.verNotas = verNotas;
	}

	public boolean isExportarChamado() {
		return exportarChamado;
	}

	public void setExportarChamado(boolean exportarChamado) {
		this.exportarChamado = exportarChamado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((permissaoId == null) ? 0 : permissaoId.hashCode());
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
		Permissao other = (Permissao) obj;
		if (permissaoId == null) {
			if (other.permissaoId != null)
				return false;
		} else if (!permissaoId.equals(other.permissaoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Permissao [permissaoId=" + permissaoId + ", descricao="
				+ descricao + ", addUser=" + addUser + ", excluirUser="
				+ excluirUser + ", editarUser=" + editarUser + ", addRole="
				+ addRole + ", addNotas=" + addNotas + ", verNotas=" + verNotas
				+ ", verCockpit=" + verCockpit + ", abrirChamado="
				+ abrirChamado + ", excluirChamado=" + excluirChamado
				+ ", editarChamado=" + editarChamado + ", atribuirChamado="
				+ atribuirChamado + ", verChamado=" + verChamado
				+ ", verChamadoFilizola=" + verChamadoFilizola
				+ ", encaminharChamadoFilizola=" + encaminharChamadoFilizola
				+ ", exportarChamado=" + exportarChamado
				+ ", atribuirChamadoItauTec=" + atribuirChamadoItauTec
				+ ", atribuirChamadoTrix=" + atribuirChamadoTrix + ", addRede="
				+ addRede + ", verFornecedor=" + verFornecedor
				+ ", addFornecedor=" + addFornecedor
				+ ", podeExcluirFornecedor=" + podeExcluirFornecedor
				+ ", podeEditarFornecedor=" + podeEditarFornecedor
				+ ", exportarFornecedor=" + exportarFornecedor
				+ ", verCentroDeCusto=" + verCentroDeCusto
				+ ", addCentroDeCusto=" + addCentroDeCusto
				+ ", podeExcluirCentroDeCusto=" + podeExcluirCentroDeCusto
				+ ", podeEditarCentroDeCusto=" + podeEditarCentroDeCusto
				+ ", exportarCentroDeCusto=" + exportarCentroDeCusto
				+ ", verLoja=" + verLoja + ", addLoja=" + addLoja
				+ ", podeExcluirLoja=" + podeExcluirLoja + ", podeEditarLoja="
				+ podeEditarLoja + ", exportarLoja=" + exportarLoja
				+ ", lancarNota=" + lancarNota + ", verChamadosSomenteDaLoja="
				+ verChamadosSomenteDaLoja + ", verTodosChamados="
				+ verTodosChamados + ", emitirRelatorios=" + emitirRelatorios
				+ ", emitirLaudoTecnico=" + emitirLaudoTecnico
				+ ", darFeedback=" + darFeedback + "]";
	}
	
}
