package com.ssp.regression.insurer.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.BaseTest;
import com.ssp.support.EmailReport;
import com.ssp.support.Log;
import com.ssp.support.WebDriverFactory;
import com.ssp.utils.DataProviderUtils;
import com.ssp.uxp_pages.GetTestData;

// TODO: Auto-generated Javadoc
/**
 * The Class PP_6675_5518_5519_5520.
 */
@Listeners(EmailReport.class)
public class PP_6675_5518_5519_5520 extends BaseTest {

	/** The mode. */
	private String webSite, mode;
	
	/** The PC lweb site. */
	public String PCLwebSite;
	
	/** The feature id. */
	String featureId = "PP_6675_5518_5519_5520_";

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
		PCLwebSite = System.getProperty("PCLwebSite") != null ? System.getProperty("PCLwebSite")
				: context.getCurrentXmlTest().getParameter("PCLwebSite");
		mode = context.getCurrentXmlTest().getParameter("mode");
	}

	/* (non-Javadoc)
	 * @see com.ssp.support.BaseTest#addTestInfo(java.lang.String, java.lang.String)
	 */
	public ExtentTest addTestInfo(String testCaseId, String testDesc) {

		String browserwithos = null;
		String test = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getName();

		String browsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("browser");
		String browserversion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("browser_version");
		String os = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("os").substring(0,
				1);
		String osversion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("os_version");
		browserwithos = os + osversion + "_" + browsername + browserversion;

		return Log.testCaseInfo(testCaseId + " [" + test + "]",
				testCaseId + " - " + testDesc + " [" + browserwithos + "]", test, "UXP-EC-Purebroker");
	}

	/**
	 * Tc01.
	 *
	 * @param browser the browser
	 * @throws Exception the exception
	 */
	@Test(description = "Client/ Policy Transaction Enquiry UI", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC01(String browser) throws Exception {
		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData("CreateClientAndPolicy_", tcId);
		Log.testCaseInfo(testDataConfig.description + "<small><b><i>[" + browser + "]</b></i></small>");
		ExtentTest extentedReport = addTestInfo(tcId, testDataConfig.description);
		try {
			for (int iterCount = 0; iterCount < Integer.parseInt(testDataConfig.iterationCount); iterCount++) {
				Log.message("<--------------------- Iteration " + iterCount + " is started ----------------------->",
						extentedReport);
				driver.get(webSite);
				GetTestData.getObjectXmlData(testDataConfig.xml_Location, mode, tcId, iterCount, driver,
						extentedReport);
				Log.message("<--------------------- Iteration " + iterCount + " is ended ----------------------->",
						extentedReport);
			}
			testDataConfig = new GetTestData(featureId, tcId);
			Log.testCaseInfo(testDataConfig.description + "<small><b><i>[" + browser + "]</b></i></small>");
			extentedReport = addTestInfo(tcId, testDataConfig.description);
			for (int iterCount = 0; iterCount < Integer.parseInt(testDataConfig.iterationCount); iterCount++) {
				Log.message("<--------------------- Iteration " + iterCount + " is started ----------------------->",
						extentedReport);
				// driver.get(webSite);
				GetTestData.getObjectXmlData(testDataConfig.xml_Location, mode, tcId, iterCount, driver,
						extentedReport);
				Log.message("<--------------------- Iteration " + iterCount + " is ended ----------------------->",
						extentedReport);
			}
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}
}