package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageActions.LoginPageAction;

public class LoginPage_TS_001 extends LoginPageAction {

	@Test
	public void loginTest() {
		selectWebsite(driver);
		userSignIn(driver);
	}

	@BeforeTest
	public void browserstart() {
		driver = setBrowser();
	}

}