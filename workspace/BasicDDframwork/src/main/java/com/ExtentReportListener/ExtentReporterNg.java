package com.ExtentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\Extent.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation");
		reporter.config().setDocumentTitle("test result");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Shital");
		return extent;
	}
}
