package com.fcrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.fcrm.qa.util.TestUtil;
import com.fcrm.qa.util.WebEventListener;


public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try {
			
		prop = new Properties();
	    FileInputStream fp = new FileInputStream("C:\\SundayFW\\AutomationFramworkFreeCRM\\src\\main\\java\\"
	    		+ "com\\fcrm\\qa\\config\\config.properties");
		 prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("Chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", "C:\\SeleniumSoftware\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Geckodriver\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_WAIT, TimeUnit.SECONDS);
	}
	
}
