package learnSelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class NewTabDemoWH {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://wallethub.com/credit-cards/compare/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"searchtool\"]/div[1]/div[2]/span"))).click();
			driver.findElement(By.xpath("//*[@id=\"card-1\"]/div[4]/a")).click();
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> winIter = windows.iterator();
			String window1 = winIter.next();
			String window2 = winIter.next();
			driver.switchTo().window(window2);
			WebElement aprValue = driver.findElement(By.xpath("//*[@id=\"scroller\"]/main/div[5]/div[2]/div[1]/div[3]/p"));
			System.out.println("Value = "+ aprValue.getText());
			driver.close();
			driver.switchTo().window(window1);
			WebElement applyNow = driver.findElement(By.xpath("//*[@id=\"card-1\"]/div[6]/div[4]/div[5]/div/div[1]/a"));
			applyNow.click();
;
			
		}catch(Exception e) {
		e.printStackTrace();
	}

}

}
