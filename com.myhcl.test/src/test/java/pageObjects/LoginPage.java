package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Base;

public class LoginPage extends Base {

	public WebElement txtField(WebDriver driver, String input) {
		return getElement(driver, "//div[text()='" + input + "']//following::input[1]", "xpath");
	}

	public WebElement submitBtn(WebDriver driver) {
		return getElement(driver, "//div//input[@type='submit']", "xpath");
	}

	public WebElement approveAuth(WebDriver driver) {
		return getElement(driver, "//div[text()='Approve sign in request']", "xpath");
	}

	public WebElement chkBox(WebDriver driver) {
		return getElement(driver, "//div[text()='Stay signed in?']//following::input[@name='DontShowAgain']", "xpath");
	}

	public WebElement homePage(WebDriver driver, String input) {
		return getElement(driver, "//div//a[@id='setting']//div[@title='" + input + "']", "xpath");
	}

}