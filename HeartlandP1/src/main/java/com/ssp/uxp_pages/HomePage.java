package com.ssp.uxp_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.utils.ElementLayer;
import com.ssp.utils.WaitUtils;

/**
 * Customer Dashboard Page consists all the policy/premium related documents *
 */
public class HomePage extends LoadableComponent<HomePage> {

	static String pathType = "css";

	private final WebDriver driver;
	private ExtentTest extentedReport;
	public ElementLayer uielement;

	/**
	 * 
	 * Constructor class for Customer Dashboard Page Here we initializing the
	 * driver for page factory objects. For ajax element waiting time has added
	 * while initialization
	 * 
	 * @param driver
	 *            : Webdriver
	 */
	public HomePage(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
		uielement = new ElementLayer(driver);
		load();
	}

	@Override
	protected void isLoaded() {
		WaitUtils.waitForPageLoad(driver, 100);
		if (!driver.getTitle().contains("SSP - Pure Insurance")) {
			Log.fail("Home Page did not open up. Site might be down.", driver, extentedReport);
		} else {
			Log.message("Successfully navigated to Client/Policy Search Page", driver, extentedReport);
		}
	}

	@Override
	protected void load() {
		WaitUtils.waitForPageLoad(driver, 60);
		isLoaded();
	}
}
