package Listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Base.Base;
import com.Utility.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNg;

public class Listeners extends Base implements ITestListener{
	ExtentReports extent=ExtentReporterNg.getReportObject();
	public ExtentTest test;
	ThreadLocal<ExtentTest> tl=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		 test=extent.createTest(result.getMethod().getMethodName());
		 tl.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tl.get().log(Status.PASS,"test pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		tl.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testcaseName=result.getMethod().getMethodName();
		System.out.println(testcaseName);
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			
			e1.printStackTrace();
		}
		try {
			tl.get().addScreenCaptureFromPath(TestUtil.getScreenShot(testcaseName, driver), result.getMethod().getMethodName());
			//tl.get().addScreenCaptureFromPath(getScreenShot(testcaseName, driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
