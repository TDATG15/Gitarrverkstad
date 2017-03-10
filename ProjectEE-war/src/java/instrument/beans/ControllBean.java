
package instrument.beans;

import instrument.persistence.InstrumentFacade;
import entities.Instrument;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;


@Named(value = "controllBean")
@SessionScoped
public class ControllBean implements Serializable {
    
    @Inject
            InstrumentBean instrumentBean;
    
    @EJB
            InstrumentFacade instrumentFacade;
    
    public List<Instrument> getAll(){
        return instrumentFacade.findAll();
    }
    
    public int count(){
        return instrumentFacade.count();
    }
    
    public String delete(Instrument e){
        instrumentFacade.remove(e);
        return null;
    }
    
    public String add(){
        
        Instrument e = new Instrument();
        
        e.setBeskrivning(instrumentBean.getBeskrivning());
        e.setModel(instrumentBean.getModel());
        e.setPris(instrumentBean.getPris());
        e.setTillverkare(instrumentBean.getTillverkare());
        e.setTidigareagare(instrumentBean.getTidigareagare());
        
        instrumentFacade.create(e);
        
        return "config";
    }
    
    public String edit(Instrument e){
        
        
        instrumentBean.setBeskrivning(e.getBeskrivning());
        instrumentBean.setModel(e.getModel());
        instrumentBean.setPris(e.getPris());
        instrumentBean.setTillverkare(e.getTillverkare());
        instrumentBean.setTidigareagare(e.getTidigareagare());
        
        return "update";
    }
    public String save(){
        
        Instrument e = new Instrument(instrumentBean.getInstrumentId());
        
        e.setBeskrivning(instrumentBean.getBeskrivning());
        e.setModel(instrumentBean.getModel());
        e.setPris(instrumentBean.getPris());
        e.setTillverkare(instrumentBean.getTillverkare());
        e.setTidigareagare(instrumentBean.getTidigareagare());
        
        
        instrumentFacade.edit(e);
        
        return "config";
        
    }
    
}
