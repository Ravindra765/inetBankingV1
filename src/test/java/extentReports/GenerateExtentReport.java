package extentReports;

import java.io.File;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

//Extent Report change avenetstack not support by reveent code so if want just download pom for externt for selenim revelnt code 
/*public class GenerateExtentReport {
ExtentReports  extent;
ExtentTest test;
@BeforeTest
public void startReport() {
extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportResults.html",true);
extent.addSystemInfo("Host Name","LocalHost");
extent.addSystemInfo("Environment","QA");
extent.addSystemInfo("User Name", "Ravi");
extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
}
@Test
public void demoReportPass() {
	test=extent.startTest("demoReportPass");
	Assert.assertTrue(true);
	test.log(LogStatus.PASS, "Assert Pass as condtion is True");
}

@Test
public void demoReportFail() {
	test=extent.startTest("demoReportPass");
	Assert.assertTrue(false);
	test.log(LogStatus.FAIL, "Assert Pass as condtion is False");
}
@AfterMethod
public void getResult(ITestResult result) {
if(result.getStatus()==ITestResult.FAILURE)	{
	test.log(LogStatus.FAIL, result.getThrowable());
}
extent.endTest(test);
}
@AfterTest
public void endreport() {
	extent.flush();	
}
}*/
