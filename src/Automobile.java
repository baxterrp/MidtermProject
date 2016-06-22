import java.math.BigDecimal;
import java.math.RoundingMode;

public class Automobile extends Product implements Taxable {

	
	//constructor sets id, name, prices, description, and category
	public Automobile(String name, double price, String description) {
		setId();
		setName(name);
		setPrice(price, applyTaxes(price));
		setDescription(description);
		setCategory("Automobile");

		FileOperations.writeToFile(getId(), getName(),  getCategory(), getDescription(), getPrice(), getPostTax());
	}

	// apply 6% sales tax to price
	//return a string
	public String applyTaxes(double price){
		
		double taxed = price*1.06;
		
		return String.format("%.2f", taxed);
	}
}
