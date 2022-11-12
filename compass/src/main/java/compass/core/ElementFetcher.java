package compass.core;



import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import com.aventstack.extentreports.ExtentTest;

import compass.testbase.BaseTests;



public class ElementFetcher {

	/**
	 * The element element Type must be
	 *
	 * elementType elementIdentifierValue
	 */


	public WebElement getWebElement(String elementType, String elementIdentifierValue) {
		switch (elementType) {
		case "id":
			return BaseTests.driver.findElement(By.id(elementIdentifierValue));
		case "css":
			return BaseTests.driver.findElement(By.cssSelector(elementIdentifierValue));
		case "tagname":
			return BaseTests.driver.findElement(By.tagName(elementIdentifierValue));
		case "xpath":
			return BaseTests.driver.findElement(By.xpath(elementIdentifierValue));
		default:
			return null;

		}

	}

	public List<WebElement> getListOfWebElements(String elementType, String elementIdentifierValue) {
		switch (elementType) {
		case "id":
			return BaseTests.driver.findElements(By.id(elementIdentifierValue));
		case "css":
			return BaseTests.driver.findElements(By.cssSelector(elementIdentifierValue));
		case "tagname":
			return BaseTests.driver.findElements(By.tagName(elementIdentifierValue));
		case "xpath":
			return BaseTests.driver.findElements(By.xpath(elementIdentifierValue));
		default:
			return null;

		}
	}

	public String getTextByWebElement(String elementType, String elementIdentifierValue) {

		String text = getWebElement(elementType, elementIdentifierValue).getText();
		return text;
	}

	public void mouseHoverAction(String elementType, String elementIdentifierValue) {
		Actions actions = new Actions(BaseTests.driver);
		actions.moveToElement(getWebElement(elementType, elementIdentifierValue)).build().perform();
	}

	public void moveToElementAndClickAction(String elementType, String elementIdentifierValue) {
		Actions actions = new Actions(BaseTests.driver);
		actions.moveToElement(getWebElement(elementType, elementIdentifierValue)).click().build().perform();
	}

	public <T> void verify(T actualResult, T expectedResult, String message) {
		
		Assert.assertEquals(actualResult, expectedResult, message);
	}
	
	public boolean doesElementExists(String elementType, String elementIdentifierValue) {
	 boolean exists=	getWebElement(elementType, elementIdentifierValue)!=null;
	 return exists;
	}
	

	public void scrollDownByJavaScript(String elementType, String elementIdentifierValue) {

		String msg = "Scrolling to element by JavaScript";
		System.out.println(msg);
		WebElement element = getWebElement(elementType, elementIdentifierValue);

		((JavascriptExecutor) BaseTests.driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

}