/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schema.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elementalist
 */
@Entity
@Table(name = "TIDBOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tidbok.findAll", query = "SELECT t FROM Tidbok t")
    , @NamedQuery(name = "Tidbok.findByDatId", query = "SELECT t FROM Tidbok t WHERE t.datId = :datId")
    , @NamedQuery(name = "Tidbok.findByDatums", query = "SELECT t FROM Tidbok t WHERE t.datums = :datums")
    , @NamedQuery(name = "Tidbok.findByTidId", query = "SELECT t FROM Tidbok t WHERE t.tidId = :tidId")})
public class Tidbok implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAT_ID")
    private Integer datId;
    @Column(name = "DATUMS")
    @Temporal(TemporalType.DATE)
    private Date datums;
    @Column(name = "TID_ID")
    private Integer tidId;
    @PrimaryKeyJoinColumn(name = "ARENDE_ID", referencedColumnName = "ARENDE_ID")
    @ManyToOne
    private Arende arendeId;
    @PrimaryKeyJoinColumn(name = "LOPNUMMER", referencedColumnName = "LOPNUMMER")
    @ManyToOne
    private Forfragan lopnummer;
    @PrimaryKeyJoinColumn(name = "ARENDE_ID", referencedColumnName = "TID_ID")
    @ManyToOne
    private Tidblock arendeId1;

    public Tidbok() {
    }

    public Tidbok(Integer datId) {
        this.datId = datId;
    }

    public Integer getDatId() {
        return datId;
    }

    public void setDatId(Integer datId) {
        this.datId = datId;
    }

    public Date getDatums() {
        return datums;
    }

    public void setDatums(Date datums) {
        this.datums = datums;
    }

    public Integer getTidId() {
        return tidId;
    }

    public void setTidId(Integer tidId) {
        this.tidId = tidId;
    }

    public Arende getArendeId() {
        return arendeId;
    }

    public void setArendeId(Arende arendeId) {
        this.arendeId = arendeId;
    }

    public Forfragan getLopnummer() {
        return lopnummer;
    }

    public void setLopnummer(Forfragan lopnummer) {
        this.lopnummer = lopnummer;
    }

    public Tidblock getArendeId1() {
        return arendeId1;
    }

    public void setArendeId1(Tidblock arendeId1) {
        this.arendeId1 = arendeId1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datId != null ? datId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tidbok)) {
            return false;
        }
        Tidbok other = (Tidbok) object;
        if ((this.datId == null && other.datId != null) || (this.datId != null && !this.datId.equals(other.datId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "schema.entities.Tidbok[ datId=" + datId + " ]";
    }
    
}
