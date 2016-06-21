public abstract class Product {

	private int id;
	private String category;
	private String name;
	private double price;
	private double postTax;

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public void setPrice(double pretax, double postTax) {
		this.price = pretax;
		this.postTax = postTax;
	}
	
	public double getPrice(){
		return price;
	}

	public double getPostTax(){
		return postTax;
	}
	
	public String getCategory(){
		return category;
	}
	
	public int getId(){
		return id;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	// for testing purposes
	public String toString() {
		return "Product \t: " + name + "\nCategory \t: " + category
				+ "\nPrice \t\t: $" + price + "\nPost Tax Price \t: $"
				+ postTax;
	}
}
