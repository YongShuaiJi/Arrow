package com.Haidian.WebEnergy;

import org.junit.After;
import org.junit.Test;
public class TestDemo {
	@Test
	public void test(){
		//1、登录功能测试
		login_Operator login = new login_Operator();
		login.login();
		login.Close();
	}
}
