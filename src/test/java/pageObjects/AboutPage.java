package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AllureAttachmens;
import io.qameta.allure.Step;

public class AboutPage extends BasePage{

	@FindBy(css = ".MuiTypography-body1.css-sere2z")
	private WebElement title;
	
	public AboutPage(WebDriver driver) {
		super(driver);
	}
	
	//Validations
	@Step("Check if its the about page")
	public boolean isItTheAboutPage() {
		AllureAttachmens.attachElementScreenshot(title);
		return getText(title).equalsIgnoreCase("The world relies on your code. Test on thousands of device, browser, and OS configurations – anywhere, any time.");
	}

}
