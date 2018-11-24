package com.fcrm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fcrm.qa.base.TestBase;

public class HomePage extends TestBase{

	
 @FindBy(xpath="//td[contains(text(),'Girish Baliga')]")
  private WebElement usernameLabel;
 
 @FindBy(xpath="//a[contains(text(),'Contacts')]")
 private WebElement contactsLabel;
 
 @FindBy(xpath="//a[contains(text(),'Deals')]")
 private WebElement dealsLabel; 
 
 @FindBy(xpath="//a[contains(text(),'New Contact')]")
 private WebElement newContactLink;
 
 public HomePage()
 {
	 PageFactory.initElements(driver, this);
 }
 
 
 public String verifyHomePageTitle()
 {
	 return driver.getTitle();
 }
 
 public boolean verifyCorrectUsernamelabel()
 {
	 return usernameLabel.isDisplayed();
 }
 
 public ContactsPage clicksOnContactsLink()
 {
	 contactsLabel.click();
	 
	 return new ContactsPage();
 }
 
 
 public DealsPage clicksOnDealsLink()
 {
	 dealsLabel.click();
	 
	 return new DealsPage();
 }
 
 public void ClickOnNewContactLink()
 {
	 Actions action = new Actions(driver);
	 action.moveToElement(contactsLabel).build().perform();
	 newContactLink.click();
 }
 
 
}
