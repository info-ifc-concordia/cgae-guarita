package br.edu.ifc.concordia.inf.cgaeguarita;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import br.edu.ifc.concordia.inf.cgaeguarita.model.User;

@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public boolean isLogged() {
		return this.user != null;
		
	}
	

}
