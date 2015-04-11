package com.sample.JBehavePOC.Steps;





import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import com.sample.JBehavePOC.Utilities.TestUtil;




public class Common_actions extends TestUtil  {


public Common_actions() {
	
	
}

	
	@BeforeStories
	public void bfstories(){
		System.out.println("*********BEFORE ALL STORIES***************");
	}
	
	@AfterStories
	public void afstories(){
		
		System.out.println("*********AFTER ALL STORIES***************");
	}
	
	@BeforeScenario
	public void  BeforeScenario(){
		System.out.println("****TEST SCENARIO BEGUINED*******");	
	
	}

	@AfterScenario
	public void afterscenario(){
		
		System.out.println("****TEST SCENARIO ENDED*******");	
		
	}

	@BeforeStory
	public void  BeforeStory(){
		System.out.println("****TEST STORY BEGUINED*******");	
		

	}
	
	
	@Given("The browser <browsertype> is opened")
	public void browseropen(@Named("browsertype") String browsertype) throws Exception{
		try{
		openbrowser(browsertype);
		}catch(Exception e){
			class Local {};
		    String name = Local.class.getEnclosingMethod().getName();
			excepcleanup(e,name);
			throw e;
			
		}
	}

	
	@Then("User opens the <URL>")
	public void navigatetourl(@Named("URL")String url) throws Exception{
		try{
			APPLICATION_LOG.debug("URL is Opened");
		navigate(url);
		}catch(Exception e){
			class Local {};
		    String name = Local.class.getEnclosingMethod().getName();
			excepcleanup(e,name);
			throw e;
			
		}

}

	
	@Then("user ends the test case and closed the browser")
	public void Teardown() throws Exception{
		try{
teardown();
	
		}catch(Exception e){
			class Local {};
		    String name = Local.class.getEnclosingMethod().getName();
			excepcleanup(e,name);
			throw e;
			
		}
}
	
}