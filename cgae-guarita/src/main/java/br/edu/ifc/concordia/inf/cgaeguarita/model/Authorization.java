package br.edu.ifc.concordia.inf.cgaeguarita.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.boilerplate.SimpleEntity;

@Entity(name="authorizations")
@Table(name="authorizations")
public class Authorization extends SimpleEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional=false, targetEntity=Student.class)
	private Student student;
	
	private String date;
	private String time;
	private String description;
	private String userName;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}



}
