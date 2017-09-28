package br.edu.ifc.concordia.inf.cgaeguarita.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.boilerplate.SimpleEntity;

@Entity(name="authorization")
@Table(name="authorization")
public class Authorization extends SimpleEntity {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional=false, targetEntity=Student.class)
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}