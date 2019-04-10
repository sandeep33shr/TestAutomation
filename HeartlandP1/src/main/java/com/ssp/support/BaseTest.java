package com.ssp.support;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.NetworkMode;
import com.ssp.utils.FileUtils;
import com.ssp.uxp_pages.GetTestData;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseTest.
 */
public class BaseTest {
	
	/** The extent. */
	protected static ExtentReports extent;
	// private static String reportFolderPath;

	/**
	 * Before suite.
	 */
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {

		extent = new ExtentReports("target/surefire-reports/TestReport.html", true, DisplayOrder.OLDEST_FIRST,
				NetworkMode.ONLINE);
		Reporter.getCurrentTestResult().getTestContext().getSuite().setAttribute("policy_number", "");
	}

	/**
	 * Adds the test case information to extent report.
	 *
	 * @param testCaseId the test case id
	 * @param testDesc the test desc
	 * @return ExtentTest Object
	 */
	protected ExtentTest addTestInfo(String testCaseId, String testDesc) {
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
	 * Test case steps.
	 *
	 * @param driver the driver
	 * @param tcId the tc id
	 * @param browser the browser
	 * @param mode the mode
	 * @param testDataConfig the test data config
	 * @param extentedReport the extented report
	 * @throws Exception the exception
	 */
	protected void testCaseSteps(WebDriver driver, String tcId, String browser, String mode, GetTestData testDataConfig,
			ExtentTest extentedReport) throws Exception {
		Log.testCaseInfo(testDataConfig.description + "<small><b><i>[" + browser + "]</b></i></small>");
		for (int iterCount = 0; iterCount < Integer.parseInt(testDataConfig.iterationCount); iterCount++) {
			Log.message("<--------------------- Iteration " + iterCount + " is started ----------------------->",
					extentedReport);
			GetTestData.getObjectXmlData(testDataConfig.xml_Location, mode, tcId, iterCount, driver, extentedReport);
			Log.message("<--------------------- Iteration " + iterCount + " is ended ----------------------->",
					extentedReport);
		}
	}

	/**
	 * After suite.
	 */
	/*
	 * After suite will be responsible to close the report properly at the end
	 * You an have another afterSuite as well in the derived class and this one
	 * will be called in the end making it the last method to be called in test
	 * exe
	 */
	@AfterSuite
	public void afterSuite() {
		extent.flush();
		File reportFolder = new File("test-output");
		File reportSourceFile = new File("target/surefire-reports/TestReport.html");
		String reportDestFolder = reportFolder + File.separator + "TestReport.html";
		File reportDestFile = new File(reportDestFolder);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		try {
			FileUtils.copyFile(reportSourceFile, reportDestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
