package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;





public class RelativeLocatorDemo {

	public static void main(String[] args) {
		
		/*
		 * 
		 * 
		 * Relative locator dont seem to work correct as expected
		 * 
		 * 
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
//			WebElement field = driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input"));
			WebElement passLabel = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[6]/label"));
			WebElement field = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(passLabel));
			System.out.println(field);
			field.sendKeys("jebaJebajeba");
			System.out.println(field.getAttribute("type"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
