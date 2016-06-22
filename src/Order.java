import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Order {

	private ArrayList<String[]> products = FileOperations.getFile();
	private ArrayList<Integer> newOrder = new ArrayList<Integer>();

	// user chooses items - they are added to newOrder by id number
	public void addItem(int id, int quantity) {
		for (int i = 0; i < quantity; i++) {
			newOrder.add(id);
		}
	}

	// getFile() reads file and adds item's id to arrayList;

	public String printOrder() {

		double subTotal = 0;
		String output = "";

		System.out.println("Item#\t\tItem\t\t\tCategory\t\tPrice\t\t\t\n*****\t\t****\t\t\t********\t\t*****");
		for (int i : newOrder) {
			for (String[] s : products) {
				if (i == Integer.parseInt(s[0])) {

					if (s[1].length() > 15) {
						output += s[0] + "\t\t" + s[1] + "\t" + s[2] + "\t\t" + "$" + s[4] + "\n";

					} else if (s[1].length() > 7) {
						output += s[0] + "\t\t" + s[1] + "\t\t" + s[2] + "\t\t" + "$" + s[4] + "\n";

					} else {
						output += s[0] + "\t\t" + s[1] + "\t\t\t" + s[2] + "\t\t" + "$" + s[4] + "\n";
					}

					subTotal += Double.parseDouble(s[4]);

					BigDecimal bd = new BigDecimal(subTotal).setScale(2, RoundingMode.HALF_UP);

					subTotal = bd.doubleValue();
				}
			}
		}

		output += "\nSub Total\t\t\t\t\t\t\t$" + String.format("%.2f",subTotal);

		return output;
	}

	// checkout
	public void checkout() {

		// print current order
		String output = printOrder() + "\n";

		// set totals to 0
		double total = 0;
		double subTotal = 0;

		// loop through order by id - check order id's against id's stored in
		// file - add price and postTax to total and subtotal
		for (int i : newOrder) {
			for (String[] s : products) {
				if (i == Integer.parseInt(s[0])) {
					total += Double.parseDouble(s[5]);
					subTotal += Double.parseDouble(s[4]);
				}
			}
		}

		// calculate amount of taxes by subtracting subTotal from total
		double taxes = total - subTotal;

		// output totals
		output += "Taxes\t\t\t\t\t\t\t\t$" + String.format("%.2f", taxes) + "\n\n";
		output += "Total\t\t\t\t\t\t\t\t$" + String.format("%.2f", total);
		System.out.println(output);
		PaymentType.getType(total);
	}

	// print menu loops through products printing out each item line by line
	public void printMenu() {
		System.out.println(
				"Item#\t\tItem\t\t\tCategory\t\tPrice\t\tItem Description\n****\t\t****\t\t\t********\t\t*****\t\t****************");
		for (String[] s : products) {
			if (s[1].length() > 14) {
				System.out.println(s[0] + "\t\t" + s[1] + "\t" + s[2] + "\t\t" + "$" + s[4] + "\t\t" + s[3]);

			} else if (s[1].length() > 7) {
				System.out.println(s[0] + "\t\t" + s[1] + "\t\t" + s[2] + "\t\t" + "$" + s[4] + "\t\t" + s[3]);

			} else {
				System.out.println(s[0] + "\t\t" + s[1] + "\t\t\t" + s[2] + "\t\t" + "$" + s[4] + "\t\t" + s[3]);

			}
		}
	}
}
