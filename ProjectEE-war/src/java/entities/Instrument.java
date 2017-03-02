
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elementalist
 */
@Entity
@Table(name = "INSTRUMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instrument.findAll", query = "SELECT i FROM Instrument i")
    , @NamedQuery(name = "Instrument.findByInstrumentId", query = "SELECT i FROM Instrument i WHERE i.instrumentId = :instrumentId")
    , @NamedQuery(name = "Instrument.findByModel", query = "SELECT i FROM Instrument i WHERE i.model = :model")
    , @NamedQuery(name = "Instrument.findByTillverkare", query = "SELECT i FROM Instrument i WHERE i.tillverkare = :tillverkare")
    , @NamedQuery(name = "Instrument.findByBeskrivning", query = "SELECT i FROM Instrument i WHERE i.beskrivning = :beskrivning")
    , @NamedQuery(name = "Instrument.findByPris", query = "SELECT i FROM Instrument i WHERE i.pris = :pris")
    , @NamedQuery(name = "Instrument.findByImage", query = "SELECT i FROM Instrument i WHERE i.image = :image")})
public class Instrument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INSTRUMENT_ID")
    private Integer instrumentId;
    @Size(max = 100)
    @Column(name = "MODEL")
    private String model;
    @Size(max = 100)
    @Column(name = "TILLVERKARE")
    private String tillverkare;
    @Size(max = 1000)
    @Column(name = "BESKRIVNING")
    private String beskrivning;
    @Column(name = "PRIS")
    private Integer pris;
    @Size(max = 255)
    @Column(name = "TIDIGAREAGARE")
    private String tidigareagare;

    public Instrument() {
    }

    public Instrument(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }

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

    public String getTillverkare() {
        return tillverkare;
    }

    public void setTillverkare(String tillverkare) {
        this.tillverkare = tillverkare;
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

    public String getTidigareAgare() {
        return tidigareagare;
    }
    
    public void setTidigareagare(String tidigareagare) {
        this.tidigareagare = tidigareagare;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instrumentId != null ? instrumentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrument)) {
            return false;
        }
        Instrument other = (Instrument) object;
        if ((this.instrumentId == null && other.instrumentId != null) || (this.instrumentId != null && !this.instrumentId.equals(other.instrumentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Instrument[ instrumentId=" + instrumentId + " ]";
    }
    
}
