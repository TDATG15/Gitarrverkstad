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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elementalist
 */
@Entity
@Table(name = "FORFRAGAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forfragan.findAll", query = "SELECT f FROM Forfragan f")
    , @NamedQuery(name = "Forfragan.findByLopnummer", query = "SELECT f FROM Forfragan f WHERE f.lopnummer = :lopnummer")
    , @NamedQuery(name = "Forfragan.findByBeskriving", query = "SELECT f FROM Forfragan f WHERE f.beskriving = :beskriving")})
public class Forfragan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOPNUMMER")
    private Integer lopnummer;
    @Size(max = 1000)
    @Column(name = "BESKRIVING")
    private String beskriving;
    @OneToMany(mappedBy = "lopnummer")
    private Collection<Tidbok> tidbokCollection;

    public Forfragan() {
    }

    public Forfragan(Integer lopnummer) {
        this.lopnummer = lopnummer;
    }

    public Integer getLopnummer() {
        return lopnummer;
    }

    public void setLopnummer(Integer lopnummer) {
        this.lopnummer = lopnummer;
    }

    public String getBeskriving() {
        return beskriving;
    }

    public void setBeskriving(String beskriving) {
        this.beskriving = beskriving;
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
        hash += (lopnummer != null ? lopnummer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forfragan)) {
            return false;
        }
        Forfragan other = (Forfragan) object;
        if ((this.lopnummer == null && other.lopnummer != null) || (this.lopnummer != null && !this.lopnummer.equals(other.lopnummer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "schema.entities.Forfragan[ lopnummer=" + lopnummer + " ]";
    }
    
}
