package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testcases.TestBase;

public class  MyListener implements ITestListener {
	 
	public void onTestStart(ITestResult result) {
		
		TestBase.log.info("Test case is starting with name: "+result.getName());
		
	}
	public void onTestSuccess(ITestResult result) {
		
		TestBase.log.info("Test case is passed with name: "+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		TestBase.takeScreenshot();
		TestBase.log.info("Test case is failed with name: "+result.getName());
	}
	public void onTestSkipped(ITestResult result) {
		
		TestBase.log.info("Test case is skipped with name: "+result.getName());
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
	}
	public void onStart(ITestContext context) {
		
		TestBase.log.info("Test suite is starting with name: "+context.getName());
	}
	public void onFinish(ITestContext context) {
		
		TestBase.log.info("Test suite is finished with name: "+context.getName());
	}

	
	
	
}
