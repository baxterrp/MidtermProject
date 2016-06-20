import java.util.Scanner;

public class testStore {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// who are you??/?
		System.out
				.println("What would you like to add? Consumable, Housewares, Automobile");
		String cat = scan.nextLine();
		Product newProduct = null;
		// scan.in
		System.out.print("Enter a name: ");
		String name = scan.nextLine();
		// scan.in for price too
		System.out.print("Enter a price: ");
		double price = scan.nextDouble();
		// switch(in)
		// newProduct = new Consumable(in, price);
		switch (cat) {
		case "Consumable":
			newProduct = new Consumable(name, price);
			break;
		case "Housewares":
			newProduct = new Housewares(name, price);
			break;
		case "Automobile":
			newProduct = new Automobile(name, price);
			break;
		}
		// constructor will call writetofile method

		System.out.println(newProduct.toString());
		// continue?

		// user
		// print menu
		// add to cart/ view menu // if no items in arraylist no checkout option
		// add to cart
		// scan.in >> item
		// additem / view menu / checkout

	}

}
