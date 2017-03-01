/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schema.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elementalist
 */
@Entity
@Table(name = "TIDBLOCK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tidblock.findAll", query = "SELECT t FROM Tidblock t")
    , @NamedQuery(name = "Tidblock.findByTidId", query = "SELECT t FROM Tidblock t WHERE t.tidId = :tidId")
    , @NamedQuery(name = "Tidblock.findByTidStart", query = "SELECT t FROM Tidblock t WHERE t.tidStart = :tidStart")
    , @NamedQuery(name = "Tidblock.findByTidSlut", query = "SELECT t FROM Tidblock t WHERE t.tidSlut = :tidSlut")})
public class Tidblock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TID_ID")
    private Integer tidId;
    @Column(name = "TID_START")
    @Temporal(TemporalType.TIME)
    private Date tidStart;
    @Column(name = "TID_SLUT")
    @Temporal(TemporalType.TIME)
    private Date tidSlut;
    @OneToMany(mappedBy = "arendeId1")
    private Collection<Tidbok> tidbokCollection;

    public Tidblock() {
    }

    public Tidblock(Integer tidId) {
        this.tidId = tidId;
    }

    public Integer getTidId() {
        return tidId;
    }

    public void setTidId(Integer tidId) {
        this.tidId = tidId;
    }

    public Date getTidStart() {
        return tidStart;
    }

    public void setTidStart(Date tidStart) {
        this.tidStart = tidStart;
    }

    public Date getTidSlut() {
        return tidSlut;
    }

    public void setTidSlut(Date tidSlut) {
        this.tidSlut = tidSlut;
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
        hash += (tidId != null ? tidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tidblock)) {
            return false;
        }
        Tidblock other = (Tidblock) object;
        if ((this.tidId == null && other.tidId != null) || (this.tidId != null && !this.tidId.equals(other.tidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "schema.entities.Tidblock[ tidId=" + tidId + " ]";
    }
    
}
