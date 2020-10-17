package testng.week6;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedCases implements IRetryAnalyzer{

	//declaring a variable "maxCount" to initialize how many times we have to rerun failed cases
	int maxCount=3;
			
	//to increment a variable atfer re-executing cases
	int retry=0;
	@Override
	public boolean retry(ITestResult result) {
		
		//isSuccess() method return true when testcase is passed & retry<maxcount ==> re-run cases for 3 iterations
		if((!result.isSuccess())&& (retry <maxCount))
		{
			//if cases is falied at interation1 ,increment retry var count & re-run cases for next iteration
			retry++;
			
			return true;
		}
		
		return false;
	}

}
