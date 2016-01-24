package tests;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.ProductPage;

import utils.common;

public class StateTest {
	
	public static final String HOMEPAGE = "https://jungle-socks.herokuapp.com/";
	WebDriver driver ;
	ProductPage objProduct;
	CheckoutPage objChkout;
	
	@DataProvider
	public Object[][] AllStatesProvider() {
		return new Object[][]{
			{ "CA", 0.08 },{ "NY", 0.06 },
			{ "MN", 0.00 },{ "AL", 0.05 },
			{ "AR", 0.05 },{ "ID", 0.05 },
			{ "AK", 0.05 },{ "IL", 0.05 },
			{ "CO", 0.05 },{ "IN", 0.05 },
			{ "CT", 0.05 },{ "IA", 0.05 },
			{ "DE", 0.05 },{ "KS", 0.05 },
			{ "FL", 0.05 },{ "KY", 0.05 },
			{ "GA", 0.05 },{ "LA", 0.05 },
			{ "HI", 0.05 },{ "ME", 0.05 },
			{ "MD", 0.05 },{ "MA", 0.05 },
			{ "MI", 0.05 },
			{ "MS", 0.05 },{ "MO", 0.05 },
			{ "MT", 0.05 },{ "NE", 0.05 },
			{ "NV", 0.05 },{ "NH", 0.05 },
			{ "NJ", 0.05 },{ "NM", 0.05 },
			{ "NC", 0.05 },{ "ND", 0.10 },
			{ "OH", 0.05 },{ "OK", 0.05 },
			{ "OR", 0.05 },{ "PA", 0.05 },
			{ "RI", 0.05 },{ "SC", 0.05 },{ "SD", 0.05 },{ "TX", 0.05 },
			{ "TN", 0.05 },{ "UT", 0.05 },{ "VT", 0.05 },{ "VA", 0.05 },
			{ "WA", 0.05 },{ "WV", 0.05 },{ "WI", 0.05 },{ "WY", 0.05 }		
		};
	}
	
	@DataProvider
	public Object[][] TestStatesProvider() {
		return new Object[][]{
			{ "CA", 0.08 },{ "NY", 0.06 },
			{ "MN", 0.00 },{ "AL", 0.05 },
			{ "CT", 0.05 },{ "ND", 0.10 }
		};
		
	}
	
	@BeforeMethod
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.get(HOMEPAGE);
		objProduct = new ProductPage(driver);
		
	}	
	/*
	 * 
	 *
	 */
	@Test(dataProvider = "TestStatesProvider")
	//@Test(dataProvider ="AllStatesProvider")
	void testValidateSalesTax(String state, Double tax) throws ParseException{
		  int qty = 1;
		  objProduct.enterQuantityForZebra("1")
		  .selectState(state);
		  Double expectedSubtotal = common.calculatePrice(objProduct.getPriceForZibra(), qty);
		  Double expectedSalesTax = common.calculateSalesTax(expectedSubtotal, tax);
		  Double expectedTotal = expectedSubtotal + expectedSalesTax;
		  objChkout = objProduct.clickCheckout();
		  Double actualTotal = objChkout.getTotal().doubleValue(); 
		  Double actualSubtotal = objChkout.getSubtotal().doubleValue();
		  Double actualSalesTax = objChkout.gettaxes().doubleValue();
		  assertEquals(expectedTotal , actualTotal);
		  assertEquals(expectedSubtotal , actualSubtotal);
		  assertEquals(expectedSalesTax ,actualSalesTax);		  
	}
	
	
	@AfterMethod
	  public void afterTest(){
		  driver.close();
	  }

}
