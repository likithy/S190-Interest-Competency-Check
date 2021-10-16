package Libraries;


import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import Pages.Home;
import Pages.SummerDresses;



public class Project {
public void RunTestCase(WebDriver driver, String TestCaseName, SoftAssert softassert) {
		
	Home home=new Home(driver,TestCaseName,softassert);

   
	SummerDresses summerdress=new SummerDresses(driver,TestCaseName,softassert);
		
	}
}
