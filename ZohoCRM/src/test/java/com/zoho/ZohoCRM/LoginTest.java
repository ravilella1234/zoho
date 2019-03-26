package com.zoho.ZohoCRM;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.zoho.ZohoCRM.excelAPIs.ExcelAPI;
import com.zoho.ZohoCRM.util.DataUtil;

public class LoginTest extends BaseTest
{
	public String runnableSheet="TestCases";
	public String sheetName="Data";
	public String testCaseName="LoginTest";
	PageAppFunctions page;
	SoftAssert softAssert;
	ExcelAPI xls;
	
	@DataProvider
	  public Object[][] getData() throws Exception 
	  {
		initialize("chromebrowser", "zohourl");
		xls=new ExcelAPI(config.getProperty("zohoxlspath"));
		  return DataUtil.getTextData(xls, testCaseName,sheetName);
	  } 
	
	
	  @Test(dataProvider="getData")
	  public void doLoginTest(Hashtable<String,String> data) throws Exception 
	  {
		  page =new PageAppFunctions();
		  test=rep.startTest("LoginTest");
		  test.log(LogStatus.INFO, data.toString());
		  
		  if(!DataUtil.isRunnable(runnableSheet,testCaseName, xls) || data.get("RunMode").equalsIgnoreCase("y"))
		  {
			  test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			  throw new SkipException("Skipping the test as runmode is N");
		  }
		 
		  boolean actualResult = PageAppFunctions.doLigin(data.get("userName"), data.get("password"));
		  
		  boolean expectedResult=false;
		  if(data.get("ExpectedResult").equalsIgnoreCase("Y"))
			  expectedResult=true;
		  else
			  expectedResult=false;
		  
		  if(expectedResult!=actualResult)
			  reportFailure("Login Test Failed ..!");
		  
		  reportPass("Login Test Passed...");
	  }
	}
