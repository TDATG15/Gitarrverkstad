
package instrument.beans;

import javax.inject.Named;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

@Named(value = "instrumentBean")
@SessionScoped
public class InstrumentBean implements Serializable {
    
    private Integer instrumentId;
    private String model;
    private String beskrivning;
    private Integer pris;
    private String tillverkare;
    
    private String image;
    
    public Integer getInstrumentId() {
        return instrumentId;
    }
    
    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
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
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
}
