package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utils.AllureAttachmens;
import io.qameta.allure.Step;

public class ProductsPage extends BasePage{

	@FindBy(css = "[class='title']")
	private WebElement title;
	@FindBy(css = ".product_sort_container")
	private WebElement sortMenu;
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
	private WebElement addToCartBtn;
	@FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
	private WebElement removeBtn;
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> listOfProducts;
	@FindBy(css = ".shopping_cart_badge")
	private WebElement cartPage;
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
	private List<WebElement> addToCartList;
	@FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
	private List<WebElement> removeAll;
	@FindBy(css = ".shopping_cart_link")
	private WebElement emptyCart;
	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuBtn;
	@FindBy(css = ".active_option")
	private WebElement sortBy;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("add a product to cart")
	public void getProductFromListAndAddIt(String productName) {
		sleep(1000);
		String id = "add-to-cart-" + productName.replace(" ", "-");
        WebElement addToCartBtn = driver.findElement(By.id(id.toLowerCase()));
        AllureAttachmens.attachElementScreenshot(addToCartBtn);
        click(addToCartBtn);
	}
	
	@Step("Click on the open cart btn")
	public void openCart() {
		AllureAttachmens.attachElementScreenshot(cartPage);
		click(cartPage);
		sleep(1000);
	}
	
	@Step("Add all products to cart")
	public void addAllProducts() {
		for (WebElement el : addToCartList) {
			click(el);
		}
	}

	@Step("Check how many products we have")
	public void getNumOfProdducts() {
		for (int i = 0; i < listOfProducts.size(); i++) {
			System.out.println(i);
		}
	}
	
	@Step("Remove a product to the cart")
	public void getProductFromListAndRemoveIt(String productName) {
		String id = "remove-" + productName.replace(" ", "-");
        WebElement removeBtn = driver.findElement(By.id(id.toLowerCase()));
        AllureAttachmens.attachElementScreenshot(removeBtn);
        click(removeBtn);
	}
	
	@Step("Remove all products from the cart")
	public void removeAllProductsFromTheCart() {
		for (WebElement el : removeAll) {
			click(el);
		}
	}
	
	@Step("Click on the cart btn")
	public void openEmptyCart() {
		AllureAttachmens.attachElementScreenshot(emptyCart);
		click(emptyCart);
	}
	
	@Step("Open a product page")
	public void chooseAProductAndOpenIt(String name) {
		for (WebElement el : listOfProducts) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}
	
	@Step("Open the menu")
	public void openMenu() {
		AllureAttachmens.attachElementScreenshot(menuBtn);
		click(menuBtn);
		sleep(1000);
	}
	
	@Step("Sort the list")
	public void sortBy(String sortBy) {
		AllureAttachmens.attachElementScreenshot(sortMenu);
		Select s = new Select(sortMenu);
		s.selectByVisibleText(sortBy);
	}
	
	//Validations
	@Step("Check if its the products page")
	public boolean isItTheProductsPage() {
		AllureAttachmens.attachElementScreenshot(title);
		return getText(title).equalsIgnoreCase("products");
	}
	
	@Step("Check if the menu is closed")
	public boolean isTheMenuClosed() {
		AllureAttachmens.attachElementScreenshot(title);
		return getText(title).equalsIgnoreCase("Products");
	}
	
	@Step("Check if its sort by...")
	public boolean isItsortBy(String sort) {
		AllureAttachmens.attachElementScreenshot(sortBy);
		return getText(sortBy).equalsIgnoreCase(sort);
	}
	
	@Step("Check how meny products are in the store")
	public String getNumOfProductsInStore() {
		int num = listOfProducts.size();
		return Integer.toString(num);
	}
	
}
