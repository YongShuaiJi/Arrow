package Bingo.temporary.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 类用来读取键值对文件，目前只希望键值对文件保存用户名与密码，测试类直接调用静态变量获取用户名密码进行测试
 * **/
public class Common {
	
	public static FileInputStream inStream = null;
	public static final String boxdeploy_username = getProperties().getProperty("boxdeploy_username");
	public static String boxdeploy_password = getProperties().getProperty("boxdeploy_password");
	private static Logger log = Logger.getLogger(Common.class.getName());
	
	public static Properties getProperties() {
	Properties prop = new Properties();
		try {
			inStream = new FileInputStream("prop.properties");
			prop.load(inStream);
			log.info("Properties加载键值对文件成功！从输入中读取属性列表字节流,流保持打开状态！");
		} catch (IOException e) {
			log.error(e);
		}finally {
			try {
				inStream.close();
				log.info("关闭流成功！");
			} catch (IOException e) {
				log.error(e);
			}
		}
	return prop;
	}
}
