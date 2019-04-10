package com.ssp.utils;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.uxp_pages.ActionKeyword;

public class ProjectSpecificFunctions {

	private WebDriver driver;
	static WebDriverWait wait;
	public static String dynamicValue = null;
	public static String dynamicList = null;
	public static HashMap<String, String> dynamicHashMap = new HashMap<>();
	private static int index = -1;
	
	public static void projectSpecificActionBasedOnFieldType(WebDriver driver, String pathType, String locatorType, String path,
			String input,String temp, String temp2,String validMessage, String errorMessage,String fieldLabel,
			ExtentTest extentedReport, String screenShot) throws Exception {
		Boolean screenshot = false;
	

		switch (locatorType) {
		
		case "assertTextOfDisabledField":
			assertTextOfDisabledField(fieldLabel, pathType, path, temp,temp2,validMessage,errorMessage, driver, extentedReport, screenshot);
			break;
		case "replaceCurrencySymbolFromClientBalance":
			replaceCurrencySymbolFromClientBalance(fieldLabel, pathType, path, driver, extentedReport, screenshot);
			break;
		default:
			Log.message("Unable to identify UIoperation type on respective field: " + fieldLabel, driver,
					extentedReport, screenshot);
			break;
		}
}

	private static void assertTextOfDisabledField(String fieldLabel, String pathType, String path, String temp,String temp2,String validMessage, String errorMessage,
			WebDriver driver, ExtentTest extentedReport, Boolean screenshot) throws Exception {
		try {
			boolean status = false;
			By locator;
			// String attribute;
			locator = ActionKeyword.locatorValue(pathType, path);
			WebElement element = driver.findElement(locator);
			WaitUtils.waitForElement(driver, element);
			System.out.println(element.isDisplayed());
			temp=element.getAttribute("value");
			temp2=temp;
			if (temp.equals(temp2)) {
				status = true;
			}
			Log.softAssertThat(status, validMessage, "Fail to achieve expected result : " + errorMessage, driver,
					extentedReport, screenshot);

		} catch (NoSuchElementException e) {
			Log.fail("Fail to achieve expected result : " + errorMessage, driver, extentedReport, true);
			throw new Exception("No Element Found to assert" + e);
		}
	}
	public static void replaceCurrencySymbolFromClientBalance(String fieldLabel, String pathType, String path, WebDriver driver,
			ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			String temp = null;
			String temp1=null;
			By locator;
			locator = ActionKeyword.locatorValue(pathType, path);
			WebElement element = driver.findElement(locator);
			Log.message("Value Displayed for " + fieldLabel + " : " + element.getText(), driver, extentedReport,
					screenshot);
			temp = element.getText();
			if(temp.contains("£"))
			{
			 temp1 = temp.replace("£", "");
			System.out.println(temp1);
			dynamicHashMap.put(fieldLabel, temp1);
			}else if(temp.contains("$"))
			{
				 temp1 = temp.replace("$", "");
				System.out.println(temp1);
				dynamicHashMap.put(fieldLabel, temp1);
			}
			
		} catch (NoSuchElementException e) {
			Log.fail("Fail to achieve expected result ", driver, extentedReport, true);
			throw new Exception("No Element Found to assert" + e);
		}
	}	
	}


