package Bingo.Arrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TotalitySettings {
	public static Properties prop = getProperties();
	/*
	 * getProperty(key,value);如果通过key找不到value，则返回默认的value
	 * public static String ChromeDriverPath = prop.getProperty("ChromeDriverPath", "./res/chromedriver.exe");
	 * */
	public static final String ChromeDriverPath = prop.getProperty("ChromeDriverPath");
	public static String FireFoxDriverPath = prop.getProperty("geckodriverpath");
	public static String IEDriverPath = prop.getProperty("IEDriverPath");
	public static String EdgeDriverPath = prop.getProperty("edgedriverpath");
	public static String HubURL = prop.getProperty("HubURL");
	public static String stepInterval = prop.getProperty("StepInterval", "500");
	public static String timeout = prop.getProperty("Timeout", "10000");
	public static String getPropertyValue(String Property) {
		
		return prop.getProperty(Property);
	}

	public static Properties getProperties() {
		Properties prop = new Properties();
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream("prop.properties");
			prop.load(inStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return prop;
	}
	

}
/*
 //测试代码
   public static void main(String[] are) {
		String str  = TotalitySettings.ChromeDriverPath;
		String str1 = TotalitySettings.ChromeDriverPath2;
		System.out.println(str+"  ----   "+str1);
	}
 
*/
