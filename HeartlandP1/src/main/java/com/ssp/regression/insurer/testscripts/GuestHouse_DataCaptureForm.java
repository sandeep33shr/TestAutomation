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

/**
 * The Class GuestHouse_DataCaptureForm.
 */
@Listeners(EmailReport.class)
public class GuestHouse_DataCaptureForm extends BaseTest {

	/** The mode. */
	private String webSite, mode;

	/** The feature id. */
	private String featureId = this.getClass().getSimpleName() + "_";

	/**
	 * Inits the properties from XML file
	 *
	 * @param context
	 *            the context
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@BeforeMethod(alwaysRun = true)
	public void init(ITestContext context) throws IOException {
		webSite = System.getProperty("webSite") != null ? System.getProperty("webSite")
				: context.getCurrentXmlTest().getParameter("webSite");
		mode = context.getCurrentXmlTest().getParameter("mode");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ssp.support.BaseTest#addTestInfo(java.lang.String,
	 * java.lang.String)
	 */
	@Override
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
	 * Positive work flow.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Create a positive GuestHouse Data Capture Form", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void positiveWorkFlow(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);
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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);
		}
	}

	/**
	 * Tc8567.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Do the premises have any Leisure Facilities (Swimming Pool, Gym, Sauna, Hot Tub etc.)?' and 'Do Permises hold firework displays/bonfires?' fields and the additional fields are properly appearing / disappearing when Yes'/No", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8567(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8568.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the following checkbox Fields when 'Do the premises have any Leisure Facilities (Swimming Pool, Gym, Sauna, Hot Tub etc.)?' = Yes", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8568(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8569.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the additional mandatory field related to  'Any other Leisure Facilities?' field are properly appearing / disappearing when Yes'/No", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8569(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8571.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the following checkbox Fields are available under the 'Guest House Details' Tab", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8571(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8572.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the Additional mandatory fields available under the 'Guest House Details'  tab", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8572(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8573.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify that 'Number of letting bedrooms' field is mandatory and it should accept 10 digits only", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8573(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8574.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify that 'Total Estimated Annual Turnover' field is mandatory and it should accept 10 digits only", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8574(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8577 tc8578.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify that 'Buildings/Tenants Improvements' field is mandatory and it should accept 10 digits only Verify the 'Contents Sum Insured' field dropdown and its values", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8577_TC8578(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8579.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "verify the field 'Are these inner contents limits adequate?' and the additional fields are properly appearing / disappearing when Yes'/No", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8579(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8580.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify that 'Please enter how much in total you require for Stock of Wines/Spirits/ Cigars/ Cigarettes/Tobacco?' field is mandatory and it should accept 10 digits only", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8580(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8581.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify that 'Please enter how much in total you require for Computers/Electronics Business Equipment?' field is mandatory and it should accept 10 digits only", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8581(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8582.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the following checkbox Field 'Do you require cover for Portable Possessions?' and the additional fields are properly appearing / disappearing when Yes'/No", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8582(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8343.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'The limit for Frozen Food is £1,000 is this adequate?' fields in Guest House Sum Insured Section after the 'Type of Cover' is selected ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8343(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8344.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'If a higher sum insured for Frozen Foods is required, please state the sum insured' fields in Guest House Sum Insured Section When 'The limit for Frozen Food is £1,000 is this adequate?' = Yes ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8344(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8359 tc8370.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Business Interruption (24 month indemnity period)', 'Loss of Licence', 'Book Debts', 'Employer liability' and 'Goods in transit' fields in 8a-sum Insured (GH) continued", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8359_TC8370(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8373.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Cash on premises during business hours and whilst in transit' fields in Guest House Sum Insured Section after the 'Type of Cover' is selected", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8373(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8374.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Cash in safe' fields in Guest House Sum Insured Section after the 'Type of Cover' is selected ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8374(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8376 tc8378.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Are the cash limits sufficient?' and 'Please provide make and model of safe' fields in Guest House Sum Insured Section after the 'Type of Cover' is selected ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8376_TC8378(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8389 tc8392.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Buildings/Tenants Improvements' fields in Holiday Homes Sum Insured Section after the 'Type of Cover' is selected and Verify the 'Contents Sum Insured' fields in Holiday Homes Sum Insured Section after the 'Type of Cover' is selected ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8389_TC8392(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8390 tc8396.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Do you wish to extend the buildings section' and 'Do you wish to extend the contents section' fields in Holiday Homes Sum Insured Section and Verify the 'Do the premises have a bar?', 'Do Premises have a restaurants?' and 'Are the premises located on a working farm?' fields in Holiday Homes Sum Insured Section after the 'Type of Cover' is selected ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8390_TC8396(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8449 tc8454.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the Read-only fields in Holiday Homes Sum Insured Continued Section after the 'Type of Cover' is selected and Verify the 'Public Liability' fields in Holiday Homes Sum Insured (HH) Continued Section after the 'Type of Cover' is selected ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8449_TC8454(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8601.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Buildings/Tenants Improvements' fields in Staff Accommodation Sum Insured Section after the 'Type of Cover' is selected ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8601(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8602.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Landlord Contents' fields in Staff Accommodation Sum Insured Section after the 'Type of Cover' is selected ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8602(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8606 tc8613.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Public/Property Owners Liability' fields in Staff Accommodation Sum Insured Section after the 'Type of Cover' is selected and Verify the 'Are the persons occupying the risk address in the direct employment of the insured AND working for the insured in the principal business activity?' fields in Staff Accommodation Sum Insured Section after the 'Type of Cover' is selected", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8606_TC8613(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8612.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Please indicate the principal business activity of the insured' fields in Staff Accommodation Sum Insured Section after the 'Type of Cover' is selected ", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8612(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc10070.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the fields in 'Declaration tab' for 'HIUA Phase 1 GLU' product", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC10070(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc10120.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the available fields inside the 'Liability Claims' pop up", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC10120(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc10138.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Liability claims Inline Grid' fields in 'Claims' Tab", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC10138(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc10150.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the available fields inside the 'Other types of Liability Claims' pop up", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC10150(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc10152.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Other type of Liability claims Inline Grid' fields in 'Claims' Tab", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC10152(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8336.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Specified Items' fields in Individual Item popup of 'Portable Possession' Tab", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8336(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8339 tc8341.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Description' and 'Valuations/Purchase Receipt (<5years old) seen?'  fields in  in Individual Item popup of 'Portable Possession' Tab and Verify the 'Value' fields in Individual Item popup of 'Portable Possession' Tab", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8339_TC8341(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}

	/**
	 * Tc8342.
	 *
	 * @param browser
	 *            the browser
	 * @throws Exception
	 *             the exception
	 */
	@Test(description = "Verify the 'Portable Possessions Inline Grid' fields in 'Portable Possession' Tab", dataProviderClass = DataProviderUtils.class, dataProvider = "ssBVTDataProvider")
	public void TC8342(String browser) throws Exception {

		String tcId = new Object() {
		}.getClass().getEnclosingMethod().getName();
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testDataConfig = new GetTestData(featureId, tcId);

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
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			driver.quit();
			Log.testCaseResult(extentedReport);
			Log.endTestCase(extentedReport);

		}
	}
}