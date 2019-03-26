package com.zoho.ZohoCRM;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoho.ZohoCRM.util.TestUtil;

public class TC_001 extends  BaseTest
{
  
  @BeforeMethod
  public void startProcess() throws Exception 
  {
	  initialize("chromebrowser","quikrurl");
	  
  }
  
  @Test
  public void loginIn() throws Exception 
  {
	  TestUtil.doLogin("9676273760", "test1234");
  }

  @AfterMethod
  public void endProcess()
  {
	  
  }

}
