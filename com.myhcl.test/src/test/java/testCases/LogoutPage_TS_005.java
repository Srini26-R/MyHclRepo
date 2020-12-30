package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageActions.LogoutPageAction;

public class LogoutPage_TS_005 extends LogoutPageAction {

	@Test(priority = 1)
	public void logout() {
		userLogout(driver);
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}