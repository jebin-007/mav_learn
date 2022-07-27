package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizeableFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().setSize(new Dimension(500, 400) );
		
			driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			WebElement drag = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
			action.dragAndDropBy(drag, 40, 40).perform();
			Thread.sleep(1000);
			driver.manage().window().setSize(new Dimension(600, 500) );
			Thread.sleep(1000);
			action.dragAndDropBy(drag, 40, 40).perform();	
			Thread.sleep(1000);
			driver.manage().window().setSize(new Dimension(700, 600) );
			Thread.sleep(1000);
			action.dragAndDropBy(drag, 40, 40).perform();
			Thread.sleep(1000);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
