package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageActions.MemePageAction;

public class MemePage_TS_004 extends MemePageAction {

	@Test(priority = 1)
	public void navLink() {
		accessMeme(driver);
	}

	@Test(priority = 2)
	public void navToMeme() {
		switchToMeme(driver);
	}

	@Test(priority = 3)
	public void addMemeProfPic() {
		uploadProfPic(driver);
	}

	@AfterTest
	public void closeMeme() {
		driver.close();
		switchWindow(driver, getWindowControl(driver, "myHclWindow"));
	}

}