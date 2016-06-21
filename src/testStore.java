import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class testStore {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// who are you??/?
		System.out.print("What would you like to do? Add item / Purchase item");
		String option = scan.nextLine();
		option = Vailidator.getUserChoice(scan, option);
		System.out.println();
		if (Character.toLowerCase(option.charAt(0)) == 'a') {
			System.out
					.print("What would you like to add? Consumable, Housewares, Automobile : ");
			String cat = scan.nextLine();
			Product newProduct = null;
			cat = Vailidator.getAddProduct(scan, cat);
			// scan.in
			System.out.print("Enter a name: ");
			String name = scan.nextLine();
			// scan.in for price too
			System.out.print("Enter a price: ");
			double price = scan.nextDouble();
			System.out.println();
			String continueAdd = "yes";


			do {

				System.out
						.print("What would you like to add? Consumable, Housewares, Automobile : ");
				cat = scan.nextLine();
				newProduct = null;
				// scan.in
				System.out.print("Enter a name: ");
				name = scan.nextLine();
				// scan.in for price too
				System.out.print("Enter a price: ");
				price = scan.nextDouble();
				scan.nextLine();
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
				System.out.println("Add another?");
				continueAdd = scan.nextLine();
			} while (Character.toLowerCase(continueAdd.charAt(0)) == 'y');
		} else {
			// constructor will call writetofile method

			ArrayList<String[]> products = FileOperations.getFile();
			Order newOrder = new Order();

			newOrder.printMenu();
			String option2 = "";

			do {

				System.out
						.println("\nPlease select an item#, view order, view menu, or checkout");
				option2 = scan.nextLine();
				Vailidator.getIndex(scan, option2);

				if (option2.equals("view order")) {
					// run printOrder
					System.out.println(newOrder.printOrder());

				} else if (option2.equals("checkout")) {
					newOrder.checkout();
				} else if (option2.equals("view menu")) {
					newOrder.printMenu();
				} else {
					// add item to order
					System.out.print("How many?");
					int quantity = scan.nextInt();
					scan.nextLine();
					for (String[] s : products) {
						if (s[0].equals(option2)) {
							newOrder.addItem(Integer.parseInt(s[0]), quantity);
							double cost = quantity * Double.parseDouble(s[3]);
							BigDecimal bd = new BigDecimal(cost).setScale(2,
									RoundingMode.HALF_EVEN);

							cost = bd.doubleValue();

							System.out.println(quantity + " * " + s[1] + " : $"
									+ cost);
						}
					}
				}
			} while (!option2.equals("checkout"));

/*			System.out.println("\nPlease select an item or checkout");
			option2 = scan.nextLine();
			option2 = Vailidator.getCheckout(scan, option2);*/

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
