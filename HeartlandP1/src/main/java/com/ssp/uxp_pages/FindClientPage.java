package com.ssp.uxp_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.WaitUtils;

/**
 * Search page of the application is implemented in the way to search
 * contacts/policies.<br/>
 * <br/>
 * This SearchPage class holds the web elements of the page and provides the
 * methods to access them.
 * 
 */
public class FindClientPage extends LoadableComponent<FindClientPage> {

	static String pathType = "css";

	private final WebDriver driver;
	private ExtentTest extentedReport;
	public ElementLayer uielement;

	/**
	 * Constructs a Search page object.
	 * 
	 * @param driver
	 * @param extentedReport
	 */
	public FindClientPage(WebDriver driver, ExtentTest extentedReport) {
		this.driver = driver;
		this.extentedReport = extentedReport;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtils.maxElementWait);
		PageFactory.initElements(finder, this);
		uielement = new ElementLayer(driver);
		load();
	}

	@Override
	protected void load() {
		WaitUtils.waitForPageLoad(driver);
		isLoaded();
	}

	@Override
	protected void isLoaded() throws Error {
		WaitUtils.waitForPageLoad(driver, 100);
		if (!driver.getTitle().contains("SSP - Pure Insurance")) {
			Log.fail("Search Page did not open up.", driver, extentedReport);
		} else {
			Log.pass("Navigated to search page", driver, extentedReport, true);
		}
	}

}