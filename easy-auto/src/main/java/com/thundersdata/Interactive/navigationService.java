package Interactive;

import com.codeborne.selenide.Selenide;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public interface navigationService {


    @Step("登录系统")
    default
    void login(WebDriver driver,String url){
        //Selenide.Wait().until(visibilityOfElementLocated(By.id("$")));
    }

    @Step("导航列表跳转")
    default
    void navigationRebound(WebDriver driver,String xpath){

    }

    @Step("双重跳转")
    default
    void doubleJump(WebDriver driver,String xpath){

    }

    @Step("界面按钮退出登录")
    default
    void exitButton(WebDriver driver,String xpath){

    }
}
