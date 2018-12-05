package com.fcrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fcrm.qa.base.TestBase;

public class ContactsPage extends TestBase {


	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	private WebElement contactslabel;
	
	@FindBy(name="first_name")
	private WebElement firstName;
	
	@FindBy(name="surname")
	private WebElement LastName;
	
	@FindBy(name="client_lookup")
	private WebElement company;
	
	@FindBy(xpath="//form[@name='contactForm']//input[@type='submit' and @value='Save']")
	private WebElement savebtn;
	
	@FindBy(xpath="//span[@id='first_name']")
	private WebElement first_name;
	
	@FindBy(xpath="//input[@value='Edit']")
	private WebElement Editbtn;
	
	
	//Initialization of page factory
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactslabel.isDisplayed();
	}
	
	public boolean verifyContactsName()
	{
		return first_name.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")).click();
	}
	
	public void createNewContact(String title,String ftName, String ltName, String comp)
	{
		Select select = new Select (driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		LastName.sendKeys(ltName);
		company.sendKeys(comp);
		savebtn.click();
		
	}
	
	public void ViewContactsByName(String name)
	{
		WebElement ele=driver.findElement(By.xpath("//a[text()='"+name+"']"));
		
		Actions action = new Actions(driver);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
		
		action.doubleClick(ele).build().perform();
	}
	
	public void EditContacts(String name, String ftName, String ltName, String comp) throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		Thread.sleep(2000);
        
		Editbtn.click();
		
		firstName.clear();
		firstName.sendKeys(ftName);
		
		LastName.clear();
		LastName.sendKeys(ltName);
		
		company.clear();
		company.sendKeys(comp);
		
		savebtn.click();
	}
	
	
}