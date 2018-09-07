package Bingo.listener;

import java.io.IOException;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter implements IHookable  {
	 
	public static WebDriver driver;
	public Logger log = Logger.getLogger(TestListener.class);
	  @Override
	  public void onFinish(ITestContext testContext) {
		  super.onFinish(testContext);
		  Iterator<ITestResult> listIfFailedTests = testContext.getFailedTests().getAllResults().iterator();
		  while(listIfFailedTests.hasNext()) 
		  {
			  ITestResult failedTest = listIfFailedTests.next();
			  ITestNGMethod method = failedTest.getMethod();
			  
			  if(testContext.getFailedTests().getResults(method).size() > 1) {
				  listIfFailedTests.remove();
			  }else {
				  if(testContext.getPassedTests().getResults(method).size() > 0) {
					  listIfFailedTests.remove();
				  }
			  }
		  }
	  }
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
		  try {
			ScreenShotOnFailure.taskSreenShoot(driver);
		} catch (WebDriverException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {

	  }

	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {

	  }


	  @Override
	  public void onStart(ITestContext testContext) {

	  }
	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		callBack.runTestMethod(testResult);
		if(testResult.getThrowable() != null) {
			try {
				ScreenShotOnFailure.takeScreenShot(testResult.getMethod().getMethodName(), driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}



	  
}
