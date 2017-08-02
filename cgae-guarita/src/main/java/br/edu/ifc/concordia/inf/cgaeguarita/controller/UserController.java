package br.edu.ifc.concordia.inf.cgaeguarita.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.caelum.vraptor.boilerplate.factory.SessionFactoryProducer;
import br.com.caelum.vraptor.boilerplate.util.GeneralUtils;
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
	public void doLogin(String username, String password) { //nomes iguais dos campos para pegar os dados
		User user = this.bs.login(username, password);
		if (user == null) {
			this.result.redirectTo(this).login("Usuário e/ou senha inválido.");
		} else {
			if (this.userSession.isLogged()) {
				this.userSession.logout();
			}
			this.userSession.login(user);
			this.result.redirectTo(UserController.class).profile();
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
	
	@Post(value="/users/register")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void doRegister(String username, String name, 
			String email, String userType, String password, 
			String rePassword) {
		//if (password == rePassword) {
			SessionFactoryProducer factoryProducer = new SessionFactoryProducer();
			this.bs.registerNewUser(factoryProducer, username, name, email, userType, password);
			this.result.redirectTo(UserController.class).login(password + " - " + rePassword + " - " + userType);
		//}else {
			//this.result.redirectTo(this).register("As senhas não coincidem.");
		//}
	}
	
	@Get(value="/users/perfil")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void profile() {
		
	}
	
	@Get(value="/users/control")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void userList(String filter) {
		List<User> users = this.bs.listAllUsers(filter);
		this.result.include("users", users);
	}
	
	@Get(value="/users/change-password")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void changePassword(String userInfo) {
		
	}
	

	@Get(value="/users/{id}/edit")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void userEdit(Long id) {
		if (id == null) {
			this.result.notFound();
		} else {
			User user = this.bs.exists(id, User.class);
			if (user == null) {
				this.result.notFound();
			} else {
				this.result.include("user", user);
			}
		}
	}
	
}
