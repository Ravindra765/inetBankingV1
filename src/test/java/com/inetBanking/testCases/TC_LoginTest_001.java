package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
@Test
public void loginTest() throws IOException {
	
	logger.info("URL is Opened");
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("Enter user name");
	lp.setPassword(password);
	logger.info("Enter password");
	lp.clickSubmit();
	logger.info("Click on Sing in button");
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage123")) {
		Assert.assertTrue(true);
		//logger.info("Login Test passed");
	}
	else{
		captureScreen(driver,"loginTest");
		Assert.assertTrue(false);
		logger.info("Login Test failed");
	}
	
}
}
