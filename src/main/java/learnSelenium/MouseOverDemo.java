package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		WebDriverManager.edgedriver().setup();
		try {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.way2automation.com/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
			
			WebElement allCourseMenu = driver.findElement(By.xpath("//*[@id=\"menu-item-27580\"]"));
			WebElement appiumMenu = driver.findElement(By.xpath("//*[@id=\"menu-item-27585\"]"));
			WebElement pythonElement = driver.findElement(By.xpath("//*[@id=\"menu-item-27587\"]"));
			Actions mouseHover = new Actions(driver);
			
			/*
			 * Firexfox driver code
			 * 
			 * 
			 * mouseHover.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(allCourseMenu))).build().perform();
			 * System.out.println("All course success");
			Thread.sleep(2000);
			mouseHover.moveToElement(wait2.until(ExpectedConditions.elementToBeClickable(appiumMenu))).build().perform();
			System.out.println("Appium menu success");
			Thread.sleep(2000);
			mouseHover.moveToElement(wait3.until(ExpectedConditions.elementToBeClickable(pythonElement))).click().build().perform();
			System.out.println("python menu success");
			Thread.sleep(2000);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			
			
				
		mouseHover.moveToElement(allCourseMenu).moveToElement(appiumMenu).moveToElement(pythonElement).click().build().perform();
			

//			driver.findElement(By.xpath("//*[@id=\"menu-item-27587\"]/a")).click();
//			driver.findElement(By.xpath("//*[@id=\"cc-list-menu\"]/li[3]/a")).click();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
