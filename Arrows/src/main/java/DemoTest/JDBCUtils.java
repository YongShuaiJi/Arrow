package DemoTest;

import java.lang.reflect.InvocationTargetException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import Bingo.Arrows.SpringTotalitySettings;

public class JDBCUtils {
	
	public static BasicDataSource dataSource = new BasicDataSource();
	static SpringTotalitySettings totalitySet;
	 
	static {
		try {
			Class c = Class.forName("Bingo.Arrows.SpringTotalitySettings");
			totalitySet = (SpringTotalitySettings)c.getConstructor().newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		 
		dataSource.setDriverClassName(totalitySet.getDriver());
		dataSource.setUrl(totalitySet.getMySQLURL());
		dataSource.setUsername(totalitySet.getUserName());
		dataSource.setPassword(totalitySet.getPwd());
		dataSource.setInitialSize(10);//初始化数量
		dataSource.setMaxTotal(8); 
		dataSource.setMaxIdle(10);
		dataSource.setMinIdle(1);
	}
	public static DataSource getDataSource() {
		return dataSource;
	}
}
