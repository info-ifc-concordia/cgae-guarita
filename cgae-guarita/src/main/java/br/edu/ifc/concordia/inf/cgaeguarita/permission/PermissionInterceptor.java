package br.edu.ifc.concordia.inf.cgaeguarita.permission;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.boilerplate.interceptor.HeadersInterceptor;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.edu.ifc.concordia.inf.cgaeguarita.UserSession;
import br.edu.ifc.concordia.inf.cgaeguarita.controller.UserController;

@Intercepts(after=HeadersInterceptor.class)
@RequestScoped
@AcceptsWithAnnotations(Permission.class)
public class PermissionInterceptor {

	@Inject private UserSession userSession;
	@Inject private HttpServletResponse httpResponse;
	@Inject private Result result;
	@Inject private ControllerMethod method;
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		if (!this.userSession.isLogged()) {
			this.result.redirectTo(UserController.class).login("Você precisar fazer login para acessar esta página.");
		} else if (this.userSession.getUser().getAccesso() >= UserRoles.SYS_ADMIN.getAccessLevel()) {
			stack.next();
		} else {
			Permission perm = this.method.getMethod().getAnnotation(Permission.class);
			if (this.userSession.getUser().getAccesso() >= perm.value().getAccessLevel()) {
				stack.next();
			} else {
				this.httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				this.result.nothing();
			}
		}
	}
}
