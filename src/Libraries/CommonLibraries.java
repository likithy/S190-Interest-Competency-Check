package Libraries;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class CommonLibraries {
	
	static ObjectRepositories repository = new ObjectRepositories();
	
	static int header_checkcount;
	private static int HeaderDivSize;
	static int footer_checkcount;
	private static int FooterDivSize;
 
	//wait till dom of the page is ready
	public void waitForPageLoaded(WebDriver driver,SoftAssert softassert) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
           driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            softassert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
	
	public void WaitFor(WebDriver driver,int time,SoftAssert softassert)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
public void HoverOver(WebDriver driver,String header,SoftAssert softassert)
{
	WebElement ele = repository.GetObject(driver, header, softassert);

	//Creating object of an Actions class
	Actions action = new Actions(driver);

	//Performing the mouse hover action on the target element.
	action.moveToElement(ele).perform();
	
}

	//set div's under header for home page
	public void setHeaderSize(int value,SoftAssert softassert)
	{
		HeaderDivSize=value;
	}
	//get div's under header count from home page 
	public int getHeaderSize(SoftAssert softassert)
	{
		return HeaderDivSize;
	}
	
	//set div's under footer for home page
	public void setFooterSize(int value,SoftAssert softassert)
	{
		FooterDivSize=value;
	}
	
	//get div's under footer count from home page 
	public int getFooterSize(SoftAssert softassert)
	{
		return FooterDivSize;
	}
	
	//verifying header
	public void CheckHeader(WebDriver driver,SoftAssert softassert)
	{
	
		List<WebElement> Header=repository.GetObjects(driver, "DIV_Header",softassert);
		
		
		waitForPageLoaded(driver, softassert);
		
	header_checkcount++;
	
	if(header_checkcount ==1)
	{
		//set number of div's under footer in home page;
		setHeaderSize(Header.size(),softassert);
		
		if(HeaderDivSize>0)
		{
			System.out.println("Header is present");
		}
		else {
			softassert.fail("Header is not present");
			
		}
	}
	
	else {
		
		int divs_under=Header.size();
		//checking number of div's under header with no of div's under footer from home page
		if(divs_under>=getHeaderSize(softassert))
		{
			System.out.println("Header is present");
		}
		else {
			softassert.fail("Header is not present");

		}
		
	}
	
	WaitFor(driver, 30, softassert);

		}
	
	//footer verification
		public void CheckFooter(WebDriver driver,SoftAssert softassert)
	{
	
		List<WebElement> Header=repository.GetObjects(driver, "DIV_Footer",softassert);
		
		
		waitForPageLoaded(driver, softassert);
		
	footer_checkcount++;
	
	if(footer_checkcount ==1)
	{
		//set number of div's under footer in home page;
		setFooterSize(Header.size(),softassert);
		
		if(FooterDivSize>0)
		{
			System.out.println("Footer is present");
		}
		else {
			softassert.fail("Footer is not present");
			
		}
	}
	
	else {
		
		int divs_under=Header.size();
		//checking number of div's under header with no of div's under footer from home page
		if(divs_under>=getFooterSize(softassert))
		{
			System.out.println("Footer is present");
		}
		else {
			softassert.fail("Footer is not present");

		}
		
	}
	
	WaitFor(driver, 30, softassert);

		}

			
	
	//checking if loader gif is present in the page for error;
	public void CheckLoaderGIF(WebDriver driver,String header,SoftAssert softassert)
	{
		
		
		//boolean checkfilters=true;
		int size=repository.GetObjectsSize(driver, header,softassert);
		for(int i=0;i<size;i++)
		{
		
			List<WebElement> element=repository.GetObjects(driver, header,softassert);
			element.get(i).findElement(By.tagName("input")).click();
			String value=element.get(i).findElement(By.tagName("a")).getText();
			waitForPageLoaded(driver,softassert);
			String loadergif_xpath=repository.GetXpath( "IMG_SummerDresses_LoaderGif",softassert);
			try {
			driver.findElement(By.xpath(loadergif_xpath));
			softassert.fail("Filter Not Applied Successfully for "+header+" - "+value);
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Filter Applied Successfully");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			
			driver.navigate().refresh();
			waitForPageLoaded(driver,softassert);
		}
		
		

	}
	
}
