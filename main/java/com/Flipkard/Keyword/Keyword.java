/*
 * Project name: Test Automation Framework
 * Author : 
 */

package com.Flipkard.Keyword;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.Flipkard.Constant.Constant;
import com.Flipkard.CustomUtil.CustomUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Keyword extends Constant{
	/**
	 * Open specified web browser
	 * @param browserName. Browser name should only include, Chrome, Firefox, IE, HTMLUnit, Safari.No browser apart from mention is allowed.
	 */
	
	public static void openBrowser(String browserName) {

		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
			
		case "HtmlUnit":
			driver = new HtmlUnitDriver();
			break;
			
		case "Safari":
			break;
			
			default:
			System.out.println("Invalid browser name: " +browserName);
			break;
		}
	}

	/**
	 * It open the specified url in web browser recently opened by driver instance.
	 * @pa
	 * Launch URL required for the project
	 */
	public static void launchUrl(String url) {
		driver.get(url);
		System.out.println("Open URL successfully");
	}

	/**
	 * Maximize window
	 */
	public static void maximize() {
		driver.manage().window().maximize();
		System.out.println("window maximize");

	}
	/**
	 * delete cookies
	 */

	public static void deleteAllcookies() {
		driver.manage().deleteAllCookies();
		System.out.println("deleted cookies");

	}
	
	/**
	 * close Log_in Pop-up
	 */
	public static void closePopup(String locatorName) {
		// System.out.println(getWebElement(locatorName).getText());
		getWebElement(locatorName).click();
		System.out.println("Close pop-up successfully");
	}
	public static void closePopup(WebElement locator) {
		gettingWebElement(locator).click();

	}
	
	
	/**
	 * WebElementMethod
	 * 
	 * @param locatorName
	 * @return
	 */

	public static WebElement getWebElement(String locatorName) {
		String[] locator = CustomUtil.getLocatorValue(locatorName);

		String locatorType = locator[0];
		String locatorValue = locator[1];
		System.out.println(locatorValue + " " + locatorType);
		switch (locatorType) {
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));

			break;
		case "css":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;

		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "linktext":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "partiallinktext":

			break;

		default:
			System.out.println("Invalied locator found");
			break;
		}
		return element;


}
	

	/**
	 * To Enter Text field
	 */
	public static void enterText(String locatorName, String text) {
		getWebElement(locatorName).sendKeys(text);
		System.out.println("text entered");

	}
	
	/**
	 * Keys down method is used to select downward option
	 * 
	 * @param locatorName
	 */
	public static void keyDown(WebElement locator) {
		gettingWebElement(locator).sendKeys(Keys.ARROW_DOWN);
	System.out.println("Key down to select option");
	}

	public static void keyUp(WebElement locator) {
		gettingWebElement(locator).sendKeys(Keys.ARROW_UP);
		System.out.println("Key Up to select option");
	}

	/**
	 * gettingWebElement method will use for getting WebElement as argument locator
	 * 
	 * @param locator
	 * @return
	 */

	public static WebElement gettingWebElement(WebElement locator) {
		return element;
	}

	public static void keyLeft(WebElement locator) {
		gettingWebElement(locator).sendKeys(Keys.ARROW_LEFT);
		System.out.println("Keys left to selelct option");
	}

	public static void keysRight(WebElement locator) {
		gettingWebElement(locator).sendKeys(Keys.ARROW_RIGHT);
	}

	/**
	 * mouse hover only will hover mouse on required content
	 * 
	 * @param locatorName
	 */
	public static void mouseHoverOnly(String locator) {
		action = new Actions(driver);
		action.moveToElement(getWebElement(locator)).perform();
		System.out.println("It will just hover mouse");

		/*
		 * action = new Actions(driver);
		 * action.moveToElement(gettingWebElement(locator)).perform();
		 * log.info("It will just hover mouse");
		 */
	}

	/**
	 * Select By value as per requirement
	 */

	public static void selectByValue(WebElement locator, String sendvalue) {
		System.out.println(locator.getText() + " " + sendvalue);
		Select value = new Select(locator);
		value.selectByValue(sendvalue);
	}

	public static void selectByIndex(WebElement locator, int sendvalue) {
		System.out.println(locator.getText() + " " + sendvalue);
		Select value = new Select(locator);
		value.selectByIndex(sendvalue);
	}

	/**
	 * to click on required position
	 */
	public static void performClick(String locatorName) {
		getWebElement(locatorName).click();
		System.out.println("click perform");
	}

	/**
	 * search Product in searchBox
	 * 
	 * @param locatorName
	 * @param productName
	 */
	public static void searchProduct(String locatorName, String productName) {
		getWebElement(locatorName).sendKeys(productName);
		System.out.println("product search done");
	}

	/**
	 * it will hover to required element
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @throws InterruptedException 
	 */
	public static void mouseHoverClick(String locator) {
		action = new Actions(driver);
		action.moveToElement(getWebElement(locator)).click().build().perform();
		System.out.println("mouse hover and click perform");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * to click on required parameter
	 * 
	 * @param locatorName
	 */
	public static void click(String locatorName) {
		getWebElement(locatorName).click();
		System.out.println("click done ");
	}

	/**
	 * implicit wait method to apply wait
	 * 
	 * @param duration
	 */
	public static void implicitWait(int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
		System.out.println("implicit wait applied");
	}

	/**
	 * Explicit wait to provide wait
	 */
	public static void explicitWait(int duration) {
		wait = new FluentWait(driver);
		wait.withTimeout(duration, TimeUnit.SECONDS);
		System.out.println("explici wait applied");
	}
	/**
	 */

	public static void waitUntil(int duration) {
		wait = new FluentWait(driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("t-0M7P _2doH3V")));
		System.out.println("wait till expected condition");
	}

	/**
	 * get text
	 * 
	 * @param locatorName
	 * @return
	 */
	public static String getText(String locatorName) {
		return getWebElement(locatorName).getText();
	}

	/**
	 * Navigate method
	 */
	public static void navigate() {
		driver.navigate();
	}

	/**
	 * refresh method to refresh the page
	 */
	public static void refresh() {
		driver.navigate().refresh();
		System.out.println("refresh page");
	}

	/**
	 * page Scroll down
	 */
	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}
	
	
	public void takeScreenShot(String name)  {
		AShot ashot= new AShot();
		Screenshot sc= ashot.takeScreenshot(driver);
		//BufferedImage img=robo.createScreenCapture(rect);
		try {
			ImageIO.write(sc.getImage(), "PNG",new File("D:\\workspace\\javas_script_Executor\\src\\Screenshot"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * Close Window
	 */
	public static void closeBrowser() {
		driver.close();
		System.out.println("close browser successfuly");

	}

}