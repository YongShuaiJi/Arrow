package Bingo.boxdeploy.page;

import org.openqa.selenium.WebDriver;


public class BasicDataConfig extends findByElement {
	private WebDriver driver;
	BasicDataConfig(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void clickConstructionSupply() {
		driver.findElement(ConstructionSupply).click();
	}
	
	public void clickEngiFoundDic() {
		driver.findElement(EngiFoundDic).click();
	}
	
	public void clickTaskProgressDic() {
		driver.findElement(TaskProgressDic).click();
	}
	
	public void clickSiteAcceptanceDic() {
		driver.findElement(SiteAcceptanceDic);
	}
	
	public void clickBoxAcceptanceDic() {
		driver.findElement(BoxAcceptanceDic);
	}
	
	public void clickAllAcceptanceDic() {
		driver.findElement(AllAcceptanceDic);
	}

}