package Bingo.Arrows;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import Bingo.verify.data.BrowerTypeEnum;

public class BrowerDriver extends SpringDriver {

	public static RemoteWebDriver browserCore;
	public static JavascriptExecutor javaScriptExecutor;
	private static Logger log = Logger.getLogger(BrowerDriver.class);

	public static synchronized RemoteWebDriver setBrowserCore(int type) {
		try {
			switch(type){
			case 1 :
				browserCore = new RemoteWebDriver(new URL(totalitySet.HubURL),new ChromeOptions());
				log.info("Start Browser :"+BrowerTypeEnum.getBrowerType(type) + " Browser Session:" + browserCore.getSessionId().toString());
				return browserCore;
			case 2 :
				browserCore = new RemoteWebDriver(new URL(totalitySet.HubURL),new FirefoxOptions());
				log.info("Start Browser :"+BrowerTypeEnum.getBrowerType(type) + " Browser Session:" + browserCore.getSessionId().toString());
				return browserCore;
			default :
				throw new MalformedURLException();
			}
		} catch (MalformedURLException e) {
			Assert.fail("Brower Type Inexistence");
			log.error("调用的浏览器出现异常了!"+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	
	/***************************************************************************
	public static synchronized RemoteWebDriver setBrowserCore(int type) {
		try {
			if(type == 1) {
				browserCore = new RemoteWebDriver(new URL(totalitySet.HubURL),new ChromeOptions());
				log.info("Start Browser :"+BrowerTypeEnum.getBrowerType(type) + " Browser Session:" + browserCore.getSessionId().toString());
			}
			if(type == 2) {
				browserCore = new RemoteWebDriver(new URL(totalitySet.HubURL),new FirefoxOptions());
				log.info("Start Browser :"+BrowerTypeEnum.getBrowerType(type) + " Browser Session:" + browserCore.getSessionId().toString());
				}
		}catch(MalformedURLException e) {
			Assert.fail("Brower Type Inexistence");
			log.error("调用的浏览器出现异常了!"+e.getMessage());
		}
		return browserCore;
	}
	
	public static ThreadLocal<RemoteWebDriver> ThreadDriver = new ThreadLocal<RemoteWebDriver>(); 
	public static RemoteWebDriver ss(int type) {
		lock.lock();
			ThreadDriver.set(BrowserCore(type));
		lock.unlock();
			return ThreadDriver.get();
		
	}
	
***********************************************************************************/
	
	
}
