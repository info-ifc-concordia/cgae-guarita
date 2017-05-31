package br.edu.ifc.concordia.inf.cgaeguarita.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

import br.com.caelum.vraptor.config.ApplicationConfiguration;
import br.edu.ifc.concordia.inf.cgaeguarita.properties.SystemConfigs;

@Specializes
@ApplicationScoped
public class ApplicationConfig extends ApplicationConfiguration {

	public static final String ENV = SystemConfigs.getConfig("sys.env");
	public static final String URL = SystemConfigs.getConfig("sys.baseurl");
	
	public static final boolean FEEDBACK_TO_EMAIL =
		"true".equals(SystemConfigs.getConfig("sys.feedback-to-email"))
		&& "production".equals(ENV)
	;
	public static final String FEEDBACK_EMAIL = SystemConfigs.getConfig("sys.feedback-email");
	
	public ApplicationConfig() {
		super(null);
	}
	
	@Override
	public String getApplicationPath() {
		return URL.replaceAll("/$", "");
	}

}
