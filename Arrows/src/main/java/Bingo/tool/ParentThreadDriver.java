package Bingo.tool;

import org.openqa.selenium.remote.RemoteWebDriver;

import Bingo.Arrows.BrowerDriver;

public class ParentThreadDriver {
	
	public static ThreadLocal<RemoteWebDriver> ThreadDriver = new ThreadLocal<RemoteWebDriver>();
	
	public static ThreadLocal<RemoteWebDriver> ParentThread(int browserType) {
		ThreadDriver.set(BrowerDriver.setBrowserCore(browserType));
		return ThreadDriver;
	}
}
