package Bingo.Arrows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface Operate {
/**
 * 后退
 * **/
    public void back(WebDriver driver);
/**
 * 关闭浏览器
 * **/
	public void quit(RemoteWebDriver driver);
/**
 * 关闭当前页面，传入WebDriver
 * **/
    public void close(RemoteWebDriver driver);

}
