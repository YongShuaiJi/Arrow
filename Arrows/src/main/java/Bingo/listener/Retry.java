package Bingo.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
/**
 * 
 * Interface to implement to be able to have a chance to retry a failed test.
 *
 * @author tocman@gmail.com (Jeremie Lenfant-Engelmann)

   * Returns true if the test method has to be retried, false otherwise.
   *
   * @param result The result of the test method that just ran.
   * @return true if the test method has to be retried, false otherwise.
	重写的接口方法：具体可以查看源码，如果返回true则重试.
 * */
public class Retry implements IRetryAnalyzer {
	public static int retryCount = 0;
	private static int maxRetryCount = 1;
	private static Logger logger = Logger.getLogger(Retry.class);
	public int getRetryCount() {
		return retryCount;
	}
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}
	public int getMaxRetryCount() {
		return maxRetryCount;
	}
	public void setMaxRetryCount(int maxRetryCount) {
		this.maxRetryCount = maxRetryCount;
	}
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount < maxRetryCount) {
			String message = "Running retry for '"+result.getName()+"' on class"+
								this.getClass().getName()+" Retrying "+retryCount;
			logger.info(message);
			Reporter.setCurrentTestResult(result);
	        Reporter.log("RunCount=" + (retryCount + 1));
	        retryCount++; 

	        return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
