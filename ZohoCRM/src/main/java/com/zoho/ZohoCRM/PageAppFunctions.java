package com.zoho.ZohoCRM;

import com.relevantcodes.extentreports.LogStatus;

public class PageAppFunctions extends BaseTest
{
	public static boolean doLigin(String userName, String password) throws Exception
	{
		test.log(LogStatus.INFO, "Trying to login with "+ userName+ "," +password);
		click("zohologinlink_xpath");
		type("zohologinid_id", userName);
		type("zohopassword_id", password);
		click("zohosignbutton_id");
		if(isElementPresent("crmlink_xpath")) {
			test.log(LogStatus.INFO, "Login Success...");
			return true;
		}
		else
		{
			test.log(LogStatus.INFO, "Login Failed..!");
			return false;
		}
	}

}
