package br.com.wofsolutions.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.wofsolutions.dao.TipoAtendimentoDAOImpl;
import br.com.wofsolutions.vo.TipoAtendimento;
@ManagedBean(name = "tipoAtendimentoConverter")
@RequestScoped
@FacesConverter(value="tipoAtendimentoConverter",forClass=TipoAtendimento.class)
public class TipoAtendimentoConverter implements Converter {

	private TipoAtendimentoDAOImpl tipoAtendimentoDAO = new TipoAtendimentoDAOImpl();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null)
			return null;
		
	
		
		return tipoAtendimentoDAO.getObjetoPelaChave(Integer.parseInt(String.valueOf(value)));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object instanceof TipoAtendimento){
			return ((TipoAtendimento)object).toString();
		}else{
			throw new IllegalArgumentException( "Não foi possível converter este objeto para TipoAtendimento" );
		}
		
	}

	public TipoAtendimentoDAOImpl getTipoAtendimentoDAO() {
		return tipoAtendimentoDAO;
	}

	public void setTipoAtendimentoDAO(TipoAtendimentoDAOImpl tipoAtendimentoDAO) {
		this.tipoAtendimentoDAO = tipoAtendimentoDAO;
	}
}
