package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AllureAttachmens;
import io.qameta.allure.Step;

public class OverviewPage extends BasePage{

	@FindBy(css = ".title")
	private WebElement title;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;
	@FindBy(css = "#finish")
	private WebElement finishBtn;
	
	public OverviewPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Click on cancel btn")
	public void clickCancal() {
		AllureAttachmens.attachElementScreenshot(cancelBtn);
		click(cancelBtn);
	}
	
	@Step("Click on finish btn")
	public void clickFinish() {
		AllureAttachmens.attachElementScreenshot(finishBtn);
		click(finishBtn);
	}
	
	//Validations
	@Step("Check if its the over view page")
	public boolean isItTheOverviewPage() {
		AllureAttachmens.attachElementScreenshot(title);
		return getText(title).equalsIgnoreCase("Checkout: Overview");
	}

}
