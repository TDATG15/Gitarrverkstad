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
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findByEventId", query = "SELECT e FROM Event e WHERE e.eventId = :eventId")
    , @NamedQuery(name = "Event.findByCustName", query = "SELECT e FROM Event e WHERE e.custName = :custName")
    , @NamedQuery(name = "Event.findByCustTel", query = "SELECT e FROM Event e WHERE e.custTel = :custTel")
    , @NamedQuery(name = "Event.findByCustMail", query = "SELECT e FROM Event e WHERE e.custMail = :custMail")
    , @NamedQuery(name = "Event.findByDescr", query = "SELECT e FROM Event e WHERE e.descr = :descr")
    , @NamedQuery(name = "Event.findByArrDate", query = "SELECT e FROM Event e WHERE e.arrDate = :arrDate")
    , @NamedQuery(name = "Event.findByDuration", query = "SELECT e FROM Event e WHERE e.duration = :duration")
    , @NamedQuery(name = "Event.findByArrTid", query = "SELECT e FROM Event e WHERE e.arrTid = :arrTid")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVENT_ID")
    private Integer eventId;
    @Size(max = 32)
    @Column(name = "CUST_NAME")
    private String custName;
    @Column(name = "CUST_TEL")
    private Long custTel;
    @Size(max = 64)
    @Column(name = "CUST_MAIL")
    private String custMail;
    @Size(max = 512)
    @Column(name = "DESCR")
    private String descr;
    @Column(name = "ARR_DATE")
    @Temporal(TemporalType.DATE)
    private Date arrDate;
    @Column(name = "DURATION")
    private Integer duration;
    @Column(name = "ARR_TID")
    @Temporal(TemporalType.TIME)
    private Date arrTid;

    public Event() {
    }

    public Event(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Long getCustTel() {
        return custTel;
    }

    public void setCustTel(Long custTel) {
        this.custTel = custTel;
    }

    public String getCustMail() {
        return custMail;
    }

    public void setCustMail(String custMail) {
        this.custMail = custMail;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getArrDate() {
        return arrDate;
    }

    public void setArrDate(Date arrDate) {
        this.arrDate = arrDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getArrTid() {
        return arrTid;
    }

    public void setArrTid(Date arrTid) {
        this.arrTid = arrTid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Event[ eventId=" + eventId + " ]";
    }
    
}
