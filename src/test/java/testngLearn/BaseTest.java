package testngLearn;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	@BeforeSuite
	void setup() {
		System.out.println("Setting up the tests!!");
	}
	
	@AfterSuite
	void postSetup() {
		System.out.println("Post suite setup done!");
	}

}
