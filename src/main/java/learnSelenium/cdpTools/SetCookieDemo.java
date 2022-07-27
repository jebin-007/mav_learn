package learnSelenium.cdpTools;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.emulation.Emulation;
import org.openqa.selenium.devtools.v101.network.Network;
import org.openqa.selenium.devtools.v101.network.model.Cookie;

public class SetCookieDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			DevTools cdp = driver.getDevTools();
			cdp.createSession();			
			driver.get("https://efdevhub.info/");
			List<Cookie> cookies = cdp.send(Network.getCookies(Optional.empty()));
			for(Cookie c:cookies) {
				if(c.getName().equals("testid")) {
					System.out.println("Test ID value = "  + c.getValue());
				}
			}
			
			driver.get("https://efdevhub.info/credit-cards/compare/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
