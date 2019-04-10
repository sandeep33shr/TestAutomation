package com.ssp.uxp_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.WaitUtils;

/**
 * Home Page acts as a gateway to perform TakeCall,MakeCall and Admin task and
 * allows to select the Branch
 */
public class AgentDashboardPage extends LoadableComponent<AgentDashboardPage> {

	static String pathType = "css";

	private WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;
	public ElementLayer uielement;

	public final String ENTER_YOUR_EXISTING_DETAIL_MSG = "Please enter your existing details";

	/**
	 * Constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 * @param extentedReport
	 */
	public AgentDashboardPage(WebDriver driver, ExtentTest extentedReport) {
		this.driver = driver;
		this.extentedReport = extentedReport;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtils.maxElementWait);
		PageFactory.initElements(finder, this);
		uielement = new ElementLayer(driver);
		load();
	}

	@Override
	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}
		if (isPageLoaded && !driver.getTitle().contains("AgentDashboard")) {
			Log.fail("Unable to navigate to Agent dashboard", driver, extentedReport);
		} else {
			Log.pass("Navigated to Agent dashboard", driver, extentedReport, true);
		}
	}

	@Override
	protected void load() {

		isPageLoaded = true;
		WaitUtils.waitForPageLoad(driver);
		isLoaded();
	}
}
