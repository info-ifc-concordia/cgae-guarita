package br.edu.ifc.concordia.inf.cgaeguarita.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.edu.ifc.concordia.inf.cgaeguarita.abstractions.AbstractController;

@Controller
public class PagesController extends AbstractController {
	
	
	@Get(value="/busca")
	@NoCache
	public void busca (){
		
	}
	
	@Get(value="/aluno")
	public void aluno(){
		
	}
	
	@Get(value="/cadastro")
	public void cadastro(){
		
	}
	
	@Get(value="/historico")
	public void historico(){
		
	}
	
	@Get(value="/observacoes")
	public void observacoes(){
		
	}
	
	
}
