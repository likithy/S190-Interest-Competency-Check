package Libraries;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;



public class ObjectRepositories {


	
	static CommonLibraries CommonLib= new CommonLibraries();
	//return object by different selectors
	public  By ReturnObject(WebDriver driver,String header,String[] locatordetails,SoftAssert softassert) {
		
		String locatorType = locatordetails[0];
		String value = locatordetails[1];
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		By by = null;
		try {
		switch (locatorType) {
		case "id":
			by = By.id(value);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			break;
		case "name":
			by = By.name(value);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			break;
		case "xpath":
			by = By.xpath(value);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			break;
		case "css":
			by = By.cssSelector(value);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			break;
		case "linkText":
			by = By.linkText(value);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			break;
		default:
			by = null;
			break;
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Element Doesnt Not Exists Element Name : "+header);
			
					}
		return by;
	}
	
	//getobject locators
	public  WebElement GetObject(WebDriver driver, String header,SoftAssert softassert) {
		String[] arrObjectLocators = GetObjectlocators(header,softassert);
		By byGetObject = ReturnObject(driver,header,arrObjectLocators,softassert);
		WebElement objElement = null;
		try {
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			objElement = driver.findElement(byGetObject);
			System.out.println("Element Exists - "+header);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Element Doesnt Not Exists Element Name : "+header);
			

			
		}
		
	
		
return objElement;
	}
	
	//get xpath of object
	public String GetXpath(String header,SoftAssert softassert)
	{
		String[] arrObjectLocators = GetObjectlocators(header,softassert);
		return arrObjectLocators[1];
	}
	
	//get multiple elements into list
	public  List<WebElement> GetObjects(WebDriver driver, String header,SoftAssert softassert) {
		String[] arrObjectLocators = GetObjectlocators(header,softassert);
		By byGetObject = ReturnObject(driver,header,arrObjectLocators,softassert);
		
		List<WebElement> objElement =null;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objElement=driver.findElements(byGetObject);
		System.out.println("Element Exists - "+header);
		
		}
catch (NoSuchElementException e) {
			
			e.printStackTrace();
			System.out.println("Element Doesnt Not Exists Element Name : "+header);
			
						
		}
		
		return objElement;
		}
	//get size of elements under the object
	public  int GetObjectsSize(WebDriver driver, String header,SoftAssert softassert) {
		
		return GetObjects(driver, header,softassert).size();
		
		
		}
	
	//storing paths of different objects
	public static String[] GetObjectlocators(String header,SoftAssert softassert) {
		String[] locatordetails = new String[2];
		switch (header) {	
		
		case "DIV_Header":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"header\"]/div//div";
			break;
		
		case "DIV_Footer":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"footer\"]/div//div";
			break;
		
		case "TXT_NewsletterInputBox":
			locatordetails[0] = "id";
			locatordetails[1] = "newsletter-input";
			break;

		case "BTN_NewsletterSubmit":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"newsletter_block_left\"]/div/form/div/button";
			break;

		case "TXT_NewsletterEmailStatus":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"columns\"]/p";
			break;

		case "LIST_SummerDresses_Size":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"ul_layered_id_attribute_group_1\"]/li";
			break;

		case "IMG_SummerDresses_LoaderGif":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"center_column\"]/ul/p/img";
			break;


		case "LIST_SummerDresses_Colors":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"ul_layered_id_attribute_group_3\"]/li";
			break;
			
		case "LIST_SummerDresses_Styles":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"ul_layered_id_feature_6\"]/li";
			break;	
			
		case "LIST_SummerDresses_Composition":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"ul_layered_id_feature_5\"]/li";
			break;			
		
		case "LIST_SummerDresses_Properties":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"ul_layered_id_feature_7\"]/li";
			break;
			
		case "LIST_SummerDresses_Availability":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"ul_layered_quantity_0\"]/li";
			break;
		
		case "LIST_SummerDresses_Condition":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"ul_layered_condition_0\"]/li";
			break;
			
		case "LIST_SummerDresses_Manufacturer":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"ul_layered_manufacturer_0\"]/li";
			break;
		
		case "LNK_SummerDresses_PriceRange":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id='layered_price_slider']/a[1]";
			break;
		
		case "DRPBX_SummerDresses_SelectSort":
			locatordetails[0] = "id";
			locatordetails[1] = "selectProductSort";
			break;
			
		case "LNK_SummerDresses_PrintedSummerDress":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]";
			break;	
			
		case "LIST_SummerDresses_Product1":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"center_column\"]/ul/li[1]";
			break;
			
		case "LNK_Header_Cart":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a";
			break;

		case "LNK_Header_Checkout":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"button_order_cart\"]";
			break;
			
		case "DIV_Header_ProductStatus":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2";
			break;
			
		case "LNK_Header_CheckOut":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a";
			break;
			
		case "TXT_Header_ProductPrice":
			locatordetails[0] = "id";
			locatordetails[1] = "total_price_container";
			break;
			
		case "LNK_CheckOutPage_CheckOut":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"center_column\"]/p[2]/a[1]";
			break;
			
		case "TXT_CheckOutPage_RegisteredEmail":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"email\"]";
			break;
			

		case "TXT_CheckOutPage_Pass":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"passwd\"]";
			break;
			

		case "BTN_CheckOutPage_Login":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"SubmitLogin\"]";
			break;
			
		case "BTN_CheckOutPage_CheckOut":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"center_column\"]/form/p/button";
			break;
			
		case "BTN_CheckOutPage_AgreeTerms":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"cgv\"]";
			break;

		case "BTN_CheckOutPage_CheckOut2":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"form\"]/p/button";
			break;

		case "BTN_CheckOutPage_PayByCheck":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a";
			break;

		case "BTN_CheckOutPage_ConfirmOrder":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"cart_navigation\"]/button";
			break;
			
		case "TXT_CheckOutPage_OrderStatus":
			locatordetails[0] = "xpath";
			locatordetails[1] = "//*[@id=\"center_column\"]/p[1]";
			break;
			
			
			
		}
	return locatordetails;
	}
}
