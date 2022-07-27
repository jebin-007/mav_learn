package learnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintBatsmenName {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver  = new EdgeDriver();
		driver.manage().window().maximize();
		try {
			driver.get("http://imsports.rediff.com/score/in_asa_105921.html");
			
			
			List<WebElement> batsmen = driver.findElements(By.xpath("//div[7]/table[2]/tbody/tr[*]/td[1]"));
			
			for(int i = 0; i<batsmen.size();i++) {
				if(i==0) {
					continue;
				}
				WebElement element = batsmen.get(i);
				System.out.println(element.getText());    
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
