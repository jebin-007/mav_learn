package testngLearn;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo {
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	
	@BeforeTest
	void testStarts() {
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation test report");
		htmlReporter.config().setReportName("Ithaca Test results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tes Suite", "Ithaca Tests");
		extent.setSystemInfo("Company", "WalletHub");
		
	}
	
	@AfterTest
	void testEnds() {
		extent.flush();
	}
	
	@Test
	void doLogin() {
		test = extent.createTest("Login test");
		test.log(Status.INFO, "Reached login screen");
		test.log(Status.INFO, "Entered username - ashley@ef.com");
		test.log(Status.INFO, "Entered password - Abcd123*");
		test.log(Status.INFO, "Clicked on Submit");
		System.out.println("Login successful");	
		
	}
	
	@Test
	void skipTest() {
		test = extent.createTest("Skip Test");
		test.log(Status.INFO, "Reached Dashboard");
		throw new SkipException("Test skipped as Offers tab not found");
		
	}
		
	@Test
	void doRegistration() {
		test = extent.createTest("Do Registration");
		test.log(Status.INFO, "Reached Name screen");
		test.log(Status.INFO, "Entered First name");
		test.log(Status.INFO, "Entered Last Name");
		Assert.fail("Error clicking the button", new ElementNotInteractableException("Elememt not interactable"));
	}
	
	@AfterMethod
	void updateStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			Markup m = MarkupHelper.createLabel(result.getMethod().getMethodName().toUpperCase() + " - Success", ExtentColor.GREEN);
			test.pass(m);
		}else if(result.getStatus() == ITestResult.FAILURE) {
			Markup m = MarkupHelper.createLabel(result.getMethod().getMethodName().toUpperCase() + " -  Failed", ExtentColor.RED);
			test.fail(m);
			test.fail(result.getThrowable());
		
		}else if(result.getStatus() == ITestResult.SKIP) {
			Markup m = MarkupHelper.createLabel(result.getMethod().getMethodName().toUpperCase() + " -  Skipped", ExtentColor.GREY);
			test.skip(m);
		}
	}

}
