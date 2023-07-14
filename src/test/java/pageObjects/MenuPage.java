package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AllureAttachmens;
import io.qameta.allure.Step;

public class MenuPage extends BasePage{

	@FindBy(css = "#inventory_sidebar_link")
	private WebElement allItems;
	@FindBy(css = "#about_sidebar_link")
	private WebElement about;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logout;
	@FindBy(css = "#react-burger-cross-btn")
	private WebElement closeMenu;
	
	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Close the menu")
	public void closeMenu() {
		AllureAttachmens.attachElementScreenshot(closeMenu);
		click(closeMenu);
	}
	
	@Step("Click on about")
	public void clickAbout() {
		AllureAttachmens.attachElementScreenshot(about);
		click(about);
		sleep(1000);
	}
	
	@Step("Click on logout")
	public void clickLogout() {
		AllureAttachmens.attachElementScreenshot(logout);
		click(logout);
	}
	
	@Step("Click on all itens")
	public void clickAllItems() {
		AllureAttachmens.attachElementScreenshot(allItems);
		click(allItems);
	}
	
	//Validations
	@Step("Check if the menu is opend")
	public boolean isTheMenuOPened() {
		AllureAttachmens.attachElementScreenshot(about);
		return getText(about).equalsIgnoreCase("About");
	}

}
