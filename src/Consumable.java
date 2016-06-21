
public class Consumable extends Product{

	public Consumable(String name, double price){
		setName(name);
		setPrice(price, price);
		setCategory("Consumable");
		
		FileOperations.writeToFile(5, getName(), getCategory(), getPrice(), getPostTax());
	}
	

}
