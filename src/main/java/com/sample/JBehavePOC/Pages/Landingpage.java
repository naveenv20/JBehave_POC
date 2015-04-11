package com.sample.JBehavePOC.Pages;

import java.util.Hashtable;

import org.jbehave.core.annotations.Named;

import org.openqa.selenium.WebDriver;


import com.sample.JBehavePOC.Utilities.TestUtil;




public class Landingpage extends TestUtil {
	private WebDriver d1;
	private Hashtable<String,String> objdata;
	
	public Landingpage(WebDriver d1,Hashtable<String,String> objdata) {
		super(d1, objdata);
		this.d1=d1;
		this.objdata=objdata;
		APPLICATION_LOG.debug("4:     "+objdata.size());
		
	}

	
	public void dologin(String username,String password){
	click("login_link");
	type("login_email_Txtbx", username);
	type("password_Txtbx", password);
	click("login_button");
	try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public Searchresultspage searchresults(String searchwhat){
		type("searchbox", searchwhat);
		click("search_button");
		//keyboardaction("ENTER");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Searchresultspage();
		
	}
	
	
	public Customercarepage navigatetocustomercare(){
		click("Customercare_link");
		APPLICATION_LOG.debug("1:     "+objdata.size());
		return new Customercarepage();
		
	}


	public boolean isloogedinornot(){
		
			
		return false;
		
	}
	
	public void Openbrowser(String browser){
		openbrowser(browser);
	}
	

	public void navigatetourl(@Named("URL")String url){
		navigate(url);
	}
	

}
