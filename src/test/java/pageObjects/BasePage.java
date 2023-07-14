package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage {
	WebDriver driver;
	private Actions actions;
	JavascriptExecutor js;
	
	public  BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void fillText(WebElement el, String text) {
		highlightElement(el, "green");
		el.clear();
		el.sendKeys(text);
		sleep(500);
	}
	
	public void click(WebElement el) {
		highlightElement(el, "yellow");
		sleep(500);
		el.click();
	}
	
	public void moveTo(WebElement el) {
		highlightElement(el, "green");
		actions.moveToElement(el).build().perform();
	}
	
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getText(WebElement el) {
		highlightElement(el, "green");
		String result = el.getText();
		return result;
	}
	
	private void highlightElement(WebElement element, String color) {
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:yellow; border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}
	
	public void assertEqwals(String expected, String actual) {
		assertEqwals(expected, actual);
	}
	
	public void assertTrue(boolean expected) {
		Assert.assertTrue(expected);
	}
	
}
