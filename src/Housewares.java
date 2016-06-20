
public class Housewares extends Product implements Taxable{
	
	public Housewares(String name, double price){
		setName(name);
		setPrice(price, applyTaxes(price));
		setCategory("Housewares");
	}
	
	//apply 6% sales tax to price
	public double applyTaxes(double price){
		
		double taxed = price*1.06;
		
		return taxed;
	}

}
