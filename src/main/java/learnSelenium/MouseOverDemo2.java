package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		WebDriverManager.edgedriver().setup();
		try {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://wallethub.com/");
			WebElement ccMenu = driver.findElement(By.xpath("//header/div/nav/div[1]/a[2]"));
			Actions mouseHover = new Actions(driver);
			mouseHover.moveToElement(ccMenu).perform();
			driver.findElement(By.xpath("//*[@id=\"cc-list-menu\"]/li[3]/a")).click();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
