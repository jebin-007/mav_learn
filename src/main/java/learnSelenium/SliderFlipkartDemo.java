package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderFlipkartDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
		
			driver.get("https://www.flipkart.com/computers/storage/pr?sid=6bo%2Cjdy&marketplace=FLIPKART&p%5B%5D");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
			WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div/div/section[2]/div[3]/div[2]"));
			WebElement slider = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div/div/section[2]/div[3]/div[1]/div[2]"));
			System.out.println("slider found");
			int newWidth = mainSlider.getSize().width;
			
			Actions action = new Actions(driver);
			newWidth = newWidth/3;
			action.dragAndDropBy(slider, -newWidth, 0).perform();
			Thread.sleep(3000);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
