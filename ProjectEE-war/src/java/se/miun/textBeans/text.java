/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.textBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Kjek
 */
@Named(value = "text")
@SessionScoped
public class text implements Serializable {

	private String text ="Anders Andersson\n "
                + "Andersgatan 1A (A för Anders)";
        
        private String othertext ="Kontakta mig!\n"
                + "E-post: GitarrAnders@gmail.com\n"
                + "Telefon: 072 - 212 54 00";

        public String getOthertext() {
        return othertext;
        }
	
        public void setOtherText(String othertext){
            this.othertext = othertext;
        }

        
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
