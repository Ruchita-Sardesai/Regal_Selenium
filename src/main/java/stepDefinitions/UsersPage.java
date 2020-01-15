package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import Listeners.ExtentReportListener;
import cucumber.api.java.en.Given;

public class UsersPage extends ExtentReportListener {

	public static WebDriver driver;
	
	   
	
	@Given("^Click on Add users button$")
	public void Getin_to_Home_page() 
	{
		
		test = extent.createTest(Feature.class,"User Page feature");							
		test=test.createNode(Scenario.class, "User Page Scenario");
		ExtentTest logInfo=null;
		try {
								
			     logInfo=test.createNode(new GherkinKeyword("Given"), "Click on Add users button");
	             driver.findElement(By.xpath("")).click();
	             Thread.sleep(2000);
	             logInfo.pass("Add Users pop up got displayed");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	
		} 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
		
}

