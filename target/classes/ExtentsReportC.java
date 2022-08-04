package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReportC {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
	    String path = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter es = new ExtentSparkReporter(path);
		es.config().setReportName("Test Execution");
		es.config().setDocumentTitle("Report");
		
		extent = new ExtentReports();
		extent.attachReporter(es);
		extent.setSystemInfo("Tester", "Sathish");
		return extent;
		
	}

}
