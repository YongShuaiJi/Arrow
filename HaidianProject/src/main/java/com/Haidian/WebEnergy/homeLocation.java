package com.Haidian.WebEnergy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homeLocation {
	        //第一个图片
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[1]/div[1]/div[1]/div[2]/ul/li[1]/a")
			WebElement jpg_1;
			//第二个图片
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[1]/div[1]/div[1]/div[2]/ul/li[2]/a")
			WebElement jpg_2;
			//第三个图片
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[1]/div[1]/div[1]/div[2]/ul/li[3]/a")
			WebElement jpg_3;
			//首页标题
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[1]/a")
			WebElement onepage;
			//新闻动态
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[2]/a")
			WebElement news;
			//通知公告
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[3]/a")
			WebElement inform;
			//政策法规
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[4]/a")
			WebElement policy;
			//节能流程
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[5]/a")
			WebElement energy;
			//知识普及
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[6]/a")
			WebElement knowledge;
			//节能互动
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[7]/a")
			WebElement interation;
			//节能产品推广
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[8]/a")
			WebElement generalize;
			//内部频道
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[9]/a")
			WebElement interior;
			//下载中心
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[10]/a")
			WebElement download;
			//节能平台
			@FindBy(xpath="//*[@id=\"form1\"]/div[3]/ul/li[11]/a")
			WebElement terrace;
			//首页顶部右侧第一个详情
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[1]/div[1]/div[2]/div[1]/a")
			WebElement oneparticular;
			//首页顶部右侧第二个详情
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[1]/div[1]/div[2]/div[2]/a")
			WebElement twoparticular;
			//首页顶部右侧第三个详情
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[1]/div[1]/div[2]/div[3]/a")
			WebElement threeparticular;
			//搜索输入框
			@FindBy(xpath="")
			WebElement inputsearch;
			//清空按钮
			@FindBy(xpath="")
			WebElement empty;
			//搜索按钮
			@FindBy(xpath="")
			WebElement bthsearch;
			//新闻动态-更多
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[2]/div[1]/div/a")
			WebElement newsmore;
			//通知公告-更多
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[2]/div[2]/div/a")
			WebElement informmore;
			//节能流程-更多
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[2]/div[3]/div/a")
			WebElement energymore;
			//知识普及-更多
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[3]/div[1]/div[1]/div[1]/a")
			WebElement knowledgemore;
			//节能产品推广-更多
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[3]/div[1]/div[1]/div[1]/a")
			WebElement generalizemore;
			//政策法规-更多
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[3]/div[1]/div[2]/div/a")
			WebElement policymore;
			//节能互动-更多
			@FindBy(xpath="//*[@id=\"form1\"]/div[4]/div[3]/div[1]/div[3]/div/a")
			WebElement interationmore;
			
			public homeLocation(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
	

}
