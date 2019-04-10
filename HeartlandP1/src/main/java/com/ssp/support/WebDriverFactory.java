package com.ssp.support;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.xml.XmlTest;

/**
 * WebdriverFactory class used to get a web driver instance, depends on the user
 * requirement as driverHost, driverPort and browserName we adding the
 * desiredCapabilities and other static action initialized here and some methods
 * used to retrieve the Hub and node information. It also consists page wait
 * load for images/frames/document
 */

public class WebDriverFactory {

	/** The config property. */
	private static EnvironmentPropertiesReader configProperty = EnvironmentPropertiesReader.getInstance();

	/** The driver host. */
	static String driverHost;

	/** The driver port. */
	static String driverPort;

	/** The browser name. */
	static String browserName;

	/** The device name. */
	static String deviceName;

	/** The hub URL. */
	static URL hubURL;

	/** The ie capabilities. */
	static DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

	/** The firefox capabilities. */
	static DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();

	/** The chrome capabilities. */
	static DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();

	/** The safari capabilities. */
	static DesiredCapabilities safariCapabilities = DesiredCapabilities.safari();

	/** The html unit capabilities. */
	static DesiredCapabilities htmlUnitCapabilities = DesiredCapabilities.htmlUnit();

	/** The opt. */
	static ChromeOptions opt = new ChromeOptions();

	/** The fp. */
	static FirefoxProfile fp = new FirefoxProfile();

	/** The max page load wait. */
	public static int maxPageLoadWait = 150;

	static {
		XmlTest test = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
		driverHost = System.getProperty("hubHost") != null ? System.getProperty("hubHost")
				: test.getParameter("deviceHost");
		driverPort = System.getProperty("hubPort") != null ? System.getProperty("hubPort")
				: test.getParameter("devicePort");

		maxPageLoadWait = configProperty.getProperty("maxPageLoadWait") != null
				? Integer.valueOf(configProperty.getProperty("maxPageLoadWait")) : maxPageLoadWait;

		opt.addArguments("--ignore-certificate-errors");
		opt.addArguments("--disable-bundled-ppapi-flash");
		opt.addArguments("--disable-extensions");
		opt.addArguments("--disable-web-security");
		opt.addArguments("--always-authorize-plugins");
		opt.addArguments("--allow-running-insecure-content");
		opt.addArguments("--test-type");
		opt.addArguments("--enable-npapi");

		try {
			hubURL = new URL("http://" + driverHost + ":" + driverPort + "/wd/hub");
		} catch (MalformedURLException e) {
			Log.fail(e.getMessage());
		}
	}

	private WebDriverFactory() {

	}

	/**
	 * Method to get instance of web driver using default parameters.
	 *
	 * @return driver
	 */
	public static WebDriver get() {
		browserName = System.getProperty("browserName") != null ? System.getProperty("browserName")
				: Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserName")
						.toLowerCase();
		return get(browserName);
	}

	/**
	 * Webdriver to get the web driver with browser name and platform and
	 * setting the desired capabilities for browsers.
	 *
	 * @param browserWithPlatform
	 *            : Browser With Platform
	 * @return driver
	 */
	public static WebDriver get(String browserWithPlatform) {

		WebDriver driver = null;
		String browser = null, platform = null;
		if (browserWithPlatform.contains("_")) {
			browser = browserWithPlatform.split("_")[0].toLowerCase().trim();
			platform = browserWithPlatform.split("_")[1].toUpperCase().trim();
		} else {
			browser = browserWithPlatform;
			platform = "ANY";
		}

		try {
			if ("chrome".equalsIgnoreCase(browser)) {

				chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, opt);
				chromeCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
				chromeCapabilities.setPlatform(Platform.fromString(platform));
				driver = new RemoteWebDriver(hubURL, chromeCapabilities);
			}

			else if ("iexplorer".equalsIgnoreCase(browser)) {
				ieCapabilities.setCapability("enablePersistentHover", false);
				ieCapabilities.setCapability("nativeEvents", false);
				ieCapabilities.setCapability("JavascriptEnabled", true);
				ieCapabilities.setCapability("requireWindowFocus", true);
				ieCapabilities.setCapability("ignoreZoomSetting", true);
				ieCapabilities.setCapability("ie.ensureCleanSession", true);
				ieCapabilities.setCapability("enableElementCacheCleanup", true);
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				ieCapabilities.setPlatform(Platform.fromString(platform));
				driver = new RemoteWebDriver(hubURL, ieCapabilities);
			} else if ("safari".equalsIgnoreCase(browser)) {
				driver = new RemoteWebDriver(hubURL, safariCapabilities);

			} else if ("cloud".equalsIgnoreCase(browser)) {

				DesiredCapabilities caps = new DesiredCapabilities();
				String test_type = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
						.getParameter("type");
				if ("device".equalsIgnoreCase(test_type)) {
					String BS_browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("browser");
					String BS_platform = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("os");
					String BS_device = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("device");
					caps.setCapability("browserName", BS_browser);
					caps.setCapability("os", BS_platform);
					caps.setCapability("platform", BS_platform);
					platform = BS_platform;
					caps.setCapability("device", BS_device);
					caps.setCapability("realMobile", "true");
					caps.setCapability("orientation", "landscape");
					caps.setCapability("javascriptEnabled", "false");

				} else {
					String BS_browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("browser");
					String BS_browserVersion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("browser_version");
					String BS_os = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("os");
					String BS_osVersion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
							.getParameter("os_version");
					String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
					caps.setCapability("browser", BS_browser);
					caps.setCapability("browser_version", BS_browserVersion);
					caps.setCapability("os", BS_os);
					caps.setCapability("os_version", BS_osVersion);
					caps.setCapability("browserstack.debug", "true");
					caps.setCapability("browserstack.local", "true");
					caps.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
					caps.setCapability("browserstack.ie.enablePopups", "true");
					caps.setCapability("javascriptEnabled", "false");
					caps.setCapability("browserstack.safari.enablePopups", "true");
				}

				driver = new RemoteWebDriver(
						new URL("https://" + driverHost + ":" + driverPort + "@hub-cloud.browserstack.com/wd/hub"),
						caps);

			}

			else if ("zap".equalsIgnoreCase(browser)) {
				Proxy zapChromeProxy = new Proxy();
				DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
				zapChromeProxy.setHttpProxy("localhost:8080");
				zapChromeProxy.setFtpProxy("localhost:8080");
				zapChromeProxy.setSslProxy("localhost:8080");
				chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, opt);
				chromeCapabilities.setCapability(CapabilityType.PROXY, zapChromeProxy); // Set
																						// proxy
																						// for
																						// ZAP
				chromeCapabilities.setPlatform(Platform.fromString(platform));
				driver = new RemoteWebDriver(hubURL, chromeCapabilities);

			} else if ("Headless".equalsIgnoreCase(browser)) {
				htmlUnitCapabilities.setBrowserName("htmlunit");
				htmlUnitCapabilities.setVersion("firefox");
				htmlUnitCapabilities.setPlatform(Platform.ANY);
				htmlUnitCapabilities.setJavascriptEnabled(true);
				driver = new HtmlUnitDriver(true);
			} else {
				synchronized (WebDriverFactory.class) {
					firefoxCapabilities.setCapability("marionette", true);
					firefoxCapabilities.setPlatform(Platform.fromString(platform));
					driver = new RemoteWebDriver(hubURL, firefoxCapabilities);
				}
				driver.manage().timeouts().pageLoadTimeout(maxPageLoadWait, TimeUnit.SECONDS);
			}
			Assert.assertNotNull(driver,
					"Driver did not intialize...\n Please check if hub is running / configuration settings are corect.");

			if (!"ANDROID".equalsIgnoreCase(platform)) {
				driver.manage().window().maximize();
			}
		} catch (UnreachableBrowserException e) {
			e.printStackTrace();
			throw new SkipException("Hub is not started or down.");
		} catch (WebDriverException e) {

			try {
				if (driver != null) {
					driver.quit();
				}
			} catch (Exception e1) {
				e.printStackTrace();
			}

			if (e.getMessage().toLowerCase().contains("error forwarding the new session empty pool of vm for setup")) {
				throw new SkipException("Node is not started or down.");
			} else if (e.getMessage().toLowerCase()
					.contains("error forwarding the new session empty pool of vm for setup")
					|| e.getMessage().toLowerCase().contains("cannot get automation extension")
					|| e.getMessage().toLowerCase().contains("chrome not reachable")) {
				Log.message("&emsp;<b> --- Re-tried as browser crashed </b>");
				try {
					driver.quit();
				} catch (WebDriverException e1) {
					e.printStackTrace();
				}
				driver = get();
			} else {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception encountered in getDriver Method." + e.getMessage());
		} finally {
			try {
				Field f = Reporter.getCurrentTestResult().getClass().getDeclaredField("m_startMillis");
				f.setAccessible(true);
				f.setLong(Reporter.getCurrentTestResult(), Calendar.getInstance().getTime().getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		if (!("Headless".equalsIgnoreCase(browser))) {
			Log.addTestRunMachineInfo(driver);
		}
		return driver;

	}

	/**
	 * Get the test session Node IP address,port when executing through Grid.
	 *
	 * @param driver
	 *            : Webdriver
	 * @return the test session node IP
	 * @throws Exception
	 *             : Selenium Exception
	 * @return: Session ID
	 */

	public static final String getTestSessionNodeIP(final WebDriver driver) throws Exception {
		XmlTest test = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
		driverHost = System.getProperty("hubHost") != null ? System.getProperty("hubHost")
				: test.getParameter("deviceHost");
		driverPort = test.getParameter("devicePort");
		HttpHost host = new HttpHost(driverHost, Integer.parseInt(driverPort));
		HttpClient client = HttpClientBuilder.create().build();
		URL testSessionApi = new URL("https://" + driverHost + ":" + driverPort + "/grid/api/testsession?session="
				+ ((RemoteWebDriver) driver).getSessionId());
		BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST",
				testSessionApi.toExternalForm());
		HttpResponse response = client.execute(host, r);
		JSONObject object = new JSONObject(EntityUtils.toString(response.getEntity()));
		String nodeIP = object.getString("proxyId").toLowerCase();
		nodeIP = nodeIP.replace("https://", "");
		nodeIP = nodeIP.replaceAll(":[0-9]{1,5}", "").trim();
		return nodeIP;
	}

}
