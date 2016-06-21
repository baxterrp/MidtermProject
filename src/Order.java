import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Order {

	ArrayList<Integer> newOrder = new ArrayList<Integer>();

	public Order() {

	}

	// user chooses items - they are added to newOrder by id number
	public void addItem(int id) {
		newOrder.add(id);
	}

	// getFile() reads file and adds item's id to arrayList;

	public String printOrder() {

		ArrayList<String[]> products = FileOperations.getFile();
		double subTotal = 0;
		String output = "";

		System.out
				.println("Item\t\t\tCategory\t\tPrice\t\t\t\n****\t\t\t********\t\t*****");
		for (int i : newOrder) {
			for (String[] s : products) {
				if (i == Integer.parseInt(s[0])) {

					if (s[1].length() > 16) {
						output += s[1] + "\t" + s[2] + "\t\t" + "$" + s[3]
								+ "\n";

					} else if (s[1].length() > 8) {
						output += s[1] + "\t\t" + s[2] + "\t\t" + "$" + s[3]
								+ "\n";

					} else {
						output += s[1] + "\t\t\t" + s[2] + "\t\t" + "$" + s[3]
								+ "\n";
					}

					subTotal += Double.parseDouble(s[3]);
					
					BigDecimal bd = new BigDecimal(subTotal).setScale(2,
							RoundingMode.HALF_EVEN);
					
					subTotal = bd.doubleValue();
				}
			}
		}

		output += "\nSub Total\t\t\t\t\t$" + subTotal;

		return output;
	}
}
