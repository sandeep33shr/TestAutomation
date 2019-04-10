package com.ssp.uxp_pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.utils.WaitUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonPages.
 */
public class CommonPages extends LoadableComponent<CommonPages> {

	/** The driver. */
	private final WebDriver _driver;

	/** The extented report. */
	private ExtentTest _extentedReport;

	/** The page name. */
	private String _title, _pageName;	
	/**
	 * Constructor to assign global variables.
	 *
	 * @param driver
	 *            the driver
	 * @param report
	 *            the report
	 * @param title
	 *            the title
	 * @param pageName
	 *            the page name
	 */
	public CommonPages(WebDriver driver, ExtentTest report, String title, String pageName) {
		this._driver = driver;
		this._extentedReport = report;
		this._title = title;
		this._pageName = pageName;			
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.ui.LoadableComponent#isLoaded()
	 */
	@Override
	protected void isLoaded() {
		WaitUtils.waitForPageLoad(_driver, 30);	
		try {
		WaitUtils.waitForExpectedTitle(_driver, _title);
		}catch (TimeoutException e) {
			Log.fail(_pageName + " Page did not open up. Site might be down", _driver,
					_extentedReport);
		}
		String actualTitle=_driver.getTitle();
		if (!actualTitle.contains(_title)) {
			Log.fail(_pageName + " Page did not open up. Site might be down. Actual Page title is "+actualTitle+". Expected Page title is " + _title, _driver,
					_extentedReport);
		} else {
			Log.message("Successfully navigated to " + _pageName + " Page", _driver, _extentedReport);
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openqa.selenium.support.ui.LoadableComponent#load()
	 */
	@Override
	protected void load() {		
		WaitUtils.waitForPageLoad(_driver, 60);		
	}
}
