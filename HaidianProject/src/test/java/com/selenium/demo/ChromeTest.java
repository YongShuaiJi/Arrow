package com.selenium.demo;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class ChromeTest extends TestCase {
	private static ChromeDriverService service;
	private WebDriver driver;
	@BeforeClass
	public static void createAndStartService() {
		service = new ChromeDriverService.Builder().usingDriverExecutable(new File(".//rcs//chromedriver.exe"))
				.usingAnyFreePort().build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void createAndStopService() {
		service.stop();
	}
	@Before
	public void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
	}
	@After
	public void quitDriver() throws InterruptedException {
		driver.quit();
	}
	@Test
	public void testGoogleSearch() {
		driver.get("https://www.baidu.com/");
		WebElement searchBox = driver.findElement(By.name("wd"));
		searchBox.sendKeys("webdriver");
		searchBox.clear();
		assertEquals("百度一下，你就知道", driver.getTitle());
	}
}
