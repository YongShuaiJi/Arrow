package com.thundersdata.Interactive;

import com.thundersdata.element.loginPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class navigationServiceImpl implements navigationService {


    @Autowired
    loginPage loginPageService;

    @Autowired
    optimizationService optimizationServece;

    @Override
    public void login(WebDriver driver,String url) {
        driver.get("");
        if (optimizationServece.WaitTimeElement(loginPageService.loginButton,driver)) throw new NoSuchElementException("找不到必有元素：\"登录按钮\"");
        driver.findElement(loginPageService.user).sendKeys("");
        driver.findElement(loginPageService.password).sendKeys("");
        driver.findElement(loginPageService.loginButton).click();
    }
}
