package br.com.wofsolutions.filtros;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletResponse;

import br.com.wofsolutions.util.HibernateUtil;

public class PhaseListener implements javax.faces.event.PhaseListener {  
  
    @Override  
    public void beforePhase(PhaseEvent event) {  
        final FacesContext facesContext = event.getFacesContext();  
        final HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();  
  
        
        System.out.println("rodando o filtro "); 
        
        if (event.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {  
        	HibernateUtil.getCurrentSession();   
        
            System.out.println("Criou a sessão e atrelou a requisição. ");  
        }  
  
    }  
  
    @Override  
    public void afterPhase(PhaseEvent event) {  
        if (event.getPhaseId().equals(PhaseId.RENDER_RESPONSE) ) {  
            /* recupera sessão do hibernate e fecha a sessão.**/  
        	HibernateUtil.doCloseSession();  
            System.out.println("Fechou a sessão");  
        }  
    }  
  
    @Override  
    public PhaseId getPhaseId() {  
        return PhaseId.RENDER_RESPONSE;
    }  
}  
