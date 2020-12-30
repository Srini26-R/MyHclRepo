package pageActions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.IsuccessLearnPage;

public class IsuccessLearnPageAction extends IsuccessLearnPage {

	public void accessIsuccess(WebDriver driver) {
		type(driver, autoCompTxtBox(driver), isuccess);
		openLinkInNewTab(driver, autoCompDrpDwn(driver, isuccess));
	}

	public void switchToIsuccess(WebDriver driver) {
		String isuccessWin = getWindowControl(driver, "childWindow");
		switchWindow(driver, isuccessWin);
	}

	public void viewLearningHistory(WebDriver driver) {
		waitTillEleLoads(driver, viewAllBtn(driver), 100, 1000);
		click(driver, viewAllBtn(driver));
		sleep(6000);
		List<WebElement> list1 = getStatus(driver, status1);
		int successfulCount = list1.size();
		for (int i = 0; i < successfulCount; i++) {
			String title = list1.get(i).getText();
			System.out.println("Completed Course name: " + title);
		}
		System.out.println("Successful list count is ---> " + successfulCount);
		List<WebElement> list2 = getStatus(driver, status2);
		int unsuccessfulCount = list2.size();
		for (int i = 0; i < unsuccessfulCount; i++) {
			String title = list2.get(i).getText();
			System.out.println("Incomplete Courses name: " + title);
		}
		System.out.println("UnSuccessful list count is ---> " + unsuccessfulCount);
	}

}