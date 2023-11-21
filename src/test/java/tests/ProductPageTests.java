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
import pageObjects.ProductPage;
import pageObjects.ProductsPage;

@Epic("Product Page")
public class ProductPageTests extends BaseTest{

	@Severity(SeverityLevel.MINOR)
	@Feature("Add to cart")
	@Story("As a user i will expect that i will be able to add products to the cart from the product page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Product page")
	@Description("Add a product to the cart from product page")
	public void TC15() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		ProductPage prp = new ProductPage(driver);
		CartPage cp = new CartPage(driver);
		
		lip.seccessfulyLogIn();
		pp.chooseAProductAndOpenIt("Sauce Labs Bolt T-Shirt");
		prp.addToBtn();
		pp.openCart();
		assertTrue(cp.checkIfItemInList("Sauce Labs Bolt T-Shirt"));

		cp.continueShoping();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Feature("Remove from cart")
	@Story("As a user i will expect that i will be able to remove products from the cart in the product page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Product page")
	@Description("Remove product frome product page")
	public void TC16() {
		ProductsPage pp = new ProductsPage(driver);
		ProductPage prp = new ProductPage(driver);
		CartPage cp = new CartPage(driver);

		pp.chooseAProductAndOpenIt("Sauce Labs Bolt T-Shirt");
		prp.removeBtn();
		pp.openEmptyCart();
		assertTrue(cp.checkIfItemNotInList("Sauce Labs Bolt T-Shirt"));

		cp.continueShoping();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Feature("Add to cart")
	@Story("As a user i will expect that i will be able to add products to the cart from the product page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Product page")
	@Description("Add 2 products to the cart from product page")
	public void TC17() {
		ProductsPage pp = new ProductsPage(driver);
		ProductPage prp = new ProductPage(driver);
		CartPage cp = new CartPage(driver);

		pp.chooseAProductAndOpenIt("Sauce Labs Fleece Jacket");
		prp.addToBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Bike Light");
		prp.addToBtn();
		pp.openCart();
		assertTrue(cp.checkIfItemInList("Sauce Labs Fleece Jacket"));
		assertTrue(cp.checkIfItemInList("Sauce Labs Bike Light"));

		cp.continueShoping();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Feature("Remove from cart")
	@Story("As a user i will expect that i will be able to remove products from the cart in the product page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Product page")
	@Description("Remove 2 products from product page")
	public void TC18() {
		ProductsPage pp = new ProductsPage(driver);
		ProductPage prp = new ProductPage(driver);
		CartPage cp = new CartPage(driver);

		pp.chooseAProductAndOpenIt("Sauce Labs Fleece Jacket");
		prp.removeBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Bike Light");
		prp.removeBtn();
		pp.openEmptyCart();
		assertTrue(cp.checkIfItemNotInList("Sauce Labs Fleece Jacket"));
		assertTrue(cp.checkIfItemNotInList("Sauce Labs Bike Light"));

		cp.continueShoping();
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Feature("Add all to cart")
	@Story("As a user i will expect that i will be able to add all products to the cart from the product page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Product page")
	@Description("Add all products to the cart from product page")
	public void TC19() {
		ProductsPage pp = new ProductsPage(driver);
		ProductPage prp = new ProductPage(driver);
		CartPage cp = new CartPage(driver);

		prp.addAllProducts();
		pp.openCart();
		assertTrue(cp.isAlltheProductsInCart());
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Feature("Remove from cart")
	@Story("As a user i will expect that i will be able to remove products from the cart in the product page")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Product page")
	@Description("Remove all products frome product page")
	public void TC20() {
		ProductsPage pp = new ProductsPage(driver);
		ProductPage prp = new ProductPage(driver);
		CartPage cp = new CartPage(driver);

		prp.removeAllProducs();
		pp.openEmptyCart();
		assertTrue(cp.checkIfTheCartIsEmpty());
		AllureAttachmens.addTextAttachment("Test Ended Successfully");
	}
	
}
