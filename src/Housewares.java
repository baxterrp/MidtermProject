import java.math.BigDecimal;
import java.math.RoundingMode;


public class Housewares extends Product implements Taxable{
	
	//constructor sets id, name, prices, description, and category - calls writeToFile
	public Housewares(String name, double price, String description){
		setId();
		setName(name);
		setPrice(price, applyTaxes(price));
		setDescription(description);
		setCategory("Housewares");
		
		//calls writeToFile passing variables
		FileOperations.writeToFile(getId(), getName(),  getCategory(), getDescription(), getPrice(), getPostTax());
	}
	
	//apply 6% sales tax to price - return as string
	public String applyTaxes(double price){
		
		double taxed = price*1.06;
		
		return String.format("%.2f", taxed);
	}

}
