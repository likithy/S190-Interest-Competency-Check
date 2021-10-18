package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import Libraries.CommonLibraries;
import Libraries.ObjectRepositories;
import Libraries.ProjectConstants;

public class SummerDresses {


	ObjectRepositories repository = new ObjectRepositories();
	CommonLibraries commonlib= new CommonLibraries();
	
	public  SummerDresses(WebDriver driver,String TestCaseName,SoftAssert softassert )
	{
		//navigating to summerdressespage
		driver.get(ProjectConstants.SummerDresses);
		if("Summer Dresses - My Store".equals( driver.getTitle()))
		{
			System.out.println("Title Verified");
		}
		else
		{
		softassert.fail("Title Not Verified");
		
		}
		//checking header in SummerDresses page
		commonlib.CheckHeader(driver,softassert);
		//checkingfooter
		commonlib.CheckFooter(driver,softassert);
		
		
		switch(TestCaseName){
		case "TC_SummerDresses_VerifyFilters":
			CheckFilters(driver,softassert);
			break;
		case "TC_SummerDresses_VerifySorting":
			CheckSorting(driver, softassert);
			break;
		case "TC_SummerDresses_CheckOut":
			AddItemsToCart(driver, softassert);
			break;
			
		}
		
		
	}
	
	//filters check
	public void CheckFilters(WebDriver driver,SoftAssert softassert)
	{
		commonlib.CheckLoaderGIF(driver, "LIST_SummerDresses_Size",softassert);	
		
		driver.navigate().refresh();
		
		commonlib.CheckLoaderGIF(driver, "LIST_SummerDresses_Colors",softassert);
		
		driver.navigate().refresh();
		
		commonlib.CheckLoaderGIF(driver, "LIST_SummerDresses_Styles",softassert);
		
		driver.navigate().refresh();
		
		commonlib.CheckLoaderGIF(driver, "LIST_SummerDresses_Composition",softassert);
		
		driver.navigate().refresh();
		
		commonlib.CheckLoaderGIF(driver, "LIST_SummerDresses_Properties",softassert);
		
		driver.navigate().refresh();
		
		commonlib.CheckLoaderGIF(driver, "LIST_SummerDresses_Availability",softassert);
		
		driver.navigate().refresh();
		
		commonlib.CheckLoaderGIF(driver, "LIST_SummerDresses_Condition",softassert);
		
		driver.navigate().refresh();
		
		commonlib.CheckLoaderGIF(driver, "LIST_SummerDresses_Manufacturer",softassert);
		
		driver.navigate().refresh();	
		//price range check
		WebElement element=repository.GetObject(driver, "LNK_SummerDresses_PriceRange", softassert);
		element.sendKeys(Keys.ARROW_LEFT);
		String loadergif_xpath=repository.GetXpath( "IMG_SummerDresses_LoaderGif",softassert);
		try {
			driver.findElement(By.xpath(loadergif_xpath));
			softassert.fail("Filter Not Applied Successfully for LNK_SummerDresses_PriceRange " );
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Filter Applied Successfully");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		
		driver.navigate().refresh();	
		
	}
	
	
	public void AddItemsToCart(WebDriver driver,SoftAssert softassert)
	{
		WebElement element=repository.GetObject(driver, "LNK_SummerDresses_PrintedSummerDress", softassert);
		commonlib.HoverOver(driver, "LIST_SummerDresses_Product1", softassert);
		element.click();
		commonlib.waitForPageLoaded(driver, softassert);
		commonlib.WaitFor(driver, 40, softassert);
		
		element=repository.GetObject(driver, "LNK_Header_CheckOut", softassert);
		element.click();
		commonlib.WaitFor(driver, 30, softassert);
		
	}
	
//sort verification with all values
	public void CheckSorting(WebDriver driver,SoftAssert softassert)
	{
		
		Select Sort;
		Sort= new Select(repository.GetObject(driver, "DRPBX_SummerDresses_SelectSort", softassert));
		
		List<WebElement> options=Sort.getOptions();
		for(int i=0;i<options.size();i++)
		{
			Sort=new Select(repository.GetObject(driver, "DRPBX_SummerDresses_SelectSort", softassert));
			Sort.selectByIndex(i);
			String loadergif_xpath=repository.GetXpath( "IMG_SummerDresses_LoaderGif",softassert);
			try {
				driver.findElement(By.xpath(loadergif_xpath));
				softassert.fail("Sorting Not Applied Successfully for LNK_SummerDresses_PriceRange " );
				}
				catch(NoSuchElementException e)
				{
					System.out.println("Filter Applied Successfully");
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}
			
			driver.navigate().refresh();
			commonlib.waitForPageLoaded(driver,softassert);
			
		}
	}
}
