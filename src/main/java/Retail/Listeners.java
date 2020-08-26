package Retail;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends TestBase implements ITestListener{

	private static ThreadLocal<ExtentTest>tl = new ThreadLocal<ExtentTest>();
	private static ExtentReports localized = new ExtentReports();
	private WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		localized = Extents.ExtentReportInitialize(result.getName());
		
		ExtentTest et = localized.createTest(result.getName());
		tl.set(et);
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		
		TestBase tb = new Listeners();
		String myScreenshot = "";
		
		try 
		{
			// Don't need to remember this verbatim but this would show some in-depth knowledge
			//driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			Class clazz = result.getTestClass().getRealClass();
			Field field = clazz.getDeclaredField("driver");
			field.setAccessible(true);

			driver = (WebDriver)field.get(result.getInstance());
		} 		
		catch (Exception e)
		{
			System.out.println("Issue retrieving driver from test " + result.getName() + "\tDesc: " + e);
		}
		
		
		try
		{
			myScreenshot = tb.TakeAFULLScreenshot(result.getName(), driver);
		}
		catch(Exception e)
		{
			System.out.println("Errors taking screenshot for test: " + result.getName() + "Error Desc: " + e);
		}
		
		System.out.println("Test Passed Successfully");
		
		try
		{
			tl.get().addScreenCaptureFromPath(myScreenshot);
		}
		catch(Exception e)
		{
			System.out.println("Error attaching screenshot from path: " + myScreenshot + "\tDesc: " + e);
		}
		//tl.get().addScreenCaptureFromPath(tb.TakeAFULLScreenshot(context.getName(), driver));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
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
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);

		localized.flush();
	}

}
