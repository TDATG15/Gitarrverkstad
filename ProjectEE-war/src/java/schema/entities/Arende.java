/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schema.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elementalist
 */
@Entity
@Table(name = "ARENDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arende.findAll", query = "SELECT a FROM Arende a")
    , @NamedQuery(name = "Arende.findByArendeId", query = "SELECT a FROM Arende a WHERE a.arendeId = :arendeId")
    , @NamedQuery(name = "Arende.findByJobbArende", query = "SELECT a FROM Arende a WHERE a.jobbArende = :jobbArende")})
public class Arende implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ARENDE_ID")
    private Integer arendeId;
    @Size(max = 1000)
    @Column(name = "JOBB_ARENDE")
    private String jobbArende;
    @PrimaryKeyJoinColumn(name = "KUND_ID", referencedColumnName = "KUND_ID")
    @ManyToOne
    private Kund kundId;
    @OneToMany(mappedBy = "arendeId")
    private Collection<Tidbok> tidbokCollection;

    public Arende() {
    }

    public Arende(Integer arendeId) {
        this.arendeId = arendeId;
    }

    public Integer getArendeId() {
        return arendeId;
    }

    public void setArendeId(Integer arendeId) {
        this.arendeId = arendeId;
    }

    public String getJobbArende() {
        return jobbArende;
    }

    public void setJobbArende(String jobbArende) {
        this.jobbArende = jobbArende;
    }

    public Kund getKundId() {
        return kundId;
    }

    public void setKundId(Kund kundId) {
        this.kundId = kundId;
    }

    @XmlTransient
    public Collection<Tidbok> getTidbokCollection() {
        return tidbokCollection;
    }

    public void setTidbokCollection(Collection<Tidbok> tidbokCollection) {
        this.tidbokCollection = tidbokCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arendeId != null ? arendeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arende)) {
            return false;
        }
        Arende other = (Arende) object;
        if ((this.arendeId == null && other.arendeId != null) || (this.arendeId != null && !this.arendeId.equals(other.arendeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "schema.entities.Arende[ arendeId=" + arendeId + " ]";
    }
    
}
