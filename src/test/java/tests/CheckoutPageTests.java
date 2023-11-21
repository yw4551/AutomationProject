package tests;

import static org.testng.Assert.assertEquals;
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
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LogInPage;
import pageObjects.OverviewPage;
import pageObjects.ProductsPage;

@Epic("Checkout Page")
public class CheckoutPageTests extends BaseTest{

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Form")
	@Story("As a user i will want to have the option to fill in my details")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Checkout Page")
	@Description("Fill the form")
	public void TC26() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage chp = new CheckoutPage(driver);
		OverviewPage op = new OverviewPage(driver);
		
		lip.seccessfulyLogIn();
		pp.getProductFromListAndAddIt("Sauce Labs Bolt T-Shirt");
		pp.openCart();
		cp.checkout();
		chp.SuccessfullyForm();
		chp.clickContinue();
		pp.assertTrue(op.isItTheOverviewPage());

		chp.clickCancel();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Form")
	@Story("As a user i will expect that i will get an error that will lead my to the error")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Checkout page")
	@Description("Fill the form and leave the first name empty")
	public void TC27() {
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage chp = new CheckoutPage(driver);

		pp.openCart();
		cp.checkout();
		chp.fillForm("", "Weiner", "00000");
		chp.clickContinue();
		assertEquals("Error: First Name is required", chp.isItTheRightError());

		chp.clickCancel();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Form")
	@Story("As a user i will expect that i will get an error that will lead my to the error")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Checkout Page")
	@Description("Fill the form and leave the last name empty")
	public void TC28() {
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage chp = new CheckoutPage(driver);

		pp.openCart();
		cp.checkout();
		chp.fillForm("Yitzi", "", "00000");
		chp.clickContinue();
		assertEquals("Error: Last Name is required", chp.isItTheRightError());

		chp.clickCancel();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Form")
	@Story("As a user i will expect that i will get an error that will lead my to the error")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Checkout Page")
	@Description("Fill the form and leave the zip code empty")
	public void TC29() {
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage chp = new CheckoutPage(driver);

		pp.openCart();
		cp.checkout();
		chp.fillForm("Yitzi", "Weiner", "");
		chp.clickContinue();
		assertEquals("Error: Postal Code is required", chp.isItTheRightError());

		chp.clickCancel();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Cancel the order")
	@Story("As a user i will expect that i will be able to cancel the order and go back to products page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Checkout Page")
	@Description("Cancel the order")
	public void TC30() {
		ProductsPage pp = new ProductsPage(driver);
		CheckoutPage chp = new CheckoutPage(driver);
		CartPage cp = new CartPage(driver);

		pp.openCart();
		cp.checkout();
		chp.fillForm("Yitzi", "Weiner", "00000");
		chp.clickCancel();
		assertTrue(cp.isItCartPage());
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
}
