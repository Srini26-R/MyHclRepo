package pageActions;

import org.openqa.selenium.WebDriver;

import pageObjects.MemePage;

public class MemePageAction extends MemePage {

	public void accessMeme(WebDriver driver) {
		type(driver, autoCompTxtBox(driver), meme);
		openLinkInNewTab(driver, autoCompDrpDwn(driver, meme));
	}

	public void switchToMeme(WebDriver driver) {
		String memeWin = getWindowControl(driver, "childWindow");
		switchWindow(driver, memeWin);
	}

	public void uploadProfPic(WebDriver driver) {
		click(driver, dropDwn(driver));
		click(driver, changeProfPic(driver));
		click(driver, chooseFile(driver));
		uploadPhoto(img);
		waitTillEleLoads(driver, removePhoto(driver), 50, 1000);
		click(driver, saveBtn(driver));
		sleep(20000);
	}

}