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
import br.edu.ifc.concordia.inf.cgaeguarita.model.Student;
import br.edu.ifc.concordia.inf.cgaeguarita.properties.SystemConfigs;

@RequestScoped
public class StudentBS extends HibernateBusiness {
	
	//CADASTRA NOVO ALUNO
	public void registerNewStudent(SessionFactoryProducer factoryProducer,
			String registration, String name, String course, String grade) {
		
		factoryProducer.initialize("hibernate.cfg.xml");	
		
		CryptManager.updateKey(SystemConfigs.getConfig("crypt.key"));
		CryptManager.updateSalt("@2o!A", "70Px$");

		SessionManager mngr = new SessionManager(factoryProducer.getInstance());
		HibernateDAO dao = new HibernateDAO(mngr);
		
		Criteria criteria = dao.newCriteria(Student.class);
		criteria.add(Restrictions.eq("name", name));
		Student student = (Student) criteria.uniqueResult();
		
		if (student == null) {
			student = new Student();
			student.setRegistration(registration);
			student.setName(name);
			student.setCourse(course);
			student.setGrade(grade);
			
			dao.persist(student);
			
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