package br.com.wofsolutions.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wofsolutions.dao.ConfiguracaoDAOImpl;
import br.com.wofsolutions.mensagens.FacesMessages;
import br.com.wofsolutions.vo.Configuracao;

@ManagedBean
@ViewScoped
public class ConfiguracaoController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConfiguracaoDAOImpl configuracaoDAO = ConfiguracaoDAOImpl.getInstancia();
	private Configuracao configuracao = new Configuracao();
	
	
	
	public void salvar() {		
		boolean resp = configuracaoDAO.salvar(configuracao);
		FacesMessages.setMessageSuccessOrFailure(resp);		
	}

	@PostConstruct
	public void init() {		
		configuracao = configuracaoDAO.getObject();		
	}

	public ConfiguracaoDAOImpl getConfiguracaoDAO() {		
		return configuracaoDAO;		
	}

	public void setConfiguracaoDAO(ConfiguracaoDAOImpl configuracaoDAO) {		
		this.configuracaoDAO = configuracaoDAO;		
	}

	public Configuracao getConfiguracao() {		
		return configuracao;		
	}

	public void setConfiguracao(Configuracao configuracao) {		
		this.configuracao = configuracao;		
	}
	
	public TimeZone getTimeZone() {		
		return java.util.TimeZone.getDefault();		
	}
	
	public Date getHoje() {
        return new Date();
    }

	@Override
	protected void finalize() throws Throwable {		
		super.finalize();
		configuracao=null;		
	}	
}