import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class testStore {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("What would you like to do? Add item / Purchase item");
		String option = scan.nextLine();
		option = Validator.getUserChoice(scan, option);
		System.out.println();

		String cat = "";
		if (Character.toLowerCase(option.charAt(0)) == 'a') {

			String continueAdd = "yes";
			Product newProduct = null;

			do {
				System.out
						.print("What would you like to add? Consumable, Housewares, Automobile : ");
				cat = scan.nextLine();
				cat = Validator.getAddProduct(scan, cat);
				// scan.in
				System.out.print("Enter a name: ");
				String name = scan.nextLine();
				System.out.println("Enter a description");
				String description = scan.nextLine();
				// scan.in for price too
				System.out.print("Enter a price: ");
				double price = scan.nextDouble();
				System.out.println();
				scan.nextLine();

				switch (cat) {
				case "Consumable":
					newProduct = new Consumable(name, price, description);
					System.out.println("Food added");
					break;
				case "Housewares":
					newProduct = new Housewares(name, price, description);
					break;
				case "Automobile":
					newProduct = new Automobile(name, price, description);
					break;
				}
				System.out.println(continueAdd);
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

				option2 = Validator.getIndex(scan);

				if (Character.toLowerCase(option2.charAt(0)) == 'o') {
					// run printOrder
					System.out.println(newOrder.printOrder());

				} else if (Character.toLowerCase(option2.charAt(0)) == 'c') {
					newOrder.checkout();
				} else if (Character.toLowerCase(option2.charAt(0)) == 'm') {
					newOrder.printMenu();
				} else {
					// add item to order
					System.out.print("How many?");
					int quantity = scan.nextInt();
					scan.nextLine();
					for (String[] s : products) {
						if (s[0].equals(option2)) {
							newOrder.addItem(Integer.parseInt(s[0]), quantity);
							double cost = quantity * Double.parseDouble(s[4]);
							BigDecimal bd = new BigDecimal(cost).setScale(2,
									RoundingMode.HALF_UP);

							cost = bd.doubleValue();

							System.out.println(quantity + " * " + s[1] + " : $"
									+ cost);
						}
					}
				}
			} while (!option2.equals("checkout"));

		}

		scan.close();
	}
}
