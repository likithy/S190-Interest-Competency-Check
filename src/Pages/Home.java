package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Libraries.CommonLibraries;
import Libraries.ObjectRepositories;
import Libraries.ProjectConstants;


public class Home {


	ObjectRepositories repository = new ObjectRepositories();
	CommonLibraries commonlib= new CommonLibraries();
	//Constructor to select differect test cases 
	public Home(WebDriver driver,String TestCaseName ,SoftAssert softassert)
	{
	//checking header in homepage
		if(commonlib.CheckHeader(driver,softassert))
		{
			System.out.println("Header Verified");
		}
		else
		{
			Assert.fail("Header not verified");
		}
	//checking footer in homepage
		if(commonlib.CheckFooter(driver, softassert))
		{
			System.out.println("Footer Verified");
		}
		else
		{
			softassert.fail("Footer not verified");
		}
		
		switch(TestCaseName){
		case "TC_NewsLetter":
			CheckNewsLetter(driver, softassert);
			break;
		
		}
	}
	
	//newsletter verification
	
	public void CheckNewsLetter(WebDriver driver,SoftAssert softassert)
	{
		WebElement Newsletter=repository.GetObject(driver, "TXT_NewsletterInputBox",softassert);
		Newsletter.sendKeys(ProjectConstants.NewsLetterEmail);
		
		softassert.assertEquals(Newsletter.getAttribute("value"), ProjectConstants.NewsLetterEmail);

		Newsletter=repository.GetObject(driver, "BTN_NewsletterSubmit",softassert);
		Newsletter.click();
		commonlib.waitForPageLoaded(driver,softassert);
		Newsletter=repository.GetObject(driver, "TXT_NewsletterEmailStatus",softassert);
		Newsletter.getText();
		if(Newsletter.getText().contains("already registered."))
		{
			System.out.println("This email address is already registered.");
		}
		else if(Newsletter.getText().contains("successfully subscribed"))
		{
			System.out.println("Successfully subscribed to this newsletter");	
		}
		else
		{
			softassert.fail("Message Displayed on page : "+Newsletter.getText());
		
		}
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
		

	
}
