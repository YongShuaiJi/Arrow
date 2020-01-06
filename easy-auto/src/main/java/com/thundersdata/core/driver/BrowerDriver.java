package core.driver;

import com.codeborne.selenide.WebDriverRunner;
import core.config.BeanConfig;
import core.config.BeanEnv;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Future;

@Service
public class BrowerDriver {

    public static JavascriptExecutor javaScriptExecutor;
    static core.config.BeanConfig BeanConfig;
    static {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");
        context.register(BeanEnv.class);
        context.refresh();
        BeanConfig = context.getBean(BeanConfig.class);
    }

    @Async
    public Future<RemoteWebDriver> setBrowserCore(int type) {
        try {
            switch(type){
                case 1 :
                    RemoteWebDriver ChromeCore = new RemoteWebDriver(new URL(BeanConfig.getHub()),new ChromeOptions());
                    return new AsyncResult<RemoteWebDriver>(ChromeCore);
                case 2 :
                    RemoteWebDriver FireFoxCore = new RemoteWebDriver(new URL(BeanConfig.getHub()),new FirefoxOptions());
                    WebDriverRunner.setWebDriver(FireFoxCore);
                    return new AsyncResult<RemoteWebDriver>(FireFoxCore);
                default :
                    throw new MalformedURLException();
            }
        } catch (MalformedURLException e) {
            Assert.fail("Brower Type Inexistence");
            e.printStackTrace();
        }
        return null;
    }
}
