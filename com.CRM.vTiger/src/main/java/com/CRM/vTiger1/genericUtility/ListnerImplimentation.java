package com.CRM.vTiger1.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentation implements ITestListener{
	
	ExtentTest test;
	ExtentReports reports;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----->"+"Test Script Execution Starts");
		
		//Start testscript Execution
		test=reports.createTest(methodName);
		
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----->"+"Test Script Execution Sucessful");
		test.log(Status.PASS, "Test Script Passed");
		
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----->"+"Test Script Execution Failed");
		
		test.log(Status.FAIL, "Test Script Failed");
		test.log(Status.INFO, result.getThrowable());	//To Throw Exceptions to report
		
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		String screenshotName = methodName+"-"+jUtil.modifiedDateTime();
		try {
			String path = wUtil.takeScreenShotsOfEntireWebPage(BaseClass.ldriver, screenshotName);
			test.addScreenCaptureFromPath(path);	// To Add ScreenShot to Report
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"----->"+"Test Script Skipped");
		test.log(Status.SKIP, "Test Script Skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite level execution Started");
		//Basic system configuration
		ExtentSparkReporter reporter=new ExtentSparkReporter("./ExtentReport\\report-"+new JavaUtility().modifiedDateTime()+".html");
		reporter.config().setDocumentTitle("Execution Report");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Vtiger Execution Report");
		
		//Report configuration
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("url", "http://localhost:8888/");
		reports.setSystemInfo("browserName", "chrome");
		reports.setSystemInfo("Platform", "window");
		reports.setSystemInfo("Reporter Name", "Soumyajit");
	}

	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite level execution Finished");
		//To generate reports and replace old report with new report.
		reports.flush();
	}
	
	
}
