package br.edu.ifc.concordia.inf.cgaeguarita.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	
	@Post(value="/students/register")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void doRegister(String registration, String name, 
			String course, String grade) {
		List<String> classes = new ArrayList<String>();
		List<String> inputs = new ArrayList<String>();
		if ((registration == null) || (name == null) || (course == null)
				|| (grade == null)) {
			
			List<String> values = Arrays.asList(registration, name, 
					course, grade);
			int i = 0;
			for(String x : values) {
				if (x == null) {
						classes.add("invalid");
				} else {
					classes.add("");
				}
				i += 1;
				inputs.add(x);
			}
			if (classes.contains("invalid")) {
				this.result.redirectTo(this).register("Os campos devem ser preenchidos!",
					classes, inputs);
			}
		}
		SessionFactoryProducer factoryProducer = new SessionFactoryProducer();
		this.sbs.registerNewStudent(factoryProducer, registration, name, course, grade);
		this.result.redirectTo(UserController.class).profileCGAE();
		
	}
	
	@Get(value="/students/aluno")
	@NoCache
	public void aluno() {
		
	}
	
	@Get(value="/students/historico")
	@NoCache
	public void historico() {
		
	}
	
	@Get(value="/students/observacoes")
	@NoCache
	public void observacoes() {
		
	}
	
}