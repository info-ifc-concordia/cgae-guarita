package br.edu.ifc.concordia.inf.cgaeguarita.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.caelum.vraptor.boilerplate.factory.SessionFactoryProducer;
import br.com.caelum.vraptor.boilerplate.util.GeneralUtils;
import br.edu.ifc.concordia.inf.cgaeguarita.abstractions.AbstractController;
import br.edu.ifc.concordia.inf.cgaeguarita.business.StudentBS;
import br.edu.ifc.concordia.inf.cgaeguarita.model.Student;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.Permission;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.UserRoles;

@Controller
public class StudentController extends AbstractController {
	
	@Inject private StudentBS sbs;

	@Get(value="/students/register")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void register(String errorMsg) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
	}
	
	
	@Post(value="/students/register")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void doRegister(String registration, String name, 
			String course, String grade) {
		
		SessionFactoryProducer factoryProducer = new SessionFactoryProducer();
		this.sbs.registerNewStudent(factoryProducer, registration, name, course, grade);
		this.result.redirectTo(UserController.class).profile();
		
	}
	
}