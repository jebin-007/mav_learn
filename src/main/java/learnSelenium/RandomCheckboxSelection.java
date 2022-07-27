package learnSelenium;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 
 * To randomly select two checkboxes in the site http://www.tizag.com/htmlT/htmlcheckboxes.php
 * 
 * 
 * 
 * 
 * 
 */


public class RandomCheckboxSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver  = new EdgeDriver();
		driver.manage().window().maximize();
		try {
			driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
			
			
			List<WebElement> checkboxes = driver.findElements(By.xpath("//div[4]/input"));
			Random rand = new Random();
			
			for(int i = 0;i<2;i++) {
				int index = rand.nextInt(checkboxes.size());
				WebElement element = checkboxes.get(index);
				element.click();
				checkboxes.remove(index);
			}
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
