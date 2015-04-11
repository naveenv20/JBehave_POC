package com.sample.JBehavePOC.Steps;

import java.util.Hashtable;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;

import com.sample.JBehavePOC.Pages.Itemviewpage;
import com.sample.JBehavePOC.Pages.Landingpage;
import com.sample.JBehavePOC.Pages.Searchresultspage;
import com.sample.JBehavePOC.Utilities.TestUtil;
import com.sample.JBehavePOC.Utilities.Util;



public class Searchresults {
	Landingpage landingpage;
	Searchresultspage searchresultspage;
	Itemviewpage itemviewpage;
	public Searchresults() throws Exception{
		
	}
	
	
@Given("searchresults test is initialised")
public void searchresultsinit() throws Exception{
	try{
WebDriver d1=null;
	
	
	Hashtable<String,String> objdata=Util.getobjectdata("SearchResults", "Suite");
	landingpage= new Landingpage(d1,objdata);
	}catch(Exception e){
		class Local {};
	    String name = Local.class.getEnclosingMethod().getName();
		TestUtil.excepcleanup(e,name);
		throw e;
		
	}
}
	
	
	
@Then("the user logs into the system with the <username> and <password>")
	public void userlogin(@Named("username")String username,@Named("password")String password) throws Exception{
	try{
	landingpage.dologin(username, password);
	}catch(Exception e){
		class Local {};
	    String name = Local.class.getEnclosingMethod().getName();
		TestUtil.excepcleanup(e,name);
		throw e;
		
	}
}

@Then("user searhces for <searchvalue>")
public void searching(@Named("searchvalue")String searchvalue) throws Exception{
	try{
	searchresultspage=landingpage.searchresults(searchvalue);
	searchresultspage.getsearchresults();
	}catch(Exception e){
		class Local {};
	    String name = Local.class.getEnclosingMethod().getName();
		TestUtil.excepcleanup(e,name);
		throw e;
		
	}
}
	
@Then("selects an item from the search results")
public void selectthethirditem() throws Exception{
	try{
	itemviewpage=searchresultspage.selectaresult();
	}catch(Exception e){
		class Local {};
	    String name = Local.class.getEnclosingMethod().getName();
		TestUtil.excepcleanup(e,name);
		throw e;
		
	}
}

@Then("View the item")
public void viewtheittem() throws Exception{
	try{
	itemviewpage.getwatchname();
	}catch(Exception e){
		class Local {};
	    String name = Local.class.getEnclosingMethod().getName();
		TestUtil.excepcleanup(e,name);
		throw e;
		
	}
}






}
