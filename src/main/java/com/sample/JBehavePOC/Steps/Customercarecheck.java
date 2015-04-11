package com.sample.JBehavePOC.Steps;

import java.util.Hashtable;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;

import com.sample.JBehavePOC.Pages.Customercarepage;
import com.sample.JBehavePOC.Pages.Landingpage;
import com.sample.JBehavePOC.Utilities.TestUtil;
import com.sample.JBehavePOC.Utilities.Util;



public class Customercarecheck  {

	Customercarepage customercarepage;
	Landingpage landingpage;
	public Customercarecheck() throws Exception{

}

	
	@Given("customercarecheck test is initialised")
	public void customercarecheckinit() throws Exception{
		
		try{
			System.out.println("customercarecheck");
			WebDriver d1=null;
			Hashtable<String,String> objdata=Util.getobjectdata("Customercaretest", "Suite");
			landingpage= new Landingpage(d1,objdata);
		}
		catch(Exception e){
			class Local {};
		    String name = Local.class.getEnclosingMethod().getName();
			TestUtil.excepcleanup(e,name);
			throw e;
			
		}
		
		
	}
	
	@Then("user clicks on the customercare link")
	public void userclickcustomercarelink() throws Exception{
		try{
		customercarepage=landingpage.navigatetocustomercare();
		}catch(Exception e){
			class Local {};
		    String name = Local.class.getEnclosingMethod().getName();
			TestUtil.excepcleanup(e,name);
			throw e;
			
		}
	}
	
	
	@Then("user select the case as <case_type>")
	public void userselectscasetype(@Named("case_type")String case_type) throws Exception{
		try{
			
		
		customercarepage.selecttheissuetype("issuetype_links", case_type);
		
		}catch(Exception e){
			class Local {};
		    String name = Local.class.getEnclosingMethod().getName();
			TestUtil.excepcleanup(e,name);
			throw e;
			
		}
		
		}
	
	@Then("user selects the <question_number> and checks the question text as <Question_text>")
	public void userselectsquestionum(@Named("question_number")String question_number,@Named("Question_text")String Question_text) throws Exception{
		try{
			
		customercarepage.selectthequestionnumber(question_number);
		String actual=customercarepage.getquestion_text("question_text");
		String Expected=Question_text;
		
		Assert.assertTrue("Expected Question not popped up", actual.equalsIgnoreCase(Expected));
		
		}catch(Exception e){
			class Local {};
		    String name = Local.class.getEnclosingMethod().getName();
			TestUtil.excepcleanup(e,name);
			throw e;
			
		}
	}
	
		
	

	
}


