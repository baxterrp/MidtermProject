public abstract class Product {

	private int id;
	private String category;
	private String name;
	private double price;
	private double postTax;

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double pretax, double postTax) {
		this.price = pretax;
		this.postTax = postTax;
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
