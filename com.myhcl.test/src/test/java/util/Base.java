package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Base extends Setup {

	public WebElement getElement(WebDriver driver, String identifier, String identifierType) {
		switch (identifierType) {

		case "xpath":
			return driver.findElement(By.xpath(identifier));

		case "id":
			return driver.findElement(By.id(identifier));

		case "className":
			return driver.findElement(By.className(identifier));

		case "name":
			return driver.findElement(By.name(identifier));

		default:
			System.out.println("Invalid element type used for the element with identifier :" + identifierType);
		}
		return null;
	}

	public void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
	}

	public void click(WebDriver driver, WebElement webElement) {
		waitTillEleLoads(driver, webElement, 50, 1000);
		Actions action = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
		action.moveToElement(webElement).perform();
		sleep(300);
		action.moveToElement(webElement).click().perform();
	}

	public void type(WebDriver driver, WebElement webElement, String value) {
		waitTillEleLoads(driver, webElement, 50, 1000);
		webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		webElement.sendKeys(value);
//		webElement.sendKeys(Keys.TAB);
	}

	public void openLinkInNewTab(WebDriver driver, WebElement webElement) {
		waitTillEleLoads(driver, webElement, 50, 1000);
		Actions action = new Actions(driver);
		action.contextClick(webElement).build().perform();
		try {
			Robot robot = new Robot();
			robot.delay(300);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public String getWindowControl(WebDriver driver, String input) {
		sleep(10000);
		Set<String> set = driver.getWindowHandles();
		String windowID = null;
		for (String win : set) {
			if (input.equals("myHclWindow")) {
				windowID = win;
				break;
			} else if (input.equals("childWindow")) {
				windowID = win;
			} else {
				System.out.println("No Window ID found!...");
			}
		}
		return windowID;
	}

	public void switchWindow(WebDriver driver, String input) {
		if (input.equals("default")) {
			driver.switchTo().defaultContent();
		} else {
			driver.switchTo().window(input);
		}
	}

	public void switchFrame(WebDriver driver, int i) {
		sleep(8000);
		driver.switchTo().frame(i);
	}

	public String getText(WebDriver driver, WebElement webElement) {
		String fetchedTxt = webElement.getText();
		return fetchedTxt;
	}

	public void mouseOverList(WebDriver driver, List<WebElement> webElement, int i) {
		Actions action = new Actions(driver);
		action.moveToElement(webElement.get(i)).perform();
	}

	public void uploadPhoto(String imgPath) {
		StringSelection path = new StringSelection(imgPath);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Clipboard clipboard = tool.getSystemClipboard();
		clipboard.setContents(path, null);
		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void alertHandle(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@SuppressWarnings("unused")
	public void waitTillEleLoads(WebDriver driver, WebElement webElement, int timeOut, int pollTime) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollTime)).ignoring(NoSuchElementException.class);
		try {
			sleep(300);
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			for (int i = 1; i <= 3; i++) {
				sleep(300);
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(webElement)));
				break;
			}
		}
	}

}