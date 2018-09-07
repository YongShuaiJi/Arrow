package Bingo.boxdeploy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public interface Navigation {
	
	@Step("展开基础资料配置")
	default
	BasicDataConfig toBasicDataAllocation(WebDriver driver){
		driver.findElement(By.xpath("")).click();
		return new BasicDataConfig(driver);
	}
	

}
