package br.edu.ifc.concordia.inf.cgaeguarita.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.formula.functions.T;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.caelum.vraptor.boilerplate.util.GeneralUtils;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.edu.ifc.concordia.inf.cgaeguarita.abstractions.AbstractController;
import br.edu.ifc.concordia.inf.cgaeguarita.business.StudentBS;
import br.edu.ifc.concordia.inf.cgaeguarita.model.Authorization;
import br.edu.ifc.concordia.inf.cgaeguarita.model.Student;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.Permission;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.UserRoles;

@Controller
public class StudentController extends AbstractController {
	
	@Inject private StudentBS sbs;
	@Inject private HttpServletResponse response;

	//REGISTRO DE ALUNO
	@Get(value="/students/register")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void register(String errorMsg, List<String> inputCls, List<String> inputVal) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
		if (!GeneralUtils.isEmpty(inputCls)) {
			this.result.include("inputCls", inputCls);
		}
		if (!GeneralUtils.isEmpty(inputVal)) {
			this.result.include("inputVal", inputVal);
		}
	}
	//
	@Post(value="/students/register")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void doRegister(String registration, String name, 
			UploadedFile studentImg, String course, String grade) {
		List<String> classes = new ArrayList<String>();
		List<String> inputs = new ArrayList<String>();
		if ((registration == null) || (name == null) || (course == null)
				|| (grade == null)) {
			
			List<String> values = Arrays.asList(registration, name, 
					course, grade);
			for(String x : values) {
				if (x == null) {
					classes.add("invalid");
				} else {
					classes.add("");
				}
				inputs.add(x);
			}
			if (classes.contains("invalid")) {
				this.result.redirectTo(this).register("Os campos devem ser preenchidos!",
					classes, inputs);
			}
		}
		this.sbs.registerNewStudent(registration, name,
				studentImg, course, grade);
		this.result.redirectTo(UserController.class).profileCGAE(null);;
		
	}
	
	//PERFIL DO ALUNO
	@Get(value="/students/{registration}/profile")
	@NoCache
	public void studentProfile(String registration) {
		if (registration == null) {
			this.result.notFound();
		} else {
			Student student = this.sbs.exists(registration, Student.class);
			
			List<Authorization> authorization = sbs.getAuthorization(student);
			if (student == null) {
				this.result.notFound();
			} else {
				this.result.include("student", student);
				this.result.include("user", this.userSession.getUser());
				try{
					Authorization lastAuthorization = authorization.get(authorization.size()-1);
					this.result.include("lastAuthorization", lastAuthorization);
				} catch(Exception e) {
					
				}
			}
		}
	}
	
	@Post(value="/students/{registration}/profile")
	@NoCache
	public void newAuthorization(String description, String registration) {
		Student student = this.sbs.exists(registration, Student.class);
		if (student == null) {
			this.result.notFound();
		} else {
			Date dateTime = new Date();
			Format dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Format timeFormat = new SimpleDateFormat("HH:mm");
			String date = dateFormat.format(dateTime);
			String time = timeFormat.format(dateTime);
			
			String userName = this.userSession.getUser().getUsername();
			
			this.sbs.registerNewAuthorization(description, student, date, time, userName);
			this.result.redirectTo(this).studentProfile(registration);
		}
	}
	
	//DOWNLOAD E UPLOAD DA IMAGEM DO ALUNO
	@Get(value="/students/{registration}/image")
	@NoCache
	public void getStudentImage(String registration) {
		if (registration == null) {
			this.result.notFound();
		} else {
			Student student = this.sbs.exists(registration, Student.class);
			if (student == null) {
				this.result.notFound();
			} else {
				try {
					InputStream read = new FileInputStream(student.getImage());
					this.response.setContentType(student.getImageType());
					IOUtils.copy(read, this.response.getOutputStream());
					this.result.nothing();
				} catch (Throwable ex) {
					LOGGER.error(ex);
					this.result.notFound();
				}
			}
		}
	}
	
	//AUTORIZAÇÕES DO ALUNO
	@Get(value="/students/{registration}/autorizacoes")
	public void authorizations(String registration) {
		if (registration == null) {
			this.result.notFound();
		} else {
			Student student = this.sbs.exists(registration, Student.class);
			if (student == null) {
				this.result.notFound();
			} else {
				List<Authorization> authorizations = sbs.getAuthorization(student);
				this.result.include("authorizations", authorizations);
			}
		}
	}
	
	//LISTAGEM DE ALUNOS
	@Get(value="/students/list")
	@NoCache
	public void studentList(List<Student> students, String filter) {
		if (!GeneralUtils.isEmpty(students)) {
			this.result.include("students", students);
		}
		if (!GeneralUtils.isEmpty(filter)) {
			this.result.include("filter", filter);
		}
	}
	
	@Post(value="/students/list")
	@NoCache
	public void searchStudent(String registration) {
		List<Student> students = this.sbs.listStudents(registration);
		if (students.size() == 0) {
			this.result.notFound();
		} else if (students.size() == 1) {
			this.result.redirectTo(this).studentProfile(students.get(0).getRegistration());
		} else {
			this.result.redirectTo(this).studentList(students, registration);
		}
	}
}