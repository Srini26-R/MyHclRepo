package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Base;

public class IsuccessLearnPage extends Base {

	public WebElement autoCompTxtBox(WebDriver driver) {
		return getElement(driver, "//div[@id='DivautoComplete']//input[@id='txtSearch']", "xpath");
	}

	public WebElement autoCompDrpDwn(WebDriver driver, String input) {
		return getElement(driver, "//ul//li//table[@class='hoverTable']//tbody//tr//td//a[text()='" + input + "']",
				"xpath");
	}

	public WebElement viewAllBtn(WebDriver driver) {
		return getElement(driver,
				"//div//h3//a//span[text()='Learning History']//following::button//div[text()='View All']", "xpath");
	}

	public List<WebElement> getStatus(WebDriver driver, String status) {
		return driver.findElements(
				By.xpath("//div[@class='completedWorkTableStyle']//table//tbody//tr//td//span[contains(text(),'"
						+ status + "')]//preceding::td[1]"));
	}

}