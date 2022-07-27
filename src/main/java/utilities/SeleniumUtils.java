package utilities;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
	
	public static void captureScreenshot(WebDriver driver) {
		Date d = new Date();
		String filename = d.toString().replace(":","_").replace(" ","_") + ".jpg";
		try {
			
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./screenshots/" + filename));
		}catch (Exception e) {
			System.out.println("Error taking screenshot - " + filename);
		
	}

}}
