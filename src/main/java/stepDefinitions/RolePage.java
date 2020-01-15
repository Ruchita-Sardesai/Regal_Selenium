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

import Listeners.ExtentReportListener;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RolePage extends ExtentReportListener {

	public static WebDriver driver;
	
	@Given("^Click on Add role button$")
	
	public void Navigate_to_Roles() 
	{
		
		test = extent.createTest(Feature.class,"Role Page feature");							
		test=test.createNode(Scenario.class, "Role Page Scenario");
		ExtentTest logInfo=null;
		try {
			 logInfo=test.createNode(new GherkinKeyword("Given"), "Click on roles button");
             
			 WebElement Roles= driver.findElement(By.xpath("//input[@id='pills-roles-tab']"));
			 WebDriverWait wait=new WebDriverWait(driver,120);
			 wait.until(ExpectedConditions.visibilityOf(Roles));
			 logInfo.pass("user able to navigate to roles");
			 Thread.sleep(5000);
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		   }
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);}
			
	}
		

    @Then("^Click on Add role button")
    
    public void Add_Role()
    {
    	ExtentTest logInfo=null;
    	try {
    		logInfo= test.createNode(new GherkinKeyword("Given"), "Click on Add Role button");
    		WebElement AddRoles_Btn= driver.findElement(By.xpath("//input[@text='Add Role]"));
    		WebDriverWait wait=new WebDriverWait(driver,120);
			 wait.until(ExpectedConditions.visibilityOf(AddRoles_Btn));
			 logInfo.pass("user able to Click on Add role button");
			 Thread.sleep(5000);
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		   }
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);}
			
    	}
    
@Then("^Add the role name")
    
    public void RoleName()
    {
    	ExtentTest logInfo=null;
    	try {
    		logInfo= test.createNode(new GherkinKeyword("Given"), "Add the role name");
    		WebElement RoleName= driver.findElement(By.xpath(""));
    		WebDriverWait wait=new WebDriverWait(driver,120);
			 wait.until(ExpectedConditions.visibilityOf(RoleName));
			 logInfo.pass("user is able to add role name");
			 Thread.sleep(5000);
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		   }
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);}
			
    	}

@Then("^select the role level")
public void RoleLevel()
{
	ExtentTest logInfo=null;
	try {
		logInfo= test.createNode(new GherkinKeyword("Given"), "select the role level");
		WebElement RoleLevel= driver.findElement(By.xpath(""));
		WebDriverWait wait=new WebDriverWait(driver,120);
		 wait.until(ExpectedConditions.visibilityOf(RoleLevel));
		 logInfo.pass("user is able to select role level");
		 Thread.sleep(5000);
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	   }
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);}
		
	}

@Then("^select the role permissions")
public void Rolepermissions()
{
	ExtentTest logInfo=null;
	try {
		logInfo= test.createNode(new GherkinKeyword("Given"), "select the role permissions");
		WebElement Rolepermissions= driver.findElement(By.xpath(""));
		WebDriverWait wait=new WebDriverWait(driver,120);
		 wait.until(ExpectedConditions.visibilityOf(Rolepermissions));
		 logInfo.pass("user is able to select role permissions");
		 Thread.sleep(5000);
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	   }
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);}
		
	}

@And("^click on Save button")
public void SaveRole()
{
	ExtentTest logInfo=null;
	try {
		logInfo= test.createNode(new GherkinKeyword("Given"), "click on Save button");
		WebElement SaveRole= driver.findElement(By.xpath(""));
		WebDriverWait wait=new WebDriverWait(driver,120);
		 wait.until(ExpectedConditions.visibilityOf(SaveRole));
		 logInfo.pass("user is able to Save the role");
		 Thread.sleep(5000);
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	   }
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);}
		
	}
    }
    