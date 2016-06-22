import java.util.ArrayList;

public abstract class Product {

	// main variables
	private int id;
	private String category;
	private String name;
	private double price;
	private double postTax;
	private String description;

	// sets description as string
	public void setDescription(String description) {
		this.description = description;
	}

	// sets returns
	public String getDescription() {
		return description;
	}

	// sets name as string
	public void setName(String name) {
		this.name = name;
	}

	// returns name
	public String getName() {
		return name;
	}

	// sets both price and postTax prices as doubles
	public void setPrice(double pretax, String postTax) {
		this.price = pretax;
		this.postTax = Double.parseDouble(postTax);
	}

	// returns price
	public double getPrice() {
		return price;
	}

	// returns postTax
	public double getPostTax() {
		return postTax;
	}

	// returns category
	public String getCategory() {
		return category;
	}

	// set id gets file - loops through each String[] in file - checks index 0
	// for id to find latest id and increment by 1
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

	// returns id
	public int getId() {
		return id;
	}

	// sets category as string
	public void setCategory(String category) {
		this.category = category;
	}

}
