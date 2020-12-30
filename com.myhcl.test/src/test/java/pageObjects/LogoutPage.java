package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Base;

public class LogoutPage extends Base {

	public WebElement userDrpDwn(WebDriver driver) {
		return getElement(driver, "//div//ul//li//a//div[@class='userName']//following::span[1]", "xpath");
	}

	public WebElement logoutLnk(WebDriver driver) {
		return getElement(driver, "//div//ul//li//a[text()='Logout.']", "xpath");
	}

}