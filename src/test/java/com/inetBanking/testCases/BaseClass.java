package com.inetBanking.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilites.ReadConfig;



public class BaseClass{
//public String baseURL="https://demo.guru99.com/v3/index.php";
//public String username="mngr347425";
//public String password="pAgemeb";
ReadConfig readconfig=new ReadConfig();
public String baseURL=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword();
public static WebDriver driver;
public static Logger logger;
@Parameters("browsers")
@BeforeClass
public void setUp(String br) {
	//System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
	
	
	 logger=Logger.getLogger("ebanking");
	 PropertyConfigurator.configure("Log4j.properties");
	 if(br.equals("chrome")) {
		 System.setProperty("webdriver.chrome.driver",readconfig.getChromePath() );
			driver=new ChromeDriver();
	 }
	 else if(br.equals("firefox")) {
		 System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath() );
			driver=new FirefoxDriver();
	 }
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get(baseURL);
}
@AfterClass
public void tearDown() {
	driver.quit();
}
public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
	
	
	
}
}
