package br.com.wofsolutions.interfaces;

import br.com.wofsolutions.vo.Empresa;
/**
 * Esta clase obrigatoriamente deve ser extendida por todos
 * os objetos que se tem uma pagina 
 * @author Helber
 *
 */
public interface ObjectBase {
	/**
	 * A qual empresa pertence e assim que se distingue as empresas
	 * @param empresa
	 */
	public void setEmpresa(Empresa empresa);
	/**	
	 * E o Id do objeto por exemplo: usarioId, empresaId, paginaId, etc
	 * @param id
	 */
	public void setId(Integer id);
}