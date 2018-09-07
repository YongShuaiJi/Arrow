package Bingo.Arrows;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementOperator extends DriverOperate {

	public static Logger logger = Logger.getLogger(ElementOperator.class.getName());

	//通过By获取元素
	    public synchronized WebElement getElement(WebDriver browserCore,By by) {
	        WebElement element = browserCore.findElement(by);
	        return element;
	    }

	/**获取元素的List*/
	    public synchronized List<WebElement> findElements(WebDriver browserCore,By by) {
	        return browserCore.findElements(by);
	    }
	    
	    public synchronized void Open(WebDriver browserCore,String url) {
	        browserCore.get(url);
	        logger.info("Opened url " + url);
	    }
	//	
	    public synchronized void navigateGet(WebDriver browserCore,String url) {
	        browserCore.navigate().to(url);
	        logger.info("Opened url " + url);
	    }
	    //
	    public synchronized void click(WebElement element) {
	        element.click();
	    }

	//
	    public synchronized String getUrl(WebDriver browserCore) {
	        return browserCore.getCurrentUrl();
	    }
	/**
	 * 获取Title
	 * */
	    public synchronized String getTitle(WebDriver browserCore) {
	        return browserCore.getTitle();
	    }
	    //
	    public synchronized List<String> getWindowsHandles(WebDriver browserCore) {
	        Set<String> winHandels = browserCore.getWindowHandles();
	        List<String> handles = new ArrayList<String>(winHandels);
	        return handles;
	    }
	//
	    public synchronized String getWindowHandle(WebDriver browserCore) {
	        return browserCore.getWindowHandle();
	    }
	    public synchronized void MaxWindow(WebDriver driver) {
	    	driver.manage().window().maximize();
	    }
	/**
	 * 进入到一个窗口，传入两个参数：
	 * 第一个参数表示当前驱动，第二个参数标书句柄名称，句柄名称通过其他方式方式获取
	 * */
	    public synchronized void switchWindows(WebDriver browserCore,String name) {
	        browserCore.switchTo().window(name);
	    }
	//
	    public synchronized void switchAlert(WebDriver browserCore) {
	        browserCore.switchTo().alert();
	    }
	//  
	    public synchronized void accept(Alert alert) {
	        alert.accept();
	    }
	    
	    public synchronized void dismiss(Alert alert) {
	        alert.dismiss();;
	    }
	//
	    public synchronized void switchToMode(WebDriver browserCore) {
	        browserCore.switchTo().activeElement();
	    }
	//
	    public synchronized void action(WebDriver browserCore,WebElement element) {
	        Actions action = new Actions(browserCore);
	        action.moveToElement(element).perform();
	    }
	//cookcie
	    public synchronized Set<Cookie> getCookie(WebDriver browserCore) {
	        Set<Cookie> cookies = browserCore.manage().getCookies();
	        return cookies;
	    }
	//删除cookcie
	    public synchronized void deleteCookie(WebDriver browserCore) {
	        browserCore.manage().deleteAllCookies();
	    }
	//封装点击
		public synchronized void click(RemoteWebDriver browserCore,String xpath) {
			expectElementExistOrNot(true, xpath,browserCore);
			try {
				clickTheClickable(browserCore, xpath, System.currentTimeMillis(), 2500);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("Failed to click " + xpath);
			}
			logger.info("Clicked " + xpath);
		}
	//
		private synchronized void clickTheClickable(WebDriver browserCore,String xpath, long startTime, int timeout) throws Exception {
			try {
				browserCore.findElement(By.xpath(xpath)).click();
			} catch (Exception e) {
				if (System.currentTimeMillis() - startTime > timeout) {
					logger.info("Element " + xpath + " is unclickable");
					throw new Exception(e);
				} else {
					logger.info("Element " + xpath + " is unclickable, try again");
					clickTheClickable(browserCore, xpath, startTime, timeout);
				}
			}
		}
		
		public synchronized void ElementsendKeys(RemoteWebDriver driver,By by,String keysToSend) {
			driver.findElement(by).sendKeys(keysToSend);
		}
		
	//
		public synchronized void type(RemoteWebDriver browserCore,String xpath, String text) {
			expectElementExistOrNot(true, xpath,browserCore);
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
	 * 特殊
	 * 
	 * **/
		public void mouseOver(RemoteWebDriver browserCore,String xpath) {
			
			expectElementExistOrNot(true, xpath,browserCore);
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
	//
		public void selectWindow(WebDriver browserCore,String windowHandle) {
			browserCore.switchTo().window(windowHandle);
			logger.info("Switched to window ");
		}
	//	
		public Set<String> setWindow(WebDriver browserCore) {
			Set<String> Handles = browserCore.getWindowHandles();
			return Handles;
		}
		public String windowHandle(WebDriver browserCore) {
			String handle = browserCore.getWindowHandle();
			logger.info("Switched to window ");
			return handle;
		}
	// 
		public void enterFrame(WebDriver browserCore,String xpath) {
			browserCore.switchTo().frame(browserCore.findElement(By.xpath(xpath)));
			logger.info("Entered iframe " + xpath);
		}
	//
		public void leaveFrame(WebDriver browserCore) {
			browserCore.switchTo().defaultContent();
			logger.info("Left the iframe");
		}
	//
		public void refresh(WebDriver browserCore) {
			browserCore.navigate().refresh();
			logger.info("Refreshed");
		}
	//
		public void pressKeyboard(int keyCode) {
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
	//
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
//		判断元素是否存在，用一个回调函数的方式  固定时间为10秒--需要修改
		public Boolean expectElementExistOrNot(boolean boo, final String xpath,RemoteWebDriver driver) {
			    return (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
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
		public synchronized Boolean expectElementExistOrNot(final String xpath,WebDriver driver) {
		    return (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return isElementPresentWebDriver(xpath, -1, driver);
				}
		    });
		}
		
		public synchronized void expectTitleExit(WebDriver driver,String title) {
		
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
		         @Override
		         public Boolean apply(WebDriver d) {
		                   return d.getTitle().contains("title"); 
		         }});
		}

	/*
		private FluentWait<WebDriver> retrun(WebDriverWait webDriverWait) {
			// TODO Auto-generated method stub
			return null;
		}
	*/
	//这么写完全是为了打日志。不然在上面一行代码就完成
		public boolean isElementPresent(String xpath, int time,RemoteWebDriver driver) {
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
			boolean isPresent = driver.findElement(By.xpath(xpath)).isDisplayed();
			if (isPresent) {
				logger.info("Found element " + xpath);
				return true;
			} else {
				logger.info("Not found element" + xpath);
				return false;
			}
		}
	//
		public String getText(WebDriver browserCore,String xpath) {
			WebElement element = browserCore.findElement(By.xpath(xpath)); 
			return element.getText();
		}
	//
		public void select(WebDriver browserCore,String xpath, String option) {
			WebElement element = browserCore.findElement(By.xpath(xpath));
			Select select = new Select(element);
			select.selectByVisibleText(option);
		}



}
