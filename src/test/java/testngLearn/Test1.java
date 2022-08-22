package testngLearn;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@SuppressWarnings("unused")
public class Test1 {
	
	@BeforeSuite
	void setup1() {
		System.out.println("First setup run");
	}
	
	@BeforeMethod
	void openBrowser() {
		System.out.println("Browser opened!");
	}
	
	@AfterMethod
	void closeBrowser() {
		System.out.println("Browser closed!");
	}
	
	@Test(priority = 1)
	void doRegistration() {
		System.out.println("Registation Success!");
		String actual = "Jebin";
		String expected = "Jebin";
		Assert.assertEquals(actual, expected);
	}

	
	@Test(priority = 3)
	void doLogin() {
		System.out.println("login success");
		
	}
	
	@Test(priority = 2, dependsOnMethods = "doRegistration")
	void reachDashboard() {
		
		System.out.println("Reached dashboard");
	}
	
	@Test
	void multipleValidations() {
		int a = 2;
		int b = 5;
		String name1 = "Jebin";
		String name2 = "Jebin";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(a, b, "Numbers don't match");
		softAssert.assertFalse(true, "Element is present!");
		softAssert.assertEquals(name1, name2, "Names don't match");
		System.out.println("Multiple validations test ran fully");
		softAssert.assertAll();
		
	}
	
	@Test
	void skipTest() {
		throw new SkipException("Test skipped as condition not met!");
	}
	
	@BeforeTest
	void openDBConnectiono() {
		System.out.println("Connected to DB!");
	}
	
	@AfterTest
	void closeDBConnection() {
		System.out.println("DB connection closed!");
	}
	
	
	@AfterSuite
	void postSetup() {
		System.out.println("First post setup done");
	}

}
