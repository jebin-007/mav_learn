package maven_learn.mav_learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String path = "./Data.xlsx";
        String sheetName = "Employees";
        
        ExcelReader file = new ExcelReader(path, sheetName);
        
        int jj = file.getIntCellData(3, 0);
        System.out.println("Int value test : " + jj);
        System.out.println("String value test : " + file.getCellData(1, 1));
        
        try {
//        	WebDriverManager.chromedriver().setup();
            System.out.println(System.getProperty("webdriver.chrome.driver"));
        	
        	WebDriver driver = new ChromeDriver();
        	driver.get("https://google.com");
        	driver.quit();
        }catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
