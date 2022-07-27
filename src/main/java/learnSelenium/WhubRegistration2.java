package learnSelenium;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.RandomMethods;
import utilities.WhActions;

public class WhubRegistration2 {
	
	public static Logger logger = LogManager.getLogger(WhubRegistration2.class);

	public static void main(String[] args) {
		/*
		 * Registration data Map generation
		 * 
		 */
		HashMap<String, String> regData = new HashMap<String, String>();
		
		regData.put("firstName","CRYSTAL");
		regData.put("lastName","COOPER");
		regData.put("address1","1808 S 16TH ST");
		regData.put("city","ESCANABA");
		regData.put("state","MI");
		regData.put("zipCode","49829");
		regData.put("dob","01/01/1964");
		regData.put("ssn","2838");
		
		
		
		/*
		 * 
		 * Driver setup 
		 * 
		 */
		try {
			logger.info("App started!");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://efdevhub.info/testing/unblock-vpn-ip.php");
			driver.get("https://efdevhub.info/join/");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			WhActions action = new WhActions();
			
			Properties WhLocators = new Properties();
			FileInputStream locatorFile = new FileInputStream("./src/main/java/resources/WH_Locators.properties");
			WhLocators.load(locatorFile);
			System.out.println(WhLocators.getProperty("firstName_xpath"));
			
	        action.sendKeys(driver,"firstName_xpath",regData.get("firstName"));
	        action.sendKeys(driver,"lastName_xpath",regData.get("lastName"));
			action.waitNclick(driver,"nameScreenSubmit_xpath");
			action.waitNsendKeys(driver, "email_xpath", RandomMethods.getRandomEmail());
			action.click(driver,"emailScreenSubmit_xpath");			
			action.waitNsendKeys(driver, "password_id", "Abcd123*");			
			action.waitNsendKeys(driver,"confirmPass_xpath" , "Abcd123*");			
			action.waitNclick(driver, "passScreenSubmit_xpath");			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-secq\"]/form/div[1]/div/span[1]"))).click();
			driver.findElement(By.xpath("//*[@id=\"join-secq\"]/form/div[1]/div/ul/li[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"join-secq\"]/form/div[2]/input")).sendKeys("Joseph");
			driver.findElement(By.xpath("//*[@id=\"join-secq\"]/form/div[3]/button[2]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-address\"]/form/div[2]/input"))).sendKeys(regData.get("address1"));
			driver.findElement(By.xpath("//*[@id=\"join-address\"]/form/div[9]/button[2]")).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-address\"]/form/div[3]/input[1]"))).sendKeys(regData.get("address1"));
			driver.findElement(By.xpath("//*[@id=\"join-address\"]/form/div[4]/input[1]")).sendKeys(regData.get("city"));
			driver.findElement(By.xpath("//*[@id=\"join-address\"]/form/div[4]/input[2]")).sendKeys(regData.get("state"));
			driver.findElement(By.xpath("//*[@id=\"join-address\"]/form/div[4]/input[3]")).sendKeys(regData.get("zipCode"));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"join-address\"]/form/div[9]/button[2]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-phone\"]/form/div[3]/button[3]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-phone\"]/form/div[3]/button[2]"))).click();
			String year = regData.get("dob").substring(6);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"month-ipt\"]"))).sendKeys("01");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"day-ipt\"]"))).sendKeys("01");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"year-ipt\"]"))).sendKeys(year);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-birthday\"]/div/form/div[3]/button[2]"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-ssn\"]/form/div[1]/input"))).sendKeys(regData.get("ssn"));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-ssn\"]/form/div[2]/div/label/span[1]"))).click();
			driver.findElement(By.xpath("//*[@id=\"join-ssn\"]/form/div[3]/button[2]")).click();
			
//			Thread.sleep(5000);
//			driver.quit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
