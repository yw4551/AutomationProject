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
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LogInPage;
import pageObjects.OverviewPage;
import pageObjects.ProductsPage;
import pageObjects.ThanksPage;

@Epic("Overview Page")
public class OverviewPageTests extends BaseTest{

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Finish")
	@Story("As a user i will expect that i can complite the order")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Overview Page")
	@Description("Finish the order")
	public void TC31() {
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
		chp.fiilForm("Yitzi", "Weiner", "00000");
		chp.clickContinue();
		op.clickFinish();
		assertTrue(tp.isItThanksPage());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Finish")
	@Story("As a user i will expect that i can complite the order")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Overview Page")
	@Description("Cancel the order")
	public void TC32() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage chp = new CheckoutPage(driver);
		OverviewPage op = new OverviewPage(driver);
		
		lip.seccessfulyLogIn();
		pp.getProductFromListAndAddIt("Sauce Labs Bolt T-Shirt");
		pp.openCart();
		cp.checkout();
		chp.fiilForm("Yitzi", "Weiner", "00000");
		chp.clickContinue();
		op.clickCancal();
		assertTrue(pp.isItTheProductsPage());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}
	
}
