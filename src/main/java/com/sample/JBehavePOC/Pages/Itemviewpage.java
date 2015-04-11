package com.sample.JBehavePOC.Pages;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import com.sample.JBehavePOC.Utilities.TestUtil;



public class Itemviewpage extends TestUtil  {
	
	
	
	public Itemviewpage(WebDriver d1, Hashtable<String, String> objdata){
		APPLICATION_LOG.debug("**********ITEMVIEW page***************");
	}
	
	
	public void getwatchname(){
		APPLICATION_LOG.debug("The Result is:::::"+gettextofaelement("Watch_View_Text"));
	}

}
