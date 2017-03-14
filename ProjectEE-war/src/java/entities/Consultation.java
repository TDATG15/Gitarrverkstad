/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elementalist
 */
@Entity
@Table(name = "CONSULTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c")
    , @NamedQuery(name = "Consultation.findByConId", query = "SELECT c FROM Consultation c WHERE c.conId = :conId")
    , @NamedQuery(name = "Consultation.findByConDate", query = "SELECT c FROM Consultation c WHERE c.conDate = :conDate")
    , @NamedQuery(name = "Consultation.findByConTime", query = "SELECT c FROM Consultation c WHERE c.conTime = :conTime")
    , @NamedQuery(name = "Consultation.findByCustName", query = "SELECT c FROM Consultation c WHERE c.custName = :custName")
    , @NamedQuery(name = "Consultation.findByCustTel", query = "SELECT c FROM Consultation c WHERE c.custTel = :custTel")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CON_ID")
    private Integer conId;
    @Column(name = "CON_DATE")
    @Temporal(TemporalType.DATE)
    private Date conDate;
    @Column(name = "CON_TIME")
    @Temporal(TemporalType.TIME)
    private Date conTime;
    @Size(max = 32)
    @Column(name = "CUST_NAME")
    private String custName;
    @Size(max = 10)
    @Column(name = "CUST_TEL")
    private String custTel;

    public Consultation() {
    }

    public Consultation(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Date getConDate() {
        return conDate;
    }

    public void setConDate(Date conDate) {
        this.conDate = conDate;
    }

    public Date getConTime() {
        return conTime;
    }

    public void setConTime(Date conTime) {
        this.conTime = conTime;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Consultation[ conId=" + conId + " ]";
    }
    
}
