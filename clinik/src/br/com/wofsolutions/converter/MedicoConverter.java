package br.com.wofsolutions.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.wofsolutions.dao.MedicoDAOImpl;
import br.com.wofsolutions.vo.Medico;
@ManagedBean(name = "medicoConverter")
@RequestScoped
@FacesConverter(value="medicoConverter",forClass=Medico.class)
public class MedicoConverter implements Converter {

	private MedicoDAOImpl medicoDAO = new MedicoDAOImpl();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null)
			return null;
		
		value=value.replaceAll("Medico \\[usuarioId\\=", "");
		value=value.replaceAll("\\]", "");
		
		return medicoDAO.getObjetoPelaChave(Integer.parseInt(String.valueOf(value)));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object instanceof Medico){
			return ((Medico)object).toString();
		}else{
			throw new IllegalArgumentException( "Não foi possível converter este objeto para Medico" );
		}
		
	}

	public MedicoDAOImpl getMedicoDAO() {
		return medicoDAO;
	}

	public void setMedicoDAO(MedicoDAOImpl medicoDAO) {
		this.medicoDAO = medicoDAO;
	}
}
