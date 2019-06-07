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
	
	@Step("Dado que acessei a Api de obten��o de usu�rio")
	public void dado_que_acessei_a_api_de_obtencao_do_usuario() {
	
		apiActions.setUri("https://reqres.in/");
	
	}
	
	@Step("Quando Obter o usu�rio")
	public void quando_obter_o_usuario() {
		
		apiActions.requisitarUsuario(2);
		
	}
	
	@Step("Ent�o o usu�rio dever� ser v�lido")
	public void entao_o_usuario_devera_ser_valido() {
		
		logger.info("Retorno do servi�o de obten��o do usu�rio [First_Name]" 
		+ apiActions.obterUsuario().getFirst_name());
		Assert.assertEquals(apiActions.obterUsuario().getFirst_name(), "Janet");
		
	}
	
	@Step("Dado que acessei a Api de login do usu�rio")
	public void dado_que_acessei_a_api_de_login_do_usuario() {
		
		apiActions.setUri("https://reqres.in/");
	
	}
	
	@Step("Quando fazer o login")
	public void quando_fazer_o_login() {
		
		apiActions.requisitarLogin("eve.holt@reqres.in", "cityslicka");
		
	}
	
	@Step("Ent�o o usu�rio dever� estar logado")
	public void entao_o_usuario_devera_estar_logado() {
		
		logger.info("Token retornado do servi�o de autentica��o [Token]" + apiActions.obterToken());
		Assert.assertTrue(apiActions.obterToken() != "");
		
	}
	
	@Step("Dado que acessei a Api de cria��o de usu�rio")
	public void dado_que_acessei_a_api_de_cria��o_do_usuario() {
		
		logger.debug("Acessando a API de cria��o do usuario.");
		apiActions.setUri("https://reqres.in/");
		
	}
	
	@Step("Quando criar usu�rio")
	public void quando_criar_o_login() {
		
		logger.debug("Criando o usu�rio.\n\n\n\n");
		apiActions.requisitarRegistro("Jo�o", "Mecanico");
		logger.debug("Usuario Criado.\n\n\n");
	}
	
	@Step("Ent�o o usu�rio dever� ser criado com sucesso")
	public void entao_o_usuario_devera_ser_criado_com_sucesso() {
	
		
		JsonPath jsonPath = apiActions.getResponse().jsonPath();
		String c = jsonPath.get("name");
		logger.debug("Usu�rio dever� ser criado com o nome " + c);
		Assert.assertTrue(jsonPath.get("name").equals("Jo�o"));
		
	}
	
}
