package tests;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.ProductPage;

import utils.common;

public class ProductTests {
	
	public static final String HOMEPAGE = "https://jungle-socks.herokuapp.com/";
	WebDriver driver ;
	ProductPage objProduct;
	CheckoutPage objChkout;
	
	@BeforeMethod
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.get(HOMEPAGE);
		objProduct = new ProductPage(driver);
		
	}
	/* Test for product Zebra , State CA , Calculates product subtotal based on price */
	@Test
	  void testSubTotalForProductZebra() throws ParseException{
		  int qty = 2;
		  objProduct.enterQuantityForZebra("2")
		  .selectState("CA");
		  Double expected = common.calculatePrice(objProduct.getPriceForZibra(), qty); 
		  objChkout = objProduct.clickCheckout();
		  Double actual = objChkout.getSubtotal().doubleValue();
		  assertEquals(expected ,actual);	  
	 }
	/* Test for product Lion , State NY , Calculates product subtotal based on price */
	@Test
	  void testSubTotalForProductLion() throws ParseException{
		 objProduct.enterQuantityForLion("3")
		  .selectState("NY");
		  Double expected = common.calculatePrice(objProduct.getPriceForLion(), 3); 
		  objChkout = objProduct.clickCheckout();
		  Double actual = objChkout.getSubtotal().doubleValue();
		  assertEquals(expected ,actual);	  
	 }
	/* Test for product Elephant , State CT , Calculates product subtotal based on price */
	@Test
	  void testSubTotalForProductElephant() throws ParseException{
		 objProduct.enterQuantityForElephant("4")
		  .selectState("CT");
		  Double expected = common.calculatePrice(objProduct.getPriceForElephant(), 4); 
		  objChkout = objProduct.clickCheckout();
		  Double actual = objChkout.getSubtotal().doubleValue();
		  assertEquals(expected ,actual);	  
	 }
	
	/* Test for product Giraffe , State CT , Calculates product subtotal based on price */
	@Test
	  void testSubTotalForProductGiraffe() throws ParseException{
		 objProduct.enterQuantityForGiraffe("4")
		  .selectState("CT");
		  Double expected = common.calculatePrice(objProduct.getPriceForGiraffe(), 4); 
		  objChkout = objProduct.clickCheckout();
		  Double actual = objChkout.getSubtotal().doubleValue();
		  assertEquals(expected ,actual);	  
	 }
	
	@Test
	  void testSubTotalForAll(){
		 //TODO	  
	 }
	
	@Test
	  void testInvalidInput(){
		//TODO -- no error displayed on website for negative input or incorrect value
	}
	
	 @AfterMethod
	  public void afterTest(){
		  driver.close();
	  }
}
