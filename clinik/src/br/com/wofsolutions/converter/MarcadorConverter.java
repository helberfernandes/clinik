package br.com.wofsolutions.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.wofsolutions.dao.PaginaDAOImpl;
import br.com.wofsolutions.vo.Marcador;
@ManagedBean(name = "marcadorConverter")
@RequestScoped
@FacesConverter(value="marcadorConverter",forClass=Marcador.class)
public class MarcadorConverter implements Converter {

	private PaginaDAOImpl paginaDAO = PaginaDAOImpl.getInstancia();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null)
			return null;
		
		value=value.replaceAll("Marcador \\[marcadorId\\=", "");
		value=value.replaceAll("\\]", "");
		
		return paginaDAO.getMarcadorPelaChave(Integer.parseInt(String.valueOf(value)));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object instanceof Marcador){
			return ((Marcador)object).toString();
		}else{
			throw new IllegalArgumentException( "Não foi possível converter este objeto para Marcador" );
		}
		
	}

	public PaginaDAOImpl getPaginaDAO() {
		return paginaDAO;
	}

	public void setPaginaDAO(PaginaDAOImpl paginaDAO) {
		this.paginaDAO = paginaDAO;
	}
}
