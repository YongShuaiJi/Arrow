package core.images;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.IOException;
import java.util.Iterator;

public class TestListener extends TestListenerAdapter implements IHookable  {

	public static WebDriver driver;

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
