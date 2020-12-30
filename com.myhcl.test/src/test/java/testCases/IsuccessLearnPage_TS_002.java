package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageActions.IsuccessLearnPageAction;

public class IsuccessLearnPage_TS_002 extends IsuccessLearnPageAction {

	@Test(priority = 1)
	public void navLink() {
		accessIsuccess(driver);
	}

	@Test(priority = 2)
	public void navToIlearn() {
		switchToIsuccess(driver);
	}

	@Test(priority = 3)
	public void viewHistory() {
		viewLearningHistory(driver);
	}

	@AfterTest
	public void closeIsuccess() {
		driver.close();
		switchWindow(driver, getWindowControl(driver, "myHclWindow"));
	}

}