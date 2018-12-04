package com.fcrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fcrm.qa.base.TestBase;
import com.fcrm.qa.pages.ContactsPage;
import com.fcrm.qa.pages.HomePage;
import com.fcrm.qa.pages.LoginPage;
import com.fcrm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtil testutil;
	
	
	String sheetName = "contacts";
	
	
	public ContactsPageTest()
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
		testutil.switchToFrame();
		contactpage = homepage.clicksOnContactsLink();
	}
	
	
	@Test(priority=1)
	public void verifyContactsLabelTest()
	{
		Assert.assertTrue(contactpage.verifyContactsLabel(),"Contacts label is missing");
	}
	
	@Test(priority=2)
	public void verifyContactsTest()
	{
		contactpage.selectContactsByName("Mahesh Hebbar");
		contactpage.selectContactsByName("Nymesh Chellur");
	}
	
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homepage.ClickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactpage.createNewContact(title, firstName, lastName, company);
		
	}
	
	@Test(priority=4)
	public void verifyContactsCreated() throws InterruptedException
	{
		contactpage.doubleClickOnContactsByName("Nymesh Chellur");
		Assert.assertTrue(contactpage.verifyContactsName(), "Name not matching");
		Thread.sleep(2000);
	}
	

	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
