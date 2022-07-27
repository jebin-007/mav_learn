package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WallethubLoginExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://efdevhub.info/join/login");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10) );
			
			
			
			WebElement email = driver.findElement(By.id("email"));
			
			email.sendKeys("enhanceusr920@evolutionfinance.com");
			System.out.println(email.getText());
			WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			pass.sendKeys("Abcd123*");
		
			
	
//			if(wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"password\"]")))) {
//				System.out.println("Element was selected");
//			}else {
//				System.out.println("Element was not selected in the wait period");
//			}
			
				
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
