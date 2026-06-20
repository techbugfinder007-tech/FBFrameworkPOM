package com.app.testcomponent;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest extentTest;
	ExtentReports extentReports = ExtentReporterNG.getExtentReport();
	ThreadLocal<ExtentTest> thExtent = new ThreadLocal<ExtentTest>();//Thread safe.
	
	
	@Override
	public void onTestStart(ITestResult result) {
		//this is a method which called before each test case
		System.out.println(result.getMethod().getMethodName()+"   onTestStart called ");
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
		thExtent.set(extentTest);//unique thread id -> (loginWithValidCredentials) test 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"   onTestSuccess called ");
		thExtent.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		thExtent.get().fail(result.getThrowable());
		//logging
		//screenshot
		WebDriver driver = null;
		String filePath =null;
		System.out.println(result.getMethod().getMethodName()+"   onTestFailure called ");
		try {
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 filePath =getScreenShot(result.getMethod().getMethodName(), driver);
			System.out.println(filePath);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//attaching the scrreenshot to extent report
		thExtent.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

	@Override
	protected void finalize() throws Throwable {
	}
	
	@Override
	public void onTestSkipped(ITestResult result) { }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {}

	@Override
	public void onStart(ITestContext context) {}
}