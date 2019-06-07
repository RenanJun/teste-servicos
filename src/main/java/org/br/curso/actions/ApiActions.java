package org.br.curso.actions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.util.HashMap;

import org.br.curso.steps.ApiSteps;
import org.testng.Assert;

import com.br.inmetrics.frm.helpers.LoggerHelper;
import com.br.inmetrics.frm.helpers.ThreadHelper;
import com.google.common.collect.ImmutableMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiActions {

	protected RequestSpecification request;
	protected Response response;
	private static HashMap<Long, ApiActions> instances;
	private static final Object objectLock = new Object();

	LoggerHelper logger = new LoggerHelper(ApiSteps.class);
	
	public ApiActions() {
		
		synchronized(objectLock) {
			
			long threadId = ThreadHelper.getThreadId();
			
			if(instances == null) 
				instances = new HashMap<Long, ApiActions>();		
			
			if(!instances.containsKey(threadId)) {
				instances.put(threadId, this);
			}
			
		}
	}
	
	public static synchronized ApiActions createOrInstance(){
	//	return null;
		
		long threadId = ThreadHelper.getThreadId();
		
		if(instances == null || instances.containsKey(threadId))
			new ApiActions();
		
		return instances.get(threadId);
	
	}
	
	public void setUri(String uri) {
		RestAssured.baseURI = uri;
	}
	
	public void requisitarUsuario(int idUsuario) {
		
		request = given();
		logger.info("REST Request: " + request.toString());
		
		response = request.get("api/users/" + idUsuario);
		logger.info("REST Response: " + response.asString());
		
	}
	
	public UsuarioPojo obterUsuario() {
		
		if(response != null)
			return response.getBody().jsonPath().getObject("data", UsuarioPojo.class);
		
		return null;
	}
	
	public void requisitarLogin(String email, String password) {
		
		try {
			
			request = given()
						.header("Accept", "")
						.contentType(ContentType.JSON.withCharset("UTF-8"))
						.body(ImmutableMap.builder().put("email", email)
													.put("password", password).build())
						.log().all();
			
			response = request
							.when()
							.post("api/login");
			
			response.then().assertThat().body(containsString("token"));
			
			logger.info("REST Response: " + response.asString());
			
		}catch (Exception e){
			Assert.fail("Error on rest", e);
		}
		
	}
	
	public String obterToken() {

		return response.getBody().path("token");
	}
	
	public void requisitarRegistro(String name, String job) {
		
		request = given()
				.header("Accept", "")
				.contentType(ContentType.JSON.withCharset("UTF-8"))
				.body(ImmutableMap.builder().put("name", name)
											.put("job", job).build())
				.log().all();
				
		logger.info("REST Request: " + request.toString());

		response = request
						.when()
						.post("api/users" );
		logger.info("REST Response: " + response.asString());
		
	}
	
	public Response getResponse() {
		return response;
	}

}