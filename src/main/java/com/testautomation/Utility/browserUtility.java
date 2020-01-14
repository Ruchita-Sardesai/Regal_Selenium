package com.testautomation.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/*public class browserUtility {


	public static WebDriver OpenBrowser(WebDriver driver,String browserName,String url) throws InterruptedException
	{
		if(browserName.equals("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); //to maximize the browser
			options.addArguments("disable-infobars"); // to disable the infobars
			options.addArguments("version");//to get the version of Google Chrome
			
			//Open the browser
			System.setProperty("webdriver.chrome.driver", "D:\\Chethan\\Timesheet_Project\\drivers\\chromedriver.exe");
			driver=new ChromeDriver(options);
			return driver;
			
		}
		
		else
			
			if(browserName.equals("IE"))
			
		{
				System.setProperty("webdriver.ie.driver", "D:\\Chethan\\Timesheet_Project\\drivers\\IE.exe");
				DesiredCapabilities capabilities=new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability("ignoreZoomSetting", true);
				capabilities.setCapability("requireWindowFocus", true);//to move mouse manually			
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.get(url);
				return driver;	
		}
	
	        return null;
	
	}
		
	
} */
