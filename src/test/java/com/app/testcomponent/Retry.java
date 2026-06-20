package com.app.testcomponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	
	int count =0;
	int maxTry =1 ;//1 -time original 2 time it will re-run 
	
	@Override
	public boolean retry(ITestResult result) {
			
		if (count<maxTry) {
			count++;
			return true;
		}
		return false;
	}
	
	
	
}
