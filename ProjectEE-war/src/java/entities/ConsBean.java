
package entities;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;


@Named(value = "consBean")
@SessionScoped
public class ConsBean implements Serializable {


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


    public Long getCustTel() {
        return custTel;
    }


    public void setCustTel(Long custTel) {
        this.custTel = custTel;
    }

    private Integer conId;
    private Date conDate;
    private Date conTime;
    private String custName;
    private Long custTel;
    
    
}
