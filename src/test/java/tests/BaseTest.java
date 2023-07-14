package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import Utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	protected TakesScreenshot ts;

	@BeforeSuite
	void setAllureEnvironment() {
		allureEnvironmentWriter(
				ImmutableMap.<String, String>builder()
				.put("Browser", "Chrome")
				.put("Browser.Version", "114.0.5735.199")
				.put("URL", "https://www.saucedemo.com/")
				.build());
	}

	@Test
	void myTest() {
		assertTrue(true);
	}

	@BeforeMethod
	protected void setup(ITestContext testContext) throws InterruptedException {
		driver = WebDriverManager.chromedriver().create();
		testContext.setAttribute("WebDriver", this.driver);
		driver.manage().window().maximize();
		driver.get(Utils.readProperty("URL"));
		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
