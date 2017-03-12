package guitar.beans;
 

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean(name= "addBean")
@ViewScoped 
public class AddBean implements Serializable{
 
    
   
    private Integer gid;
    private String model;
    private Integer price;
    private String manf;
    private String descr;
    private String prvowner;
    private UploadedFile img;
    
    public UploadedFile getImg() {
        return img;
    }
    public void setImg(UploadedFile img) {
        this.img = img;
    }
    public void handleFileUpload(FileUploadEvent event) {
        System.out.println("beans.AddBean.handleFileUpload()");
        img = event.getFile();
        
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
    public String store(){
               
        if(img!=null){
            try{
               
                InputStream fin = img.getInputstream();
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url="jdbc:derby://192.168.1.2:1527/sample;user=app;password=app;";
                Connection con = DriverManager.getConnection(url);
                PreparedStatement ps= con.prepareStatement("insert into guitar(model,price,manf,descr,prvowner,img)values(?,?,?,?,?,?)");
                ps.setString(1, model);
                ps.setInt(2, price);
                ps.setString(3, manf);
                ps.setString(4, descr);
                ps.setString(5, prvowner);
                ps.setBinaryStream(6, fin, img.getSize());
                ps.executeUpdate();
            }       
            catch(IOException | ClassNotFoundException | SQLException e){
                System.out.println("Exception-File Upload." + e.getMessage());
            }
        }
        else
        {
            System.out.print("Error no file!");
        }
        return "config";
    }   
         
}