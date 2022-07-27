package utilities;

import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListener implements ITestListener,ISuiteListener {
	
	
	public static ExtentTest test;
	public static Date d = new Date();
    public static String fileName = "Extent_" + d.toString().replace(":","-").replace(" ", "_") + ".html";
    public static ExtentReports report = ExtentManager.createReportInstance("./reports/" + fileName);
	

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}
	
    @Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		// kjkjkjj
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getTestClass().getName() + "@case:" + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String m = "<b>" + "Test case : " + result.getMethod().getMethodName().toUpperCase() + " Passed</b>";
		Markup label = MarkupHelper.createLabel(m, ExtentColor.GREEN);
		test.pass(label);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String m = "<b>" + "Test case : " + result.getMethod().getMethodName().toUpperCase() + " Failed</b>";
		Markup label = MarkupHelper.createLabel(m, ExtentColor.RED);
		test.fail(label);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String m = "<b>" + "Test case : " + result.getMethod().getMethodName().toUpperCase() + " Skipped</b>";
		Markup label = MarkupHelper.createLabel(m, ExtentColor.AMBER);
		test.skip(label);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		if (report != null) {

			report.flush();
		}
	}

}
