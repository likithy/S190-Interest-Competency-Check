package Pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Libraries.CommonLibraries;
import Libraries.ObjectRepositories;
import Libraries.ProjectConstants;
import net.bytebuddy.utility.RandomString;

public class CheckOutPage {


	ObjectRepositories repository = new ObjectRepositories();
	CommonLibraries commonlib= new CommonLibraries();
	public  CheckOutPage(WebDriver driver,String TestCaseName,SoftAssert softassert )
	{
		
		//header check
	commonlib.CheckHeader(driver,softassert);
		//checkingfooter
		commonlib.CheckFooter(driver,softassert);
		
		
		switch(TestCaseName){
		case "TC_SummerDresses_CheckOut":
			CheckOutProcess(driver, softassert);
			break;
			
		}
		
		
	}

	public void CheckOutProcess(WebDriver driver,SoftAssert softassert)
	{
		WebElement element=repository.GetObject(driver, "TXT_Header_ProductPrice", softassert);
		
		String Total=element.getText();
		element=repository.GetObject(driver, "LNK_CheckOutPage_CheckOut", softassert);
		element.click();
		commonlib.waitForPageLoaded(driver, softassert);
		commonlib.WaitFor(driver, 30, softassert);
		element=repository.GetObject(driver, "TXT_CheckOutPage_RegisteredEmail", softassert);
		element.sendKeys(ProjectConstants.RegisteredEmail);
		commonlib.waitForPageLoaded(driver, softassert);
		commonlib.WaitFor(driver, 30, softassert);
		element=repository.GetObject(driver, "TXT_CheckOutPage_Pass", softassert);
		element.sendKeys(ProjectConstants.AccPass);
		commonlib.waitForPageLoaded(driver, softassert);
		commonlib.WaitFor(driver, 30, softassert);
		element=repository.GetObject(driver, "BTN_CheckOutPage_Login", softassert);
		element.click();
		commonlib.waitForPageLoaded(driver, softassert);
		commonlib.WaitFor(driver, 30, softassert);
		element=repository.GetObject(driver, "BTN_CheckOutPage_CheckOut", softassert);
		element.click();
		commonlib.waitForPageLoaded(driver, softassert);
		commonlib.WaitFor(driver, 30, softassert);
		element=repository.GetObject(driver, "BTN_CheckOutPage_AgreeTerms", softassert);
		element.click();
		commonlib.waitForPageLoaded(driver, softassert);
		commonlib.WaitFor(driver, 30, softassert);
		element=repository.GetObject(driver, "BTN_CheckOutPage_CheckOut2", softassert);
		element.click();
		commonlib.waitForPageLoaded(driver, softassert);
		commonlib.WaitFor(driver, 30, softassert);
		try {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());
		}
		catch(NoSuchElementException e)
		{
			softassert.fail();
		}
		
		element=repository.GetObject(driver, "BTN_CheckOutPage_PayByCheck", softassert);
		element.click();
		commonlib.waitForPageLoaded(driver, softassert);
		try {
			System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/div/h3")).getText());}
			catch(NoSuchElementException e)
			{
				softassert.fail();
			}
		element=repository.GetObject(driver, "BTN_CheckOutPage_ConfirmOrder", softassert);
		element.click();
		commonlib.waitForPageLoaded(driver, softassert);
		commonlib.WaitFor(driver, 30, softassert);
		element=repository.GetObject(driver, "TXT_CheckOutPage_OrderStatus", softassert);
		if(element.getText().contains("Your order on My Store is complete."))
		{
			System.out.println("Your order on My Store is complete.");
		}
		else
		{
			softassert.fail("order on My Store is not complete.");
		}
		

	}

	
}
