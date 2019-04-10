package com.ssp.support;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class ListenerTest.
 */
public class ListenerTest implements ITestListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.
	 * testng.ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure(ITestResult arg0) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped(ITestResult arg0) {
		String tcId = arg0.getName();
		String description = arg0.getMethod().getDescription();
		String methodsDependsOn = Arrays.toString(arg0.getMethod().getMethodsDependedUpon());
		ExtentTest test = BaseTest.extent.startTest(tcId, description);
		test.log(LogStatus.SKIP, "Skip the test case because any of the method on which it depends " + methodsDependsOn
				+ " is/are fail");
		BaseTest.extent.endTest(test);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
}
