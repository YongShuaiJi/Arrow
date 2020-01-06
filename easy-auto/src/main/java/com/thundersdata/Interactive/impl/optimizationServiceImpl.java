package com.thundersdata.Interactive;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class optimizationServiceImpl implements optimizationService {

    /**
     *  WebElement 是否存在
     * */
    public Boolean WaitTimeElement(By by, WebDriver driver) {
        return (new WebDriverWait(driver, 50)).until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    driver.findElement(by);
                    return true;
                }catch (NoSuchElementException e){
                    return false;
                }
            }
        });
    }

    public Boolean WaitTimeElement(WebElement element, RemoteWebDriver driver) {
        return (new WebDriverWait(driver, 50)).until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }
        });
    }

    public Boolean WaitTimeElement(String result,WebElement element, RemoteWebDriver driver) {
        return (new WebDriverWait(driver, 50)).until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return element.getText().equals(result);
            }
        });
    }

    public Boolean WaitTimeElementContains(String result,WebElement element,RemoteWebDriver driver) {
        return (new WebDriverWait(driver, 10)).until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return element.getText().contains(result);
            }
        });
    }

    public Boolean TitleExit(WebDriver driver,String title) {
        return (new WebDriverWait(driver, 10)).until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains(title);
        }});
    }

    // 双重移动
    public void moveDoubleTo(WebDriver driver,By by1,By by2){
        new Actions(driver).moveToElement(driver.findElement(by1)).moveToElement(driver.findElement(by2)).click().perform();
    }

    // 根据位置确定一个元素

    public By button_collects_subscribesBy(int i){
        return null;
    }


    // 根据类型确定一个元素
    public By button_collects_subscribesBy(Object t){
        return null;
    }

    // 根据位置和类型确定一个元素
    public By button_collects_subscribesBy(int i,Object t){
        return null;
    }

    // 根据文字返回该元素WebElement
    private WebElement getElement(List<WebElement> elements, String StandardString){
        List <WebElement> element =  elements.parallelStream().filter((WebElement webelement) -> webelement.getText().equals(StandardString)).collect(Collectors.toList());
        if (element.size() != 1) return null;
        return element.get(0);
    }

}
