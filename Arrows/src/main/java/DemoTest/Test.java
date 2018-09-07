package DemoTest;

import java.lang.reflect.InvocationTargetException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Bingo.Arrows.SpringTotalitySettings;
import Bingo.temporary.data.Common;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
//		Class c = Class.forName("Bingo.tool.LogTool");
//		LogTool lt = (LogTool) c.getConstructor().newInstance();
//		System.out.println(lt.data());
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		SpringTotalitySettings obj = (SpringTotalitySettings) ac.getBean("Totality");
		System.out.println(obj.getMySQLURL());
		Common con = new Common();
		String str = con.boxdeploy_username;
		System.out.println(str);   
	}
}
 