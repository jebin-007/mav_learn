package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WallethubLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://efdevhub.info/join/login");
//			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20) );
			
			
			
			WebElement email = driver.findElement(By.id("email"));
			
			email.sendKeys("enhanceusr920@evolutionfinance.com");
			System.out.println(email.getText());
			WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			pass.sendKeys("Abcd123*");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-login\"]/form/div[4]/button[2]"))).click();			
//			WebElement login = driver.findElement(By.xpath("//*[@id=\"join-login\"]/form/div[4]/button[2]"));
//			login.click();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
