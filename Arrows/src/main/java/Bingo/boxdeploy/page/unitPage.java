package Bingo.boxdeploy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class unitPage {

	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div[1]/div/div[1]/input")
	public WebElement username;
	 
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div[2]/div/div/input")
	public WebElement password;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/button")
	public WebElement login;
	
	public unitPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
