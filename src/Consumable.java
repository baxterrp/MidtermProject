
public class Consumable extends Product{

	public Consumable(String name, double price){
		setId();
		setName(name);
		setPrice(price, price);
		setCategory("Consumable");
		
		FileOperations.writeToFile(getId(), getName(), getCategory(), getPrice(), getPostTax());
	}
	

}
