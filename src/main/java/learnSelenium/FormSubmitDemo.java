package learnSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormSubmitDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://way2automation.com/way2auto_jquery/index.php");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/form/fieldset[1]/input"))).sendKeys("Jebin Joseph");
			driver.findElement(By.xpath("//div/div/form/fieldset[2]/input")).sendKeys("23489239283");
			driver.findElement(By.xpath("//div/div/form/fieldset[3]/input")).sendKeys("jsjd2343@gmailcom");
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")));
			dropdown.selectByValue("Cyprus");
			driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[5]/input")).sendKeys("Prague");
			driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[6]/input")).sendKeys("johnyjohny");
			driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input")).sendKeys("AbcPass123");
			driver.findElement(By.xpath("//div/div/form/div[1]/div[2]/input")).click();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
