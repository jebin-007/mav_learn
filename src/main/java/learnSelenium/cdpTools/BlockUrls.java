package learnSelenium.cdpTools;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockUrls {

	public static void main(String[] args) {
		/*
		 * To block urls with images loading
		 * 
		 */
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			
//			List<String> blockedUrls = new ArrayList<>(List.of("*.jpg","*.png","*.jpeg"));
			ImmutableList<String> blockedUrls = ImmutableList.of("*.png","*.jpeg");
			DevTools cdp = driver.getDevTools();
			cdp.createSession();
			cdp.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			cdp.send(Network.setBlockedURLs(blockedUrls));
			driver.get("https://wallethub.com/credit-cards/business-rewards/");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
