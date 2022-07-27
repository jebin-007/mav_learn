package learnSelenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTabNewWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			driver.get("https://www.youtube.com/");
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get("https://www.primevideo.com/");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://www.facebook.com/");			
			driver.switchTo().newWindow(WindowType.fromString("TAB"));
			driver.get("https:google.com");
			Set<String> windows =  driver.getWindowHandles();
			int i = 1;
			for(String window:windows) {
				driver.switchTo().window(window);
				System.out.println("Window " + i + " title = " + driver.getTitle());
				i++;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
