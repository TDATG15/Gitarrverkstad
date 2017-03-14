package schedule;
 
import persistence.bokning.ConsultationFacade;
import entities.Consultation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
 
@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {
 
    @Inject
        ConsBean consBean;
    @EJB
        ConsultationFacade consultationFacade;
    
    
    private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    List<Consultation> scheduleList = new ArrayList<Consultation>();
    public List<Consultation> getAll(){
        
        return consultationFacade.findAll();
    }
    
    @PostConstruct
    
    
    public void init() {
        
        lazyEventModel = new DefaultScheduleModel();
        //lazyEventModel = new LazyScheduleModel();
        scheduleList = getAll();
        for(Consultation c: scheduleList){
            
            lazyEventModel.addEvent(new DefaultScheduleEvent("Bokad",c.getConDate(),c.getConDate()));
            
        }
        TimeZone time = TimeZone.getDefault();
        System.out.print(time.getID());
        

    }
    
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }    
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
        
        return calendar.getTime();
    }
    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    } 
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }     
    public ScheduleEvent getEvent() {
        return event;
    } 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }     
    public void addEvent(ActionEvent actionEvent) {
        
        if(event.getId() == null)
            lazyEventModel.addEvent(event);
        else
            lazyEventModel.updateEvent(event); 
        addConsultation();
        event = new DefaultScheduleEvent();
       
        
    } 
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    } 
    public void onDateSelect(SelectEvent selectEvent) {
        
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
          
        
    } 
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void addConsultation(){
        
        Consultation c = new Consultation();
        c.setCustName(consBean.getCustName());
        c.setConDate(consBean.getConDate());
        c.setCustTel(consBean.getCustTel());
        c.setConTime(consBean.getConTime());
        consultationFacade.create(c);    
        
    }
}