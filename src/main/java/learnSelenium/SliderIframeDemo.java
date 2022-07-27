package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderIframeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
		
			driver.get("https://jqueryui.com/slider/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
			WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
			driver.switchTo().frame(frame);
			WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
			WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
			System.out.println("slider found");
			int newWidth = 0;
			newWidth = mainSlider.getSize().getWidth()/4;
			System.out.println("New width = " + newWidth);
			Actions action = new Actions(driver);
			
			action.dragAndDropBy(slider, newWidth, 0).perform();
			Thread.sleep(3000);
			action.dragAndDropBy(slider, -50, 0).perform();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
