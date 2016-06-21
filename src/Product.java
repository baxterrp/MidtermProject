import java.util.ArrayList;

public abstract class Product {

	private int id;
	private String category;
	private String name;
	private double price;
	private double postTax;
	private String description;

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double pretax, double postTax) {
		this.price = pretax;
		this.postTax = postTax;
	}

	public double getPrice() {
		return price;
	}

	public double getPostTax() {
		return postTax;
	}

	public String getCategory() {
		return category;
	}

	public void setId() {
		ArrayList<String[]> products = FileOperations.getFile();
		int maxId = 0;

		for (String[] s : products) {
			if (Integer.parseInt(s[0]) > maxId) {
				maxId = Integer.parseInt(s[0]);
			}

		}

		maxId += 1;

		this.id = maxId;
	}

	public int getId() {
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
