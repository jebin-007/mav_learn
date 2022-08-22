package learnSelenium;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utilities.SeleniumUtils;

public class ScreenshotDemo {
	
	static WebDriver driver;
	static String fileName;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			driver.get("https://wallethub.com/free-credit-score");
			fileName = new Date().toString().replace(",", "_").replace(":", "_").replace(" ","_");
			getScreenshot();
			fullScreenshot();
			
		}catch (Exception e) {
			e.printStackTrace();
		

	    }
		
 }
	
	public static void getScreenshot() throws IOException {
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshots//selenium_" + fileName + ".jpg"));
	}
	
	public static void fullScreenshot() throws IOException {
		Screenshot sh = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(sh.getImage(), "jpg",new File(".//screenshots//ashot_" + fileName + ".jpg"));
	}
	
	
}