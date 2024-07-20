package SK_selenium.resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject() {
		
		File file = new File(System.getProperty("user.dir")+"\\seleniumReports\\testResults.html");
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		
		reporter.config().setDocumentTitle("Selenium Frame Work Results");
		reporter.config().setReportName("Test Results");
		reporter.config().setTheme(Theme.STANDARD);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Runner", "Suresh Kumar");
		return extent;
	}

}
