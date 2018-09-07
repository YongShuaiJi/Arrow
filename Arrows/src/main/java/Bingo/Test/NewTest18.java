package Bingo.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Bingo.Arrows.BrowerDriver;
import Bingo.Arrows.ElementOperator;
import Bingo.listener.TestListener;
import Bingo.tool.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

@Epic("Regression Tests")
@Feature("Baidu Tests")
public class NewTest18 extends ElementOperator{
	 private static RemoteWebDriver driver;

	 @Parameters({"browserType"})
	 @BeforeClass
	  public void createDriver(int browserType) throws IOException {
		 driver = BrowerDriver.setBrowserCore(browserType);
		 TestListener.driver = driver;
		 MaxWindow(driver);
	  }
	 
	 @Parameters({"browserType"})
	 @AfterClass
	  public void quitDriver(int browserType) {
	    quit(driver);

	  }
	 
	 @Test(priority = 1) 
	 @Step("进入部署系统")
	 @Severity(SeverityLevel.MINOR)
	 @Description("部署落地ERP的登录页面")
	 public void loginSys() throws InterruptedException {
		 Log.info("Start Run 部署落地ERP的登录页面");
		 Open(driver, "http://boxdeploy.bingobox.cc/login");
	 }
	 
	 @Test (priority = 2)
	 @Severity(SeverityLevel.BLOCKER)
	 @Description("调用百度搜索的演示")
	 public void testDemo() throws InterruptedException {
		 Log.info("Start Run 用百度搜索的演示");
		 Open(driver, "http://www.baidu.com");
	    getElement(driver, By.id("kw")).sendKeys("webdriver");
	    click(getElement(driver,By.id("su")));
	    
	    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	    		         @Override
	    		         public Boolean apply(WebDriver d) {
	    		                   return d.getTitle().contains("webdriver_百度搜索"); 
	    		         }});

	    Assert.assertEquals("webdriver_百度搜索", driver.getTitle());
	    Log.info("使用百度搜索WebDriver，跳转到新页面测试用例通过");
	  }
}

