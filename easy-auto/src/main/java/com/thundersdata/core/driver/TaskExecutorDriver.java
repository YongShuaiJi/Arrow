package core.driver;

import core.config.TaskExecutorConfig;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;

public class TaskExecutorDriver {
    public static BrowerDriver BDriver;
    static {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        BDriver = context.getBean(BrowerDriver.class);
        context.close();
    }
    public static RemoteWebDriver setBrowserCore(int type) {
        try {
            return (BDriver.setBrowserCore(type)).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
