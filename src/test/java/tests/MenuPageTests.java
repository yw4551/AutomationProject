package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Utils.AllureAttachmens;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.AboutPage;
import pageObjects.LogInPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;

@Epic("Menu Page")
public class MenuPageTests extends BaseTest{

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Menu")
	@Story("As a user i will expect that i will be able to open the menu")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Menu Page")
	@Description("Open menu")
	public void TC36() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		MenuPage mp = new MenuPage(driver);
		
		lip.seccessfulyLogIn();
		pp.openMenu();
		assertTrue(mp.isTheMenuOPened());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Menu")
	@Story("As a user i will expect that i will be able to close the menu")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Menu Page")
	@Description("Close menu")
	public void TC37() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		MenuPage mp = new MenuPage(driver);
		
		lip.seccessfulyLogIn();
		pp.openMenu();
		mp.closeMenu();
		assertTrue(pp.isTheMenuClosed());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Menu options")
	@Story("As a user i will expect that i will be able to open the about page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Menu Page")
	@Description("About option")
	public void TC38() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		MenuPage mp = new MenuPage(driver);
		AboutPage ap = new AboutPage(driver);
		
		lip.seccessfulyLogIn();
		pp.openMenu();
		mp.clickAbout();
		assertTrue(ap.isItTheAboutPage());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Menu options")
	@Story("As a user i will expect that i will be able to logout")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Menu Page")
	@Description("Logout option")
	public void TC39() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		MenuPage mp = new MenuPage(driver);
		
		lip.seccessfulyLogIn();
		pp.openMenu();
		mp.clickLogout();
		assertTrue(lip.isItTheLoginPage());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Menu options")
	@Story("As a user i will expect that i will be able to open the all items page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Menu Page")
	@Description("All items option")
	public void TC40() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		MenuPage mp = new MenuPage(driver);
		
		lip.seccessfulyLogIn();
		pp.chooseAProductAndOpenIt("Sauce Labs Bike Light");
		pp.openMenu();
		mp.clickAllItems();
		assertTrue(pp.isItTheProductsPage());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}
	
}
