package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Base;

public class MemePage extends Base {

	public WebElement autoCompTxtBox(WebDriver driver) {
		return getElement(driver, "//div[@id='DivautoComplete']//input[@id='txtSearch']", "xpath");
	}

	public WebElement autoCompDrpDwn(WebDriver driver, String input) {
		return getElement(driver, "//ul//li//table[@class='hoverTable']//tbody//tr//td//a[text()='" + input + "']",
				"xpath");
	}

	public WebElement dropDwn(WebDriver driver) {
		return getElement(driver, "//div//a[@class='dropdown-toggle']//img[1]", "xpath");
	}

	public WebElement changeProfPic(WebDriver driver) {
		return getElement(driver, "//div//a[text()='Change Profile Picture']", "xpath");
	}

	public WebElement chooseFile(WebDriver driver) {
		return getElement(driver, "(//div//span[text()='Profile Cropper']//following::input[@type='file'])[1]",
				"xpath");
	}

	public WebElement saveBtn(WebDriver driver) {
		return getElement(driver, "//div//button[text()='Save']", "xpath");
	}

	public WebElement removePhoto(WebDriver driver) {
		return getElement(driver, "//div//input[@value='Remove']", "xpath");
	}

}