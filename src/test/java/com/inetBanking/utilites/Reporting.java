package com.inetBanking.utilites;
// Listener class used to genrate extent reports 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public void onStart(ITestContext testContext) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		String repName="Test-Report-"+timeStamp+".html"; //report name
		htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName); //specify location
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/test-output/extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name","LocalHost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("User Name", "Ravi");
		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); //Title of Report
		htmlReporter.config().setReportName("Funcational Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of chart
		htmlReporter.config().setTheme(Theme.DARK);
			
	}
	public void onTestStart(ITestResult tr) {
		System.out.println("Test started");	
		}
		public void onTestSuccess(ITestResult tr) {
			logger=extent.createTest(tr.getName()); //Create new entiry in the report
			logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); //send pass information
		}
		public void onTestFailure(ITestResult tr) {
			logger=extent.createTest(tr.getName()); //Create new entiry in the report
			logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); //send fail information
			String screenshotPath=System.getProperty("user.dir")+"//Screenshots//"+tr.getName()+".png";
			File f=new File(screenshotPath);
			if(f.exists()) {
				try {
					logger.fail("Screen is below: "+ logger.addScreenCaptureFromPath(screenshotPath));
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		public void onTestSkipped(ITestResult tr) {
			logger=extent.createTest(tr.getName()); //Create new entiry in the report
			logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE)); //send skip information
		}
		public void onFinish(ITestContext testContext) {
			extent.flush();	
		}
	
}
