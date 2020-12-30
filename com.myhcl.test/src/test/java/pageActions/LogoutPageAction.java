package pageActions;

import org.openqa.selenium.WebDriver;

import pageObjects.LogoutPage;

public class LogoutPageAction extends LogoutPage {

	public void userLogout(WebDriver driver) {
		click(driver, userDrpDwn(driver));
		click(driver, logoutLnk(driver));
		alertHandle(driver);
	}

}