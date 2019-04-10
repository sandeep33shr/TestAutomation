package com.ssp.regression.insurer.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.BaseTest;
import com.ssp.support.Log;
import com.ssp.support.WebDriverFactory;
import com.ssp.utils.DataProviderUtils;
import com.ssp.uxp_pages.GetTestData;

// TODO: Auto-generated Javadoc
/**
 * The Class US_5647.
 */
public class US_5647 extends BaseTest {

	/** The mode. */
	private String webSite, mode;
	
	/** The feature id. */
	private String featureId = this.getClass().getSimpleName() + "_";

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
	 * Tc 5647 6049 01.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "To check that a new Account Enquiry button is available at policy where policy has been settled by Pay now option", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC_5647_6049_01(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
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
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);
		}
	}

	/**
	 * Tc 5647 6049 02.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "To check that a new Account Enquiry button is available at policy where policy has been settled by Invoice option", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC_5647_6049_02(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
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
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);
		}
	}

	/**
	 * Tc 5647 6048.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "To check that a new Account Enquiry button is not available for a existing Quotes on a client", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC_5647_6048(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
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
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);
		}
	}
}