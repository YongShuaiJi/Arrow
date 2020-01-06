package core.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class BeanEnv {

    private AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(PropertyConfig.class);

    @Bean
    @Profile("dev")
    public BeanConfig devDemoBean() {
        return new BeanConfig(context.getEnvironment().getProperty("auto.hub"));
    }

    @Bean
    @Profile("test")
    public BeanConfig prodDemoBean() {
        return new BeanConfig(context.getEnvironment().getProperty("localhost.hub"));
    }

}
