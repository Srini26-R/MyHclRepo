package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Base;

public class LMSPage extends Base {

	public WebElement autoCompTxtBox(WebDriver driver) {
		return getElement(driver, "//div[@id='DivautoComplete']//input[@id='txtSearch']", "xpath");
	}

	public WebElement autoCompDrpDwn(WebDriver driver, String input) {
		return getElement(driver, "//ul//li//table[@class='hoverTable']//tbody//tr//td//a[text()='" + input + "']",
				"xpath");
	}

	public WebElement skipNowLnk(WebDriver driver) {
		return getElement(driver, "(//div[@role='dialog']//table//tbody//tr//td//img)[2]", "xpath");
	}

	public WebElement navDate(WebDriver driver) {
		return getElement(driver, "//div[@id='navDate']", "xpath");
	}

	public WebElement nxtMonth(WebDriver driver) {
		return getElement(driver, "//div[contains(@class,'next')]", "xpath");
	}

	public List<WebElement> comHolDate(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='pmu-CH disabledate']"));
	}

	public WebElement comHolDateToolTip(WebDriver driver) {
		return getElement(driver, "//div[@class='pmu-CH disabledate']//div[@role='tooltip']//div[2]", "xpath");
	}

	public List<WebElement> restHolDate(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='pmu-RH pmu-button']"));
	}

	public WebElement restHolDateToolTip(WebDriver driver) {
		return getElement(driver, "//div[@class='pmu-RH pmu-button']//div[@role='tooltip']//div[2]", "xpath");
	}

}