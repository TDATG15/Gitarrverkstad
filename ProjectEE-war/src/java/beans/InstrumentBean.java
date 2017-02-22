/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author Elementalist
 */
@Named(value = "instrumentBean")
@SessionScoped
public class InstrumentBean implements Serializable {

    private Integer instrumentId;
    private String modell;
    private String beskrivning;
    private Integer pris;
    private String tillverkare;
    private String tidigareAgare;
    
    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    public Integer getPris() {
        return pris;
    }

    public void setPris(Integer pris) {
        this.pris = pris;
    }

    public String getTillverkare() {
        return tillverkare;
    }

    public void setTillverkare(String tillverkare) {
        this.tillverkare = tillverkare;
    }

    public String getTidigareAgare() {
        return tidigareAgare;
    }

    public void setTidigareAgare(String tidigareAgare) {
        this.tidigareAgare = tidigareAgare;
    }
    
}
