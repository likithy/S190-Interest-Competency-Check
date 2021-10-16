package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Libraries.Project;
import Libraries.ProjectConstants;

public class Tests {

	String ProjectPath = System.getProperty("user.dir");;
String driverPath=ProjectPath+"\\External Libraries\\Drivers\\chromedriver.exe";
WebDriver driver;

//Initializing the drivers and navigating to the main page

@BeforeTest

    public void setup() throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", driverPath);
        
        driver = new ChromeDriver();
 
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        driver.get(ProjectConstants.HOMEURL);
        driver.manage().window().maximize();
     
    }
    
//Test one to check the filters in SummerDresses Page
    @Test
    
    public void Verify_SummerDresses_filters()
    {
    	SoftAssert softassert = new SoftAssert();
    	Project RunProject= new Project();
    	
    	RunProject.RunTestCase(driver, "TC_SummerDresses_VerifyFilters",softassert);
    	softassert.assertAll();
    
    }

  //Test two to check the newsletter in home Page    
    @Test
    public void checknewsletter()
    {
    	SoftAssert softassert = new SoftAssert();
    	Project RunProject= new Project();
    	
    	RunProject.RunTestCase(driver, "TC_NewsLetter",softassert);
    	softassert.assertAll();
    
    }
//Test one to check the filters in SummerDresses Page    
    @Test
    public void Verify_SummerDresses_Sorting()
    {
    	SoftAssert softassert = new SoftAssert();
    	Project RunProject= new Project();
    	
    	RunProject.RunTestCase(driver, "TC_SummerDresses_VerifySorting",softassert);
    	softassert.assertAll();
    
    }

//method to close all the instances of the browser and kill the driver.
@AfterTest

public void closedrivers()
{
	driver.close();
	driver.quit();
}
}
