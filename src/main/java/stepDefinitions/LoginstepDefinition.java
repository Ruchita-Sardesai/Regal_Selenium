package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import Listeners.ExtentReportListener;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginstepDefinition  extends ExtentReportListener{
	
	public static WebDriver driver;
	
	 
	@Given("^User should open the browser$")
	public void Login_Button() 
	{
		
		test = extent.createTest(Feature.class, "Org Admin Login feature");							
		test=test.createNode(Scenario.class, "Org admin login Scenario");
		
		ExtentTest logInfo=null;
		try {
				
			  logInfo=test.createNode(new GherkinKeyword("Given"), "User should open the browser");
			     
			     ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized"); //to maximize the browser
				options.addArguments("disable-infobars"); // to disable the infobars
				options.addArguments("version");//to get the version of Google Chrome
				
				//Open the browser
				System.setProperty("webdriver.chrome.driver", "D:\\Chethan\\Timesheet_Project\\drivers\\chromedriver.exe");
				driver=new ChromeDriver(options);
				driver.get("https://org-app.regalpayone.com/login");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@id='details-button']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[.='Login']")).click();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); 
			
			
			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
						
			
		} 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
       
				
	
	
	
	@When("^Title of login page matches$")
	public void Login_Page_Title() 
	
	{
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("When"), "Title of login page matches");
			String Expected_title = "RegalPay Organization Admin App";
		    String Actual_title = driver.getTitle();
		    if(Expected_title.contains(Actual_title))
		    {
			System.out.println(Actual_title);
			logInfo.pass("Title of login page matched");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		    }
		    
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
			
		}
		
	}
	
	
	
	@Then("^User Enters the \"(.*)\" and \"(.*)\"$")
	public void Enter_Credentials(String Email,String Password) 
	{
		ExtentTest logInfo=null;
		try {
									
		logInfo=test.createNode(new GherkinKeyword("Then"), "User Enters the Email and Password");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
		logInfo.pass("User Entered the email and password");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
			
		}
		
	
	}
	
	
	
	@And("^User clicks on login button$")
   public void click_LoginButton() 
   {

		ExtentTest logInfo=null;
		try {
									
		logInfo=test.createNode(new GherkinKeyword("And"), "User clicks on login button");
		driver.findElement(By.xpath("//button[@value='login']")).click();
		logInfo.pass("User clicks on login button");
	    logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
			
		}
		
	
	}
	
	
	@And("^Verify user is on selection Page$")
	public void verify_Homepage() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("And"), "Verify user is on selection Page");
			WebDriverWait wait=new WebDriverWait(driver,20);
			WebElement dropdown=driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
			wait.until(ExpectedConditions.visibilityOf(dropdown));
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			logInfo.pass("Title of selection page matched");
			
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
			
		}
		
		
	}
	
	
	
	@And("^Verify Invalid UserName and credentials error message$")
	public void Verify_Invalid_UserName_and_credentials_error_message() throws Throwable{
		
		ExtentTest logInfo=null;
		try {
			
		logInfo=test.createNode(new GherkinKeyword("And"), "Verify Invalid UserName and credentials error message");
		String value=driver.findElement(By.xpath("//div//strong[text()='Error']//following::div//ul/li")).getText();
		System.out.println(value);
		Thread.sleep(1000);
		assertEquals("Invalid username or password",value);
		Assert.assertTrue(value.contains("Invalid username or password"), "invalid username");	
		logInfo.pass("Error message mathched");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
			
		}
		
	}
	
	
	
	@Then ("^Close the browser$")
	public void Quit_browsers()
	
	{
		ExtentTest logInfo=null;
		try {
			
		logInfo=test.createNode(new GherkinKeyword("Then"), "Close the browser");
		driver.quit();
		logInfo.pass("Closing the browser");
		
		}
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
			
		}
		
	} 
	
	
	
	
	
	
	
	
	
	

}
