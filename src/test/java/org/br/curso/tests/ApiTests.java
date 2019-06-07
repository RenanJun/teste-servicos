package org.br.curso.tests;

import static com.br.inmetrics.frm.bdd.Gherkin.executeScenario_;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.br.inmetrics.frm.base.TestBase;
import com.br.inmetrics.frm.controllers.EmptyController;
import com.br.inmetrics.frm.testng.TestConfig;

@TestConfig(controllerType=EmptyController.class)
public class ApiTests extends TestBase{

	public void testeObterUsuario() {
		
		try {
			
			executeScenario_("ApiFeature", "Obter um único usuario");
				
		} catch(Exception e) {
			
			Assert.fail("Error on test.", e);
			
		}
		
	}
	
	@Test(priority=2)
	public void testeLogin() {
		
		try {
			
			executeScenario_("ApiFeature", "Fazer login usuario");
			
			
		} catch (Exception e) {
			
			Assert.fail("Error on test.", e);
			
		}
		
		
	}
	
	@Test(priority=3)
	public void testeCriacaoUsuario() {
		
		try {
			
			executeScenario_("ApiFeature", "Criar usuario");
			
		} catch (Exception e) {
			
			Assert.fail("Error on test.", e);
			
		}
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup(final Method method, final ITestContext context) {
		
		super.setup(method, context);
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown(final Method method, final ITestContext context) {
		super.teardown(method, context);
	}
	
}
