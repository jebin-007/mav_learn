package testngLearn;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class CcSearchTools {
	
	@Test
	void verifyCardTemplate() {
		System.out.println("Verifying Card template");
		Assert.fail();
	}
	
	@Test
	void verifyDescription() {
		int a = 2;
		int b = 2;
		System.out.println("Verifying custom uri description");
		Reporter.log("<a href = \"./screenshots/Promises1.jpeg\">Screenshot</a>");
		Reporter.log("<br/><br/>");
		Reporter.log("<a href = \"./screenshots/Promises1.jpeg\"><img src = \"./screenshots/Promises1.jpeg\" width = \"200\"   ></a>");
		Assert.assertEquals(b, a);
	}

}
