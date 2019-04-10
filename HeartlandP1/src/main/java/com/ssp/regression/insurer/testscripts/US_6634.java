package com.ssp.regression.insurer.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.BaseTest;
import com.ssp.support.Log;
import com.ssp.support.WebDriverFactory;
import com.ssp.utils.DataProviderUtils;
import com.ssp.uxp_pages.GetTestData;

// TODO: Auto-generated Javadoc
/**
 * The Class US_6634.
 */
@Listeners(com.ssp.support.ListenerTest.class)
public class US_6634 extends BaseTest {

	/** The mode. */
	private String webSite, mode;
	
	/** The feature id. */
	private String featureId = this.getClass().getSimpleName() + "_";
	
	/** The driver. */
	private WebDriver driver = null;

	/**
	 * Inits the.
	 *
	 * @param context the context
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@BeforeMethod(alwaysRun = true)
	public void init(ITestContext context) throws IOException {
		webSite = System.getProperty("webSite") != null ? System.getProperty("webSite")
				: context.getCurrentXmlTest().getParameter("webSite");
		mode = context.getCurrentXmlTest().getParameter("mode");
	}

	/**
	 * Tc 6634 6704 01.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "To Validate that the Finance search transaction screen columns name are similar to the columns which are selected at Select columns button", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC_6634_6704_01(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData("CreateClientAndPolicy_", tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
			driver.get(webSite);
			// The below step is to create the policy
			testCaseSteps(driver, tcId, browser, mode, testDataConfig, extentedReport);
			testDataConfig = new GetTestData(featureId, tcId);
			// The below step is to do the test case execution after creating
			// the policy
			testCaseSteps(driver, tcId, browser, mode, testDataConfig, extentedReport);
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);
		}
	}

	/**
	 * Tc 6634 6704 02.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "To Validate that the Finance search transaction screen columns values are correct", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider", dependsOnMethods = "TC_6634_6704_01")
	public void TC_6634_6704_02(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData("CreateClientAndPolicy_", tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
			driver.get(webSite);
			// The below step is to create the policy
			testCaseSteps(driver, tcId, browser, mode, testDataConfig, extentedReport);
			testDataConfig = new GetTestData(featureId, tcId);
			// The below step is to do the test case execution after creating
			// the policy
			testCaseSteps(driver, tcId, browser, mode, testDataConfig, extentedReport);
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);
		}
	}

	/**
	 * Close browser.
	 */
	@AfterClass
	public void closeBrowser() {
		if (driver != null)
			driver.quit();
	}
}