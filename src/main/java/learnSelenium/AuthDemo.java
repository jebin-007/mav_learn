package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			((HasAuthentication) driver ).register(UsernameAndPassword.of("admin","admin"));
			driver.get("https://the-internet.herokuapp.com/");
			Thread.sleep(1000);
			driver.findElement(By.linkText("Basic Auth")).click();
			Thread.sleep(1000);
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
