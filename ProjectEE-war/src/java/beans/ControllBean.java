/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Instrument;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Elementalist
 */
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
        e.setInstrumentId(instrumentBean.getInstrumentId());
        e.setBeskrivning(instrumentBean.getBeskrivning());
        e.setModell(instrumentBean.getModell());
        e.setPris(instrumentBean.getPris());
        e.setTillverkare(instrumentBean.getTillverkare());
        e.setTidigareAgare(instrumentBean.getTidigareAgare());
        instrumentFacade.create(e);
        
        return "config";
    }
    
    public String edit(Instrument e){
        
        instrumentBean.setInstrumentId(e.getInstrumentId());
        instrumentBean.setBeskrivning(e.getBeskrivning());
        instrumentBean.setModell(e.getModell());
        instrumentBean.setPris(e.getPris());
        instrumentBean.setTillverkare(e.getTillverkare());
        instrumentBean.setTidigareAgare(e.getTidigareAgare());
        
        return "update";
    }
    public String save(){
        
        Instrument e = new Instrument(instrumentBean.getInstrumentId());
        
        e.setBeskrivning(instrumentBean.getBeskrivning());
        e.setModell(instrumentBean.getModell());
        e.setPris(instrumentBean.getPris());
        e.setTillverkare(instrumentBean.getTillverkare());
        e.setTidigareAgare(instrumentBean.getTidigareAgare());
        
        
        instrumentFacade.edit(e);
        
        return "config";
        
    }
    
}
