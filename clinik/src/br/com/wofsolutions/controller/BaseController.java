package br.com.wofsolutions.controller;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;

import br.com.wofsolutions.interfaces.BaseControllerInterface;
import br.com.wofsolutions.model.ObjDataModel;
import br.com.wofsolutions.vo.Usuario;

/**
 * 
 * @author Helber
 * 
 * @param <C>
 *            Objeto da classe desejada. exemplo Usuario, Compras, Carro
 * @param <D>
 *            Dao para o C
 */
public abstract class BaseController<C, D> implements Serializable,
		BaseControllerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8024798118018529944L;

	protected List<C> lista = new ArrayList<C>();
	
	protected C obj;
	protected D dao;
	protected static final Logger log = Logger.getLogger(BaseController.class);

	@ManagedProperty(value="#{sessaoController.usuarioSessao}")
	protected Usuario usuarioOnline;
	
	@SuppressWarnings("unchecked")
	public BaseController() {
		super();

		try {
			obj = (((Class<C>) ((ParameterizedType) this.getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0]))
					.newInstance();
			dao = (((Class<D>) ((ParameterizedType) this.getClass()
					.getGenericSuperclass()).getActualTypeArguments()[1]))
					.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	public void novoObjeto() {
		obj = null;
		try {
			obj = (((Class<C>) ((ParameterizedType) this.getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0]))
					.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<C> getLista() {
		return lista;
	}

	public void setLista(List<C> lista) {
		this.lista = lista;
	}

	public C getObj() {
		return obj;
	}

	public void setObj(C obj) {
		this.obj = obj;
	}

	public Usuario getUsuarioOnline() {
		return usuarioOnline;
	}

	public void setUsuarioOnline(Usuario usuarioOnline) {
		this.usuarioOnline = usuarioOnline;
	}
}
