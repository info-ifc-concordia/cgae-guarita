package br.edu.ifc.concordia.inf.cgaeguarita.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="students")
@Table(name="students")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String registration;
	
	@Column(unique=true)
	private String name;
	private String course;
	private String grade;
	
	public String getRegistration() {
		return registration;
	}	
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}	
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGrade() {
		return grade;
	}	
	public void setGrade(String grade) {
		this.grade = grade;
	}	
}