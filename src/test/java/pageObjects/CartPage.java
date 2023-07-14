package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AllureAttachmens;
import io.qameta.allure.Step;

public class CartPage extends BasePage{

	@FindBy(css = ".title")
	private WebElement title;
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> listOfItems;
	@FindBy(css = ".shopping_cart_badge")
	private WebElement numOfProducts;
	@FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
	private WebElement removeBtn;
	@FindBy(css = "#continue-shopping")
	private WebElement continueShopingBtn;
	@FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
	private List<WebElement> listRemove;
	@FindBy(css = "#checkout")
	private WebElement checkout;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@Step("Remove the product from the cart")
	public void chooseAProductAndRemoveIt(String name) {
		sleep(1000);
		for (WebElement el : listOfItems) {
			if (el.getText().equalsIgnoreCase(name)) {
				AllureAttachmens.attachElementScreenshot(removeBtn);
				click(removeBtn);
			}
		}
	}

	@Step("Click on continue shoping")
	public void continueShoping() {
		AllureAttachmens.attachElementScreenshot(continueShopingBtn);
		click(continueShopingBtn);
	}

	@Step("Remove all products from the cart")
	public void removeAllProducts() {
		for (WebElement el : listRemove) {
			AllureAttachmens.attachElementScreenshot(removeBtn);
			click(el);
		}
	}

	@Step("Click on the checkout btn")
	public void checkout() {
		AllureAttachmens.attachElementScreenshot(checkout);
		click(checkout);
	}

	//Validations
	@Step("Check if its the cart page")
	public boolean isItCartPage() {
		return getText(title).equalsIgnoreCase("Your Cart");
	}

	@Step("Check if the item is in the cart")
	public boolean checkIfItemInList(String name) {
		for (WebElement el : listOfItems) {
			AllureAttachmens.attachElementScreenshot(title);
			if (el.getText().equalsIgnoreCase(name)) {
				return true;	
			}
		}
		return false;
	}

	@Step("Check if the item was removed from the cart")
	public boolean checkIfItemNotInList(String name) {
		for (WebElement el : listOfItems) {
			if (el.getText().equalsIgnoreCase(name)) {
				return false;
			}
		}
		return true;
	}

	@Step("Check the amount of products taht are in the cart")
	public String getNumOfProductsInCart() {
		AllureAttachmens.attachElementScreenshot(numOfProducts);
		String num = numOfProducts.getText();
		return num;
	}

	@Step("Check if all the products are in the cart")
	public boolean isAlltheProductsInCart() {
		ProductsPage pp = new ProductsPage(driver);
		assertEquals(getNumOfProductsInCart(), pp.getNumOfProductsInStore());
		return true;
	}

	@Step("Check if the cart is empty")
	public boolean checkIfTheCartIsEmpty() {
		checkIfItemNotInList("Sauce Labs Backpack");
		checkIfItemNotInList("Sauce Labs Bike Light");
		checkIfItemNotInList("Sauce Labs Bolt T-Shirt");
		checkIfItemNotInList("Sauce Labs Fleece Jacket");
		checkIfItemNotInList("Sauce Labs Onesie");
		checkIfItemNotInList("Test.allTheThings() T-Shirt (Red)");
		return true;
	}

	@Step("Is there the right amount of products in the cart")
	public boolean isTheRightNumOfProductsInCart(String num) {
		assertEquals(getNumOfProductsInCart(), num);
		return true;
	}

}
