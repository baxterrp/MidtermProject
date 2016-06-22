
public class Consumable extends Product{

	//constructor sets id, name, prices, description, and category - calls writeToFile
	public Consumable(String name, double price, String description){
		setId();
		setName(name);
		setPrice(price, Double.toString(price));
		setDescription(description);
		setCategory("Consumable");
		
		//calls writeToFile passing variables
		FileOperations.writeToFile(getId(), getName(),  getCategory(), getDescription(), getPrice(), getPostTax());
	}
	

}
