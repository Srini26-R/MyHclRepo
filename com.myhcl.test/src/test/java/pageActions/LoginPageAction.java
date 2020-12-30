package pageActions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.LoginPage;

public class LoginPageAction extends LoginPage {

	public void userSignIn(WebDriver driver) {
		type(driver, txtField(driver, "Sign in"), username);
		click(driver, submitBtn(driver));
		type(driver, txtField(driver, "Enter password"), password);
		click(driver, submitBtn(driver));
		sleep(8000);
//		After approving from Microsoft Authenticator
		click(driver, chkBox(driver));
		click(driver, submitBtn(driver));
		waitTillEleLoads(driver, homePage(driver, homePageTitle), 30, 1000);
		String titleChk = homePage(driver, homePageTitle).getAttribute("title");
		Assert.assertEquals(titleChk, homePageTitle, "Sign In Failed!...");
	}

}