package learnSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ExcelReader;

/*
 * 
 * This is a feature where it reads Properties excep to get the value of browser and open that browser
 * 
 * 
 */

public class BrowserChoice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "./Properties.xlsx";
		String browser = "chrome";
		String sheetName = "properties";
		WebDriver driver = null;
		
		try {
			ExcelReader properties = new ExcelReader(path,sheetName);
			browser = properties.getValueOfProperty("browser");
			System.out.println("Browser = " + browser);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get("https://youtube.com");

	}

}
