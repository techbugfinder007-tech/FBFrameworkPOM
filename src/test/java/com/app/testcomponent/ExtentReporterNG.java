package com.app.testcomponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	//configure meta data of a report 
	public static ExtentReports getExtentReport() {
		
		String path = System.getProperty("user.dir")+"//reports//extentReport//index.html";
		
		//This is class responsible to generate html report 
		//It Handle UI part of report.
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("FBAutomation Report");
		reporter.config().setDocumentTitle("Test Result");
		
		//This class is responsible for handling Backend of extent report
		//it will create a report and attach the report ExtentSparkReporter
		//It controls the test logging .
		//it stores the test execution data
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "NameOfTester");
		return extent;
	}

}
