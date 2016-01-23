package pages;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.common;

public class CheckoutPage {
	public static String pageTitle = "JungleSocks";  // can be read from file
	public static WebDriver driver;
	private By subtotal = By.xpath(".//*[@id='subtotal']");
	private By taxes = By.xpath(" .//*[@id='taxes']");
	private By total = By.xpath(".//*[@id='total']");

	public CheckoutPage(WebDriver driver){
		this.driver = driver;
	}
	
	/*public String getSubtotal() throws ParseException{
		//convertStringToNumber(driver.findElement(subtotal).getText(),Locale.US);
		//convertStringToNumber(driver.findElement(taxes).getText(),Locale.US);
		//convertStringToNumber(driver.findElement(total).getText(),Locale.US);
		return driver.findElement(subtotal).getText();
	}*/
	
	public Number getSubtotal() throws ParseException{
		return common.convertStringToNumber(driver.findElement(subtotal).getText());	
	}
	
	public Number getTotal() throws ParseException{
		return common.convertStringToNumber(driver.findElement(total).getText());
	}
	
	public Number gettaxes() throws ParseException{
		return common.convertStringToNumber(driver.findElement(taxes).getText());
	}
	
	

}
