package Bingo.Arrows;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 测试框架中嵌入Spring的依赖注入特性目前集线器的地址与端口和其他变量用到了此功能
 * 
 * **/
public class SpringDriver {
	public static SpringTotalitySettings totalitySet;
	static {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		totalitySet = (SpringTotalitySettings) ac.getBean("Totality");		
	}
}
