
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "GUITAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guitar.findAll", query = "SELECT g FROM Guitar g")
    , @NamedQuery(name = "Guitar.findByGid", query = "SELECT g FROM Guitar g WHERE g.gid = :gid")
    , @NamedQuery(name = "Guitar.findByModel", query = "SELECT g FROM Guitar g WHERE g.model = :model")
    , @NamedQuery(name = "Guitar.findByPrice", query = "SELECT g FROM Guitar g WHERE g.price = :price")
    , @NamedQuery(name = "Guitar.findByManf", query = "SELECT g FROM Guitar g WHERE g.manf = :manf")
    , @NamedQuery(name = "Guitar.findByDescr", query = "SELECT g FROM Guitar g WHERE g.descr = :descr")
    , @NamedQuery(name = "Guitar.findByPrvowner", query = "SELECT g FROM Guitar g WHERE g.prvowner = :prvowner")})

public class Guitar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GID")
    private Integer gid;
    @Size(max = 16)
    @Column(name = "MODEL")
    private String model;
    @Column(name = "PRICE")
    private Integer price;
    @Size(max = 32)
    @Column(name = "MANF")
    private String manf;
    @Size(max = 1024)
    @Column(name = "DESCR")
    private String descr;
    @Size(max = 32)
    @Column(name = "PRVOWNER")
    private String prvowner;
    @Lob
    @Column(name = "IMG")
    private byte[] img;
   
    
    public Guitar(){
        
    }
    public Guitar(Integer gid) {
        this.gid = gid;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getManf() {
        return manf;
    }
    public void setManf(String manf) {
        this.manf = manf;
    }
    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
    public String getPrvowner() {
        return prvowner;
    }
    public void setPrvowner(String prvowner) {
        this.prvowner = prvowner;
    }
    public byte[] getImg() {
        return img;
    }
    public void setImg(byte[] img) {
        this.img = img;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Guitar)) {
            return false;
        }
        Guitar other = (Guitar) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "beans.Guitar[ gid=" + gid + " ]";
    }
    
    
}
