package ReusabilityMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods  {
	
	static WebElement driver;
	public static void performClickOnobject(WebElement element)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].click();", " ");
	}
	
	public static void ScrolldownToTheObject(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true);",element);	
	}


	public static void SelectValueFromDropDown(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	
	
	public static void p()
	{
		
		
	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
