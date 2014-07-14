package br.com.wofsolutions.helper;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import br.com.wofsolutions.annotation.Parammeter;
import br.com.wofsolutions.controller.BaseController;
import br.com.wofsolutions.interfaces.HibernateDAO;
import br.com.wofsolutions.interfaces.ObjectBase;
import br.com.wofsolutions.mensagens.FacesMessages;
import br.com.wofsolutions.model.ObjDataModel;
import br.com.wofsolutions.util.FacesUtil;
import br.com.wofsolutions.vo.Modulo;
import br.com.wofsolutions.vo.Usuario;
/**
 * Esta classe serve para ajudar em funcoes que geralmente sao comuns a todos 
 * os controllers 
 * @author Helber
 *
 * @param <A> geralmente um objeto ex. Usuario, Atendimento, etc...
 * @param <B> classe DAO
 */
public class BaseControllerHelper<A extends ObjectBase, B extends HibernateDAO<A, ?, ?>>
		extends BaseController<A, B> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Deprecated
	protected   static  String PARAMMETER_KEY="objectId";
	protected   static final  int FINDALL_COM_EMPRESA=0;
	protected   static  final int FINDALL_SEM_EMPRESA=1;
	protected   static  final int NAO_EXECUTA_FIND_ALL=2;
	protected FacesUtil facesUtil = new FacesUtil();
	
	
	@Override
	@PostConstruct
	public void init() {
		
			init(FINDALL_COM_EMPRESA);	
		
			
		
	}
	
	/**
	 * Metodo inicial, sempre e chamado nas classe. Para atender diversos tipos 
	 * de controllers ele posue para cada caso uma abordagem: 
	 * @param tipo pode ser um dos seguintes parametros:<br/>
	 * FINDALL_COM_EMPRESA - faz uma busca considerando a empresa geralmente a mesma do usuario logado.<br/>
	 * FINDALL_SEM_EMPRESA - faz uma busca desconsiderando a empresa geralmente a mesma do usuario logado.<br/>
	 * NAO_EXECUTA_FIND_ALL - inicia o controller sem nenhuma busca<br/>
	 */
	public void init(int tipo) {
		log.info("Executando o ini de "+obj.getClass());
		
		switch (tipo) {
		case FINDALL_COM_EMPRESA:
			lista = dao.findAll(getUsuarioOnline().getEmpresa());
			break;
		case FINDALL_SEM_EMPRESA:
			lista = dao.findAll();
			break;
		case NAO_EXECUTA_FIND_ALL:
			break;
		}
		
		carregaParammter();	
		
	}
	
	
	public void carregaParammter() {
				
		if (facesUtil.getParammeter(PARAMMETER_KEY) != null) {
			obj.setId(facesUtil
					.getParammeterASInteger(PARAMMETER_KEY));

			if (lista.contains(obj)) {
				obj = lista.get(lista.indexOf(obj));
			}		
		}
	}

	@Override
	public void salvar() {
		
		obj.setEmpresa(getUsuarioOnline().getEmpresa());
		
		boolean resp = dao.salvar(obj);
		novoObjeto();
		FacesMessages.setMessageSuccessOrFailure(resp);
		lista=dao.findAll(getUsuarioOnline().getEmpresa());
	}
	/**
	 * Este metodo deve ser mudado para se ajustar ao JSF 2.2
	 * onde podemos passar o objeto diretamente e não só o ID, assim
	 * evitamos ir novamente ao banco, uma vez que temos o objeto já carregado.
	 */
	@Deprecated
	@Override
	public void editar(String GO_PAGE) {
		novoObjeto();
		FacesUtil.redirect(GO_PAGE + facesUtil.getParammeter(PARAMMETER_KEY)
				+ "/");		
	}
	
	
	

	
	
	@Override
	public void excluir() {
		// TODO Auto-generated method stub
	}

	/**
	 * Retorna o usuario que esta logado no momento	 * 
	 * @return usuairo
	 */
	public Usuario getUsuarioSessao() {
		return (Usuario) FacesUtil.getAttribute(Usuario.USUARIO_KEY);
	}

	@Deprecated
	public static String getPARAMMETER_KEY() {
		return PARAMMETER_KEY;
	}

	@Deprecated
	public static void setPARAMMETER_KEY(String pARAMMETER_KEY) {
		PARAMMETER_KEY = pARAMMETER_KEY;
	}
	
	
}