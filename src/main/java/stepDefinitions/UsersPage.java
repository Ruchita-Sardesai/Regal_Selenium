package stepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Utility.WebDriverFactory;

import Listeners.ExtentReportListener;
import ReusabilityMethods.CommonMethods;
import ReusabilityMethods.ExcelDataConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UsersPage extends ExtentReportListener {

	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\DELL\\git\\Regal_Selenium\\Regal_Selenium\\TestData(2).xlsx");
	
	
	public UsersPage (WebDriverFactory DriverFactory) throws Exception
	{
		super();
		webDriverFactory = new WebDriverFactory();
	}
	
	 
	@Given("^Launch browser and login$")
	public void Launch_and_Login()
	{
		test = extent.createTest(Feature.class,"User Page feature");							
		test=test.createNode(Scenario.class, "User Page Scenario");
		ExtentTest logInfo=null;
		try {
			
			  logInfo=test.createNode(new GherkinKeyword("Given"), "Launch browser and login");
			     
			   WebDriverFactory.OpenBrowser( "chrome", "https://qa.org.regalpayone.com/login");  //Launching the browser
			   Thread.sleep(3000);
		
				this.driver = webDriverFactory.driver; 

				Thread.sleep(3000);
			/*	driver.findElement(By.xpath("//button[@id='details-button']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
				Thread.sleep(3000); */
				driver.findElement(By.xpath("//button[.='Login']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(excel.getData(0, 0, 0));
				driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(excel.getData(0, 0, 1));
				//driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("abhishek@regal-us.com");
				//driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Abhi@123");
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//button[@value='login']")).click();
				Thread.sleep(3000);
				
				//select the org from the dropdown
				WebElement  element= driver.findElement(By.xpath("//select[@id='ddlOrganizations'] "));
				int index=1;
				CommonMethods.SelectValueFromDropDown(element,index);
				Thread.sleep(3000);
				
				//click on submit button
				driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
				Thread.sleep(16000);
				WebElement users=driver.findElement(By.xpath("//span[text()='Users']"));
				Thread.sleep(5000);
				users.click();
				Thread.sleep(5000);
		     	logInfo.pass("user is on Users Page");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
							
				
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	

	
	
	@Then("^Click on Add users button$")
	public void Getin_to_Home_page() 
	{
		
		ExtentTest logInfo=null;
		try {
								
			     logInfo=test.createNode(new GherkinKeyword("Given"), "Click on Add users button");
	             driver.findElement(By.xpath("//button[text()='Add User']")).click();
	             Thread.sleep(2000);
	             logInfo.pass("Add Users pop up got displayed");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	
		} 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
	
	
	
	
	@Then("^Enter the email and select the role and entity$")
	public void enter_details()
	{
		ExtentTest logInfo=null;
		try {
								
			     logInfo=test.createNode(new GherkinKeyword("Given"), "Enter the email and select the role and entity");
			     String mainWindow=driver.getWindowHandle();
			     System.out.println("the windows opened are" + mainWindow);
			     Set<String> set =driver.getWindowHandles();
			     // Using Iterator to iterate with in windows
			     Iterator<String> itr= set.iterator();
			     while(itr.hasNext())
			     {
			     String childWindow=itr.next();
			        // Compare whether the main windows is not equal to child window. If not equal, we will close.
			     if(!mainWindow.equals(childWindow))
			     {
			     driver.switchTo().window(childWindow);
			     System.out.println(driver.switchTo().window(childWindow).getTitle());
			     }
			     
			     driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("Azar@regal-us.com");
			     Thread.sleep(3000);
			    List<WebElement> radio=driver.findElements(By.xpath("//div[@class='checkbox-content']/div/input[@type='checkbox']"));
			    int size=radio.size();
			    System.out.println(size);
			    for(int i=0;i<=radio.size();i++)
			    {
			    	WebElement local = radio.get(i);
			    	String value=local.getAttribute("value");
			    	System.out.println(value);
			    }
			     /* This to switch to the main window
			     driver.switchTo().window(mainWindow); */
			     } 
			     logInfo.pass("User info added");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				 
} 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
		
}

