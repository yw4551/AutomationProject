package tests;

import static org.testng.Assert.assertTrue;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
	protected WebDriver driver;
	public String hubURL = "http://localhost:4444/wd/hub";

	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) throws MalformedURLException {
		switch(browser){
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setPlatformName("Linux");
				driver = new RemoteWebDriver(new URL(hubURL),chromeOptions);
				break;
			case "firefox":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setPlatformName("Linux");
				driver = new RemoteWebDriver(new URL(hubURL),firefoxOptions);
				break;
			case "edge":
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.setPlatformName("Linux");
				driver = new RemoteWebDriver(new URL(hubURL),edgeOptions);
				break;
		}

		driver.manage().window().maximize();
		driver.get(Utils.readProperty("URL"));
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
