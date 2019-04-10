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

@Listeners(com.ssp.support.ListenerTest.class)
public class US_3044 extends BaseTest {

	private String webSite, mode;
	private String featureId = this.getClass().getSimpleName() + "_";
	private WebDriver driver = null;

	@BeforeMethod(alwaysRun = true)
	public void init(ITestContext context) throws IOException {
		webSite = System.getProperty("webSite") != null ? System.getProperty("webSite")
				: context.getCurrentXmlTest().getParameter("webSite");
		mode = context.getCurrentXmlTest().getParameter("mode");
	}

	@Test(description = "To Validate the availability of 'Bank Reconciliation'task under FInance>Bank ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC_3044_7729(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
			driver.get(webSite);
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

	@Test(description = "To Validate the filter options and fields available on 'Bank Reconciliation'screen header", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider", dependsOnMethods = "TC_3044_7729")
	public void TC_3044_7730_01(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();

		GetTestData testDataConfig = new GetTestData(featureId, tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {

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
	@Test(description = "To Validate the Unreconciled,Total Marked,Closing Balance fields and Show Marked Items checkbox are disabled", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider", dependsOnMethods = "TC_3044_7730_01")
	public void TC_3044_7730_02(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();

		GetTestData testDataConfig = new GetTestData(featureId, tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {

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
	@Test(description = "To Validate the columns available on bank reconciliation screen", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider", dependsOnMethods = "TC_3044_7730_02",alwaysRun=true)
	public void TC_3044_7731(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
			driver.get(webSite);
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
	@Test(description = "To Validate the buttons available on bank reconciliation screen", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider",dependsOnMethods="TC_3044_7731")
	public void TC_3044_7732(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		GetTestData testDataConfig = new GetTestData(featureId, tcId);
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
			
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
	
	@AfterClass
	public void closeBrowser() {
		if (driver != null)
			driver.quit();
	}

}