
package image.beans;

import entities.Image;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;


@Named(value = "imageControllBean")
@SessionScoped
public class ImageControllBean implements Serializable {

    @Inject
    ImageBean imageBean;
    
    @EJB
    ImageFacade imageFacade;
    
    public List<Image> getAll(){
        return imageFacade.findAll();
    }
    
    public int count(){
        return imageFacade.count();
    }
    
    public String delete(Image e){
        imageFacade.remove(e);
        return null;
    }
    
    public String add(){
        
        Image e = new Image();
        //e.setInstrumentId(imageBean.getInstrumentId());
        e.setPath(imageBean.getPath());
        imageFacade.create(e);
        
        return "config";
    }
    
    public String edit(Image e){
        
        imageBean.setPath(e.getPath());
        
        return "update";
    }
    
    public String save(){
        
        Image e = new Image(imageBean.getInstrumentId());
        e.setPath(imageBean.getPath());
        imageFacade.edit(e);
        
        return "config";
        
    }
    
    
    
}
