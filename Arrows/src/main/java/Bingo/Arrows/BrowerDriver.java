package Bingo.Arrows;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class BrowerDriver {
	//远程调用浏览器
	RemoteWebDriver browserCore;
	JavascriptExecutor javaScriptExecutor;
	int stepInterval = Integer.parseInt(TotalitySettings.stepInterval);
	int timeout = Integer.parseInt(TotalitySettings.timeout);
	private static Logger logger = Logger.getLogger(BrowerDriver.class.getName());
	private void setBrowserType(int type) {
		try {
			if(type==1) {
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				//capabilities.setCapability("", "");
				browserCore = new RemoteWebDriver(new URL(TotalitySettings.HubURL),capabilities);
			}if(type==2) {
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				browserCore = new RemoteWebDriver(new URL(TotalitySettings.HubURL),capabilities);
			}if(type==3) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				browserCore = new RemoteWebDriver(new URL(TotalitySettings.HubURL),capabilities);
			}if(type==4) {
				DesiredCapabilities capabilities = DesiredCapabilities.edge();
				browserCore = new RemoteWebDriver(new URL(TotalitySettings.HubURL),capabilities);
			}
		}catch(MalformedURLException e) {
			Assert.fail("Brower Type Inexistence ");
		}
		
	}
	public RemoteWebDriver getBrowserCore() {
		return browserCore;
	}

	public JavascriptExecutor getJavascriptExecutor() {
		return javaScriptExecutor;
	}
	
	//关闭浏览器
	public void quit() {
		browserCore.quit();
		logger.info("Quitted BrowserEmulator");
	}
	
	//关闭当前页面
    public void stop() {
        browserCore.close();
        logger.info("stop webdriver");
    }

    public WebElement findElement(By by) {
        WebElement element = browserCore.findElement(By.id(""));
        return element;
    }

    /**
     * 封装定位一组elements的方法
     */
    public List<WebElement> findElements(By by) {
        return browserCore.findElements(by);
    }

    /**
     * 截图，并返回图片位置
     * @throws IOException 
     */
    public String takeScreenShot() throws IOException {
    	String dir = "screenshot"; // TODO
    	Date date = Calendar.getInstance().getTime();
        String time = new SimpleDateFormat("yyyyMMdd-HHmmss").format(date);
        String path = dir + File.separator + time + ".png";
        File sourceFile = ((TakesScreenshot) this.browserCore).getScreenshotAs(OutputType.FILE);//截图
    	FileUtils.copyFile(sourceFile, new File(path));
        //takeScreenShot((TakesScreenshot) driver, path);
    	return path.replace("\\", "/");
    }
    //get_url
    public void get(String url) {
        browserCore.get(url);
        logger.info("Opened url " + url);
    }
    
	public void getTime(String url) {
		pause(stepInterval);
		browserCore.get(url);
		logger.info("Opened url " + url);
	}
	
    public void navigateGet(String url) {
        browserCore.navigate().to(url);
        logger.info("Opened url " + url);
    }
    
	public void navigateTimeGet(String url) {
		pause(stepInterval);
		browserCore.navigate().to(url);
		logger.info("Opened url " + url);
	}
	
	//后退
    public void back() {
        browserCore.navigate().back();
        logger.info("浏览器后退到上一步");
    }
    
    //关闭浏览器
	public void quitTime() {
		pause(stepInterval);
		browserCore.quit();
		logger.info("Quitted BrowserEmulator");
	}

    /**
     * 点击
     */
    public void click(WebElement element) {
        element.click();
    }

    /**
     * 获取当前url
     */
    public String getUrl() {
        return browserCore.getCurrentUrl();
    }

    /**
     * 获取title
     */
    public String getTitle() {
        return browserCore.getTitle();
    }

    /**
     * 关闭当前窗口
     */
    public void close() {
        browserCore.close();
    }

    /**
     * 获取当前窗口Handle的list
     */
    public List<String> getWindowsHandles() {
        Set<String> winHandels = browserCore.getWindowHandles();
        List<String> handles = new ArrayList<String>(winHandels);
        return handles;
    }

    /**
     * 获取当前窗口的handle
     * **/
    public String getWindowHandle() {
        return browserCore.getWindowHandle();
    }

    /**
     * 切换窗口
     */
    public void switchWindows(String name) {
        browserCore.switchTo().window(name);
    }

    /**
     * 切换alert窗口以及一些操作封装,切换到aleret窗口、同意、取消
     */
    public void switchAlert() {
        browserCore.switchTo().alert();
    }
    
    public void accept(Alert alert) {
        alert.accept();
    }
    
    public void dismiss(Alert alert) {
        alert.dismiss();;
    }

    /**
     * 模态框切换
     */
    public void switchToMode() {
        browserCore.switchTo().activeElement();
    }

    /**
     * actionMoveElement
     */
    public void action(WebElement element) {
        Actions action = new Actions(browserCore);
        action.moveToElement(element).perform();
    }

    /**
     * 获取cookcie
     *
     * @return Set
     */
    public Set<Cookie> getCookie() {
        Set<Cookie> cookies = browserCore.manage().getCookies();
        return cookies;
    }

    /*
	删除cookie
	*/
    public void deleteCookie() {
        browserCore.manage().deleteAllCookies();
    }
    //封装点击
	public void click(String xpath) {
		pause(stepInterval);
		expectElementExistOrNot(true, xpath, timeout,browserCore);
		try {
			clickTheClickable(xpath, System.currentTimeMillis(), 2500);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Failed to click " + xpath);
		}
		logger.info("Clicked " + xpath);
	}


	/**
	 * Click an element until it's clickable or timeout
	 * @param xpath
	 * @param startTime
	 * @param timeout in millisecond
	 * @throws Exception
	 */
	private void clickTheClickable(String xpath, long startTime, int timeout) throws Exception {
		try {
			browserCore.findElementByXPath(xpath).click();
		} catch (Exception e) {
			if (System.currentTimeMillis() - startTime > timeout) {
				logger.info("Element " + xpath + " is unclickable");
				throw new Exception(e);
			} else {
				Thread.sleep(500);
				logger.info("Element " + xpath + " is unclickable, try again");
				clickTheClickable(xpath, startTime, timeout);
			}
		}
	}

	/**
	 * Type text at the page element<br>
	 * Before typing, try to clear existed text
	 * @param xpath
	 *            the element's xpath
	 * @param text
	 *            the input text
	 */
	public void type(String xpath, String text) {
		pause(stepInterval);
		expectElementExistOrNot(true, xpath, timeout,browserCore);

		WebElement we = browserCore.findElement(By.xpath(xpath));
		try {
			we.clear();
		} catch (Exception e) {
			logger.warn("Failed to clear text at " + xpath);
		}
		try {
			we.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Failed to type " + text + " at " + xpath);
		}

		logger.info("Type " + text + " at " + xpath);
	}

	/**
	 * Hover on the page element
	 * 
	 * @param xpath
	 *            the element's xpath
	 */
	public void mouseOver(String xpath) {
		pause(stepInterval);
		expectElementExistOrNot(true, xpath, timeout,browserCore);
		//操作鼠标与键盘
		try {
			Robot rb = new Robot();
			rb.mouseMove(0, 0);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		WebElement we = browserCore.findElement(By.xpath(xpath));
		Actions builder = new Actions(browserCore);
		builder.moveToElement(we).build().perform();
		logger.info("Mouseover " + xpath);
		}

	/**
	 * Selenium API
	 * Switch the focus of future commands for this driver to the window with the given name/handle.
	 */
	public void selectWindow(String windowHandle) {
		pause(stepInterval);
		browserCore.switchTo().window(windowHandle);
		logger.info("Switched to window ");
	}
	
	public Set<String> setWindow() {
		Set<String> Handles = browserCore.getWindowHandles();
		return Handles;
	}
	public String windowHandle() {
		String handle = browserCore.getWindowHandle();
		logger.info("Switched to window ");
		return handle;
	}

	/**
	 * Enter the iframe
	 * @param xpath
	 *            the iframe's xpath
	 */
	public void enterFrame(String xpath) {
		pause(stepInterval);
		browserCore.switchTo().frame(browserCore.findElementByXPath(xpath));
		logger.info("Entered iframe " + xpath);
	}

	/**
	 * Leave the iframe
	 */
	public void leaveFrame() {
		pause(stepInterval);
		browserCore.switchTo().defaultContent();
		logger.info("Left the iframe");
	}
	
	/**
	 * Refresh the browser
	 */
	public void refresh() {
		pause(stepInterval);
		browserCore.navigate().refresh();
		logger.info("Refreshed");
	}
	
	/**
	 * Mimic system-level keyboard event
	 * @param keyCode
	 *            such as KeyEvent.VK_TAB, KeyEvent.VK_F11
	 */
	public void pressKeyboard(int keyCode) {
		pause(stepInterval);
		Robot rb = null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		rb.keyPress(keyCode);	// press key
		rb.delay(100); 			// delay 100ms
		rb.keyRelease(keyCode);	// release key
		logger.info("Pressed key with code " + keyCode);
	}

	/**
	 * Mimic system-level keyboard event with String
	 * 
	 * @param text
	 * 
	 */
	public void inputKeyboard(String text) {
		String cmd = System.getProperty("user.dir") + "\\res\\SeleniumCommand.exe" + " sendKeys " + text;

		Process p = null;
		try {
			p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			p.destroy();
		}
		logger.info("Pressed key with string " + text);
	}
	
	//TODO Mimic system-level mouse event

	/**
	判断元素是否存在，用一个回调函数的方式。
	 */
	public Boolean expectElementExistOrNot(boolean boo, final String xpath, int timeout,RemoteWebDriver driver) {
		    return (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return isElementPresentWebDriver(xpath, -1, driver);
				}
		    });
		}
/*
 * A utility class, designed to help the user automatically wait until a condition turns true. Use it like this:
 * 发现开源社区有这样的写法，但是Selenium官方文档中此种方法不推荐使用
 * new Wait() {public boolean until() {return isElementPresent();}}.wait();
 * */
	public Boolean expectElementExistOrNot(boolean boo, final String xpath, int timeout,WebDriver driver) {
	    return (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return isElementPresentWebDriver(xpath, -1, driver);
			}
	    });
	}	   

/*
	private FluentWait<WebDriver> retrun(WebDriverWait webDriverWait) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
	/**
	 *这么写完全是为了打日志。不然在上面一行代码就完成
	 * @return
	 */
	public boolean isElementPresent(String xpath, int time,RemoteWebDriver driver) {
		pause(time);
		boolean isPresent = driver.findElementByXPath(xpath).isDisplayed();
		if (isPresent) {
			logger.info("Found element " + xpath);
			return true;
		} else {
			logger.info("Not found element" + xpath);
			return false;
		}
	}
	public boolean isElementPresentWebDriver(String xpath, int time,WebDriver driver) {
		pause(time);
		boolean isPresent = driver.findElement(By.xpath(xpath)).isDisplayed();
		if (isPresent) {
			logger.info("Found element " + xpath);
			return true;
		} else {
			logger.info("Not found element" + xpath);
			return false;
		}
	}
	
	/**
	 * Pause
	 * @param time in millisecond
	 */
	public void pause(int time) {
		if (time <= 0) {
			return;
		}
		try {
			Thread.sleep(time);
			logger.info("Pause " + time + " ms");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	
	/**
	 * Return text from specified web element.
	 * @param xpath
	 * @return
	 */
	public String getText(String xpath) {
		WebElement element = this.getBrowserCore().findElement(By.xpath(xpath)); 
		return element.getText();
	}
	
	/**
	 * Select an option by visible text from &lt;select&gt; web element.
	 * @param xpath
	 * @param option
	 */
	public void select(String xpath, String option) {
		WebElement element = this.browserCore.findElement(By.xpath(xpath));
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
}

	
	
	
	
	
	

