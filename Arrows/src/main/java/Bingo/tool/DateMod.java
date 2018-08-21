package Bingo.tool;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Bingo.Test.whole_acceptance_pic_detail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateMod {
	
//	Class c = JDBCUtils.class;//先用另外一种反射写
	static DataSource ds;
	static String df;
	static String Strprimary;
	static String Strrestskey;
	static whole_acceptance_pic_detail wa;
	static {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date(System.currentTimeMillis());
		df = sd.format(d);
		Random random =new Random();
		int Primary = random.nextInt(1000);
		int Restskey = random.nextInt(10000);
		Strprimary = String.valueOf(Primary);
		Strrestskey = Integer.toString(Restskey);
		Constructor con;
		try {
			Class c = Class.forName("Bingo.Test.JDBCUtils");
			Class wapd = Class.forName("Bingo.Test.whole_acceptance_pic_detail");
			wa = (whole_acceptance_pic_detail) wapd.getConstructor().newInstance();
			JDBCUtils jb = (JDBCUtils)c.getConstructor().newInstance();
			ds = jb.getDataSource();
//			Class qr = QueryRunner.class;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	

	
	@Ignore
	@Test
	public void insert() {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "insert into whole_acceptance_pic_detail  values(?,?,?,?,?,?,?,?,?);";
		Object[] params = {Strprimary, Strrestskey, Strrestskey,1,Strrestskey,df,df,Strrestskey,0};	
		try {
			int line = qr.update(sql,params);
			System.out.println("插入的条数： "+line);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void aselect() {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select * from whole_acceptance_pic_detail";
		
		List<whole_acceptance_pic_detail> list = null;
		try {
			list = qr.query(sql,new BeanListHandler<whole_acceptance_pic_detail>(whole_acceptance_pic_detail.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			wa = qr.query(sql, new BeanHandler<whole_acceptance_pic_detail>(whole_acceptance_pic_detail.class));
			System.out.println("id值="+wa.getAcceptance_pic_detail_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/**用于测试
		for(whole_acceptance_pic_detail wapd : list) {
			
			System.out.println(wapd.toString());
		}
		*/
	}
	
	@Test
	public void delete() {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "delete from whole_acceptance_pic_detail where acceptance_pic_detail_id=?";
		Object[] param = {wa.getAcceptance_pic_detail_id()};
		System.out.println("id值="+wa.getAcceptance_pic_detail_id());
		try {
			int line = qr.update(sql, param);
			
			System.out.println("已经删除的数量="+line);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	
}
