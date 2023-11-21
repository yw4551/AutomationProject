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
public class ProductsPageTest extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @Feature("Sort")
    @Owner(value = "Yitzi Weiner")
    @Story("As a user i will expect that i will be able to sort the page by different options")
    @Test(description = "Products Page")
    @Description("sort by price (low to high)")
    public void TC08() {
        LogInPage lip = new LogInPage(driver);
        ProductsPage pp = new ProductsPage(driver);

        lip.seccessfulyLogIn();
        pp.sortBy("Price (low to high)");
        assertTrue(pp.isItsortBy("Price (low to high)"));
        AllureAttachmens.addTextAttachment("Test Ended Successfully");
    }

    @Severity(SeverityLevel.MINOR)
    @Feature("Add to cart")
    @Story("As a user i will expect that i will be able to add products to the cart from the products page")
    @Owner(value = "Yitzi Weiner")
    @Test(description = "Products Page")
    @Description("Add a product to the cart from the products page")
    public void TC09() {
        ProductsPage pp = new ProductsPage(driver);
        CartPage cp = new CartPage(driver);

        pp.getProductFromListAndAddIt("Sauce Labs Bolt T-Shirt");
        pp.openCart();
        assertTrue(cp.checkIfItemInList("Sauce Labs Bolt T-Shirt"));

        cp.continueShoping();
        AllureAttachmens.addTextAttachment("Test Ended Successfully");
    }

    @Severity(SeverityLevel.MINOR)
    @Feature("Remove from cart")
    @Story("As a user i will expect that i will be able to remove products from the cart in the products page")
    @Owner(value = "Yitzi Weiner")
    @Test(description = "Products Page")
    @Description("Remove product from products page")
    public void TC12() {
        ProductsPage pp = new ProductsPage(driver);
        CartPage cp = new CartPage(driver);

        pp.getProductFromListAndRemoveIt("Sauce Labs Bolt T-Shirt");
        pp.openEmptyCart();
        assertTrue(cp.checkIfItemNotInList("Sauce Labs Bolt T-Shirt"));

        cp.continueShoping();
        AllureAttachmens.addTextAttachment("Test Ended Successfully");
    }

    @Severity(SeverityLevel.MINOR)
    @Feature("Add to cart")
    @Story("As a user i will expect that i will be able to add products to the cart from the products page")
    @Owner(value = "Yitzi Weiner")
    @Test(description = "Products Page")
    @Description("Add 2 products to the cart from the products page")
    public void TC10() {
        ProductsPage pp = new ProductsPage(driver);
        CartPage cp = new CartPage(driver);

        pp.getProductFromListAndAddIt("Sauce Labs Onesie");
        pp.getProductFromListAndAddIt("Sauce Labs Bike Light");
        pp.openCart();
        assertTrue(cp.checkIfItemInList("Sauce Labs Onesie"));
        assertTrue(cp.checkIfItemInList("Sauce Labs Bike Light"));

        cp.continueShoping();
        AllureAttachmens.addTextAttachment("Test Ended Successfully");
    }

    @Severity(SeverityLevel.MINOR)
    @Feature("Remove from cart")
    @Story("As a user i will expect that i will be able to remove products from the cart in the products page")
    @Owner(value = "Yitzi Weiner")
    @Test(description = "Products page")
    @Description("Remove 2 products from products page")
    public void TC13() {
        ProductsPage pp = new ProductsPage(driver);
        CartPage cp = new CartPage(driver);

        pp.getProductFromListAndRemoveIt("Sauce Labs Onesie");
        pp.getProductFromListAndRemoveIt("Sauce Labs Bike Light");
        pp.openEmptyCart();
        assertTrue(cp.checkIfItemNotInList("Sauce Labs Onesie"));
        assertTrue(cp.checkIfItemNotInList("Sauce Labs Bike Light"));

        cp.continueShoping();
        AllureAttachmens.addTextAttachment("Test Ended Successfully");
    }

    @Severity(SeverityLevel.MINOR)
    @Feature("Add to cart")
    @Story("As a user i will expect that i will be able to add all products to the cart from the products page")
    @Owner(value = "Yitzi Weiner")
    @Test(description = "Products Page")
    @Description("Add all products to the cart from the products page")
    public void TC11() {
        ProductsPage pp = new ProductsPage(driver);
        CartPage cp = new CartPage(driver);

        pp.addAllProducts();
        pp.openCart();
        assertTrue(cp.isAlltheProductsInCart());
        AllureAttachmens.addTextAttachment("Test Ended Successfully");
    }


    @Severity(SeverityLevel.MINOR)
    @Feature("Remove from cart")
    @Story("As a user i will expect that i will be able to remove products from the cart in the products page")
    @Owner(value = "Yitzi Weiner")
    @Test(description = "Products Page")
    @Description("Remove all products from products page")
    public void TC14() {
        ProductsPage pp = new ProductsPage(driver);
        CartPage cp = new CartPage(driver);

        pp.removeAllProductsFromTheCart();
        pp.openEmptyCart();
        assertTrue(cp.checkIfTheCartIsEmpty());
        AllureAttachmens.addTextAttachment("Test Ended Successfully");
    }

}
