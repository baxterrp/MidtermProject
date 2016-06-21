import java.math.BigDecimal;
import java.math.RoundingMode;

public class Automobile extends Product implements Taxable {

	public Automobile(String name, double price, String description) {
		setId();
		setName(name);
		setPrice(price, applyTaxes(price));
		setDescription(description);
		setCategory("Automobile");

		FileOperations.writeToFile(getId(), getName(),  getCategory(), getDescription(), getPrice(), getPostTax());
	}

	// apply 6% sales tax to price
	public double applyTaxes(double price) {

		double taxed = price * 1.06;

		BigDecimal bd = new BigDecimal(taxed).setScale(2,
				RoundingMode.HALF_EVEN);

		taxed = bd.doubleValue();

		return taxed;
	}
}
