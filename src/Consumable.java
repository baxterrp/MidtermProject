
public class Consumable extends Product{

	public Consumable(String name, double price, String description){
		setId();
		setName(name);
		setPrice(price, price);
		setDescription(description);
		setCategory("Consumable");
		
		FileOperations.writeToFile(getId(), getName(),  getCategory(), getDescription(), getPrice(), getPostTax());
	}
	

}
