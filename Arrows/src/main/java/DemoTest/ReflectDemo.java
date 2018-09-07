package DemoTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReflectDemo {
	public static Constructor[] cons = null;
	public static Constructor con = null;
	public static void main(String[] args) {
		constr();
	}
	private static void constr() {
		try {
			Class c = Class.forName("org.openqa.selenium.remote.RemoteWebDriver");
			con = c.getConstructor(CommandExecutor.class,Capabilities.class);
			RemoteWebDriver obj = (RemoteWebDriver) con.newInstance();
			}catch (InstantiationException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}catch (ClassNotFoundException e) {
			e.printStackTrace();
			}finally {
			if(con!=null) {
				System.out.println(con);
			}else {
				System.out.println("Constructor为空！");
			}
		}
	}
	private static void consts() {
		try {
			Class c = Class.forName("org.openqa.selenium.remote.RemoteWebDriver");
			cons = c.getConstructors();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(cons!=null) {
				for(Constructor cs : cons) {
					System.out.println(cs);
				}
			}else {
				System.out.println("Constructor为空！");
			}
		}
	}

}
