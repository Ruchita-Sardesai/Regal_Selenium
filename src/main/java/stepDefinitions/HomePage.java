package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import Listeners.ExtentReportListener;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePage extends ExtentReportListener{

	
		public static WebDriver driver;
		
		   
		
		@Given("^User is on the home page$")
		public void Getin_to_Home_page() 
		{
			
			test = extent.createTest(Feature.class,"Home Page feature");							
			test=test.createNode(Scenario.class, "Home Page Scenario");
			ExtentTest logInfo=null;
			try {
									
				     logInfo=test.createNode(new GherkinKeyword("Given"), "User is on the home page");
				
				     ChromeOptions options = new ChromeOptions();
					options.addArguments("start-maximized"); //to maximize the browser
					options.addArguments("disable-infobars"); // to disable the infobars
					options.addArguments("version");//to get the version of Google Chrome
					
					//Open the browser and go into the org selection page
					System.setProperty("webdriver.chrome.driver", "D:\\Chethan\\Timesheet_Project\\drivers\\chromedriver.exe");
					driver=new ChromeDriver(options);
					driver.get("https://org-app.regalpayone.com/login");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@id='details-button']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[.='Login']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("abhishek@regal-us.com");
					driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Abhi@123");
					Thread.sleep(3000);
					
					driver.findElement(By.xpath("//button[@value='login']")).click();
					Thread.sleep(3000);
					
					//select the org from the dropdown
					WebElement  element= driver.findElement(By.xpath("//select[@id='ddlOrganizations'] "));
					Select dropdown=new Select(element);
					 dropdown.selectByIndex(1);
					Thread.sleep(3000);
					
					//click on submit button
					driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
				
				logInfo.pass("User has selected the organization");
				Thread.sleep(3000);
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
							
				
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
		
		
		
		@Then("^Verify User is on the home page$")
		public void Verify_User_is_Home_page() 
		{
				ExtentTest logInfo=null;
				try {
											
					logInfo=test.createNode(new GherkinKeyword("Then"), "User is on Home page");
					WebDriverWait wait=new WebDriverWait(driver,20);
					WebElement element=driver.findElement(By.xpath("//li[.=' Organization Settings ']"));
					wait.until(ExpectedConditions.visibilityOf(element));
					logInfo.pass("User is on Home page");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				    
				    
				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);
					
				}
				
			
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}


















