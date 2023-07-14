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
import pageObjects.LogInPage;
import pageObjects.ProductsPage;

@Epic("Products Page")
public class ProductsPageTest extends BaseTest{

	@Severity(SeverityLevel.MINOR)
	@Feature("Sort")
	@Owner(value = "Yitzi Weiner")
	@Story("As a user i will expect that i will be able to sort the page by defrent options")
	@Test(description = "Products Page")
	@Description("sort by price (low to high)")
	public void TC08() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);

		lip.seccessfulyLogIn();
		pp.sortBy("Price (low to high)");
		assertTrue(pp.isItsortBy("Price (low to high)"));
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.MINOR)
	@Feature("Add to cart")
	@Story("As a user i will expect that i will be able to add products to the cart from the products page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Products Page")
	@Description("Add a product to the cart from the products page")
	public void TC09() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);

		lip.seccessfulyLogIn();
		pp.getProductFromListAndAddIt("Sauce Labs Bolt T-Shirt");
		pp.openCart();
		assertTrue(cp.checkIfItemInList("Sauce Labs Bolt T-Shirt"));
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.MINOR)
	@Feature("Add to cart")
	@Story("As a user i will expect that i will be able to add products to the cart from the products page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Products Page")
	@Description("Add 2 products to the cart from the products page")
	public void TC10() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);

		lip.seccessfulyLogIn();
		pp.getProductFromListAndAddIt("Sauce Labs Onesie");
		pp.getProductFromListAndAddIt("Sauce Labs Bike Light");
		pp.openCart();
		assertTrue(cp.checkIfItemInList("Sauce Labs Onesie"));
		assertTrue(cp.checkIfItemInList("Sauce Labs Bike Light"));
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.MINOR)
	@Feature("Add to cart")
	@Story("As a user i will expect that i will be able to add products to the cart from the products page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Products Page")
	@Description("Add all products to the cart from the products page")
	public void TC11() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);

		lip.seccessfulyLogIn();
		pp.addAllProducts();
		pp.openCart();
		assertTrue(cp.isAlltheProductsInCart());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.MINOR)
	@Feature("Remove from cart")
	@Story("As a user i will expect that i will be able to remove products from the cart in the products page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Products Page")
	@Description("Remove product frome products page")
	public void TC12() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);

		lip.seccessfulyLogIn();
		pp.getProductFromListAndAddIt("Sauce Labs Backpack");
		pp.openCart();
		cp.checkIfItemInList("Sauce Labs Backpack");
		cp.continueShoping();
		pp.getProductFromListAndRemoveIt("Sauce Labs Backpack");
		pp.openEmptyCart();
		assertTrue(cp.checkIfItemNotInList("Sauce Labs Backpack"));
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.MINOR)
	@Feature("Remove from cart")
	@Story("As a user i will expect that i will be able to remove products from the cart in the products page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Products page")
	@Description("Remove 2 products frome products page")
	public void TC13() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);

		lip.seccessfulyLogIn();
		pp.getProductFromListAndAddIt("Sauce Labs Fleece Jacket");
		pp.getProductFromListAndAddIt("Test.allTheThings() T-Shirt (Red)");
		pp.openCart();
		cp.checkIfItemInList("Sauce Labs Fleece Jacket");
		cp.checkIfItemInList("Test.allTheThings() T-Shirt (Red)");
		cp.continueShoping();
		pp.getProductFromListAndRemoveIt("Sauce Labs Fleece Jacket");
		pp.getProductFromListAndRemoveIt("Test.allTheThings() T-Shirt (Red)");
		pp.openEmptyCart();
		assertTrue(cp.checkIfItemNotInList("Sauce Labs Fleece Jacket"));
		assertTrue(cp.checkIfItemNotInList("Test.allTheThings() T-Shirt (Red)"));
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.MINOR)
	@Feature("Remove from cart")
	@Story("As a user i will expect that i will be able to remove products from the cart in the products page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Products Page")
	@Description("Remove all products frome products page")
	public void TC14() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);

		lip.seccessfulyLogIn();
		pp.addAllProducts();
		pp.openCart();
		cp.isAlltheProductsInCart();
		cp.continueShoping();
		pp.removeAllProductsFromTheCart();
		pp.openEmptyCart();
		assertTrue(cp.checkIfTheCartIsEmpty());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

}
