package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports createReportInstance(String fileName) {
		try {
			
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setDocumentTitle("Automation Test report");
			htmlReporter.config().setReportName("Login and Registration");
			htmlReporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		
		} catch (Exception e) {
			System.out.println("Error Creating html reporter");
		}
		return extent;
	}

}
