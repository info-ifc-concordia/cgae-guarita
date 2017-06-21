package br.edu.ifc.concordia.inf.cgaeguarita.business;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.boilerplate.HibernateBusiness;
import br.com.caelum.vraptor.boilerplate.util.CryptManager;
import br.edu.ifc.concordia.inf.cgaeguarita.model.User;

@RequestScoped
public class UserBS extends HibernateBusiness {

	public User login(String username, String password) {
		Criteria criteria = this.dao.newCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("senha",
				CryptManager.passwordHash(password)));
		return (User) criteria.uniqueResult();
	}
}
