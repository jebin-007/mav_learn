package learnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintGameTableData {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver  = new EdgeDriver();
		driver.manage().window().maximize();
		try {
			driver.get("http://imsports.rediff.com/score/in_asa_105921.html");
			
			WebElement table = driver.findElement(By.xpath("//*[@id=\"bat-board\"]/tbody"));
			List<WebElement> tableRows = table.findElements(By.tagName("tr"));
			
			for(WebElement row: tableRows) {
				List<WebElement> rowCells = row.findElements(By.tagName("td"));
				System.out.println();
				for(WebElement cell:rowCells) {
					System.out.print(cell.getText() + "\t\t");
				}
			}
			
					
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
