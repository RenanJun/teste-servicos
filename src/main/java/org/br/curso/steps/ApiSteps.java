package org.br.curso.steps;

import org.br.curso.actions.ApiActions;
import org.testng.Assert;

import com.br.inmetrics.frm.bdd.DesignSteps;
import com.br.inmetrics.frm.bdd.Step;
import com.br.inmetrics.frm.helpers.LoggerHelper;

import io.restassured.path.json.JsonPath;

@DesignSteps
public class ApiSteps {

	ApiActions apiActions = ApiActions.createOrInstance();
	LoggerHelper logger = new LoggerHelper(ApiSteps.class);
	
	@Step("Dado que acessei a Api de obtenção de usuário")
	public void dado_que_acessei_a_api_de_obtencao_do_usuario() {
	
		apiActions.setUri("https://reqres.in/");
	
	}
	
	@Step("Quando Obter o usuário")
	public void quando_obter_o_usuario() {
		
		apiActions.requisitarUsuario(2);
		
	}
	
	@Step("Então o usuário deverá ser válido")
	public void entao_o_usuario_devera_ser_valido() {
		
		logger.info("Retorno do serviço de obtenção do usuário [First_Name]" 
		+ apiActions.obterUsuario().getFirst_name());
		Assert.assertEquals(apiActions.obterUsuario().getFirst_name(), "Janet");
		
	}
	
	@Step("Dado que acessei a Api de login do usuário")
	public void dado_que_acessei_a_api_de_login_do_usuario() {
		
		apiActions.setUri("https://reqres.in/");
	
	}
	
	@Step("Quando fazer o login")
	public void quando_fazer_o_login() {
		
		apiActions.requisitarLogin("eve.holt@reqres.in", "cityslicka");
		
	}
	
	@Step("Então o usuário deverá estar logado")
	public void entao_o_usuario_devera_estar_logado() {
		
		logger.info("Token retornado do serviço de autenticação [Token]" + apiActions.obterToken());
		Assert.assertTrue(apiActions.obterToken() != "");
		
	}
	
	@Step("Dado que acessei a Api de criação de usuário")
	public void dado_que_acessei_a_api_de_criação_do_usuario() {
		
		logger.debug("Acessando a API de criação do usuario.");
		apiActions.setUri("https://reqres.in/");
		
	}
	
	@Step("Quando criar usuário")
	public void quando_criar_o_login() {
		
		logger.debug("Criando o usuário.\n\n\n\n");
		apiActions.requisitarRegistro("João", "Mecanico");
		logger.debug("Usuario Criado.\n\n\n");
	}
	
	@Step("Então o usuário deverá ser criado com sucesso")
	public void entao_o_usuario_devera_ser_criado_com_sucesso() {
	
		
		JsonPath jsonPath = apiActions.getResponse().jsonPath();
		String c = jsonPath.get("name");
		logger.debug("Usuário deverá ser criado com o nome " + c);
		Assert.assertTrue(jsonPath.get("name").equals("João"));
		
	}
	
}
