package br.edu.ifc.concordia.inf.cgaeguarita.business;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;

import javax.enterprise.context.RequestScoped;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.boilerplate.HibernateBusiness;
import br.com.caelum.vraptor.boilerplate.HibernateDAO;
import br.com.caelum.vraptor.boilerplate.factory.SessionFactoryProducer;
import br.com.caelum.vraptor.boilerplate.factory.SessionManager;
import br.com.caelum.vraptor.boilerplate.util.CryptManager;
import br.edu.ifc.concordia.inf.cgaeguarita.factory.ApplicationSetup.DefaultTrustManager;
import br.edu.ifc.concordia.inf.cgaeguarita.model.User;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.UserRoles;
import br.edu.ifc.concordia.inf.cgaeguarita.properties.SystemConfigs;

@RequestScoped
public class UserBS extends HibernateBusiness {

	public User login(String username, String password) {
		Criteria criteria = this.dao.newCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password",
				CryptManager.passwordHash(password)));
		return (User) criteria.uniqueResult();
	}

	public void registerNewUser(SessionFactoryProducer factoryProducer, 
			String username, String name, String email, String userType, 
			String password) {
		
		factoryProducer.initialize("hibernate.cfg.xml");	
		
		CryptManager.updateKey(SystemConfigs.getConfig("crypt.key"));
		CryptManager.updateSalt("@2o!A", "70Px$");

		SessionManager mngr = new SessionManager(factoryProducer.getInstance());
		HibernateDAO dao = new HibernateDAO(mngr);
		
		Criteria criteria = dao.newCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();
		
		if (user == null) {
			user = new User();
			user.setUsername(username);
			user.setName(name);
			user.setEmail(email);
			if (userType != "CGAE") {
				user.setAccess(UserRoles.NORMAL.getAccessLevel());
			}else {
				user.setAccess(UserRoles.ADMIN.getAccessLevel());
			}
			user.setPassword(CryptManager.passwordHash(password));
			
			dao.persist(user);
			
			try {
				SSLContext ctx = SSLContext.getInstance("TLS");
				ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
				SSLContext.setDefault(ctx);
			} catch (GeneralSecurityException ex) {
				System.out.println("Não consegui sobrescrever o SSLContext.");
				ex.printStackTrace();
			}
			
			mngr.closeSession();
		}else {
			
		}
		
	}
	
}
