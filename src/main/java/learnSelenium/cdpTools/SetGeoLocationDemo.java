package learnSelenium.cdpTools;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.emulation.Emulation;

public class SetGeoLocationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
			DevTools cdp = driver.getDevTools();
			cdp.createSession();
			cdp.send(Emulation.setGeolocationOverride(Optional.of(38.575764), Optional.of(-121.478851), Optional.of(100)));
			driver.get("https://mycurrentlocation.net/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
