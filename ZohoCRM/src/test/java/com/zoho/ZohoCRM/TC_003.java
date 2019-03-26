package com.zoho.ZohoCRM;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zoho.ZohoCRM.BaseTest;
import com.zoho.ZohoCRM.excelAPIs.ExcelAPI;
import com.zoho.ZohoCRM.util.DataUtil;

public class TC_003 extends BaseTest
{
	String testCaseName="TestC";
	ExcelAPI  xls;
	
	@DataProvider
	  public Object[][] getData() throws Exception 
	  {
		initialize("chromebrowser", "quikrurl");
		xls=new ExcelAPI(config.getProperty("xlspath"));
		  return DataUtil.getTextData(xls, testCaseName);
	  } 
	
	
	@Test(dataProvider = "getData")
	public void f(Hashtable<String, String> data) 
	{
		if(!DataUtil.isRunnable(testCaseName, xls) || data.get("RunMode").equalsIgnoreCase("y"))
		{
			System.out.println(data.get("RunMode")+"-------"+data.get("col1")+"------"+data.get("col2"));
		}	
	}

  
}
