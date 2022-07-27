package utilities;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;


public class WhActionReport extends WhActions {
	@Override
	public void click(WebDriver driver,String locator) {
		super.click(driver, locator);
		ExtentListener.test.log(Status.INFO, "Clicked on : " + locator);
	}
	
	@Override
	public void waitNclick(WebDriver driver,String locator, String waitTime) {
		super.waitNclick(driver, locator, waitTime);
		ExtentListener.test.log(Status.INFO, "Clicked on : " + locator);
	}
	
	@Override
	public void sendKeys(WebDriver driver,String locator, String keys) {
		super.sendKeys(driver, locator, keys);
		ExtentListener.test.log(Status.INFO, "Entered " + keys + " on field " + locator);
	}
	
	@Override
	public void waitNsendKeys(WebDriver driver,String locator, String keys, String waitTime) {
		super.waitNsendKeys(driver, locator, keys, waitTime);
		ExtentListener.test.log(Status.INFO, "Entered " + keys + " on field " + locator);
	}
	
	@Override
	public Actions moveTo(WebDriver driver, String locator) {
		Actions action =  super.moveTo(driver, locator);
		ExtentListener.test.log(Status.INFO, "Moving mouse to  " +  locator);
		return action;
	}
}
