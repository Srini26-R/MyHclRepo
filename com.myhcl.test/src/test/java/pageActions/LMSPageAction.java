package pageActions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.LMSPage;

public class LMSPageAction extends LMSPage {

	public void accessLMS(WebDriver driver) {
		type(driver, autoCompTxtBox(driver), lms);
		openLinkInNewTab(driver, autoCompDrpDwn(driver, lms));
	}

	public void switchToLMS(WebDriver driver) {
		String lmsWin = getWindowControl(driver, "childWindow");
		switchWindow(driver, lmsWin);
	}

	public void lmsPageCtrl(WebDriver driver) {
		try {
			click(driver, skipNowLnk(driver));
		} catch (Exception e) {
		}
		waitTillEleLoads(driver, navDate(driver), 30, 1000);
		String monthYr = getText(driver, navDate(driver));
		if (!monthYr.equals(monthYear)) {
			click(driver, nxtMonth(driver));
		}
		String monthAndYear = getText(driver, navDate(driver));
		List<WebElement> listHolidays = comHolDate(driver);
		System.out.println("\nList of Company Holidays for " + monthAndYear + " :");
		for (int i = 0; i < listHolidays.size(); i++) {
			mouseOverList(driver, listHolidays, i);
			String companyHolidays = comHolDateToolTip(driver).getText();
			System.out.println("* " + companyHolidays);
		}
		List<WebElement> listHol = restHolDate(driver);
		System.out.println("\nList of Restricted Holidays for " + monthAndYear + " :");
		for (int i = 0; i < listHol.size(); i++) {
			mouseOverList(driver, listHol, i);
			String restHolidays = restHolDateToolTip(driver).getText();
			System.out.println("* " + restHolidays);
		}
	}

}