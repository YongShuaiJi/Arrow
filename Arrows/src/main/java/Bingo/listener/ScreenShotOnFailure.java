package Bingo.listener;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.log4testng.Logger;
import Bingo.tool.CreateTime;
import io.qameta.allure.Attachment;

public class ScreenShotOnFailure extends CreateFile implements CreateTime{
	private final static String PATH = "FailImg"+File.separator+"screenshot";
	private static Logger log = Logger.getLogger(ScreenShotOnFailure.class);
	
	
	/**
	 * taskSreenShoot的作用是在用例失败后自动截图并保存到本地的FailImg\screenshot目录内
	 * 在监听器的失败情况下调用了此方法(重写了监听器)
	 * **/
	public static void taskSreenShoot(WebDriver driver) throws WebDriverException, IOException {
		
		File sreenFile = new File(PATH);
		if(CreatePath(sreenFile).exists()) {
			log.info("Sava Screenshots Directory Create Success,PATH:"+CreatePath(sreenFile).getAbsolutePath());
		}else {
			log.info("Screenshots directory Create fail！");
		}
		String paths = sreenFile.getAbsolutePath() + File.separator + CreateTime.CurrentTimeString() + ".png";
		
	    File file = new File(paths);
		if(CreateFile(file).exists()) {
			log.info("Sava Screenshots File Create Success,PATH:"+CreateFile(file).getAbsolutePath());
		}
		
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),file);
	}
	
	/**
	 * @Attachment allure中表示上传附件
	 * type 说明上传文件的类型
	 * 此方法用于截图并上传到Allure中的附件中，可以在测试失败后查看最后失败的截图。
	 * TestListener(监听器),中的失败情况发生后会调Run方法，Run方法会调用此方法。
	 * **/
	 @Attachment(value = "Failure in method {0}", type = "image/png")
    public static byte[] takeScreenShot(String methodName,WebDriver driver) throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

	
}
