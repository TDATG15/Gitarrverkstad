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
@Table(name = "KUND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kund.findAll", query = "SELECT k FROM Kund k")
    , @NamedQuery(name = "Kund.findByKundId", query = "SELECT k FROM Kund k WHERE k.kundId = :kundId")
    , @NamedQuery(name = "Kund.findByPhone", query = "SELECT k FROM Kund k WHERE k.phone = :phone")
    , @NamedQuery(name = "Kund.findByAdress", query = "SELECT k FROM Kund k WHERE k.adress = :adress")
    , @NamedQuery(name = "Kund.findByEfternamn", query = "SELECT k FROM Kund k WHERE k.efternamn = :efternamn")
    , @NamedQuery(name = "Kund.findByFornamn", query = "SELECT k FROM Kund k WHERE k.fornamn = :fornamn")})
public class Kund implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KUND_ID")
    private Integer kundId;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 45)
    @Column(name = "ADRESS")
    private String adress;
    @Size(max = 45)
    @Column(name = "EFTERNAMN")
    private String efternamn;
    @Size(max = 100)
    @Column(name = "FORNAMN")
    private String fornamn;
    @OneToMany(mappedBy = "kundId")
    private Collection<Arende> arendeCollection;

    public Kund() {
    }

    public Kund(Integer kundId) {
        this.kundId = kundId;
    }

    public Integer getKundId() {
        return kundId;
    }

    public void setKundId(Integer kundId) {
        this.kundId = kundId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public String getFornamn() {
        return fornamn;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    @XmlTransient
    public Collection<Arende> getArendeCollection() {
        return arendeCollection;
    }

    public void setArendeCollection(Collection<Arende> arendeCollection) {
        this.arendeCollection = arendeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kundId != null ? kundId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kund)) {
            return false;
        }
        Kund other = (Kund) object;
        if ((this.kundId == null && other.kundId != null) || (this.kundId != null && !this.kundId.equals(other.kundId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "schema.entities.Kund[ kundId=" + kundId + " ]";
    }
    
}
