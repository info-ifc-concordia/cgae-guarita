package br.edu.ifc.concordia.inf.cgaeguarita;

import java.io.Serializable;

import br.edu.ifc.concordia.inf.cgaeguarita.model.Authorization;
import br.edu.ifc.concordia.inf.cgaeguarita.model.Student;
import br.edu.ifc.concordia.inf.cgaeguarita.model.User;

public class ResponseGroup implements Serializable{

	private Student student;
	private Authorization authorization;
	private User user;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Authorization getAuthorization() {
		return authorization;
	}
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
