package br.edu.ifc.concordia.inf.cgaeguarita.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.caelum.vraptor.boilerplate.util.GeneralUtils;
import br.edu.ifc.concordia.inf.cgaeguarita.IndexController;
import br.edu.ifc.concordia.inf.cgaeguarita.abstractions.AbstractController;
import br.edu.ifc.concordia.inf.cgaeguarita.business.UserBS;
import br.edu.ifc.concordia.inf.cgaeguarita.model.User;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.Permission;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.UserRoles;

@Controller
public class UserController extends AbstractController {
	
	@Inject private UserBS bs;
	
	@Get(value="/login")
	@NoCache
	public void login(String errorMsg) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
	}
	
	@Post(value="/login")
	@NoCache
	public void doLogin(String username, String password) {
		User user = this.bs.login(username, password);
		if (user == null) {
			this.result.redirectTo(this).login("Usuário e/ou senha inválido.");
		} else {
			this.userSession.login(user);
			this.result.redirectTo(IndexController.class).index();
		}
	}

	@Get(value="/users")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void usersList() {
		
	}
	
	@Get(value="/users/register")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void register(String errorMsg) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
	}
	
}
