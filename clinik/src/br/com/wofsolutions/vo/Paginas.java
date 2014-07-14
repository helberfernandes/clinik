package br.com.wofsolutions.vo;

import java.io.Serializable;

/**
 * 
 * @author Helber
 * @version 1.0.0
 * 
 */
public enum Paginas implements Serializable {

	HOME_COCKPIT("/clinik/cokpit/"), 
	LOGIN("/clinik/"), 
	ACESSO_NEGADO("/clinik/"), 
	HOME_CLINIK("/clinik/clinik/"),	
	PAGE_HOME("/clinik/home/"),
	PAGE_HOME_MEDICO("/clinik/atendimento/");
	
	private final String valor;

	private Paginas(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
}
