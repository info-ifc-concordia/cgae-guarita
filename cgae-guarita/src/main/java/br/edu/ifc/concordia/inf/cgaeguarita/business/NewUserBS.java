package br.edu.ifc.concordia.inf.cgaeguarita.business;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.boilerplate.HibernateBusiness;
import br.com.caelum.vraptor.boilerplate.util.CryptManager;
import br.edu.ifc.concordia.inf.cgaeguarita.model.User;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.UserRoles;

@RequestScoped
public class NewUserBS extends HibernateBusiness {

	public void registerNewUser(String username, String name,
			String email, String userType, String password) {
		
		Criteria criteria = this.dao.newCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();
		if (user == null) {
			user = new User();
			user.setUsername(username);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(CryptManager.passwordHash(password));
			if (userType == "CGAE") {
				user.setAccesso(UserRoles.ADMIN.getAccessLevel());
			}else {
				user.setAccesso(UserRoles.NORMAL.getAccessLevel());
			}
			dao.persist(user);
		}
	}
}
	

