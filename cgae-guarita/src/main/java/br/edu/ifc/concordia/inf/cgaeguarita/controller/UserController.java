package br.edu.ifc.concordia.inf.cgaeguarita.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.caelum.vraptor.boilerplate.util.GeneralUtils;
import br.edu.ifc.concordia.inf.cgaeguarita.abstractions.AbstractController;
import br.edu.ifc.concordia.inf.cgaeguarita.business.NewUserBS;
import br.edu.ifc.concordia.inf.cgaeguarita.business.UserBS;
import br.edu.ifc.concordia.inf.cgaeguarita.model.User;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.Permission;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.UserRoles;

@Controller
public class UserController extends AbstractController {
	
	@Inject private UserBS bs;
	@Inject private NewUserBS nbs;
	
	@Post(value="/login")
	@NoCache
	public void doLogin(String username, String password) { //nomes iguais dos campos para pegar os dados
		User user = this.bs.login(username, password);
		if (user == null) {
			this.result.redirectTo(this).login("Usuário e/ou senha inválido.");
		} else {
			this.userSession.login(user);
			this.result.redirectTo(UserController.class).profile();
		}
	}
	
	@Get(value="/login")
	@NoCache
	public void login(String errorMsg) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
	}

	@Get(value="/users")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void usersList() {
		
	}
	
	@Post(value="/users/cadastro")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void doRegister(String username, String name, 
			String email, String userType, String password, String repassword) {
		if (password == repassword) {
			this.nbs.registerNewUser(username, name, email, userType, password);
			this.result.redirectTo(UserController.class).login("");
		}else {
			this.result.redirectTo(this).register("As senhas não coincidem.");
		}
		
	}
	
	@Get(value="/users/cadastro")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void register(String errorMsg) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
	}
	
	@Get(value="/users/perfil")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void profile() {
		
	}
	
}
