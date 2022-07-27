package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			
			driver.get("https://deluxe-menu.com/popup-mode-sample.html");
			WebElement img = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
			
			Actions action = new Actions(driver);
			action.contextClick(img).perform();
		
			Thread.sleep(3000);
			WebElement menu1 = driver.findElement(By.xpath("//*[@id=\"dm2m1i1tdT\"]"));
			action.moveToElement(menu1).perform();			
			WebElement menu2 = driver.findElement(By.xpath("//*[@id=\"dm2m2i1tdT\"]"));
			action.moveToElement(menu2).perform();
			WebElement menu3 = driver.findElement(By.xpath("//*[@id=\"dm2m3i1tdT\"]"));
			action.moveToElement(menu3).click().perform();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
