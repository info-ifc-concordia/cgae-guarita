package br.edu.ifc.concordia.inf.cgaeguarita.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.boilerplate.SimpleEntity;

@Entity(name="movements")
@Table(name="movements")
public class Movement extends SimpleEntity implements Serializable{
	@ManyToOne(optional=false, targetEntity=Student.class)
	private Student student;
	
	private String date;
	private String time;
	private String movementType;
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
	public String getMovementType() {
		return movementType;
	}
	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}