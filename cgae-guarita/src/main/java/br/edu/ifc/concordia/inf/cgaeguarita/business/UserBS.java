package br.edu.ifc.concordia.inf.cgaeguarita.business;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

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
	
	//REGISTRA NOVO USUÁRIO
	public void registerNewUser(String username, String name, String email, 
			String userType, String password) {
		
		Criteria criteria = this.dao.newCriteria(User.class);
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
			
			this.dao.persist(user);
			
		}else {
			
		}
	}
	
	//ATUALIZA USUARIO
	public void updateUser(User user, String newName, String newEmail, String newPassword) {
		user.setName(newName);
		user.setEmail(newEmail);
		if (newPassword != null) {
			user.setPassword(CryptManager.passwordHash(newPassword));
		}
		
		this.dao.update(user);
	}
	
	//DELETA USUÁRIO
	public void deleteUser(User user) {
		this.dao.delete(user);
	}
	
	//VERIFICA USERNAME
	public User checkUsername(String username) {
		Criteria criteria = this.dao.newCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		
		return (User) criteria.uniqueResult();
	}
	
	//GERA UMA STRING (SENHA) ALEATÓRIA
	public String getRandomPassword(int length) {
		final String alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		String randomPassword = "";
		Random random = new Random();
		while (randomPassword.length() < length) {
			int index = (int) (random.nextFloat() * alphanum.length());
			randomPassword += alphanum.charAt(index);
		}
		return randomPassword;
	}
	
	//MUDA A SENHA DE USUÁRIO
	private void changePassword(User user, String newPassword) {
		user.setPassword(newPassword);
		this.dao.update(user);
	}
	
	//RECUPERA SENHA
	public void recoverPassword(String username, String email) {
		Criteria criteria = this.dao.newCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();
		 
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
			
			String newPassword = this.getRandomPassword(7);
			msg.setSubject("Recuperação de Senha");
			msg.setText("Você requisitou uma nova senha para o usuário "
					+ "\"" + username + "\". Sua nova senha será: " + newPassword);

			this.changePassword(user, newPassword);
			
			Transport t = session.getTransport("smtp");   
			t.connect("smtp.gmail.com", "cgaeguarita@gmail.com", "hodiernamente");
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();
			
		} catch(Exception exc) {
		  exc.printStackTrace();
		}
	}
}
