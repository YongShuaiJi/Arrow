package Bingo.Arrows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class LogTool {
	private static String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
	private static Logger logger = Logger.getLogger(BrowerDriver.class.getName());
	public static void log(String logText) {
//		System.out.println("[" + data + "] " + logText);
		logger.info(data);
	
	}
}
