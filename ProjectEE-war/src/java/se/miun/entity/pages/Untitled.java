/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.entity.pages;

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
 * @author Kjek
 */
@Entity
@Table(name = "UNTITLED")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Untitled.findAll", query = "SELECT u FROM Untitled u")
	, @NamedQuery(name = "Untitled.findById", query = "SELECT u FROM Untitled u WHERE u.id = :id")})
public class Untitled implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
	private Integer id;
	@Lob
    @Size(max = 32700)
    @Column(name = "TEXT")
	private String text;

	public Untitled() {
	}

	public Untitled(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Untitled)) {
			return false;
		}
		Untitled other = (Untitled) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "se.miun.entity.pages.Untitled[ id=" + id + " ]";
	}
	
}
