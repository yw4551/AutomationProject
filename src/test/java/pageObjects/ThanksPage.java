package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AllureAttachmens;
import io.qameta.allure.Step;

public class ThanksPage extends BasePage{

	@FindBy(css = ".title")
	private WebElement title;
	@FindBy(css = "#back-to-products")
	private WebElement goBack;
	@FindBy(css = ".complete-header")
	private WebElement thanksMsg;
	
	public ThanksPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Click on go back btn")
	public void goBack() {
		AllureAttachmens.attachElementScreenshot(goBack);
		click(goBack);
	}
	
	//Validations
	@Step("Check if its the thanks page")
	public boolean isItThanksPage() {
		AllureAttachmens.attachElementScreenshot(title);
		return getText(title).equalsIgnoreCase("Checkout: Complete!");
	}
	
	@Step("Check if you get the right error")
	public boolean isItTheRightMesege() {
		AllureAttachmens.attachElementScreenshot(thanksMsg);
		assertEquals(getText(thanksMsg), "Thank you for your order!");
		return true;
	}

}
