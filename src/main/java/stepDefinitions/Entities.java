package stepDefinitions;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Entities extends ExtentReportListener {

	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	ExcelDataConfig excel=new ExcelDataConfig();

	
    
	public Entities (WebDriverFactory DriverFactory) throws Exception
	{
		super();
		webDriverFactory = new WebDriverFactory();
	}
	
	 
	@Given("^Login and get in to entity page$")
	public void Loginto_entity()
	{
		test = extent.createTest(Feature.class,"Entity Page feature");							
		test=test.createNode(Scenario.class, "Entity Page Scenario");
		ExtentTest logInfo=null;
		try {
			
			  logInfo=test.createNode(new GherkinKeyword("Given"), "Login and get in to entity page");
			     
			   WebDriverFactory.OpenBrowser( "chrome", "https://qa.org.regalpayone.com/login");  //Launching the browser
			   Thread.sleep(3000);
		
				this.driver = webDriverFactory.driver; 

				Thread.sleep(3000);
			/*	driver.findElement(By.xpath("//button[@id='details-button']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
				Thread.sleep(3000); */
				driver.findElement(By.xpath("//button[.='Login']")).click();
				Thread.sleep(28000);
				driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(excel.getData("Credentials", 0, 0));
				driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(excel.getData("Credentials", 0, 1));
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
				
				//click on entities 
				
				WebElement entity=driver.findElement(By.xpath("//span[text()='Entities']"));
				WebDriverWait wait= new WebDriverWait(driver,1200);
				wait.until(ExpectedConditions.visibilityOf(entity));
				entity.click();
				Thread.sleep(5000);
		     	logInfo.pass("user is on Entities Page");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
							
				
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	

	
	
	@Then("^Click on Add Entity button$")
	public void click_add_entity()
	{
		
		ExtentTest logInfo=null;
		try {
								
			     logInfo=test.createNode(new GherkinKeyword("Then"), "Click on Add Entity button");
	             driver.findElement(By.xpath("//button[text()='Add Entity']")).click();
	             Thread.sleep(2000);
	             logInfo.pass("Add Entity pop up got displayed");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	
		} 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
	
	
	
}