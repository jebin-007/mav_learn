package utilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WhActions {

	public static Logger logger = LogManager.getLogger(WhActions.class);
	public static Properties WhLocator = new Properties();
	
	public WhActions() {
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/resources/WH_Locators.properties");
			WhLocator.load(fis);
			logger.info("Locator property file loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public By getBy(String locator) {
		By by = null;
		
		try {
			if(locator.endsWith("_xpath")) {
				by = By.xpath(WhLocator.getProperty(locator));
			}else if (locator.endsWith("_css")) {
				by = By.cssSelector(WhLocator.getProperty(locator));			
			}else if (locator.endsWith("_id")) {
				by = By.id(WhLocator.getProperty(locator));
				
			}else if (locator.endsWith("_link")) {
				by = By.linkText(WhLocator.getProperty(locator));
				
			}else {
				by = By.xpath(WhLocator.getProperty(locator));
			}
			
			
		} catch (Exception e) {
			System.out.println("Error in getting By class");
		}
		return by;
	}
	
	public void click(WebDriver driver,String locator) {
		
        By by = getBy(locator);
		
		driver.findElement(by).click();
		String message = "Clicked on : " + locator;
		logger.info(message);
	}
	
	public void waitNclick(WebDriver driver,String locator, String waitTime) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.valueOf(waitTime)));
		By by = getBy(locator);
				
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
		logger.info("Clicked on : " + locator);
	}
	
	public void waitNclick(WebDriver driver, String locator) {
		waitNclick(driver, locator, "10");
	}
	
	public void sendKeys(WebDriver driver,String locator, String keys) {
		
		By by = getBy(locator);
		
		
		driver.findElement(by).sendKeys(keys);	
		logger.info("Entered " + keys + " on field " + locator);
	}
	
	public void waitNsendKeys(WebDriver driver,String locator, String keys, String waitTime) {
		    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.valueOf(waitTime)));
			By by = getBy(locator);
		
			wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(keys);
			logger.info("Entered " + keys + " on field " + locator);
		}
	
	public void waitNsendKeys(WebDriver driver,String locator, String keys) {
		waitNsendKeys(driver,locator,keys,"10");
	}
	
	public WebElement waitForElement(WebDriver driver,String locator,String waitTime) {
	
		WebElement elem;
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.valueOf(waitTime)));
		By by = getBy(locator);
				
		elem = wait.until(ExpectedConditions.elementToBeClickable(by));
		return elem;
	}
	
	public WebElement waitForElement(WebDriver driver,String locator) {
		return waitForElement(driver,locator,"30");
	}
	
	public Actions moveTo(WebDriver driver, String locator) {
		By by = getBy(locator);
		Actions action = new Actions(driver);
		logger.info("Moving mouse to  " +  locator);
		return action.moveToElement(driver.findElement(by));
	}
}
