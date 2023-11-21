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
import pageObjects.ProductsPage;

@Epic("Cart Page")
public class CartPageTests extends BaseTest{
	
	@Severity(SeverityLevel.MINOR)
	@Feature("Remove products from the cart")
	@Story("As a user i will expect to remove a product from the cart")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Cart Page")
	@Description("Remove product from the cart page")
	public void TC21() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		
		lip.seccessfulyLogIn();
		pp.getProductFromListAndAddIt("Sauce Labs Bolt T-Shirt");
		pp.openCart();
		cp.checkIfItemInList("Sauce Labs Bolt T-Shirt");
		cp.chooseAProductAndRemoveIt("Sauce Labs Bolt T-Shirt");
		pp.assertTrue(cp.checkIfItemNotInList("Sauce Labs Bolt T-Shirt"));

		cp.continueShoping();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Feature("Remove products from the cart")
	@Story("As a user i will expect that i will be able to remove 2 products from the cart")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Cart Page")
	@Description("Remove 2 products from the cart page")
	public void TC22() {
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);

		pp.getProductFromListAndAddIt("Sauce Labs Bike Light");
		pp.getProductFromListAndAddIt("Sauce Labs Fleece Jacket");
		pp.openCart();
		cp.checkIfItemInList("Sauce Labs Bike Light");
		cp.checkIfItemInList("Sauce Labs Fleece Jacket");
		cp.chooseAProductAndRemoveIt("Sauce Labs Bike Light");
		cp.chooseAProductAndRemoveIt("Sauce Labs Fleece Jacket");
		pp.assertTrue(cp.checkIfTheCartIsEmpty());

		cp.continueShoping();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Feature("Remove products from the cart")
	@Story("ASa user i will expect that i will be able to empty the cart from all products")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Cart Page")
	@Description("Remove all products from the cart page")
	public void TC23() {
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);

		pp.addAllProducts();
		pp.openCart();
		cp.isAlltheProductsInCart();
		cp.removeAllProducts();
		pp.assertTrue(cp.checkIfTheCartIsEmpty());

		cp.continueShoping();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Continue Shopping")
	@Story("As a user i will expect that ill be able to go back and continue shopping")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Cart Page")
	@Description("Add a product after opening the cart")
	public void TC24() {
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);

		pp.getProductFromListAndAddIt("Sauce Labs Bolt T-Shirt");
		pp.openCart();
		cp.checkIfItemInList("Sauce Labs Bolt T-Shirt");
		cp.continueShoping();
		pp.getProductFromListAndAddIt("Sauce Labs Fleece Jacket");
		pp.openCart();
		cp.checkIfItemInList("Sauce Labs Fleece Jacket");
		pp.assertTrue(cp.isTheRightNumOfProductsInCart("2"));
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Feature("Checkout")
	@Story("As a user i will want that i will ce able to checkout")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Cart page")
	@Description("Checkout")
	public void TC25() {
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage chp = new CheckoutPage(driver);

		cp.checkout();
		pp.assertTrue(chp.isItTheinfoPage());
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
}
