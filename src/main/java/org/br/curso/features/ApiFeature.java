package org.br.curso.features;

import static com.br.inmetrics.frm.bdd.Gherkin.given_;

import java.util.concurrent.ExecutionException;

import com.br.inmetrics.frm.bdd.Feature;
import com.br.inmetrics.frm.bdd.Scenario;

@Feature("ApiFeature")
public class ApiFeature {

	@SuppressWarnings("static-access")
	@Scenario("Obter um �nico usuario")
	public void obterUnicoUsuario() throws ExecutionException {
		
		given_("Dado que acessei a Api de obten��o de usu�rio")
		.when_("Quando Obter o usu�rio")
		.then_("Ent�o o usu�rio dever� ser v�lido")
		.execute_();
		
	}
	

	@SuppressWarnings("static-access")
	@Scenario("Fazer login usuario")
	public void fazerLoginUsuario() throws ExecutionException{
		given_("Dado que acessei a Api de login do usu�rio")
		.when_("Quando fazer o login")
		.then_("Ent�o o usu�rio dever� estar logado")
		.execute_();
		
	}
	
	@SuppressWarnings("static-access")
	@Scenario("Criar usuario")
	public void criarUsuario() throws ExecutionException{
		
		given_("Dado que acessei a Api de cria��o de usu�rio")
		.when_("Quando criar usu�rio")
		.then_("Ent�o o usu�rio dever� ser criado com sucesso")
		.execute_();
		
	}
}
