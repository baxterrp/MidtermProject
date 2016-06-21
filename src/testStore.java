import java.util.ArrayList;
import java.util.Scanner;

public class testStore {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// who are you??/?
		System.out.print("What would you like to do? Add item / Purchase item");
		String option = scan.nextLine();
		System.out.println();
		if (Character.toLowerCase(option.charAt(0)) == 'a') {
			System.out
					.print("What would you like to add? Consumable, Housewares, Automobile : ");
			String cat = scan.nextLine();
			Product newProduct = null;
			// scan.in
			System.out.print("Enter a name: ");
			String name = scan.nextLine();
			// scan.in for price too
			System.out.print("Enter a price: ");
			double price = scan.nextDouble();
			System.out.println();

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

		} else {
			// constructor will call writetofile method

			ArrayList<String[]> products = FileOperations.getFile();

			System.out
					.println("Item\t\t\tCategory\t\tPrice\t\t\t\n****\t\t\t********\t\t*****");
			for (String[] s : products) {
				if (s[1].length() > 16) {
					System.out
							.println(s[1] + "\t" + s[2] + "\t\t" + "$" + s[3]);

				} else if (s[1].length() > 8) {
					System.out.println(s[1] + "\t\t" + s[2] + "\t\t" + "$"
							+ s[3]);

				} else {
					System.out.println(s[1] + "\t\t\t" + s[2] + "\t\t" + "$"
							+ s[3]);
				}
			}

			System.out.println("\nPlease select an item or checkout");
			String option2 = scan.nextLine();
		}

		// continue?

		// user
		// print menu
		// add to cart/ view menu // if no items in arraylist no checkout option
		// add to cart
		// scan.in >> item
		// additem / view menu / checkout
		scan.close();
	}

}
