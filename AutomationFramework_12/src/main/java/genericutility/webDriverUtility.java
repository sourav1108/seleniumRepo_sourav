package genericutility;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author SouravMittal
 */

public class webDriverUtility {

	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();

	}

	/**
	 * This method is used to capture size of a window
	 * 
	 * @param driver
	 * @return url
	 */
	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();

	}

	/**
	 * This method is used to switch driver control to window based on url
	 * 
	 * @param driver
	 */
	public void switchToWindow(WebDriver driver, String url) {
		// step1: capture window ids
		Set<String> allWindowID = driver.getWindowHandles();
		// step2 : navigate through all the window
		for (String id : allWindowID) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();

			if (actUrl.contains(url)) {
				break;
			}
		}
	}

	/**
	 * This method is used to right click
	 * 
	 * @param driver
	 */

	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method is used to click and hold on the target element
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act1 = new Actions(driver);
		act1.clickAndHold(element).perform();
	}

	/**
	 * THis method is used to mouse hover on the element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act2 = new Actions(driver);
		act2.moveToElement(element).perform();
	}

	/**
	 * This method is used to DragAndDrop the element
	 * 
	 * @param driver
	 * @param element
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement tarElement) {
		Actions act2 = new Actions(driver);
		act2.dragAndDrop(srcElement, tarElement).perform();
	}

	/**
	 * This method is used to switch the frame through index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch the frame through nameOrId
	 * 
	 * @param driver
	 * @param nameOrID
	 */
	public void switchtoFrame(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method is used to switch the frame through frameElement
	 * 
	 * @param driver
	 * @param frameElement
	 */
	public void switchtoFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * This method is used to switch Back the frame to main WebDriver driver
	 * 
	 * @param driver
	 */
	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to select Drop Down By Index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDownByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method is used to select Drop Down By VisibleText
	 * 
	 * @param element
	 * @param text
	 */
	public void selectDropDownByvisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method is used to select Drop Down By value
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropDownByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	public void switchToAlertAndSendkeys(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	public void jsScroll(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}
}
