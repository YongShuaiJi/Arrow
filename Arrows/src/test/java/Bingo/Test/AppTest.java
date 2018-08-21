package Bingo.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{

	public static void main(String[] args) {
		/*
		Jedis jedis = new Jedis("192.168.10.9",6379);
		jedis.auth("123456");
		jedis.set("java", "lang");
		String value = jedis.get("java");
		System.out.println(value);
		jedis.close();//
		*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		System.out.println(System.nanoTime());//返回最准确的可用系统计时器的当前值，以毫微秒为单位,系统计时器的当前值，以毫微秒为单位。
		System.out.println(System.currentTimeMillis());//返回以毫秒为单位的当前时间。
		Date d = new Date(System.currentTimeMillis()); 
		System.out.println(d);
		System.out.println(sdf.format(d));
	
	}
}
 