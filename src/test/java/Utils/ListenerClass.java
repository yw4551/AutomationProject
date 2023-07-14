package Utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerClass extends TestListenerAdapter{

	@Override
	public void onTestFailure(ITestResult result) {
		Object webDriverAttribute = result.getTestContext().getAttribute("WebDriver");
		if (webDriverAttribute instanceof WebDriver) {
			AllureAttachmens.attachScreenshot((WebDriver) webDriverAttribute);
		}
		if (webDriverAttribute instanceof WebDriver) {
			AllureAttachmens.getPageSource((WebDriver) webDriverAttribute);
		}
		if (webDriverAttribute instanceof WebDriver) {
			AllureAttachmens.attachConsoleLogs((WebDriver) webDriverAttribute);
		}
	}

}
