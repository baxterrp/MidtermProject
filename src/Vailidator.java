import java.util.ArrayList;
import java.util.Scanner;

public class Vailidator {
	// Validates first question
	public static String getUserChoice(Scanner scan, String ans) {
		while (!ans.equalsIgnoreCase("Add item")
				&& !ans.equalsIgnoreCase("Purchase item")) {
			System.out
					.println("Invalid input. You must choose \"Add item\" or \"Purchase item\"");
			ans = scan.nextLine();
		}
		return ans;
	}

	public static String getAddProduct(Scanner scan, String ans) {
		Scanner vScan = scan;
		boolean isValid = false;
		while (!isValid) {
			if (!(ans.equals("Consumable"))
					&& !(ans.equalsIgnoreCase("Housewares"))
					&& !(ans.equalsIgnoreCase("Automobile"))) {
				System.out
						.println("Invalid input. You must choose \"Consumables\" or \"Housewares\" or \"Automobile\"");
				ans = vScan.nextLine();
			} else {
				isValid = true;
			}
		}
		return ans;
	}

	public static String getIndex(Scanner scan, String ans) {
		Scanner vScan = scan;
		boolean isValid = false;

		ArrayList<String[]> products = FileOperations.getFile();

		while (!isValid) {

			if (ans.equals("view order") || ans.equals("view menu")
					|| ans.equals("checkout")) {
				isValid = true;
			} else {
				for (String[] s : products) {
					if (ans.equals(s[0])) {
						isValid = true;
						break;
					}
				}
				if (!isValid) {
					System.out
							.println("Invalid input. You must choose \"item#\" or \"view order\" or \"view menu\" or \"checkout\"");
					ans = vScan.nextLine();
				}
			}
		}
		return ans;
	}

	public static String getContinue(Scanner scan, String ans) {
		while (Character.toLowerCase(ans.charAt(0)) != 'y'
				&& Character.toLowerCase(ans.charAt(0)) != 'n') {
			System.out.println("Invalid input. You must choose \"y\" or \"n\"");
			ans = scan.nextLine();
		}
		return ans;
	}
}