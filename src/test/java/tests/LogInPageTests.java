package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.AllureAttachmens;
import Utils.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.LogInPage;
import pageObjects.ProductsPage;

@Epic("Login Page")
public class LogInPageTests extends BaseTest{

	@Severity(SeverityLevel.BLOCKER)
	@Feature("Log in")
	@Story("As a user i will like to log in to the site seccssfuly")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Login Page")
	@Description("Log in with correct User and Password")
	public void TC01() {
		LogInPage lip = new LogInPage(driver);
		ProductsPage pp = new ProductsPage(driver);

		lip.seccessfulyLogIn();
		assertTrue(pp.isItTheProductsPage());
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Log in")
	@Story("As a user i will expect that i will get an error that will lead my to the error")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Login Page")
	@Description("Log in with empty Username")
	public void TC02() {
		LogInPage lip = new LogInPage(driver);

		lip.login("", Utils.readProperty("password"));
		assertEquals(lip.isItTheRightErrorMasege(), "Epic sadface: Username is required");
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Log in")
	@Story("As a user i will expect that i will get an error that will lead my to the error")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Login Page")
	@Description("Log in with empty Password")
	public void TC03() {
		LogInPage lip = new LogInPage(driver);

		lip.login(Utils.readProperty("user"), "");
		assertEquals(lip.isItTheRightErrorMasege(), "Epic sadface: Password is required");
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Log in")
	@Story("As a user i will expect that i will get an error that will lead my to the error")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Login Page")
	@Description("Log in with wrong Username")
	public void TC04() {
		LogInPage lip = new LogInPage(driver);

		lip.login("Yitzi weiner", Utils.readProperty("password"));
		assertEquals(lip.isItTheRightErrorMasege(), "Epic sadface: Username and password do not match any user in this service");
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Log in")
	@Story("As a user i will expect that i will get an error that will lead my to the error")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Login Page")
	@Description("Log in with wrong Password")
	public void TC05() {
		LogInPage lip = new LogInPage(driver);

		lip.login(Utils.readProperty("user"), "123456");
		assertEquals(lip.isItTheRightErrorMasege(), "Epic sadface: Username and password do not match any user in this service");
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Log in")
	@Story("As a user i will expect that i will get an error that will lead my to the error")
	@Owner(value = "Yitzi Weiner")
	@Test(description = "Login Page")
	@Description("Log in with the wrong user and password")
	public void TC06() {
		LogInPage lip = new LogInPage(driver);

		lip.login("Yitzi Weiner", "123456");
		assertEquals(lip.isItTheRightErrorMasege(), "Epic sadface: Username and password do not match any user in this service");
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Feature("Log in")
	@Story("An example of all the tests in the page in one test")
	@Owner(value = "Yitzi Weiner")
	@Test(dataProvider = "getData", description = "Login Page")
	@Description("DDB test")
	public void TC07(String user, String password) {
		LogInPage lip = new LogInPage(driver);
		
		lip.login(user, password);
		AllureAttachmens.addTextAttachment("Test Ended Seccessfuly");
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{Utils.readProperty("user"), Utils.readProperty("password")},
				{"", Utils.readProperty("password")},
				{Utils.readProperty("user"), ""},
				{Utils.readProperty("user"), "1234"},
				{"Yitzi", Utils.readProperty("password")},
				{"Yitzi Weiner", "123456"}
		};
		return myData;
	}
}
