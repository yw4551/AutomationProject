package tests;

import org.testng.annotations.Test;

import Utils.AllureAttachmens;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LogInPage;
import pageObjects.OverviewPage;
import pageObjects.ProductsPage;
import pageObjects.ThanksPage;

@Epic("Thanks Page")
public class ThanksPageTests extends BaseTest{

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Message")
	@Story("As a user i will expect to get a thanks message")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Thank You Page")
	@Description("Check if you get the thanks massage")
	public void TC33() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage chp = new CheckoutPage(driver);
		OverviewPage op = new OverviewPage(driver);
		ThanksPage tp = new ThanksPage(driver);
		
		lip.seccessfulyLogIn();
		pp.getProductFromListAndAddIt("Sauce Labs Bolt T-Shirt");
		pp.openCart();
		cp.checkout();
		chp.SuccessfullyForm();
		chp.clickContinue();
		op.clickFinish();
		tp.isItTheRightMesege();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Go Back")
	@Story("As a user i will expect that i will be able to go back to the products page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Thank You Page")
	@Description("Check if you could go back")
	public void TC34() {
		ProductsPage pp = new ProductsPage(driver);
		ThanksPage tp = new ThanksPage(driver);

		tp.goBack();
		pp.isItTheProductsPage();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Go Back")
	@Story("As a user i will expect that i will be able to replace a new order")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Thank You Page")
	@Description("Check if you could replace another order")
	public void TC35() {
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage chp = new CheckoutPage(driver);
		OverviewPage op = new OverviewPage(driver);
		ThanksPage tp = new ThanksPage(driver);

		pp.getProductFromListAndAddIt("Sauce Labs Bolt T-Shirt");
		pp.openCart();
		cp.checkout();
		chp.SuccessfullyForm();
		chp.clickContinue();
		op.clickFinish();
		tp.goBack();
		pp.getProductFromListAndAddIt("Sauce Labs Bolt T-Shirt");
		pp.openCart();
		cp.checkout();
		chp.fillForm("Yitzi", "Weiner", "00000");
		chp.clickContinue();
		op.clickFinish();
		tp.isItThanksPage();
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}
	
}
