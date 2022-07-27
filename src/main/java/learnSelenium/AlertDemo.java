package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			driver.findElement(By.cssSelector("input.signinbtn")).click();
			Alert alert = driver.switchTo().alert();
			Thread.sleep(3000);
			System.out.println("Alert message is : " + alert.getText());
			alert.accept();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
