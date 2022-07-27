package learnSelenium;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class CDPToolsDemo {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			
			/*
			 * 
			 * CDP feature given by browser CDP is not stable hence we will use executeCDP command provided by Selenium
			 * 
			 */
//			DevTools cdp = driver.getDevTools();
//			cdp.createSession();
//			cdp.send(Emulation.setDeviceMetricsOverride(
//					                                     375, 
//					                                     667, 
//					                                     75, 
//					                                     true, 
//					                                     Optional.empty(), 
//					                                     Optional.empty(), 
//					                                     Optional.empty(), 
//					                                     Optional.empty(), 
//					                                     Optional.empty(), 
//					                                     Optional.empty(), 
//					                                     Optional.empty(), 
//					                                     Optional.empty()));
			
			Map<String, Object> deviceMetrics = new HashMap<String, Object>(){{
				
				put("width",375);
				put("height",667);
				put("deviceScaleFactor",75);
				put("mobile",true);
				
				
			}};
			
			driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
			
			driver.get("https://wallethub.com/");
			driver.findElement(By.xpath("//*[@id=\"homepage\"]/section[1]/div/div[2]/div[2]/h2")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
