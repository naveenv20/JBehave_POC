package com.sample.JBehavePOC.Utilities;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;




public class Util {
		

	public static Hashtable<String, String> getobjectdata(String testcasename, String suitename){
		
		Xls_Reader xls_suite_testcase=new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\sample\\JBehavePOC\\TestData\\"+suitename+".xlsx");
		
		int rownum;
		
		for(rownum=0;rownum<xls_suite_testcase.getRowCount("ObjectData");rownum++){
			
			if(xls_suite_testcase.getCellData("ObjectData", 0, rownum).equalsIgnoreCase(testcasename)){
				System.out.println("Test case found   :"+testcasename);
				break;
			}
		}
		
		int objectstartrownum=rownum+2;
		int objectendrownum=objectstartrownum;
		int objectscount=0;
		
		while(!(xls_suite_testcase.getCellData("ObjectData", 0, objectendrownum).equalsIgnoreCase(""))){
			objectscount++;objectendrownum++;
		}
		
		Hashtable<String, String> objecthash=new Hashtable<String, String>();
		for(int rnum=objectstartrownum;rnum<objectendrownum;rnum++){
			objecthash.put(xls_suite_testcase.getCellData("ObjectData", 0, rnum), xls_suite_testcase.getCellData("ObjectData", 1, rnum));
		}
		
		
	System.out.println(objecthash);	
		return objecthash;
		
		
	}


}
