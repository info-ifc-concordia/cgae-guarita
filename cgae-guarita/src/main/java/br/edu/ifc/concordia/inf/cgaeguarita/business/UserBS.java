package br.edu.ifc.concordia.inf.cgaeguarita.business;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.boilerplate.HibernateBusiness;
import br.com.caelum.vraptor.boilerplate.HibernateDAO;
import br.com.caelum.vraptor.boilerplate.factory.SessionFactoryProducer;
import br.com.caelum.vraptor.boilerplate.factory.SessionManager;
import br.com.caelum.vraptor.boilerplate.util.CryptManager;
import br.com.caelum.vraptor.boilerplate.util.GeneralUtils;
import br.edu.ifc.concordia.inf.cgaeguarita.factory.ApplicationSetup.DefaultTrustManager;
import br.edu.ifc.concordia.inf.cgaeguarita.model.User;
import br.edu.ifc.concordia.inf.cgaeguarita.permission.UserRoles;
import br.edu.ifc.concordia.inf.cgaeguarita.properties.SystemConfigs;

@RequestScoped
public class UserBS extends HibernateBusiness {
	
	//LOGIN
	public User login(String username, String password) {
		Criteria criteria = this.dao.newCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password",
				CryptManager.passwordHash(password)));
		return (User) criteria.uniqueResult();
	}
	
	//LISTA USUÁRIOS
	public List<User> listAllUsers(String filter) {
		Criteria criteria = this.dao.newCriteria(User.class);
		if (!GeneralUtils.isEmpty(filter)) {
			criteria.add(Restrictions.ilike("name", filter, MatchMode.ANYWHERE));
		}
		return this.dao.findByCriteria(criteria, User.class);
	}
	
	//VALIDA
	private void validate(SessionManager mngr) {
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
			SSLContext.setDefault(ctx);
		} catch (GeneralSecurityException ex) {
			System.out.println("Não consegui sobrescrever o SSLContext.");
			ex.printStackTrace();
		}
		
		mngr.closeSession();
	}
	
	//REGISTRA NOVO USUÁRIO
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
			if (Integer.parseInt(userType) == 3) {
				user.setAccess(UserRoles.NORMAL.getAccessLevel());
				user.setUserType("Guarita");
			}else if (Integer.parseInt(userType) == 5){
				user.setAccess(UserRoles.ADMIN.getAccessLevel());
				user.setUserType("CGAE");
			}
			user.setPassword(CryptManager.passwordHash(password));
			
			dao.persist(user);
			
			this.validate(mngr);
			
		}else {
			
		}
	}
	
	//ATUALIZA USUARIO
	public void updateUser(SessionFactoryProducer factoryProducer, 
			User user, String newName, String newEmail, String newPassword) {
			
		factoryProducer.initialize("hibernate.cfg.xml");	
		
		CryptManager.updateKey(SystemConfigs.getConfig("crypt.key"));
		CryptManager.updateSalt("@2o!A", "70Px$");

		SessionManager mngr = new SessionManager(factoryProducer.getInstance());
		HibernateDAO dao = new HibernateDAO(mngr);
		
		user.setName(newName);
		user.setEmail(newEmail);
		user.setPassword(CryptManager.passwordHash(newPassword));
		
		dao.update(user);
		
		this.validate(mngr);
	}
	
	//DELETA USUÁRIO
	public void deleteUser(SessionFactoryProducer factoryProducer, User user) {
		
		factoryProducer.initialize("hibernate.cfg.xml");	
		
		CryptManager.updateKey(SystemConfigs.getConfig("crypt.key"));
		CryptManager.updateSalt("@2o!A", "70Px$");

		SessionManager mngr = new SessionManager(factoryProducer.getInstance());
		HibernateDAO dao = new HibernateDAO(mngr);
		
		dao.delete(user);
		
		this.validate(mngr);
	}
	
	//VERIFICA USERNAME
	public User checkUsername(String username) {
		Criteria criteria = this.dao.newCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		
		return (User) criteria.uniqueResult();
	}
	
	//RECUPERA SENHA
	public void recoverPassword(String username, String email) {
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", "cgaeguarita");
		props.put("mail.smtp.password", "hodiernamente");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth","true");
		
		Session session = Session.getDefaultInstance(props);
		
		try {
			
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("cgaeguarita@gmail.com"));
			
			InternetAddress addressTo = new InternetAddress(email);
			msg.addRecipient(Message.RecipientType.TO, addressTo);

			msg.setSubject("Recuperação de Senha");
			msg.setText("Tua senha é: merda1234");

			Transport t = session.getTransport("smtp");   
			t.connect("smtp.gmail.com", "cgaeguarita@gmail.com", "hodiernamente");
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();
		} catch(Exception exc) {
		  exc.printStackTrace();
		}
	}
}
