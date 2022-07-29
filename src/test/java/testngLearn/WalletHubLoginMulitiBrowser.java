package testngLearn;

import java.io.FileInputStream;

import utilities.ExcelReader;
import utilities.WhActionReport;
import utilities.WhActions;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WalletHubLoginMulitiBrowser {
	static WebDriver driver;
	static WebDriverWait wait;
	static Properties urlProperties;
	static Properties locatoProperties;
	static FileInputStream urlFile;
	static FileInputStream locator;
	static WhActions actions;
	
	@BeforeTest
	void testStart() {
		
		try {
			urlProperties = new Properties();
			locatoProperties = new Properties();
			urlFile = new FileInputStream(".\\src\\main\\java\\resources\\WH_URLS.properties");
			urlProperties.load(urlFile);
			System.out.println(urlProperties.getProperty("login"));
			locator = new FileInputStream(".\\src\\main\\java\\resources\\WH_Locators.properties");
			locatoProperties.load(locator);
			actions = new WhActionReport();
			
		} catch (Exception e) {
			System.out.println("Properties file load failed!!");
		}
	}
	
	@BeforeMethod
	void launchBrowser() {
//		WebDriverManager.edgedriver().setup();
//		try {
//			driver = new ChromeDriver();
//			System.out.println("Driver lauch success");
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	@AfterMethod
	void closeBrowser() {
		driver.quit();
	}
	
	@Parameters({"browser"})
	@Test
	void loginWalletHub(String browser) throws InterruptedException {
		    Date d = new Date();
		    System.out.println("Date for browser " + browser + " = " + d.toString());
		    
		    
		    if(browser.equals("chrome")) {
		    	driver = new ChromeDriver();
		    }else if(browser.equals("firefox")) {
		    	driver = new FirefoxDriver();
		    }else {
		    	driver  = new EdgeDriver();
		    }
			driver.get("https://efdevhub.info/");
			driver.get(urlProperties.getProperty("login"));
			actions.waitNsendKeys(driver, "login_email_id", "ashley@evolutionfinance.com");
			actions.sendKeys(driver, "login_password_id", "Abcd123*");
			actions.click(driver, "login_button_xpath");
			WebElement scoreGauge = actions.waitForElement(driver, "scoreGauge_xpath", "20");
			Thread.sleep(3000);
			System.out.println(scoreGauge.getText());
			Actions moveMouse = actions.moveTo(driver, "nameMenu_xpath");
			moveMouse.perform();
			actions.waitNclick(driver, "logOut_xpath");
			
		
		
	}
	
	@DataProvider(name = "login-data")
	Object[][] getLoginData(){
		
		Object[][] excelData = null;
		try {
			ExcelReader excel = new ExcelReader("./src/main/resources/login-data.xlsx", "login-data");
			int rowCount = excel.getRowCount();
			int columnCount = excel.getColumnCount();
			excelData = new Object[rowCount-1][columnCount];
			for(int i =1;i < rowCount; i++) {
				
				for(int j = 0;j< columnCount;j++) {
					excelData[i-1][j] = excel.getCellData(i, j);
					
				}
			}
			
		} catch (Exception e) {
			System.out.println("Excel read error!");
		}
		
		
		return excelData;
	
		
	}
	
	@AfterTest
	void allTestFinish() {
		try {
			urlFile.close();
			locator.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
