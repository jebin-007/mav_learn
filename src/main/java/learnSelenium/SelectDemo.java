package learnSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
//			WebDriverManager.edgedriver().setup();
			System.out.println("Driver setup success!");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.wikipedia.org/");
			System.out.println("Site loaded");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			WebElement dropdownElem = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
			
			Select dropdown = new Select(dropdownElem);
			
			System.out.println("Total options = " + dropdown.getOptions().size());
			System.out.println("Option 2 = " + dropdown.getOptions().get(1));
			dropdown.selectByVisibleText("Français");
			Thread.sleep(5000);
			dropdown.selectByValue("bn");
//			driver.quit();
			
			
			
			WebElement footerRightSection = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
			
			List<WebElement> links = footerRightSection.findElements(By.tagName("a"));
			
			System.out.println("Total links in footer section is : " + links.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
