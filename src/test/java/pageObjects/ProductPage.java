package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.AllureAttachmens;
import io.qameta.allure.Step;

public class ProductPage extends BasePage{

	@FindBy(css = ".inventory_details_name.large_size")
	private WebElement pageTitle;
	@FindBy(css = ".btn_inventory")
	private WebElement addToCartBtn;
	@FindBy(css = ".btn_inventory")
	private WebElement removeBtn;
	@FindBy(css = "#back-to-products")
	private WebElement goBack;
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@Step("Check if its the product page that im looking for")
	public boolean isItThePage(String expected) {
		AllureAttachmens.attachElementScreenshot(pageTitle);
		String actual = pageTitle.getText();
		assertEquals(expected, actual);
		return true;
	}
	
	@Step("Click on the add to cart btn")
	public void addToBtn() {
		AllureAttachmens.attachElementScreenshot(addToCartBtn);
		click(addToCartBtn);
	}
	
	@Step("Click on the remove btn")
	public void removeBtn() {
		AllureAttachmens.attachElementScreenshot(removeBtn);
		click(removeBtn);
	}
	
	@Step("Click on the back to products page btn")
	public void backToTheProductsPage() {
		AllureAttachmens.attachElementScreenshot(goBack);
		click(goBack);
	}
	
	@Step("Add all products to cart")
	public void addAllProducts() {
		ProductsPage pp = new ProductsPage(driver);
		ProductPage prp = new ProductPage(driver);
		
		pp.chooseAProductAndOpenIt("Sauce Labs Backpack");
		prp.addToBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Bike Light");
		prp.addToBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Bolt T-Shirt");
		prp.addToBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Fleece Jacket");
		prp.addToBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Onesie");
		prp.addToBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Test.allTheThings() T-Shirt (Red)");
		prp.addToBtn();
	}
	
	@Step("Remove all products from the cart")
	public void removeAllProducs() {
		ProductsPage pp = new ProductsPage(driver);
		ProductPage prp = new ProductPage(driver);
		
		pp.chooseAProductAndOpenIt("Sauce Labs Backpack");
		prp.removeBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Bike Light");
		prp.removeBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Bolt T-Shirt");
		prp.removeBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Fleece Jacket");
		prp.removeBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Sauce Labs Onesie");
		prp.removeBtn();
		prp.backToTheProductsPage();
		pp.chooseAProductAndOpenIt("Test.allTheThings() T-Shirt (Red)");
		prp.removeBtn();
	}
	
}
