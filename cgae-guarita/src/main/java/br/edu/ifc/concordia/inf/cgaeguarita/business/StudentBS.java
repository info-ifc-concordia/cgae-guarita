package br.edu.ifc.concordia.inf.cgaeguarita.business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.boilerplate.HibernateBusiness;
import br.com.caelum.vraptor.boilerplate.util.GeneralUtils;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.edu.ifc.concordia.inf.cgaeguarita.ImagesUpload;
import br.edu.ifc.concordia.inf.cgaeguarita.model.Authorization;
import br.edu.ifc.concordia.inf.cgaeguarita.model.Movement;
import br.edu.ifc.concordia.inf.cgaeguarita.model.Student;

@RequestScoped
public class StudentBS extends HibernateBusiness {
	
	@Inject private ImagesUpload imagesUpload;
	
	//CADASTRA NOVO ALUNO
	public void registerNewStudent(
			String registration, String name, UploadedFile studentImg,
			String course, String grade) {
		
		Criteria criteria = this.dao.newCriteria(Student.class);
		criteria.add(Restrictions.eq("name", name));
		Student student = (Student) criteria.uniqueResult();
		
		if (student == null) {
			student = new Student();
			student.setRegistration(registration);
			student.setName(name);
			student.setCourse(course);
			student.setGrade(grade);
			imagesUpload.saveImage(studentImg, student);
			
			this.dao.persist(student);
		}else {
			
		}
		
	}
	
	//LISTA ALUNO
	public List<Student> listStudents(String filter) {
		Criteria criteria = this.dao.newCriteria(Student.class);
		if (!GeneralUtils.isEmpty(filter)) {
			criteria.add(Restrictions.ilike("registration", filter, MatchMode.ANYWHERE));
		}
		return this.dao.findByCriteria(criteria, Student.class);
	}
	
	//CADASTRA NOVA AUTORIZAÇÃO
	public void registerNewAuthorization(String description, Student student,
			String date, String time, String userName) {
		
		Authorization authorization = new Authorization();
		authorization.setDescription(description);
		authorization.setStudent(student);
		authorization.setDate(date);
		authorization.setTime(time);
		authorization.setUserName(userName);
		
		this.dao.persist(authorization);
			
	}
	
	//LISTA AUTORIZAÇÕES
	public List<Authorization> getAuthorization(Student student) {
		Criteria criteria = this.dao.newCriteria(Authorization.class);
		criteria.add(Restrictions.eq("student", student));
		return this.dao.findByCriteria(criteria, Authorization.class);
	}
	
	//EXCLUI AUTORIZAÇÃO
	public void deleteAuthotization(Authorization authorization) {
		this.dao.delete(authorization);
	}
	
	//ATUALIZA AUTORIZAÇÃO
	public void updateAuthorization(Authorization authorization, String newDescription,
			String date, String time, String userName) {
		
		authorization.setDescription(newDescription);
		authorization.setDate(date);
		authorization.setTime(time);
		authorization.setUserName(userName);
		
		this.dao.update(authorization);
	}

	//CADASTRA NOVA MOVIMENTAÇÃO
	public void registerNewMovement(Student student, String date, String time,
			String movementType, String userName) {
		
		Movement movement = new Movement();
		movement.setStudent(student);
		movement.setDate(date);
		movement.setTime(time);
		movement.setMovementType(movementType);
		movement.setUserName(userName);
		
		this.dao.persist(movement);
		
	}
	
	//LISTA MOVIMENTAÇÃO
	public List<Movement> getMovement(Student student) {
		Criteria criteria = this.dao.newCriteria(Authorization.class);
		criteria.add(Restrictions.eq("student", student));
		return this.dao.findByCriteria(criteria, Movement.class);
	}
}