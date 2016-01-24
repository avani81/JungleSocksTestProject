package tests;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.ProductPage;

public class BrowserTests {
	
	public static final String HOMEPAGE = "https://jungle-socks.herokuapp.com/";
	WebDriver driver ;
	ProductPage objProduct;
	CheckoutPage objChkout;
	
	
	 @BeforeTest
	 @Parameters("browser")
	  public void beforeTest(String browser) throws Exception{
		 if(browser.equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();
		 }else if (browser.equalsIgnoreCase("chrome")){
			 System.setProperty("webdriver.chrome.driver", "chromedriver");
			 driver = new ChromeDriver();
		 }else
			 throw new Exception("Browser is not correct");
		  
		 driver.get(HOMEPAGE);
		 objProduct = new ProductPage(driver);
		  
	  }
	 /* This test will load home page and verify all UI elements
	  * text fields and state dropdown  , click on checkout */
	 @Test
	  public void loadHomePage() throws ParseException{
		  String homePageTitle = "JungleSocks"; 
		  assertEquals(driver.getTitle(),homePageTitle);
		  objProduct.enterQuantityForZebra("1")
		  .enterQuantityForElephant("2")
		  .enterQuantityForGiraffe("3")
		  .enterQuantityForLion("2")
		  .selectState("CA");
		  objChkout = objProduct.clickCheckout();
		  assertEquals(driver.getTitle(),homePageTitle);
	  }
	  
	  @AfterMethod
	  public void afterTest(){
		  driver.close();
	  }
	  

}
