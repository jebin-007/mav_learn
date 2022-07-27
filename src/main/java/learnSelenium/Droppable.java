package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
		
			driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			WebElement draggable = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
			WebElement droppable = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
			
			action.dragAndDrop(draggable, droppable).perform();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
