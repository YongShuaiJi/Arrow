package com.Haidian.WebEnergy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_Location {
	   //登录页面
	   //用户名
		@FindBy(id="txtUserName")
		WebElement User;
		//密码
		@FindBy(id="txtPassword")
		WebElement password;
		//密码
		@FindBy(id="btnSubmit")
		WebElement login;
		public login_Location(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
}
