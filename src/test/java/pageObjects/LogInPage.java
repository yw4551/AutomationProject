package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AllureAttachmens;
import Utils.Utils;
import io.qameta.allure.Step;

public class LogInPage extends BasePage{

	@FindBy(css = "#user-name")
	private WebElement userField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = "#login-button")
	private WebElement loginBtn;
	@FindBy(css = ".error-message-container.error")
	private WebElement error;
	@FindBy(css = "div.login_password > h4")
	private WebElement title;
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Fill the form and click on login btn")
	public void login(String user, String password) {
		AllureAttachmens.attachElementScreenshot(userField);
		fillText(userField, user);
		AllureAttachmens.attachElementScreenshot(passwordField);
		fillText(passwordField, password);
		AllureAttachmens.attachElementScreenshot(loginBtn);
		click(loginBtn);
	}
	
	@Step("Check if you can login seccessfuly")
	public void seccessfulyLogIn() {
		AllureAttachmens.attachElementScreenshot(userField);
		fillText(userField, Utils.readProperty("user"));
		AllureAttachmens.attachElementScreenshot(passwordField);
		fillText(passwordField, Utils.readProperty("password"));
		AllureAttachmens.attachElementScreenshot(loginBtn);
		click(loginBtn);
	}
	
	//Validations
	@Step("Check if you get the right error")
	public String isItTheRightErrorMasege() {
		AllureAttachmens.attachElementScreenshot(error);
		String actual = getText(error);
		return actual;
	}
	
	@Step("Check if its the login page")
	public boolean isItTheLoginPage() {
		AllureAttachmens.attachElementScreenshot(title);
		return getText(title).equalsIgnoreCase("Password for all users:");
	}
	
}
