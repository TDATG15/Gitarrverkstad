
package event.beans;

import book.service.ConsultationFacade;
import entities.ConsBean;
import entities.Consultation;
import entities.Instrument;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;


@Named(value = "consControl")
@SessionScoped

public class consControl implements Serializable {

@Inject
        
    ConsBean consBean;
    
@EJB
    ConsultationFacade consultationFacade;
    
    public List<Consultation> getAll(){
            return consultationFacade.findAll();
        }
    
    public String add(){
        
        Consultation c = new Consultation();
        
        c.setConDate(consBean.getConDate());
        c.setConTime(consBean.getConTime());
        c.setCustName(consBean.getCustName());
        c.setCustTel(consBean.getCustTel());
        
        consultationFacade.create(c);
        
        return "test";
    }
}
