package com.Haidian.WebEnergy;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class login_Operator {
    final Logger logger = LogManager.getLogger(login_Operator.class.getName());
	WebDriver driver;
	@Test
	public void login(){
		DOMConfigurator.configure("log4j.xml");
		logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
		logger.info("TEST Has Started");
		System.setProperty("webdriver.chrome.driver", "./rcs/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.1.92:1001/aspx/login.aspx");
		login_Location LoginHome = new login_Location(driver);
		homeLocation pag = new homeLocation(driver);		
		LoginHome.User.sendKeys("yingtaoxiaowanziee");
		LoginHome.password.sendKeys("123456");
		LoginHome.login.click();
//		(new WebDriverWait(driver,10))
//			.until(new ExpectedCondition<Boolean>(){
//				@Override
//			public Boolean apply(WebDriver input)
//			{
//				return driver.findElement(By.xpath("///*[@id=\"form1\"]/div[3]/div[1]/div[2]/span")).isDisplayed();
//			}
//		});
		WebElement element = driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div[1]/div[2]/span"));
		String str = element.getText();
		Assert.assertEquals(str, "Hi Mysq...");
//		pag.jpg_1.click();
		logger.error("测试错误");
	}
	@Test
	public void s_2(){
		System.setProperty("webdriver.chrome.driver", "./rcs/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.1.92:1001/aspx/login.aspx");
		login_Location LoginHome = new login_Location(driver);
		homeLocation pag = new homeLocation(driver);		
		LoginHome.User.sendKeys("mysql");
		LoginHome.password.sendKeys("123456");
		LoginHome.login.click();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div[1]/div[2]/span"));
		String str = element.getText();
		Assert.assertEquals(str, "Hi Mysq...");
		logger.error("测试错误");
	}
	@After
	public void Close(){
		//无论是否成功都应该关闭浏览器进行下一个测试
		driver.close();
	}
}
