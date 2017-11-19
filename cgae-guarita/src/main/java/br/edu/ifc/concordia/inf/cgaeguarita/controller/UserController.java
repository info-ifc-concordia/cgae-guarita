package br.edu.ifc.concordia.inf.cgaeguarita.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.caelum.vraptor.boilerplate.util.CryptManager;
import br.com.caelum.vraptor.boilerplate.util.GeneralUtils;
import br.edu.ifc.concordia.inf.cgaeguarita.abstractions.AbstractController;
import br.edu.ifc.concordia.inf.cgaeguarita.business.UserBS;
import br.edu.ifc.concordia.inf.cgaeguarita.model.User;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.Permission;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.UserRoles;

@Controller
public class UserController extends AbstractController {
	
	@Inject private UserBS bs;
	
	//LOGIN
	@Get(value="/login")
	@NoCache
	public void login(String errorMsg, String usrNameMsg, String passMsg) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
		if (!GeneralUtils.isEmpty(usrNameMsg)) {
			this.result.include("usrNameMsg", usrNameMsg);
		}
		if (!GeneralUtils.isEmpty(passMsg)) {
			this.result.include("passMsg", passMsg);
		}
		this.userSession.logout();
	}
	
	@Post(value="/login")
	@NoCache
	public void doLogin(String username, String password) { //nomes iguais dos campos para pegar os dados
		if (username == null || password == null) {
			List<String> values = Arrays.asList(username, password);
			List<String> classes = new ArrayList<String>();
			for(String x : values) {
				if (x == null) {
					classes.add("invalid");
				} else {
					classes.add("");
				}
			}
			if (classes.contains("invalid")) {
				this.result.redirectTo(this).login("Os campos devem ser preenchidos!", 
						classes.get(0), classes.get(1));
			}
		}
		
		User user = this.bs.login(username, password);
		if (user == null) {
			this.result.redirectTo(this).login("Usuário e/ou senha inválido.", "invalid", "invalid");
		} else {
			if (this.userSession.isLogged()) {
				this.userSession.logout();
			}
			this.userSession.login(user);
			if (user.getAccess() >= 7) {
				this.result.redirectTo(this).profileCGAE("");
			} else {
				this.result.redirectTo(this).profileGuarita("");
			}
		}
	}
	
	//REGISTRO DE USUÁRIO
	@Get(value="/users/register")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void register(String errorMsg, String usrNameMsg, String nameMsg,
			String emailMsg, String usrTypeMsg, String passMsg, 
			String rePassMsg, List<String> inputVal) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
		if (!GeneralUtils.isEmpty(usrNameMsg)) {
			this.result.include("usrNameMsg", usrNameMsg);
		}
		if (!GeneralUtils.isEmpty(nameMsg)) {
			this.result.include("nameMsg", nameMsg);
		}
		if (!GeneralUtils.isEmpty(emailMsg)) {
			this.result.include("emailMsg", emailMsg);
		}
		if (!GeneralUtils.isEmpty(usrTypeMsg)) {
			this.result.include("usrTypeMsg", usrTypeMsg);
		}
		if (!GeneralUtils.isEmpty(passMsg)) {
			this.result.include("passMsg", passMsg);
		}
		if (!GeneralUtils.isEmpty(rePassMsg)) {
			this.result.include("rePassMsg", rePassMsg);
		}
		if (!GeneralUtils.isEmpty(inputVal)) {
			this.result.include("inputVal", inputVal);
		}
		if (this.userSession.getUser().getUserType().equals("ADMIN")) {
			this.result.include("usrProfURL", "/users/cgae/profile");
		}else {
			this.result.include("usrProfURL", "/users/" + 
					this.userSession.getUser().getUserType() + "/profile");
		}
	}
	//
	@Post(value="/users/register")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void doRegister(String username, String name, 
			String email, String userType, String password, 
			String rePassword) {
		
		List<String> classes = new ArrayList<String>();
		List<String> inputs = new ArrayList<String>();
		if ((username == null) || (name == null) || (email == null)
				|| (userType == null) || (password == null)
				|| (rePassword == null)) {
			
			
			List<String> values = Arrays.asList(username, name, 
					email, userType, password, rePassword);
			int i = 0;
			for(String x : values) {
				if (x == null) {
					if (i == 3) {
						classes.add("red-text");
					} else {
						classes.add("invalid");
					}
				} else {
					classes.add("");
				}
				i += 1;
				inputs.add(x);
			}
			if (classes.contains("invalid")) {
				this.result.redirectTo(this).register("Os campos devem ser preenchidos!",
					classes.get(0), classes.get(1), classes.get(2), classes.get(3),
					classes.get(4), classes.get(5), inputs);
			}
		}
		
		if (password.equals(rePassword)) {
			this.bs.registerNewUser(username, name, email, userType, password);
			this.result.redirectTo(this).profileCGAE("");
		}else {
			this.result.redirectTo(this).register("As senhas não coincidem.", "", "", "", "", 
					"invalid", "invalid", inputs);
		}
	}
	
	//PERFIL CGAE
	@Get(value="/users/cgae/profile")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void profileCGAE(String filter) {
		if (!GeneralUtils.isEmpty(filter)) {
			this.result.include("filter", filter);
		}
		this.result.include("usrProfURL", "/users/cgae/profile");
	}
	//
	@Post(value="/users/cgae/profile")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void logoutCGAE() {
		this.userSession.logout();
		this.result.redirectTo(this).login("", "", "");
	}
	
	//PERFIL GUARITA
	@Get(value="/users/guarita/profile")
	@NoCache
	@Permission(UserRoles.NORMAL)
	public void profileGuarita(String filter) {
		if (!GeneralUtils.isEmpty(filter)) {
			this.result.include("filter", filter);
		}
		this.result.include("usrProfURL", "/users/guarita/profile");
	}
	//
	@Post(value="/users/guarita/profile")
	@NoCache
	@Permission(UserRoles.NORMAL)
	public void logoutGuarita() {
		this.userSession.logout();
		this.result.redirectTo(this).login("", "", "");
	}
	
	//CONTROLE DE USUARIOS
	@Get(value="/users/control")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void userList(String filter) {
		List<User> users = this.bs.listAllUsers(filter);
		this.result.include("users", users);
		this.result.include("filter", filter);
		if (this.userSession.getUser().getUserType().equals("ADMIN")) {
			this.result.include("usrProfURL", "/users/cgae/profile");
		}else {
			this.result.include("usrProfURL", "/users/" + 
					this.userSession.getUser().getUserType() + "/profile");
		}
	}
	//
	@Post(value="/users/control")
	@NoCache
	@Permission(UserRoles.ADMIN)
	public void userDelete(Long id) {
		
		User user = this.bs.exists(id, User.class);
		this.bs.deleteUser(user);	
		this.result.redirectTo(this).userList("");
	}
	
	//ALTERAR DADOS
	@Get(value="/users/change-data")
	@NoCache
	@Permission(UserRoles.NORMAL)
	public void changeData(String errorMsg, String newNameMsg, 
			String newEmailMsg, String oldPassMsg, String newPassMsg, 
			String rePassMsg, List<String> inputVal) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
		if (!GeneralUtils.isEmpty(newNameMsg)) {
			this.result.include("newNameMsg", newNameMsg);
		}
		if (!GeneralUtils.isEmpty(newEmailMsg)) {
			this.result.include("newEmailMsg", newEmailMsg);
		}
		if (!GeneralUtils.isEmpty(oldPassMsg)) {
			this.result.include("oldPassMsg", oldPassMsg);
		}
		if (!GeneralUtils.isEmpty(newPassMsg)) {
			this.result.include("newPassMsg", newPassMsg);
		}
		if (!GeneralUtils.isEmpty(rePassMsg)) {
			this.result.include("rePassMsg", rePassMsg);
		}
		if (!GeneralUtils.isEmpty(inputVal)) {
			this.result.include("inputVal", inputVal);
		}
		this.result.include("user", this.userSession.getUser());
		if (this.userSession.getUser().getUserType().equals("ADMIN")) {
			this.result.include("usrProfURL", "/users/cgae/profile");
		}else {
			this.result.include("usrProfURL", "/users/" + 
					this.userSession.getUser().getUserType() + "/profile");
		}
	}
	//
	@Post(value="/users/change-data")
	@NoCache
	@Permission(UserRoles.NORMAL)
	public void selfUpdateUser(String newName,
			String newEmail, String password, String newPassword, 
			String rePassword) {
		
		List<String> values = Arrays.asList(newName, newEmail, 
				password, newPassword, rePassword);
		List<String> classes = new ArrayList<String>();
		List<String> inputs = new ArrayList<String>();
		for(String x : values) {
			if (x == null) {
				classes.add("invalid");
			} else {
				classes.add("");
			}
			inputs.add(x);
		}
		if (classes.contains("invalid")) {
			this.result.redirectTo(this).changeData("Os campos devem ser preenchidos!",
					classes.get(0), classes.get(1), classes.get(2), classes.get(3),
					classes.get(4), inputs);
		} else {
			User user = this.bs.exists(this.userSession.getUser().getId(), User.class);
			
			if (user.getPassword().equals(CryptManager.passwordHash(password))) {
				if (newPassword.equals(rePassword)) {					
					this.bs.updateUser(user, newName, newEmail, newPassword);
					this.result.redirectTo(this).userList("");
				} else {
					this.result.redirectTo(this).changeData("As senhas não coincidem!", "", "", "", 
							"invalid", "invalid", inputs);
				}
			} else {
				this.result.redirectTo(this).changeData("Senha incorreta!", "", "", "invalid", "", "", inputs);
			}
		}
	}
	
	//EDITAR USUARIO
	@Get(value="/users/{id}/edit")
	@NoCache
	@Permission(UserRoles.SYS_ADMIN)
	public void userEdit(Long id, String errorMsg, String newNameMsg, 
			String newEmailMsg, String oldPassMsg, String newPassMsg, 
			String rePassMsg, List<String> inputVal) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
		if (!GeneralUtils.isEmpty(newNameMsg)) {
			this.result.include("newNameMsg", newNameMsg);
		}
		if (!GeneralUtils.isEmpty(newEmailMsg)) {
			this.result.include("newEmailMsg", newEmailMsg);
		}
		if (!GeneralUtils.isEmpty(oldPassMsg)) {
			this.result.include("oldPassMsg", oldPassMsg);
		}
		if (!GeneralUtils.isEmpty(newPassMsg)) {
			this.result.include("newPassMsg", newPassMsg);
		}
		if (!GeneralUtils.isEmpty(rePassMsg)) {
			this.result.include("rePassMsg", rePassMsg);
		}
		if (!GeneralUtils.isEmpty(inputVal)) {
			this.result.include("inputVal", inputVal);
		}
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
		if (this.userSession.getUser().getUserType().equals("ADMIN")) {
			this.result.include("usrProfURL", "/users/cgae/profile");
		}else {
			this.result.include("usrProfURL", "/users/" + 
					this.userSession.getUser().getUserType() + "/profile");
		}
	}
	//
	@Post(value="/users/{id}/edit")
	@NoCache
	@Permission(UserRoles.SYS_ADMIN)
	public void updateUser(Long id, String newName,
			String newEmail, String password, String newPassword, 
			String rePassword) {
		
		List<String> values = Arrays.asList(newName, newEmail, 
				password, newPassword, rePassword);
		List<String> classes = new ArrayList<String>();
		List<String> inputs = new ArrayList<String>();
		for(String x : values) {
			if (x == null) {
				classes.add("invalid");
			} else {
				classes.add("");
			}
			inputs.add(x);
		}
		if (classes.contains("invalid")) {
			this.result.redirectTo(this).userEdit(id, "Os campos devem ser preenchidos!",
					classes.get(0), classes.get(1), classes.get(2), classes.get(3),
					classes.get(4), inputs);
		}
		
		User user = this.bs.exists(id, User.class);
		
		if (user.getPassword().equals(CryptManager.passwordHash(password))) {
			if (newPassword.equals(rePassword)) {		
				this.bs.updateUser(user, newName, newEmail, newPassword);
				this.result.redirectTo(this).userList("");
			} else {
				this.result.redirectTo(this).userEdit(id, "As senhas não coincidem!", "", "", "", 
						"invalid", "invalid", inputs);
			}
		} else {
			this.result.redirectTo(this).userEdit(id, "Senha incorreta!", "", "", "invalid", "", "", inputs);
		}
	}
	
	//RECUPERAR SENHA
	@Get(value="/users/recover-password")
	@NoCache
	public void recoverPassword(String errorMsg, String usrNameMsg, String emailMsg) {
		if (!GeneralUtils.isEmpty(errorMsg)) {
			this.result.include("errorMsg", errorMsg);
		}
		if (!GeneralUtils.isEmpty(usrNameMsg)) {
			this.result.include("usrNameMsg", usrNameMsg);
		}
		if (!GeneralUtils.isEmpty(emailMsg)) {
			this.result.include("emailMsg", emailMsg);
		}
	}
	
	@Post(value="/users/recover-password")
	@NoCache
	public void recoverUserPass(String username, String email) {
		List<String> values = Arrays.asList(username, email);
		List<String> classes = new ArrayList<String>();
		for(String x : values) {
			if (x == null) {
				classes.add("invalid");
			} else {
				classes.add("");
			}
		}
		if (classes.contains("invalid")) {
			this.result.redirectTo(this).recoverPassword("Os campos devem ser preenchidos!",
					classes.get(0), classes.get(1));
		} else {
			User user = this.bs.checkUsername(username);
			if (user == null) {
				this.result.redirectTo(this).recoverPassword("Nome de usuário incorreto!",
						"invalid", "");
			} else {
				if (user.getEmail().equals(email)) {
					this.bs.recoverPassword(username, email);
					this.result.redirectTo(this).login("", "", "");
				}
				else {
					this.result.redirectTo(this).recoverPassword("E-mail não corresponde ao usuário solicitado!",
							"", "invalid");
				}
			}
		}
	}
}
