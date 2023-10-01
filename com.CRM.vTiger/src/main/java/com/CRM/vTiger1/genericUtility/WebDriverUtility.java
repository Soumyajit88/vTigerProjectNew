package com.CRM.vTiger1.genericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * @author Soumyajit
 */

public class WebDriverUtility {

	/**
	 * This Method is used to maximize window
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This Method is used to minimize window
	 * 
	 * @param driver
	 */
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
		;
	}

	/**
	 * This Method is used to perform implicit wait.
	 * 
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IpathConstant.implicitWaitDuration));
	}
	
	/**
	 * This Method is used to perform explicit wait.
	 * @param driver
	 */
	public void explicitWait(WebDriver driver) {
		@SuppressWarnings("unused")
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitWaitDuration));
	}
	
	/**
	 * By using this me
	 * @param driver
	 * @param element
	 */
	public void visibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void compareTitle(WebDriver driver, String Title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitWaitDuration));
		wait.until(ExpectedConditions.titleContains(Title));
	}
	/*
	 * public void ignoreException(WebDriver driver,String exception) {
	 * WebDriverWait wait=new WebDriverWait(driver,
	 * Duration.ofSeconds(IpathConstant.explicitWaitDuration));
	 * wait.ignoring(exception); }
	 */

	public void handleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void handleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void handleDropdown(String visibleText, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * By using this method we can click on OK button or can accept the popup.
	 * 
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * By using this method we can click on CANCEL button or can dismiss the popup.
	 * 
	 * @param driver
	 */
	public void dismisAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * By using this method we can capture the text present in popup.
	 * 
	 * @param driver
	 * @return
	 */
	public String getTextFromAlertPopup(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	/**
	 * By using this method we can send datas to popup textboxes.
	 * 
	 * @param driver
	 * @param text
	 */
	public void sendTextToAlertPopup(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	/**
	 * By using this method we can switch driver control to frame by index.
	 * 
	 * @param driver
	 * @param index
	 */
	public void handleFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * By using this method we can switch driver control to frame by Name or Id.
	 * 
	 * @param driver
	 * @param name
	 */
	public void handleFrameByNameOrId(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	/**
	 * By using this method we can switch driver control to frame by WebElement.
	 * 
	 * @param driver
	 * @param element
	 */
	public void handleFrameByElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * By using this method we can switch our driver control to immediate parent
	 * frame.
	 * 
	 * @param driver
	 */
	public void parentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * By using this method we can switch our driver control to default frame.
	 * 
	 * @param driver
	 */
	public void defaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * By using this method we can move our mouse to a particular webElement.
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * By using this method we can perform right click on a particular webElement.
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * By using this method we can perform right click anywhere on WebPage
	 * @param driver
	 */
	public void rightClickAnywhere(WebDriver driver) {
		Actions action=new Actions(driver);
		action.contextClick().perform();
	}
	
	/**
	 * By using this method we can perform double click on a particular webElement.
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	/**
	 * By using this method we can perform Double click anywhere on WebPage
	 * @param driver
	 */
	public void doubleClickAnyWhere(WebDriver driver) {
		Actions action=new Actions(driver);
		action.doubleClick().perform();
	}
	
	/**
	 * By using this method we can drag an element and drop it in different position.
	 * @param driver
	 * @param sourceElement
	 * @param destinationElemenet
	 */
	public void dragAndDrop(WebDriver driver,WebElement sourceElement,WebElement destinationElemenet) {
		Actions action=new Actions(driver);
		action.dragAndDrop(sourceElement, destinationElemenet).perform();
	}
	
	/**
	 * By using this method we can switch our driver control to any windows.
	 * Here we comparing titles 
	 * @param driver
	 * @param partialtiltle
	 */
	public void switchWindow(WebDriver driver,String partialtiltle) {
		//capture all window id
		Set<String> allIds = driver.getWindowHandles();
		
		//Navigate to each window
		for(String windowIds:allIds) {
			
			String currentTitle=driver.switchTo().window(windowIds).getTitle();
			if(currentTitle.contains(partialtiltle)) {
				break;
			}
		}
	}
	
	/**
	 * By using this method we can take screenshot of entire webPage.
	 * @param driver
	 * @param ScreenshotName
	 * @return
	 * @throws Throwable
	 */
	public String takeScreenShotsOfEntireWebPage(WebDriver driver,String ScreenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		JavaUtility ju=new JavaUtility();
		String dateTime = ju.modifiedDateTime();
		
		File perm=new File("./Screenshots"+dateTime+ScreenshotName+".png");
		Files.copy(temp, perm);
		
		return perm.getAbsolutePath();//extent report
	}
	
	/**
	 * By using this method we can take screenshot of an WebElement.
	 * @param element
	 * @param ScreenshotName
	 * @return
	 * @throws Throwable
	 */
	public String takeScreenShotsOfAnElement(WebElement element,String ScreenshotName) throws Throwable {
		//TakesScreenshot ts = (TakesScreenshot)element;
						//	or	//
		
		File temp = element.getScreenshotAs(OutputType.FILE);
		JavaUtility ju=new JavaUtility();
		String dateTime = ju.modifiedDateTime();
		
		File perm=new File("./Screenshots"+dateTime+ScreenshotName+".png");
		Files.copy(temp, perm);
		
		return perm.getAbsolutePath();//extent report
	}
	
	/**
	 * By using this method we upload file by using sendKeys().
	 * @param path
	 * @param element
	 */
	public void fileUpload(String path,WebElement element) {
		File f= new File(path);
		String absPath = f.getAbsolutePath();
		element.sendKeys(absPath);
	}
	
	/**
	 * By using this method we can Scroll WebPage randomly.
	 * @param driver
	 */
	public void scrollTheWebpage(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	/**
	 * By using this method we can Scroll WebPage to a particular WebElement
	 * @param driver
	 * @param element
	 */
	public void scrollToWebpageElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
}























