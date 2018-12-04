package com.fcrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fcrm.qa.base.TestBase;
import com.fcrm.qa.pages.ContactsPage;
import com.fcrm.qa.pages.HomePage;
import com.fcrm.qa.pages.LoginPage;
import com.fcrm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtil testutil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactpage = new ContactsPage();
		homepage = loginpage.verifyLoginpage(prop.getProperty("USERNAME"),prop.getProperty("PASSWORD"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Homepage title in-correct");
		
	}
	
	@Test(priority=2)
	public void verifyusernameTest()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUsernamelabel());		
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testutil.switchToFrame();
		contactpage = homepage.clicksOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
