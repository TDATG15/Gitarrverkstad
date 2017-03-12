
package guitar.beans;

import entities.Guitar;
import guitar.persistence.GuitarFacade;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.primefaces.model.UploadedFile;

 

@Named(value = "crudBean")
@SessionScoped
public class CrudBean implements Serializable {
    
    
    
    private UploadedFile file;
    
    @Inject GuitarBean guitarBean;
    @EJB GuitarFacade guitarFacade;
    
    
    public UploadedFile getFile() {
        return file;
    }
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    public List<Guitar> getAll(){
        
        return guitarFacade.findAll();
        
    }
    public int count(){
        return guitarFacade.count();
    }
    public String delete(Guitar g){
       
        guitarFacade.remove(g);
    
       return null; 
    }
    public String edit(Guitar g){
        
        guitarBean.setGid(g.getGid());
        guitarBean.setModel(g.getModel());
        guitarBean.setPrice(g.getPrice());
        guitarBean.setManf(g.getManf());
        guitarBean.setDescr(g.getDescr());
        guitarBean.setPrvowner(g.getPrvowner());
        guitarBean.setImg(g.getImg());
        return "update";
    }
    public String save(){
        
        Guitar g = new Guitar(guitarBean.getGid());
        
        g.setModel(guitarBean.getModel());
        g.setPrice(guitarBean.getPrice());
        g.setManf(guitarBean.getManf());
        g.setDescr(guitarBean.getDescr());
        g.setPrvowner(guitarBean.getPrvowner());
        g.setImg(guitarBean.getImg());
        guitarFacade.edit(g);
        return "config"; 
    }
    
    
    
}
