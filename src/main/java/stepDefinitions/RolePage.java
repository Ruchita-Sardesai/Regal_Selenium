package stepDefinitions;


import java.util.List;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class RolePage extends ExtentReportListener {

	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	ExcelDataConfig excel=new ExcelDataConfig();
	
	
	public RolePage (WebDriverFactory DriverFactory) throws Exception
	{
		super();
		webDriverFactory = new WebDriverFactory();
	}
	
	 
	@Given("^Login for Roles$")
	public void Login_1()
	{
		test = extent.createTest(Feature.class,"Roles Page feature");							
		test=test.createNode(Scenario.class, "Roles Page Scenario");
		ExtentTest logInfo=null;
		try {
			
			   logInfo=test.createNode(new GherkinKeyword("Given"), "Login for Roles");
			     
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
				
				//click on submit button
				driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
				Thread.sleep(16000);
				WebElement users=driver.findElement(By.xpath("//span[text()='Users']"));
				Thread.sleep(5000);
				
				users.click();
				Thread.sleep(9000);
		     	logInfo.pass("User is on Roles Page");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	

	
@Then("^Click on roles button$")
	
	public void Navigate_to_Roles() 
	{
		
		test = extent.createTest(Feature.class,"Role Page feature");							
		test=test.createNode(Scenario.class, "Role Page Scenario");
		ExtentTest logInfo=null;
		try {
			 logInfo=test.createNode(new GherkinKeyword("Then"), "Click on roles button");
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//*[@id=\"pills-roles-tab\"]")).click();
			 Thread.sleep(5000);
			 logInfo.pass("user able to navigate to roles");
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		   }
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);}
			
	}
		

   @Then("^Click on Add role button$")
    
    public void Add_Role()
    {
    	ExtentTest logInfo=null;
    	try {
    		logInfo= test.createNode(new GherkinKeyword("Then"), "Click on Add Role button");
    		driver.findElement(By.xpath("//button[text()='Add Role']")).click();
    		 Thread.sleep(5000);
    		 
    		 logInfo.pass("user able to Click on Add role button");
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			 
			 
		//Activate the Add role window
		driver.findElement(By.xpath("//div[@class='modal fade in show']/div/div")).click();
		Thread.sleep(2000);	
		   }
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);}
			
    	}
    
   @Then("^Add the role name$")
    
    public void RoleName()
    {
    	ExtentTest logInfo=null;
    	try {
    		//to create the RoleName and storing into excel
		 	String value=RandomStringUtils.randomAlphabetic(8);
		 	String Rolename= value + "Role";
		 	try {
				excel.write("Sheet1",1,1,Rolename);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	Thread.sleep(3000);
		 	
    		logInfo= test.createNode(new GherkinKeyword("Then"), "Add the role name");
    		
    		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(Rolename);
    		Thread.sleep(5000);
			 
    		
			 logInfo.pass("user able to Add the role name");
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		   }
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);}
			
    	}
   

@Then("^select the role level$")
public void RoleLevel()
{
	ExtentTest logInfo=null;
	try {
		
		logInfo= test.createNode(new GherkinKeyword("Then"), "select the role level");
		WebElement RoleLevel= driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[3]/div/div/div[2]/app-role-create/div/div/form/div[2]/select"));
		int index=1;
		
		CommonMethods.SelectValueFromDropDown(RoleLevel,index);
		
		logInfo.pass("user is able to select role level as organization");
		 Thread.sleep(5000);
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	   }
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);}
		
	}

/*@Then("^select the Entity$")
public void SelectEntity()
{
	ExtentTest logInfo=null;
	try {
		
		logInfo= test.createNode(new GherkinKeyword("Then"), "select the Entity");
		WebElement SelectEntity= driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[3]/div/div/div[2]/app-role-create/div/div/form/div[3]/select"));
		int index=1;
		
		CommonMethods.SelectValueFromDropDown(SelectEntity,index);
		
		logInfo.pass("user is able to select Entity");
		 Thread.sleep(5000);
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	   }
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);}
		
	}*/


@Then("^select the role permissions$")
public void Rolepermissions()
{
	ExtentTest logInfo=null;
	try {
		logInfo= test.createNode(new GherkinKeyword("Then"), "select the role permissions");
								     

		driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[3]/div/div/div[2]/app-role-create/div/div/form/div[3]/div/div[1]/div[1]/input")).click();
		driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[3]/div/div/div[2]/app-role-create/div/div/form/div[3]/div/div[2]/div[3]/input")).click();
		Thread.sleep(9000);
		
		logInfo.pass("user is able to select role permissions");
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		 
		 
		/*List<WebElement> LevelPermissions_checkbox = driver.findElements(By.xpath("//strong[text()='Org Bolts&Nuts Resource']"));

			     int Permissionboxes=LevelPermissions_checkbox.size();
			     System.out.println("the Permissions present are " + Permissionboxes);
			     
			     Random role_random = new Random();
			     int LevelPermissions_index = role_random.nextInt(LevelPermissions_checkbox.size());
			     LevelPermissions_checkbox.get(LevelPermissions_index).click(); */

	   }
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);}
		
	}

@Then("^click on Save button$")
public void SaveRole()
{
	ExtentTest logInfo=null;
	try {
		logInfo= test.createNode(new GherkinKeyword("Then"), "click on Save button");
		
		driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[3]/div/div/div[2]/app-role-create/div/div/form/div[4]/button[2]")).click();
		Thread.sleep(5000);
		
		// Create instance of Javascript executor
		 
			/*	JavascriptExecutor je = (JavascriptExecutor) driver;
				WebElement element = driver.findElement(By.xpath("//button[.=' Save']"));
				Thread.sleep(5000);
				je.executeScript("arguments[0].scrollIntoView(true);",element);
				 
							     
				 logInfo.pass("user is able to select role permissions and click on save");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				 */
				 
				 //driver.findElement(By.xpath("//button[.=' Save']")).click();
				 //Thread.sleep(5000);
				 
		 logInfo.pass("user is able to Save the role");
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	   }
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);}
		
	}
    

@Then("^verify Role created succesfully$")
public void Verify_RoleCreated()
{
	
	ExtentTest logInfo=null;
	try {
							
		     logInfo=test.createNode(new GherkinKeyword("Then"), "verify Role created succesfully");
             WebDriverWait wait=new WebDriverWait(driver,200);
             WebElement Succesfull_message = driver.findElement(By.xpath("//div[text()='Role created successfully']"));
 			 wait.until(ExpectedConditions.visibilityOf(Succesfull_message));
 			 
             logInfo.pass("Role created successfully");
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

	} 
	
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);	
		
	}		
	
	}


@Then("^Search the Role in the search box$")
public void Search_Role()
{
	ExtentTest logInfo=null;
	try {
							
		     logInfo=test.createNode(new GherkinKeyword("Then"), "Search the Role in the search box");
		     
		     //to search the user in the search box
		     Thread.sleep(2000);
		     driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(excel.ReadDate("Sheet1", 0, 0));
		    // driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("TestAutomation");
		         Thread.sleep(2000);
		         
		         logInfo.pass("User is able to serach Role info");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
         }
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);	
		
	}		
}

@Then("^Verify Manage Role$")
public void Manage_Role1()
{
	ExtentTest logInfo=null;
	try {
		
		 logInfo=test.createNode(new GherkinKeyword("Then"), "Verify Manage Role");
		//click on ellipsis button
	    // driver.findElement(By.xpath("//mat-icon[text()='more_vert'][1]")).click();
		
		driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[2]/mat-table/mat-row[1]/mat-cell[4]/button/span/mat-icon")).click();
	     Thread.sleep(2000);
	     
	   //click on manage role 
	     driver.findElement(By.xpath("//span[text()='Manage role']")).click();
	     Thread.sleep(2000);
	     
	   //Actiave the Add role window
			driver.findElement(By.xpath("//div[@class='modal fade in show']/div/div")).click();
			Thread.sleep(2000);	
			
		//update role name
		//	driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("testAutomation123");
    	//	Thread.sleep(5000);
			
	     //Add some more permissions 
	     driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[4]/div/div/div[2]/app-role-manage/div/div/form/div[3]/div/div[1]/div[1]/input")).click();
	     Thread.sleep(5000);
	     
	     driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[4]/div/div/div[2]/app-role-manage/div/div/form/div[3]/div/div[2]/div[4]/input")).click();
	     Thread.sleep(5000);
	     
	     //Click on Save
	     driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[4]/div/div/div[2]/app-role-manage/div/div/form/div[4]/button[2]")).click();
			Thread.sleep(5000);
	     //driver.findElement(By.xpath("//button[.=' Save']")).click();
		 //Thread.sleep(5000);
         
         logInfo.pass("User is able to manage roles");
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		 
         }
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);	
		
	}	
}

@Then("^Verify Manage Members$")
public void Verify_ManageMembers()
{
	
	ExtentTest logInfo=null;
	try {
		logInfo=test.createNode(new GherkinKeyword("Then"), "Verify Manage Members");
		
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).clear();
		 driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(excel.ReadDate("Sheet1", 0, 0));
		 Thread.sleep(2000);
		//click on ellipsis button
		driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[2]/mat-table/mat-row[1]/mat-cell[4]/button/span/mat-icon")).click();
	     Thread.sleep(2000);
	     
		//click on manage role 
	     driver.findElement(By.xpath("//span[text()='Manage members']")).click();
	     Thread.sleep(2000);
	     
	     //click on Search Members and select it
	     driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).click();
	     Thread.sleep(2000);
	     
	   // WebElement  element1= driver.findElement(By.xpath("//span[@class='mat-option-text']"));
	     driver.findElement(By.xpath("/html/body/div[2]/div/div/div/mat-option[1]/span")).click();;
	     Thread.sleep(5000);
	     /*WebElement  element1=int index1=1;
		 CommonMethods.SelectValueFromDropDown(element1,index1);*/
	     
	     //Click on Add button
	     driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[5]/div/div/div[2]/app-role-member-manage/div/div/div/div[3]/div/div/app-auto-complete-search/div/button")).click();
	    // driver.findElement(By.xpath("//button[.='Add']")).click();
		 Thread.sleep(5000);
			 
		 logInfo.pass("User is able to Manage Members");
		 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	     
		 //Click on main fram to close the window
		// driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[5]")).click();
		/// Thread.sleep(5000);
		 

	} 
	
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);	
		
	}		
}	
/*
	@Then("^Verify Remove Role$")
	public void Verify_RoleRemoved()
	{
		
		ExtentTest logInfo=null;
		try {
			
			 logInfo=test.createNode(new GherkinKeyword("Then"), "Verify Remove Role");
			 
			 driver.findElement(By.xpath("//input[@id='mat-input-1']")).clear();
			 driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(excel.ReadDate("Sheet1", 0, 0));
			 Thread.sleep(2000);
			 
			//click on ellipsis button
			 driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[2]/mat-table/mat-row[1]/mat-cell[4]/button/span/mat-icon")).click();
		     Thread.sleep(2000);
		     
		     //click on Remove role 
		     driver.findElement(By.xpath("//span[text()='Remove']")).click();
		     Thread.sleep(2000);
		     
		     //driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[2]/app-role-data-table/div[5]/div/div/div[2]/app-role-member-manage/div/div/div/div[3]/div/div/app-auto-complete-search/div/button")).click();
		     //Thread.sleep(2000);
		     
		     logInfo.pass("User is able to Remove Roles");
			 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	
		} 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	*/
} 
