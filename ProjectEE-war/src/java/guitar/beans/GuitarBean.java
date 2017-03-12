
package guitar.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.persistence.Lob;


@Named(value = "guitarBean")
@SessionScoped
public class GuitarBean implements Serializable {

    
    
    private Integer gid;
    private String model;
    private Integer price;
    private String manf;
    private String descr;
    private String prvowner;
    @Lob
    private byte[] img;
    
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


}
