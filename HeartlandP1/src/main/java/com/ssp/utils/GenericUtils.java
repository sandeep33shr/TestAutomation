package com.ssp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ssp.support.Log;
import com.ssp.uxp_pages.ActionKeyword;

// TODO: Auto-generated Javadoc
/**
 * Util class consists wait for page load,page load with user defined max time
 * and is used globally in all classes and methods.
 */
public class GenericUtils {

	/** The mouse hover js. */

	private static final String MOUSE_HOVER_JS = "var evObj = document.createEvent('MouseEvents');"
			+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
			+ "arguments[0].dispatchEvent(evObj);";

	/**
	 * To compare two array list values,then print unique list value and print
	 * missed list value.
	 *
	 * @param expectedElements
	 *            - expected element list
	 * @param actualElements
	 *            - actual element list
	 * @return statusToBeReturned - returns true if both the lists are equal,
	 *         else returns false
	 */
	public static boolean compareTwoList(List<String> expectedElements, List<String> actualElements) {
		boolean statusToBeReturned = false;
		List<String> uniqueList = new ArrayList<>();
		List<String> missedList = new ArrayList<>();
		for (String item : expectedElements) {
			if (actualElements.contains(item)) {
				uniqueList.add(item);
			} else {
				missedList.add(item);
			}
		}
		Collections.sort(expectedElements);
		Collections.sort(actualElements);
		if (expectedElements.equals(actualElements)) {
			Log.event("All elements checked on this page:: " + uniqueList);
			statusToBeReturned = true;
		} else {
			Log.event("Missing element on this page:: " + missedList);
			statusToBeReturned = false;
		}
		return statusToBeReturned;
	}

	/**
	 * To get the text of a WebElement.
	 *
	 * @param element
	 *            - the input field you need the value/text of
	 * @param driver
	 *            -
	 * @return text of the input's value
	 */
	public static String getTextOfWebElement(WebElement element, WebDriver driver) {
		String sDataToBeReturned = null;
		if (WaitUtils.waitForElement(driver, element)) {
			sDataToBeReturned = element.getText().trim().replaceAll("\\s+", " ");
		}
		return sDataToBeReturned;
	}

	/**
	 * Verify contents of a WebElement contains a passed in string variable.
	 *
	 * @param elementToVerify
	 *            - element to verify the text of
	 * @param textToVerify
	 *            - expected text
	 * @return true if text on screen matches passed variable contents
	 * @throws Exception
	 *             the exception
	 */
	public static boolean verifyWebElementTextContains(WebElement elementToVerify, String textToVerify)
			throws Exception {
		try {
			boolean status = false;
			if (elementToVerify.getText().trim().replaceAll("\\s+", " ").contains(textToVerify)) {
				status = true;
			}
			return status;
		} catch (Exception e) {
			throw new Exception("Unable to retrieve the text due to " + e);
		}
	}

	/**
	 * To get matching text element from List of web elements.
	 *
	 * @param elements
	 *            -
	 * @param contenttext
	 *            - text to match
	 * @return elementToBeReturned as WebElement
	 * @throws Exception
	 *             -
	 */
	public static WebElement getMatchingTextElementFromList(List<WebElement> elements, String contenttext)
			throws Exception {
		WebElement elementToBeReturned = null;
		boolean found = false;

		if (elements.size() > 0) {
			for (WebElement element : elements) {
				if (element.getText().trim().replaceAll("\\s+", " ").equalsIgnoreCase(contenttext)) {
					elementToBeReturned = element;
					found = true;
					break;
				}
			}
			if (!found) {
				throw new Exception("Didn't find the correct text(" + contenttext + ")..! on the page");
			}
		} else {
			throw new Exception("Unable to find list element...!");
		}
		return elementToBeReturned;
	}

	/**
	 * To verify matching text element from List of web elements.
	 *
	 * @param elements
	 *            -
	 * @param contenttext
	 *            - text to match
	 * @return elementToBeReturned as WebElement
	 * @throws Exception
	 *             -
	 */
	public static boolean verifyMatchingTextContainsElementFromList(List<WebElement> elements, String contenttext)
			throws Exception {

		boolean found = false;
		if (elements.size() > 0) {
			for (WebElement element : elements) {
				if (element.getText().trim().contains(contenttext)) {
					found = true;
					break;
				}
			}
			if (!found) {
				Log.failsoft("Didn't find the correct text(" + contenttext + ")..! on the page");
			}
		} else {
			throw new Exception("Unable to find list element...!");
		}

		return found;
	}

	/**
	 * To scroll into particular element.
	 *
	 * @param driver
	 *            -
	 * @param element
	 *            - the element to scroll to
	 */
	public static void scrollIntoView(final WebDriver driver, WebElement element) {
		try {
			String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
					+ "var elementTop = arguments[0].getBoundingClientRect().top;"
					+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
			((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
			(new WebDriverWait(driver, 20).pollingEvery(500, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage("Page spinners/page not loading")).until(WaitUtils.documentLoad);
		} catch (Exception ex) {
			Log.event("Moved to element");
		}
	}

	/**
	 * Switching between tabs or windows in a browser.
	 *
	 * @param driver
	 *            -
	 */
	public static void switchToNewWindow(WebDriver driver) {
		String winHandle = driver.getWindowHandle();
		for (String index : driver.getWindowHandles()) {
			if (!index.equals(winHandle)) {
				driver.switchTo().window(index);
				break;
			}
		}
		if (!((RemoteWebDriver) driver).getCapabilities().getBrowserName().matches(".*safari.*")) {
			((JavascriptExecutor) driver).executeScript(
					"if(window.screen){window.moveTo(0, 0); window.resizeTo(window.screen.availWidth, window.screen.availHeight);};");
		}
	}

	/**
	 * To perform mouse hover on an element using javascript.
	 *
	 * @param driver
	 *            the driver
	 * @param element
	 *            the element
	 */
	public static void moveToElementJS(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript(MOUSE_HOVER_JS, element);
	}

	/**
	 * To compare two HashMap values,then print unique list value and print
	 * missed list value.
	 *
	 * @param expectedList
	 *            - expected element list
	 * @param actualList
	 *            - actual element list
	 * @return statusToBeReturned - returns true if both the lists are equal,
	 *         else returns false
	 */
	public static boolean compareTwoHashMap(HashMap<String, String> expectedList, HashMap<String, String> actualList) {
		List<String> missedkey = new ArrayList<>();
		HashMap<String, String> missedvalue = new HashMap<>();
		try {
			for (String k : expectedList.keySet()) {
				if (!(actualList.get(k).equals(expectedList.get(k)))) {
					missedvalue.put(k, actualList.get(k));
					Log.event("Missed Values:: " + missedvalue);
					return false;
				}
			}
			for (String y : actualList.keySet()) {
				if (!expectedList.containsKey(y)) {
					missedkey.add(y);
					Log.event("Missed keys:: " + missedkey);
					return false;
				}
			}
		} catch (NullPointerException np) {
			return false;
		}
		return true;
	}

	/**
	 * To verify font of the webelement.
	 *
	 * @param driver
	 *            the driver
	 * @param locator
	 *            - css selector of webelement
	 * @param font
	 *            - font type to verify
	 * @return boolean
	 * @throws Exception
	 *             the exception
	 */
	public static boolean verifyFont(WebDriver driver, String locator, String font) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.cssSelector(locator));
			String fontWeight = (String) js
					.executeScript("return getComputedStyle(arguments[0]).getPropertyValue('font-Weight');", element);
			if (fontWeight.trim().equals(font)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			throw new Exception("Error while veriying whether the string is in bold" + ex);

		}
	}

	/**
	 * To verify given string is displayed first.
	 *
	 * @param driver
	 *            the driver
	 * @param element
	 *            the element
	 * @param substringToVerify
	 *            the substring to verify
	 * @return boolean
	 * @throws Exception
	 *             the exception
	 */
	public static boolean verifyWebElementStartWith(WebDriver driver, WebElement element, String substringToVerify)
			throws Exception {
		try {
			boolean firstString = false;
			String displayedPolicyHolderName = getTextOfWebElement(element, driver);
			if (displayedPolicyHolderName.startsWith(substringToVerify)) {
				firstString = true;
			}
			return firstString;

		} catch (Exception ex) {
			throw new Exception("Error while veriying whether the string is in bold" + ex);

		}
	}

	/**
	 * To verify a list is in alphabetical order.
	 *
	 * @param listToCheck
	 *            - what to check alpha order of
	 * @return boolean
	 */
	public static boolean verifyListInAlphabeticalOrder(List<WebElement> listToCheck) {
		boolean status = false;
		List<String> actualList = new ArrayList<>();
		List<String> sortedlist = new ArrayList<>();
		for (WebElement element : listToCheck) {
			actualList.add(element.getText());
			sortedlist.add(element.getText());
		}
		Collections.sort(sortedlist);
		if (actualList.equals(sortedlist)) {
			status = true;
			Log.message("List is in alphabetical order: " + sortedlist);
		} else {
			status = false;
		}
		return status;
	}

	/**
	 * To generate Random characters.
	 *
	 * @param type
	 *            the type
	 * @param length
	 *            the length
	 * @return the random characters
	 */
	public static String getRandomCharacters(String type, int length) {
		String SALTCHARS = null;
		if ("ALPHANUMERIC".equalsIgnoreCase(type))
			SALTCHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
		else if ("ALPHA".equalsIgnoreCase(type))
			SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
		else if ("NUMERIC".equalsIgnoreCase(type))
			SALTCHARS = "0123456789";

		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < length) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}

		String saltStr = salt.toString();
		return saltStr;
	}

	/**
	 * To set past or future date.
	 *
	 * @param days
	 *            - future/past/current
	 * @param dateFieldLocator
	 *            - locator of the date field to set the date
	 * @param nofOfDays
	 *            - No of Days to add or Subtract
	 * @param noOfYear
	 *            - No of Years to add or subtract
	 * @return the string
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String setDate(String days, WebElement dateFieldLocator, int nofOfDays, int noOfYear)
			throws ParseException {

		String pastAndFutureDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String stringDate = sdf.format(date);
		Date d = sdf.parse(stringDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		if (days.equalsIgnoreCase("future")) {
			cal.add(Calendar.DATE, +nofOfDays); // number of days to add
			cal.add(Calendar.YEAR, +noOfYear);
			pastAndFutureDate = sdf.format(cal.getTime());
			dateFieldLocator.sendKeys(pastAndFutureDate);
		} else if (days.equalsIgnoreCase("past")) {
			cal.add(Calendar.DATE, -nofOfDays); // number of days to minus
			cal.add(Calendar.YEAR, -noOfYear);
			pastAndFutureDate = sdf.format(cal.getTime());
			dateFieldLocator.sendKeys(pastAndFutureDate);
		} else if (days.equalsIgnoreCase("current")) {
			dateFieldLocator.sendKeys(stringDate);
			pastAndFutureDate = stringDate;
		}
		return pastAndFutureDate;
	}

	/**
	 * Returns a random integer number in given range.
	 *
	 * @param min
	 *            the min
	 * @param max
	 *            the max
	 * @return the random integer number in given range
	 */
	public static int getRandomNumberBetween(int min, int max) {
		return new Random().nextInt(max) + min;
	}

	/**
	 * To verify String Present in Array.
	 *
	 * @param arr
	 *            the arr
	 * @param targetValue
	 *            the target value
	 * @return true, if successful
	 */
	public static boolean verifyStringPresentInArray(String[] arr, String targetValue) {
		for (String s : arr) {
			if (s.equals(targetValue))
				return true;
		}
		return false;
	}

	/**
	 * Add the table Data in a HashMap where Header name is a key and Value is
	 * column value.
	 *
	 * @param pathType
	 *            the path type
	 * @param path
	 *            the path
	 * @param driver
	 *            the driver
	 * @return the hash map
	 * @throws Exception
	 *             the exception
	 */
	public static HashMap<String, String> addTableHeaderWithTableDataInHashMap(String pathType, String path,
			WebDriver driver) throws Exception {
		String paths[] = path.split(",");
		By tableHeaderLocator, tableValuesLocator;
		tableHeaderLocator = ActionKeyword.locatorValue(pathType, paths[0]);
		String pathOfTableValues = paths[1];
		if (pathOfTableValues.contains("&lt;"))
			pathOfTableValues = pathOfTableValues.replaceAll("&lt;", "<");
		tableValuesLocator = ActionKeyword.locatorValue(pathType, pathOfTableValues);
		List<WebElement> listOfHeaderElements = driver.findElements(tableHeaderLocator);
		List<WebElement> listOfvaluesElements = driver.findElements(tableValuesLocator);
		if (listOfHeaderElements.size() != listOfvaluesElements.size())
			throw new Exception(
					"Table Header data and column Data size are not equal. Please validate your locator or contact developer");

		HashMap<String, String> previewPaneTableData = new HashMap<>();
		for (int i = 0; i < listOfHeaderElements.size(); i++) {
			previewPaneTableData.put(listOfHeaderElements.get(i).getText(), listOfvaluesElements.get(i).getText());
		}
		return previewPaneTableData;
	}

	public static String removeDelimiterFromString(String input, String... delimiter) {
		for (String delim : delimiter) {
			if (input.contains(delim)) {
				input = input.replace(delim, "");
			}
		}
		return input;
	}
}