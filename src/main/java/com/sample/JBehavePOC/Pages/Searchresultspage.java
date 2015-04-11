package com.sample.JBehavePOC.Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sample.JBehavePOC.Utilities.TestUtil;


public class Searchresultspage extends TestUtil {
	
	
	List<WebElement> searchresultsonthepage;
	Itemviewpage itmvwpage;
	
	public Searchresultspage(){
		
		APPLICATION_LOG.debug("**********Searchresults page***************");
	}
	
	
	public void getsearchresults(){
		searchresultsonthepage=findelements("search_results");
		APPLICATION_LOG.debug("number of search results in the page:::"+searchresultsonthepage.size());
	}

	public Itemviewpage selectaresult(){
		APPLICATION_LOG.debug("*&*&*&*&&*(&"+searchresultsonthepage.get(2).getAttribute("alt"));
		searchresultsonthepage.get(2).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Itemviewpage(d1,objdata);
	}
	
	
}
