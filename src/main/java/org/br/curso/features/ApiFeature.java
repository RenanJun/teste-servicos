package org.br.curso.features;

import static com.br.inmetrics.frm.bdd.Gherkin.given_;

import java.util.concurrent.ExecutionException;

import com.br.inmetrics.frm.bdd.Feature;
import com.br.inmetrics.frm.bdd.Scenario;

@Feature("ApiFeature")
public class ApiFeature {

	@SuppressWarnings("static-access")
	@Scenario("Obter um único usuario")
	public void obterUnicoUsuario() throws ExecutionException {
		
		given_("Dado que acessei a Api de obtenção de usuário")
		.when_("Quando Obter o usuário")
		.then_("Então o usuário deverá ser válido")
		.execute_();
		
	}
	

	@SuppressWarnings("static-access")
	@Scenario("Fazer login usuario")
	public void fazerLoginUsuario() throws ExecutionException{
		given_("Dado que acessei a Api de login do usuário")
		.when_("Quando fazer o login")
		.then_("Então o usuário deverá estar logado")
		.execute_();
		
	}
	
	@SuppressWarnings("static-access")
	@Scenario("Criar usuario")
	public void criarUsuario() throws ExecutionException{
		
		given_("Dado que acessei a Api de criação de usuário")
		.when_("Quando criar usuário")
		.then_("Então o usuário deverá ser criado com sucesso")
		.execute_();
		
	}
}
