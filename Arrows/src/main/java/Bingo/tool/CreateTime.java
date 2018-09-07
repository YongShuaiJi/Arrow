package Bingo.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public interface CreateTime {
	
	public static String CurrentTimeString() {
		Date date = Calendar.getInstance().getTime();
	    String CurrentTimeStr = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
		return CurrentTimeStr;
	}

}
