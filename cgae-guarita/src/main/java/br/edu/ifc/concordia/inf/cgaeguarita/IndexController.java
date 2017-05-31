package br.edu.ifc.concordia.inf.cgaeguarita;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.edu.ifc.concordia.inf.cgaeguarita.abstractions.AbstractController;

@Controller
public class IndexController extends AbstractController {
	
	
	@Path(value="/", priority=Path.HIGHEST)
	@NoCache
	public void index() {
		
	}
	
}
