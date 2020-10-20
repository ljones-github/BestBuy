package Retail;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extents {
	
	private static ExtentReports er;
	private static String dynamicPath;
	
	public static ExtentReports ExtentReportInitialize(String methodName)
	{
		dynamicPath = System.getProperty("user.dir" + "\\Resources\\Report.html");
		ExtentSparkReporter esr = new ExtentSparkReporter(dynamicPath);
		esr.config().setDocumentTitle(methodName);
		esr.config().setReportName("LaRon Jones");
		
		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Believe", "In Yourself");
		return er;
		
	}

}
