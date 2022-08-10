package learnSelenium;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.AddressSplitter;
import utilities.ExcelReader;
import utilities.RandomMethods;
import utilities.WhActions;

public class WhubRegistration2 {
	
	public static Logger logger = LogManager.getLogger(WhubRegistration2.class);

	public static void main(String[] args) {
		/*
		 * Registration data Map generation
		 * 
		 */
		HashMap<String, String> regData = getRegistrationData();
		
//		regData.put("firstName","CRYSTAL");
//		regData.put("lastName","COOPER");
//		regData.put("address1","1808 S 16TH ST");
//		regData.put("city","ESCANABA");
//		regData.put("state","MI");
//		regData.put("zipCode","49829");
//		regData.put("dob","01/01/1964");
//		regData.put("ssn","2838");
//		
//		
		
		System.out.println(regData.get("firstName"));
		System.out.println(regData.get("address1"));
		System.out.println(regData.get("city"));
		System.out.println(regData.get("state"));
		System.out.println(regData.get("zipcode"));
		System.out.println(regData.get("dob"));
		System.out.println(regData.get("ssn"));
		System.out.println(regData.get("aptNo"));
		
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
			driver.findElement(By.xpath("//input[@ng-model='fields.aptno']")).sendKeys(regData.get("aptNo"));
			driver.findElement(By.xpath("//input[@ng-model='fields.city']")).sendKeys(regData.get("city"));
			driver.findElement(By.xpath("//input[@ng-model='fields.state']")).sendKeys(regData.get("state"));
			driver.findElement(By.xpath("//input[@ng-model='fields.zip']")).sendKeys(regData.get("zipcode"));
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
	
	
	public static HashMap<String, String> getRegistrationData(){
		ExcelReader regExcel = new ExcelReader("./src/main/resources/registration-data.xlsx", "Reg Data");
		HashMap<String, String> regData = new HashMap<String, String>();
		int maxRows = regExcel.getRowCount();
		Random random = new Random();		
		while(true) {
			int row = random.nextInt(maxRows);
			if(regExcel.getCellData(row, 13).equalsIgnoreCase("no") ) {
				continue;
			}
			
			regData.put("firstName",regExcel.getCellData(row, 1));
			regData.put("lastName",regExcel.getCellData(row, 2));
			
			regData.put("dob", dobFormatted(regExcel.getCellData(row, 6)));
			regData.put("ssn", last4Ssn(regExcel.getCellData(row, 5)));
			
			HashMap<String, String> splitAdd = AddressSplitter.split(regExcel.getCellData(row, 3));
			
			regData.put("address1",splitAdd.get("street"));
			regData.put("city",splitAdd.get("city"));
			regData.put("state",splitAdd.get("state"));
			regData.put("zipcode",splitAdd.get("zipcode"));
			regData.put("aptNo",regExcel.getCellData(row, 4));
			break;
		}
		return regData;
		
		
	}
	
	public static String dobFormatted(String dob) {
		String yearString = dob.substring(0, 4);
		return "01/01/" + yearString;
	}
	
	public static String last4Ssn(String fullSsn) {
		return fullSsn.substring(5);
	}

}
