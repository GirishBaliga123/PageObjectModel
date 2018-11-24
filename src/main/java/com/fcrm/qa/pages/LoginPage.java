package com.fcrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.fcrm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//objects repository
	//page objects
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement Username;
	
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;
	
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement LoginBtn;
	
	@FindBy(how=How.XPATH, using="//ul[@class='nav navbar-nav navbar-right']//li[2]")
	private WebElement SignupLink;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	private WebElement freecrmlogo;
	
	
	//initialization of page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//verify the title of login page
	public String verifyTitlePage()
	{
		return driver.getTitle();
	}
	
	//verify the freeCRM Logo
	public Boolean verifyFreecrmLogo()
	{
		return freecrmlogo.isDisplayed();
	}
	
	//Verify the sign up link
	public void verifySignUpLink()
	{
		SignupLink.click();
	}
	
	
	//Verify the login to freeCrm.com
	public HomePage verifyLoginpage(String UserName,String PassWord)
	{
		Username.sendKeys(UserName);
		Password.sendKeys(PassWord);
		LoginBtn.click();
		
		return new HomePage();
	}
	
}
