package pages;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.common;

public class ProductPage {
	
	public static String homePageTitle = "JungleSocks";  // can be read from file
	public static WebDriver driver;
	private By zebraQuantity = By.xpath(".//*[@id='line_item_quantity_zebra']");
	private By zebraPrice = By.xpath("html/body/form/table[1]/tbody/tr[2]/td[2]");
	private By lionQuantity = By.id("line_item_quantity_lion");
	private By lionPrice = By.xpath("html/body/form/table[1]/tbody/tr[3]/td[2]");
	private By elephantQunatity = By.id("line_item_quantity_elephant");
	private By elephantPrice = By.xpath("html/body/form/table[1]/tbody/tr[4]/td[2]");
	private By giraffeQuantity = By.id("line_item_quantity_giraffe");
	private By giraffePrice = By.xpath("html/body/form/table[1]/tbody/tr[5]/td[2]");
	private By stateDropDown = By.xpath("html/body/form/table[2]/tbody/tr/td[2]/select");
	private Select dropdown;
	private By checkoutButton = By.xpath("html/body/form/input");
	
	public ProductPage(WebDriver driver){
		this.driver = driver;
	}
	
	public ProductPage enterQuantityForZebra (String qty){
		driver.findElement(zebraQuantity).sendKeys(qty);
		return this;
	}
	
	public ProductPage enterQuantityForLion (String qty){
		driver.findElement(lionQuantity).sendKeys(qty);
		return this;
	}
	
	public ProductPage enterQuantityForElephant (String qty){
		driver.findElement(elephantQunatity).sendKeys(qty);
		return this;
	}
	
	public ProductPage enterQuantityForGiraffe (String qty){
		driver.findElement(giraffeQuantity).sendKeys(qty);
		return this;
	}
	
	public ProductPage selectState(String state){
		dropdown = new Select(driver.findElement(stateDropDown));
		dropdown.selectByValue(state);
		return this;
	}
	
	public CheckoutPage clickCheckout(){
		driver.findElement(checkoutButton).click();
		return new CheckoutPage(driver);
	}
	
	public Number getPriceForZibra() throws ParseException{
			return common.convertStringToNumber(driver.findElement(zebraPrice).getText());	
	}
	
	public Number getPriceForLion() throws ParseException{
		return common.convertStringToNumber(driver.findElement(lionPrice).getText());	
	}
	
	public Number getPriceForElephant() throws ParseException{
		return common.convertStringToNumber(driver.findElement(elephantPrice).getText());	
	}
	
	public Number getPriceForGiraffe() throws ParseException{
		return common.convertStringToNumber(driver.findElement(giraffePrice).getText());	
	}
	
	
}
