package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageActions.LMSPageAction;

public class LMSPage_TS_003 extends LMSPageAction {

	@Test(priority = 1)
	public void navLink() {
		accessLMS(driver);
	}

	@Test(priority = 2)
	public void navToLms() {
		switchToLMS(driver);
	}

	@Test(priority = 3)
	public void pageCtrlLms() {
		lmsPageCtrl(driver);
	}

	@AfterTest
	public void closeLms() {
		driver.close();
		switchWindow(driver, getWindowControl(driver, "myHclWindow"));
	}

}