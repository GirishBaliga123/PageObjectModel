package com.fcrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fcrm.qa.base.TestBase;
import com.fcrm.qa.pages.HomePage;
import com.fcrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
	}
    
	
	@Test(priority=1)
	public void loginPageTitletest()
	{
		String title = loginpage.verifyTitlePage();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service","title is wrong");
	}
	
	@Test(priority=2)
	public void freecrmLogoTest()
	{
		Assert.assertTrue(loginpage.verifyFreecrmLogo(), "logo is displayed");
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homepage = loginpage.verifyLoginpage(prop.getProperty("USERNAME"),prop.getProperty("PASSWORD"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

}
