package DemoTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import Bingo.listener.CreateFile;
import Bingo.tool.CreateTime;

public class Fileio extends CreateFile implements CreateTime  {
	private final static String PATH = "FailImg"+File.separator+"screenshot";
	
	public static void main(String[] args) throws WebDriverException, IOException {
//		File sreenFile = new File(PATH);
//		if(!sreenFile.exists()) {
//			sreenFile.mkdirs();
//		} 
//		Date date = Calendar.getInstance().getTime();
//	    String SCREEN_SHOT_NAME = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
//	    String paths = sreenFile.getAbsolutePath() + File.separator + SCREEN_SHOT_NAME + ".png";
//	    File file = new File(sreenFile.getAbsolutePath()+File.separator+SCREEN_SHOT_NAME+ ".png");
//	    if(!file.exists()) {
//	    	file.createNewFile();
//	    }
//	    file.getParentFile().mkdirs();
//	    
//	    System.out.println(file.getAbsolutePath());
		File sreenFile = new File(PATH);
		if(CreatePath(sreenFile).exists()) {
//			log.info("Sava Screenshots Directory Create Success,PATH:"+CreatePath(sreenFile).getAbsolutePath());
		}else {
//			log.info("Screenshots directory Create fail！");
		}
		String paths = sreenFile.getAbsolutePath() + File.separator + CreateTime.CurrentTimeString() + ".png";
		
	    File file = new File(paths);
		if(CreateFile(file).exists()) {
//			log.info("Sava Screenshots File Create Success,PATH:"+CreateFile(file).getAbsolutePath());
		}
		
//	    FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),file);
	}

	  

}
