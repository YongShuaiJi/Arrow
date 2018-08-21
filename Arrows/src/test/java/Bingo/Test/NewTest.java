package Bingo.Test;



import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

//import junit.framework.TestCase;

//@RunWith(JUnit4.class) 
public class NewTest {

  private WebDriver driver;
  String HubURL = "http://192.168.10.8:4446/wd/hub";

 @Before
  public void createDriver() throws MalformedURLException {
    driver = new RemoteWebDriver(new URL(HubURL),DesiredCapabilities.chrome());
  }

 @After
  public void quitDriver() {
    driver.quit();
  }
 
@Test
 public void testGoogleSearch() {
    driver.get("http://www.baidu.com");
    driver.findElement(By.id("kw")).sendKeys("webdriver");
    driver.findElement(By.id("su")).click();

    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
    		         @Override
    		         public Boolean apply(WebDriver d) {
    		                   return d.getTitle().contains("webdriver_百度搜索"); 
    		         }});
    
    Assert.assertEquals("webdriver_百度搜索", driver.getTitle());
  }
}





/*
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test {
	
	
	
	
	
	/*
	public static void main(String[] args) throws MalformedURLException {
		/*
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.gecko.driver", "./res/geckodriver.exe");  
			driver =new FirefoxDriver();  
	        driver.get("http://192.168.10.116:9090/index.aspx");  
	        driver.manage().window().maximize();  
	        /*
	        WebElement txtbox=driver.findElement(By.name("wd"));  
	        txtbox.sendKeys("WebDriver");  
	        WebElement btn=driver.findElement(By.id("su"));  
	        btn.click();
	        
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("-------------------------------------------------------------------------------------------");
			try {
				driver.quit();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		/
		  DesiredCapabilities dc = DesiredCapabilities.chrome();
		  WebDriver wd = new RemoteWebDriver(new URL("http://192.168.10.8:4446/wd/hub"),dc);  
		  wd.manage().window().maximize();  
		  wd.get("http://www.baidu.com");  
		  
		  wd.quit();  
	}


}
*/
