package learnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintCheckboxNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver  = new EdgeDriver();
		driver.manage().window().maximize();
		try {
			driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
			
			
			List<WebElement> checkboxes = driver.findElements(By.xpath("//div[4]/input"));
			
			for(WebElement element:checkboxes) {
				System.out.println("Name = " + element.getAttribute("name") + " -- Value = " + element.getAttribute("value") );
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
