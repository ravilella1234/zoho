package com.zoho.ZohoCRM.util;

import com.zoho.ZohoCRM.BaseTest;

public class TestUtil extends BaseTest
{
	public static void doLogin(String userName, String password) throws InterruptedException
	{
		if(isLoggedIn)
		{
			return;
		}
		click("signin_link_xpath");  
		type("username_signin_xpath", userName);
		type("password_signin_xpath", password);
		System.out.println(waitForElement("clickable", "submit_button_name", 30));
		click("submit_button_name");
		verifyElement("username_verify_xpath",userName);
	}

}
