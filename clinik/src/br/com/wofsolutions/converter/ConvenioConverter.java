package br.com.wofsolutions.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.wofsolutions.dao.ConvenioDAOImpl;
import br.com.wofsolutions.vo.Convenio;
@ManagedBean(name = "convenioConverter")
@RequestScoped
@FacesConverter(value="convenioConverter",forClass=Convenio.class)
public class ConvenioConverter implements Converter {

	private ConvenioDAOImpl convenioDAO = new ConvenioDAOImpl();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null)
			return null;
		
		
		
		return convenioDAO.getObjetoPelaChave(Integer.parseInt(String.valueOf(value)));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object instanceof Convenio){
			return ((Convenio)object).toString();
		}else{
			throw new IllegalArgumentException( "Não foi possível converter este objeto para Convenio" );
		}
		
	}

	public ConvenioDAOImpl getConvenioDAO() {
		return convenioDAO;
	}

	public void setConvenioDAO(ConvenioDAOImpl convenioDAO) {
		this.convenioDAO = convenioDAO;
	}
}
