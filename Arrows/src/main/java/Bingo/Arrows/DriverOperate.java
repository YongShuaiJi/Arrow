package Bingo.Arrows;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverOperate implements Operate  {
	
private static Logger logger = Logger.getLogger(DriverOperate.class.getName());

/**
 * 截图功能，调用takeScreenShot，当前位置截图
 * 参数 WebDriver或者子类
 * **/
  public void takeScreenShot(WebDriver driver) throws IOException {
    	String dir = "TempImg"; // TODO
    	Date date = Calendar.getInstance().getTime();
        String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
        String path = dir + File.separator + time + ".png";
    	FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(path));
    }
    
/**
 * 当前页面调用浏览器后退功能，模拟点击浏览器后退按钮
 * 参数WebDriver或者子类
 * **/
    public synchronized void back(WebDriver driver) {
    	driver.navigate().back();
    }
/**
 * quit:关闭浏览器,销毁线程 
 * 参数RemoteWebDriver
 * **/
	public synchronized void quit(RemoteWebDriver driver) {
		logger.info("Quit BrowserDriver:"+driver.getSessionId().toString());
		driver.quit();
	}
/**
 * 关闭当前页面，传入WebDriver
 * 参数RemoteWebDriver
 * **/
    public synchronized void close(RemoteWebDriver driver) {
    	driver.close();
    }



}
