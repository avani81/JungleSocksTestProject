package utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class common {
	
	public static Number convertStringToNumber(String amt , Locale locale) throws ParseException{
	NumberFormat format = NumberFormat.getNumberInstance(locale);
	Number subt = format.parse(amt.replaceAll("[^\\d.,]",""));
	return subt;
	}
	
	public static Number convertStringToNumber(String amt ) throws ParseException{
		NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
		Number subt = format.parse(amt.replaceAll("[^\\d.,]",""));
		return subt;
	}
	
	public static Double calculatePrice(Number price , int qty){
		 return price.doubleValue() * qty;
	  }
	  
	  public static Double calculateSalesTax(Number subtotal, double percent){
		  return subtotal.doubleValue() * percent;
	  }

}
