package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AllureAttachmens;
import io.qameta.allure.Step;

public class AboutPage extends BasePage{

	@FindBy(xpath = "//*[@id=\"__next\"]/div[5]/div/div[1]/div[2]/h3")
	private WebElement title;
	
	public AboutPage(WebDriver driver) {
		super(driver);
	}
	
	//Validations
	@Step("Check if its the about page")
	public boolean isItTheAboutPage() {
		AllureAttachmens.attachElementScreenshot(title);
		return getText(title).equalsIgnoreCase("The Sauce Test Toolchain");
	}

}
