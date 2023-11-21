package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AllureAttachmens;
import io.qameta.allure.Step;

public class CheckoutPage extends BasePage{

	@FindBy(css = ".title")
	private WebElement title;
	@FindBy(css = "#first-name")
	private WebElement firstNameField;
	@FindBy(css = "#last-name")
	private WebElement lastNameField;
	@FindBy(css = "#postal-code")
	private WebElement zipCodeField;
	@FindBy(css = "#continue")
	private WebElement continueBtn;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;
	@FindBy(css = "[data-test='error']")
	private WebElement error;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Fill the form")
	public void fillForm(String first, String last, String zip) {
		AllureAttachmens.attachElementScreenshot(firstNameField);
		fillText(firstNameField, first);
		AllureAttachmens.attachElementScreenshot(lastNameField);
		fillText(lastNameField, last);
		AllureAttachmens.attachElementScreenshot(zipCodeField);
		fillText(zipCodeField, zip);
	}

	@Step("Fill the form")
	public void SuccessfullyForm (){
		AllureAttachmens.attachElementScreenshot(firstNameField);
		fillText(firstNameField, "Yitzi");
		AllureAttachmens.attachElementScreenshot(lastNameField);
		fillText(lastNameField, "Weiner");
		AllureAttachmens.attachElementScreenshot(zipCodeField);
		fillText(zipCodeField, "00000");
	}

	@Step("Click on the continue btn")
	public void clickContinue() {
		AllureAttachmens.attachElementScreenshot(continueBtn);
		click(continueBtn);
	}
	
	@Step("Click on the cancel btn")
	public void clickCancel() {
		AllureAttachmens.attachElementScreenshot(cancelBtn);
		click(cancelBtn);
	}
	
	//Validations
	@Step("Check if its the info page")
	public boolean isItTheinfoPage() {
		AllureAttachmens.attachElementScreenshot(title);
		return getText(title).equalsIgnoreCase("Checkout: Your Information");
	}
	
	@Step("Check if you get the right error")
	public String isItTheRightError() {
		String actual = getText(error);
		AllureAttachmens.attachElementScreenshot(error);
		return actual;
	}

}
