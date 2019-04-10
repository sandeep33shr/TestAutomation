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
public class US_7168 extends BaseTest {

	private String webSite, mode;
	private String featureId = this.getClass().getSimpleName() + "_";
	private WebDriver driver = null;

	@BeforeMethod(alwaysRun = true)
	public void init(ITestContext context) throws IOException {
		webSite = System.getProperty("webSite") != null ? System.getProperty("webSite")
				: context.getCurrentXmlTest().getParameter("webSite");
		mode = context.getCurrentXmlTest().getParameter("mode");
	}

	@Test(description = "This case is designed to test value of Reconciled Date on CTV screen", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC_7168_8652_01(String browser) throws Exception {
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

	@Test(description = "This case is designed to test availability of Reconciled Date column when search only for Bank Account", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider",dependsOnMethods="TC_7168_8652_01")
	public void TC_7168_8652_02(String browser) throws Exception {
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
	

	@Test(description = "This case is designed to test that Reconciled Date column will not be available when search through account code", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider",dependsOnMethods="TC_7168_8652_02")
	public void TC_7168_8652_03(String browser) throws Exception {
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
	@AfterClass
	public void closeBrowser() {
		if (driver != null)
			driver.quit();
	}

}