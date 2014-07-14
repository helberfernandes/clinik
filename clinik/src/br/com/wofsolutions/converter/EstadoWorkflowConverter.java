package br.com.wofsolutions.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.wofsolutions.dao.WorkflowDAOImpl;
import br.com.wofsolutions.vo.EstadoWorkflow;
@ManagedBean(name = "estadoWorkflowConverter")
@RequestScoped
@FacesConverter(value="estadoWorkflowConverter",forClass=EstadoWorkflow.class)
public class EstadoWorkflowConverter implements Converter {

	private WorkflowDAOImpl workflowDAO = WorkflowDAOImpl.getInstancia();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null)
			return null;
		
		value=value.replaceAll("EstadoWorkflow \\[estadoWorkflowId\\=", "");
		value=value.replaceAll("\\]", "");
		
		return workflowDAO.getEstadoWorkflowPelaChave(Integer.parseInt(String.valueOf(value)));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object instanceof EstadoWorkflow){
			return ((EstadoWorkflow)object).toString();
		}else{
			throw new IllegalArgumentException( "Não foi possível converter este objeto para EstadoWorkflow" );
		}
		
	}

	public WorkflowDAOImpl getWorkflowDAO() {
		return workflowDAO;
	}

	public void setWorkflowDAO(WorkflowDAOImpl workflowDAO) {
		this.workflowDAO = workflowDAO;
	}
}
