package br.com.wofsolutions.interfaces;

import javax.annotation.PostConstruct;

public interface BaseControllerInterface {
	@PostConstruct
	public void init();	
	public void salvar();	
	public void editar(String GO_PAGE);
	public void excluir();
}
