package learnSelenium;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.SeleniumUtils;

public class ScreenshotDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			driver.get("https://wallethub.com/free-credit-score");
			SeleniumUtils.captureScreenshot(driver);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		

	}

}
}