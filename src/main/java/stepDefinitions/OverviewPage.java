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

public class OverviewPage extends ExtentReportListener {

	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	ExcelDataConfig excel=new ExcelDataConfig();
	
	
	public OverviewPage (WebDriverFactory DriverFactory) throws Exception
	{
		super();
		webDriverFactory = new WebDriverFactory();
	}
	
	@Given("^Login for overview page$")
	public void Login_OverViewPage()
	{
		test = extent.createTest(Feature.class,"OverViewPage Page feature");							
		test=test.createNode(Scenario.class, "OverViewPage Page Scenario");
		ExtentTest logInfo=null;
		try {
			
			   logInfo=test.createNode(new GherkinKeyword("Given"), "Login for OverViewPage");
			     
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
				
				driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
				Thread.sleep(16000);
		
				Thread.sleep(9000);
		     	logInfo.pass("User is on OverViewPage Page");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}
	
	@Then("^Verify user is on the Overview page$")
	public void Verify_User_is_Home_page() 
	{
		ExtentTest logInfo=null;
		try {
			
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify user is on the Overview page");
			WebElement users=driver.findElement(By.xpath("//div/strong[text()='Overview']"));
			WebDriverWait wait= new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOf(users));
		
			logInfo.pass("User is on the Overview page");
			Thread.sleep(5000);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
			
		}
		
	}
	
	
	@Then("^Update Organization Details$")
	public void UpdateOrgDetails()
	{
		test = extent.createTest(Feature.class,"UpdateOrgDetails feature");							
		test=test.createNode(Scenario.class, "UpdateOrgDetails Page Scenario");
		ExtentTest logInfo=null;
		try {
			
			   logInfo=test.createNode(new GherkinKeyword("Then"), "Verify UpdateOrgDetails");
			
				//Update Orgname
			   driver.findElement(By.xpath("//input[@formcontrolname='name']")).clear();
			    driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Bolts and Nuts_OrgName");
				Thread.sleep(3000);
				
				//Update AdressLine1
				driver.findElement(By.xpath("//input[@formcontrolname='line1']")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname='line1']")).sendKeys("AddressLine1");
				Thread.sleep(3000);
				
				//Update City
				driver.findElement(By.xpath("//input[@formcontrolname='city']")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname='city']")).sendKeys("city");
				Thread.sleep(3000);
				
				//Update State
				driver.findElement(By.xpath("//input[@formcontrolname='state']")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname='state']")).sendKeys("state");
				Thread.sleep(3000);
				
				//Update ZipCode
				driver.findElement(By.xpath("//input[@formcontrolname='zipCode']")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname='zipCode']")).sendKeys("78728-6666");
				Thread.sleep(3000);
				
				//Update Country
				WebElement SelectEntity= driver.findElement(By.xpath("//select[@formcontrolname='country']"));
				int index=1;
				CommonMethods.SelectValueFromDropDown(SelectEntity,index);
				Thread.sleep(300);
				
				//Click on Save button
				driver.findElement(By.xpath("//button[text()=' Save']")).click();
				Thread.sleep(9000);
				
				//Check message						
				 WebDriverWait wait=new WebDriverWait(driver,200);
	             WebElement Succesfull_message = driver.findElement(By.xpath("//div[text()='Organization updated successfully']"));
	 			 wait.until(ExpectedConditions.visibilityOf(Succesfull_message));
	 			 
				Thread.sleep(9000);
		     	logInfo.pass("User is able to UpdateOrgDetails");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}
	
	@Then("^Verify Overviewpage has list of Orgdmin$")
	public void Verify_ListOfOrgadmin() 
	{
		ExtentTest logInfo=null;
		try {
			
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify Overviewpage has list of Orgdmin");
			WebElement users=driver.findElement(By.xpath("//div/strong[text()='Organization Administrator']"));
			WebDriverWait wait= new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOf(users));
		
			logInfo.pass("User is able to see list of Orgdmin");
			Thread.sleep(5000);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
			
		}
		
	}
	
	@Then("^Verify Overviewpage has list of Services$")
	public void Verify_ListOfService() 
	{
		ExtentTest logInfo=null;
		try {
			
			
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify Overviewpage has list of Services");
			WebElement users=driver.findElement(By.xpath("//div/strong[text()='Services']"));
			WebDriverWait wait= new WebDriverWait(driver,120);
			wait.until(ExpectedConditions.visibilityOf(users));
		
			logInfo.pass("User is able to see list of Services");
			Thread.sleep(5000);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
			
		}
		
	}

}