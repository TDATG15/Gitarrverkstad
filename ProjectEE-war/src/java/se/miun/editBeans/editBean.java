package se.miun.editBeans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import static javax.ws.rs.client.Entity.entity;

@Named(value = "editBean")
@ViewScoped
public class editBean {
	private boolean editmode;
	
	public void edit() {
		editmode = true;
	}
	
	public void save() {
		//entityService.save(entity);
	}
	
	public boolean isEditmode() {
		return editmode;
	}
}
