import java.math.BigDecimal;
import java.math.RoundingMode;


public class Housewares extends Product implements Taxable{
	
	public Housewares(String name, double price){
		setId();
		setName(name);
		setPrice(price, applyTaxes(price));
		setCategory("Housewares");
		
		FileOperations.writeToFile(getId(), getName(), getCategory(), getPrice(), getPostTax());
	}
	
	//apply 6% sales tax to price
	public double applyTaxes(double price){
		
		double taxed = price*1.06;
		
		BigDecimal bd = new BigDecimal(taxed).setScale(2,
				RoundingMode.HALF_EVEN);
		
		taxed = bd.doubleValue();
		
		return taxed;
	}

}
