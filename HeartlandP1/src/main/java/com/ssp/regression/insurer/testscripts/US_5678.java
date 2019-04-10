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
 * The Class US_5678.
 */
@Listeners(com.ssp.support.ListenerTest.class)
public class US_5678 extends BaseTest {

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

	/** The driver. */
	private WebDriver driver = null;

	/**
	 * Tc 5678 6142.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "To Validate the fields and data of Insurer Preview pane of Central Transaction View screen invoked from Accounts tab from Policy level", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC_5678_6142(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		GetTestData testDataConfig = new GetTestData("CreateClientAndPolicy_", tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
			driver = WebDriverFactory.get(browser);
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
	 * Tc 5678 6179.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "To Validate the fields and data of Commission Preview pane of Central Transaction View screen invoked from Accounts tab at Policy level", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider", dependsOnMethods = {
			"TC_5678_6142" }, priority = 0)
	public void TC_5678_6179(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		GetTestData testDataConfig = new GetTestData(featureId, tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
			testCaseSteps(driver, tcId, browser, mode, testDataConfig, extentedReport);
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);
		}
	}

	/**
	 * Tc 5678 6173.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "To Validate the fields and data of Commission Preview pane of Central Transaction View screen invoked from Accounts tab from at Client level", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider", dependsOnMethods = {
			"TC_5678_6178" })
	public void TC_5678_6173(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		GetTestData testDataConfig = new GetTestData(featureId, tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
			testCaseSteps(driver, tcId, browser, mode, testDataConfig, extentedReport);
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);
		}
	}

	/**
	 * Tc 5678 6178.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "To Validate the fields and data of Insurer Preview pane of Central Transaction View screen invoked from Accounts tab from at Client level", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider", dependsOnMethods = {
			"TC_5678_6142" }, priority = 1)
	public void TC_5678_6178(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		GetTestData testDataConfig = new GetTestData(featureId, tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
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
		if (driver != null) {
			driver.quit();
		}
	}
}