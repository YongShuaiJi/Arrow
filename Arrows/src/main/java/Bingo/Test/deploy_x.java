package Bingo.Test;

import org.testng.annotations.Test;

import Bingo.verify.data.DataLoadStatus;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class deploy_x {
	@Test
	public void Deploy_l() {
//		open("");
		System.out.println("获得的值是："+DataLoadStatus.valueof(2));
	}

}
