package com.sample.JBehavePOC.Pages;


import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sample.JBehavePOC.Utilities.TestUtil;



public class Customercarepage extends TestUtil {
	
	
	
	
	public Customercarepage() {
		APPLICATION_LOG.debug("INSIDE THE Customer care page");
	}


	int i=0;
	
	
	
	
	public void selecttheissuetype(String issuetype_identifier,String issue_type){
		
		//System.out.println("HELLO NAVEEN"+TestUtil.objdata.size());
		
		APPLICATION_LOG.debug("2: "+objdata.size());
		
		List<WebElement> issuelist=findelements(issuetype_identifier);
		
		for(;i<issuelist.size();i++){
			if(issuelist.get(i).getText().equalsIgnoreCase(issue_type)){
				Actions act= new Actions(d1);
				act.moveToElement(issuelist.get(i)).build().perform();
				break;
			}
			
		}
		
	}
	
	
	public void selectthequestionnumber(String question_number) throws Exception{
		
		ifpromopopupexists("promo_pop_cancel");
		String questionlist_identifier=objdata.get("questionnumber_link_part1")+(i+1)+objdata.get("questionnumber_link_part2");
		APPLICATION_LOG.debug("Questionlist::::"+questionlist_identifier);
		List<WebElement> question_list=d1.findElements(By.xpath(questionlist_identifier));	
		Actions act= new Actions(d1);
	
		WebElement element=question_list.get(Integer.parseInt(question_number)-1);
		act.moveToElement(element).build().perform();
		act.click().build().perform();
		try {
			Thread.sleep(3000);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			APPLICATION_LOG.debug("Hello");
			APPLICATION_LOG.debug(e.toString());
			throw new Exception();
		}
	}


public String getquestion_text(String identifier){
APPLICATION_LOG.debug("QUESTION TEXT::::::::"+gettextofaelement(identifier));
String actual=gettextofaelement(identifier);
if(actual!=null)
return actual;
else
	return null;
}

}
