package Bingo.Test;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDBCUtils {
	private static final String driver ="com.mysql.cj.jdbc.Driver";
	private static  String MySQLURL = "jdbc:mysql://192.168.230.132:3306/bingoboxdeplyrecord?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private static final String userName = "root";
	private static  String pwd = "12345678";
	public static BasicDataSource dataSource = new BasicDataSource();
	
	static {
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(MySQLURL);
		dataSource.setUsername(userName);
		dataSource.setPassword(pwd);
		dataSource.setInitialSize(10);//初始化数量
		dataSource.setMaxTotal(8);
		dataSource.setMaxIdle(10);
		dataSource.setMinIdle(1);
	}
	public static DataSource getDataSource() {
		return dataSource;
	}
}
