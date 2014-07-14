package br.com.wofsolutions.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.wofsolutions.dao.ExameDAOImpl;
import br.com.wofsolutions.vo.Exame;
@ManagedBean(name = "exameConverter")
@RequestScoped
@FacesConverter(value="exameConverter",forClass=Exame.class)
public class ExameConverter implements Converter {

	private ExameDAOImpl exameDAO = new ExameDAOImpl();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null)
			return null;
		
		value=value.replaceAll("Exame \\[exameId\\=", "");
		value=value.replaceAll("\\]", "");
		
		return exameDAO.getObjetoPelaChave(Integer.parseInt(String.valueOf(value)));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object instanceof Exame){
			return ((Exame)object).toString();
		}else{
			throw new IllegalArgumentException( "Não foi possível converter este objeto para Exame" );
		}
		
	}

	public ExameDAOImpl getExameDAO() {
		return exameDAO;
	}

	public void setExameDAO(ExameDAOImpl exameDAO) {
		this.exameDAO = exameDAO;
	}
}
