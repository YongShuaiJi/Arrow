package com.Haidian.WebEnergy;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homeOperator {
	WebDriver driver;
	@Before
	public void driver(){
	   System.setProperty("webdriver.chrome.driver", "./rcs/chromedriver.exe");
	   driver = new ChromeDriver();
	}
	@Test
	public void homeTestoneimg(){
		
	}
	@After
	public void close(){
		driver.close();
	}

}
