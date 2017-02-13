/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.textBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elementalist
 */
@Entity
@Table(name = "TESTTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testtable.findAll", query = "SELECT t FROM Testtable t")
    , @NamedQuery(name = "Testtable.findByTestid", query = "SELECT t FROM Testtable t WHERE t.testid = :testid")
    , @NamedQuery(name = "Testtable.findByTestname", query = "SELECT t FROM Testtable t WHERE t.testname = :testname")
    , @NamedQuery(name = "Testtable.findByTestdescr", query = "SELECT t FROM Testtable t WHERE t.testdescr = :testdescr")})
public class Testtable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TESTID")
    private Integer testid;
    @Size(max = 32)
    @Column(name = "TESTNAME")
    private String testname;
    @Size(max = 128)
    @Column(name = "TESTDESCR")
    private String testdescr;
    @Lob
    @Column(name = "TESTIMG")
    private Serializable testimg;

    public Testtable() {
    }

    public Testtable(Integer testid) {
        this.testid = testid;
    }

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getTestdescr() {
        return testdescr;
    }

    public void setTestdescr(String testdescr) {
        this.testdescr = testdescr;
    }

    public Serializable getTestimg() {
        return testimg;
    }

    public void setTestimg(Serializable testimg) {
        this.testimg = testimg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testid != null ? testid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testtable)) {
            return false;
        }
        Testtable other = (Testtable) object;
        if ((this.testid == null && other.testid != null) || (this.testid != null && !this.testid.equals(other.testid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.miun.textBeans.Testtable[ testid=" + testid + " ]";
    }
    
}
