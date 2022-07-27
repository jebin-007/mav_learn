package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			
			driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
			WebElement file = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[9]/input"));
			file.sendKeys("C:\\Users\\jebin\\OneDrive\\Desktop\\MBA-in-Business-Analytics.pdf");
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
