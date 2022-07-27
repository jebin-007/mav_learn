package learnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectAllCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver  = new EdgeDriver();
		driver.manage().window().maximize();
		try {
			driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
			
			/*
			 * 
			 * Select two checkboxes
			 * 
			 * driver.findElement(By.xpath("//input[@value=\"football\"]")).click();
			   driver.findElement(By.xpath("//div[4]/input[4]")).click();
			 * 
			 * 
			 */
			
			/*
			 * 
			 * Select all checkboxes
			 * 
			 * 
			 */
			List<WebElement> checkboxes = driver.findElements(By.xpath("//div[4]/input"));
			
			for(WebElement element:checkboxes) {
				element.click();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
