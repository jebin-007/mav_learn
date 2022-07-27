package learnSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver  = new EdgeDriver();
		driver.manage().window().maximize();
		try {
			driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
			
			
			List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
			
			
			for(WebElement element:checkboxes) {
//				System.out.println(element.getAttribute("checked"));
				if(element.getAttribute("checked")!=null) {
					System.out.println(element.getAttribute("checked"));
					continue;
				}
				element.click();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
