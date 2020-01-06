package Interactive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Service;

@Service
public interface optimizationService <T> {

    Boolean WaitTimeElement(By by, WebDriver driver);

    Boolean WaitTimeElement(WebElement element, RemoteWebDriver driver);

    Boolean WaitTimeElement(String result,WebElement element, RemoteWebDriver driver);

    Boolean WaitTimeElementContains(String result,WebElement element,RemoteWebDriver driver);

    Boolean TitleExit(WebDriver driver,String title);

    // 双重移动
    void moveDoubleTo(WebDriver driver,By by1,By by2);

    // 根据位置确定一个元素

    By button_collects_subscribesBy(int i);

    // 根据类型确定一个元素
    By button_collects_subscribesBy(T t);

    // 根据位置和类型确定一个元素
    By button_collects_subscribesBy(int i,T t);
}
