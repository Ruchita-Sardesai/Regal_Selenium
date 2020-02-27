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

public class UsersPage extends ExtentReportListener {

	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	ExcelDataConfig excel=new ExcelDataConfig();

	
    
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
				logInfo=test.createNode(new GherkinKeyword("Then"), "Verify user is on the homepage and click on Users");
				WebElement users=driver.findElement(By.xpath("//span[text()='Users']"));
				WebDriverWait wait= new WebDriverWait(driver,120);
				wait.until(ExpectedConditions.visibilityOf(users));
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
	public void click_add_user()
	{
		
		ExtentTest logInfo=null;
		try {
								
			     logInfo=test.createNode(new GherkinKeyword("Then"), "Click on Add users button");
	             driver.findElement(By.xpath("//button[text()='Add User']")).click();
	             Thread.sleep(2000);
	             logInfo.pass("Add Users pop up got displayed");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	
		} 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
	
	
	//to create the username and storing into excel
 	String value=RandomStringUtils.randomAlphabetic(8);
 	String name= value + "@regal-us.com";
 	String username=name;
 /*	excel.WriteData("Users", 1, 1, name);
 	Thread.sleep(3000); */
	
	@Then("^Enter the email and select the role and entity$")
	public void enter_details()
	{
		ExtentTest logInfo=null;
		try {
								
			     logInfo=test.createNode(new GherkinKeyword("Then"), "Enter the email and select the role and entity");
			     
			     
			 	driver.findElement(By.xpath("//div[@class='modal fade in show']/div/div")).click();
			     
			   
			     
			  // CommonMethods.switchToFrame();
			  /*    String mainWindow=driver.getWindowHandle();
			     System.out.println("the windows opened are" + mainWindow);
			     Thread.sleep(3000);
			     
			     Set<String> windows =driver.getWindowHandles();
			    
			     // Using Iterator to iterate with in windows
			     Iterator<String> itr= windows.iterator();
			     
			     while(itr.hasNext())
			     {
			     String childWindow=itr.next();
			     System.out.println("quick debug" + childWindow );
			     
			        // Compare whether the main windows is not equal to child window. If not equal, we will close.
			     if(!mainWindow.equals(childWindow))
			     {
			    	
			     driver.switchTo().window(childWindow);
			     System.out.println(driver.switchTo().window(childWindow).getTitle()); 
			     Thread.sleep(3000);
			     
                } 
			      
			     
			     }   */
			     
			    
			
			 	
			    driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(username);
			    Thread.sleep(3000);
			     
			     
			    
			    //this is to select the role 
			    //select multiple roles
			     List<WebElement> checkBoxes = driver.findElements(By.xpath("//strong[text()='Role']/ancestor::label/following-sibling::div[1]/div/div/input[1]"));
			     for(int i=0; i<checkBoxes.size(); i=i+4){
			    	    checkBoxes.get(i).click();
			    	    }
			    	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    	    int checkedCount=0, uncheckedCount=0;
			    	    for(int i=0; i<checkBoxes.size(); i++){
			    	    System.out.println(i+" checkbox is selected "+checkBoxes.get(i).isSelected());
			    	    if(checkBoxes.get(i).isSelected()){
			    	                checkedCount++;
			    	            }else{
			    	                uncheckedCount++;
			    	            }
			    	        }
			    	        System.out.println("number of selected checkbox: "+checkedCount);
			    	        System.out.println("number of unselected checkbox: "+uncheckedCount);
			    
			    //to select single role        
//			     int Roleboxes=Role_checkbox.size();
//			     System.out.println("the roles present are " + Roleboxes);
//			     
//			     Random role_random = new Random();
//			     int role_index = role_random.nextInt(Role_checkbox.size());
//			     Role_checkbox.get(role_index).click(); 
			     
			     
			    //this is to select the entity 
			    //select multiple entities	        
                 List<WebElement> Entity_checkbox = driver.findElements(By.xpath("//strong[text()='Entities']/ancestor::label/following-sibling::div[1]/div/app-tree-with-checkbox/mat-tree/mat-tree-node[1]/button/following-sibling::mat-checkbox"));
                 for(int i=0; i<Entity_checkbox.size(); i=i+4){
                	 Entity_checkbox.get(i).click();
			    	    }
			    	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    	    int entity_checkedCount=0, entity_uncheckedCount=0;
			    	    for(int i=0; i<Entity_checkbox.size(); i++){
			    	    System.out.println(i+" checkbox is selected "+Entity_checkbox.get(i).isSelected());
			    	    if(Entity_checkbox.get(i).isSelected()){
			    	    	entity_checkedCount++;
			    	            }else{
			    	            	entity_uncheckedCount++;
			    	            }
			    	        }
			    	        System.out.println("number of selected checkbox: "+entity_checkedCount);
			    	        System.out.println("number of unselected checkbox: "+entity_uncheckedCount);
                 
			    	        logInfo.pass("User info added");
							logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
                 
                 
//			    //to select single entity 
//			     int Entityboxes=Entity_checkbox.size();
//			     System.out.println("the entities present are " + Entityboxes);
//			     
//			     Random entity_random = new Random();
//			     int entity_index = entity_random.nextInt(Entity_checkbox.size());
//			     Entity_checkbox.get(entity_index).click(); 
			     Thread.sleep(5000);
			     
			     
				
				 WebElement save_button = driver.findElement(By.xpath("//button[.=' Save']"));
				 save_button.click();
				 Thread.sleep(3000); 
			     
				 
          } 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
	
		
	
	@Then("^verify user created succesfully$")
	public void Verify_userCreated()
	{
		
		ExtentTest logInfo=null;
		try {
								
			     logInfo=test.createNode(new GherkinKeyword("Then"), "verify user created succesfully");
	             WebDriverWait wait=new WebDriverWait(driver,20);
	             WebElement Succesfull_message = driver.findElement(By.xpath("//div[text()='User created successfully']"));
	 			 wait.until(ExpectedConditions.visibilityOf(Succesfull_message));
	             logInfo.pass("User Created Successfully");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	
		} 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
	
	
	
	
 	@And("^Search the user in the search box and select the manage user by clickin on ellipsis icon$")
	public void search_user()
	{
		ExtentTest logInfo=null;
		try {
								
			     logInfo=test.createNode(new GherkinKeyword("And"), "Search the user in the search box and select the manage user by clickin on ellipsis icon");
			     
			     //to search the user in the search box
			     Thread.sleep(2000);
			     driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(username);
			     Thread.sleep(3000);
               // code to write for comparison
			     
			     
			     
			     //click on ellipsis button
			     driver.findElement(By.xpath("//mat-icon[text()='more_vert'][1]")).click();
			     Thread.sleep(3000);
			     
			     
			     
			     logInfo.pass("clicked on ellipsis");
				 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			 
          } 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
	     
	
 	
    //Manage user
 	@Then("^Click on manage user$")
	public void manage_user()
	{
		ExtentTest logInfo=null;
		try {
								
			     logInfo=test.createNode(new GherkinKeyword("Then"), "Click on manage user");
			     
			
			  	//click on manage user 
			     driver.findElement(By.xpath("//span[text()='Manage User']")).click();
			     Thread.sleep(3000);
 	           
//			    List<WebElement> Role_checkbox = driver.findElements(By.xpath("//strong[text()='Role']/ancestor::label/following-sibling::div[1]/div/div/input[1]"));
//			    Random role_random = new Random();
//			    WebElement ele = null;
//			    int role_index = role_random.nextInt(Role_checkbox.size());
//			    if (!ele.isSelected())
//			        ele.click();
//			  //  Role_checkbox.get(role_index).click(); 
//                Thread.sleep(3000);
// 	
//                
//                List<WebElement> Entity_checkbox = driver.findElements(By.xpath("//strong[text()='Entities']/ancestor::label/following-sibling::div[1]/div/app-tree-with-checkbox/mat-tree/mat-tree-node[1]/button/following-sibling::mat-checkbox"));
//			    Random entity_random = new Random();
//			    WebElement entity_ele = null;
//			    int entity_index = role_random.nextInt(Entity_checkbox.size());
//			    if (!entity_ele.isSelected())
//			    	entity_ele.click();
 	            Thread.sleep(16000);
 	            
 	           
 	            //click on save button
 	            driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[1]/app-user-data-table/div[3]/div/div/div[2]/app-user-manage/div/div/form/following-sibling::div/button[text()=' Save']")).click();
 	            Thread.sleep(3000);
 	            
// 	           //click on cancel button
// 	            driver.findElement(By.xpath("/html/body/app-default-layout/app-side-nav/div/div[2]/app-user-list/div[2]/div[1]/app-user-data-table/div[3]/div/div/div[2]/app-user-manage/div/div/form/following-sibling::div/button[text()=' Cancel']")).click();
// 	            Thread.sleep(3000);
 	            
 	           logInfo.pass("user is able to do manage");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 	
           } 
		
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);	
			
		}		
	}	
	     
 	
 	
 	
 	
 	    //Resend invite
 	 	@Then("^Click on Resend_Invite$")
 		public void resend_Invite()
 		{
 			ExtentTest logInfo=null;
 			try {
 									
 				     logInfo=test.createNode(new GherkinKeyword("Then"), "Resend_Invite");
 				     
 				   //to search the user in the search box
 				     Thread.sleep(2000);
 				    driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
 				    Thread.sleep(4000);
 				     driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(username);
 				     Thread.sleep(3000);
 	              
 				     
 				     
 				     
 				     //click on ellipsis button
 				     driver.findElement(By.xpath("//mat-icon[text()='more_vert'][1]")).click();
 				     Thread.sleep(3000);
 				
 				    //click on Resend invite user 
 				     driver.findElement(By.xpath("//span[text()='Resend invite']")).click();
 				     Thread.sleep(4000);
 				     
 				    driver.findElement(By.xpath("//div[@class='modal-dialog custom-alert']/div[@class='modal-content']")).click();
 				    Thread.sleep(3000);
 				    
 				    driver.findElement(By.xpath("//button[text()='Yes']")).click();
				    Thread.sleep(3000);
 				     
//				    driver.findElement(By.xpath("//button[text()='No']")).click();
//				    Thread.sleep(3000);
 	
 	
 	
 	
 	
 				    logInfo.pass("user is able to resend invitation");
 					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 	 	
 	           } 
 			
 			catch (AssertionError | Exception e) {
 				testStepHandle("FAIL",driver,logInfo,e);	
 				
 			}		
 		}	
 	
 	
 	
 	
 	 //Remove the user from organization
 	 	@Then("^Click on Remove user$")
 		public void click_Remove()
 		{
 			ExtentTest logInfo=null;
 			try {
 									
 				     logInfo=test.createNode(new GherkinKeyword("Then"), "Remove_user");
 				     
 				   //to search the user in the search box
 				     Thread.sleep(2000);
 				    driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
 				    Thread.sleep(4000);
 				     driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(username);
 				     Thread.sleep(3000);
 	              
 				     
 				     
 				     
 				     //click on ellipsis button
 				     driver.findElement(By.xpath("//mat-icon[text()='more_vert'][1]")).click();
 				     Thread.sleep(3000);
 				
 				    //click on Resend invite user 
 				     driver.findElement(By.xpath("//span[text()='Remove from organization']")).click();
 				     Thread.sleep(4000);
 				     
 				    driver.findElement(By.xpath("//div[@class='modal-dialog custom-alert']/div[@class='modal-content']")).click();
 				    Thread.sleep(3000);
 				    
 				    driver.findElement(By.xpath("//button[text()='Yes']")).click();
				    Thread.sleep(3000);
 				     
//				    driver.findElement(By.xpath("//button[text()='No']")).click();
//				    Thread.sleep(3000);
 	
 	
 	
 	
 	
 				    logInfo.pass("user is able to remove the user from organization");
 					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 	 	
 	           } 
 			
 			catch (AssertionError | Exception e) {
 				testStepHandle("FAIL",driver,logInfo,e);	
 				
 			}		
 		}	
 	
 	
 	
 	
 	 	@Then("^verify user removed succesfully$")
 		public void Verify_user_Removed()
 		{
 			
 			ExtentTest logInfo=null;
 			try {
 									
 				     logInfo=test.createNode(new GherkinKeyword("Then"), "verify user removed succesfully");
 		             WebDriverWait wait=new WebDriverWait(driver,20);
 		             WebElement Succesfull_message = driver.findElement(By.xpath("//div[text()='User removed from Organization successfully']"));
 		 			 wait.until(ExpectedConditions.visibilityOf(Succesfull_message));
 		             logInfo.pass("User Removed Successfully");
 					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 		
 			} 
 			
 			catch (AssertionError | Exception e) {
 				testStepHandle("FAIL",driver,logInfo,e);	
 				
 			}		
 		}	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
			     
			     
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
		

