import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

public class PaymentType {

	public static double getType(double total) {
		Scanner scan = new Scanner(System.in);
		String pType = "";
		int x = 0;

		do {
			try {
				System.out
						.println("how would you like to pay? cash/check/card");
				pType = scan.nextLine();
				switch (pType) {
				case "cash":
					return (PaymentType.getChange(total));
				case "check":
					return (PaymentType.getCheck(total));
				case "card":
					return (PaymentType.getCC(total));
				}
			} catch (Exception e) {
				System.out.println("invalid input. please try again.");
			}
		} while (x == 0);

		return 0;
	}

	public static double getChange(double total) {
		double cashPayed = 0;
		double change = 0;
		Scanner scan = new Scanner(System.in);
		int p = 0;

		// BigDecimal bd1 = new BigDecimal(total).setScale(2,
		// RoundingMode.HALF_UP);
		// total = bd1.doubleValue();
		try {
			while (p == 0) {
				System.out.println("you owe $" + String.format("%.2f", total)
						+ ". How much cash are you paying with? \n");
				System.out.print("$");
				cashPayed = scan.nextDouble();
				if (cashPayed >= total) {
					change = cashPayed - total;
					p = 1;
					break;
				} else if (cashPayed < total) {
					total = total - cashPayed;
					p = 0;
				} else
					p = 0;
			}
		} catch (Exception e) {
			System.out.println("try again");
		}
		String c = "";
		if (change > 0) {
			System.out.println("your change is $"
					+ String.format("%.2f", change) + ". thanks for shopping");
		} else
			System.out.println("\nGreat, Thanks for shopping!");
		return change;
	}

	public static double getCheck(double total) {
		Scanner scan = new Scanner(System.in);
		int t = 0;
		int cn = 0;
		String checkNo = "";
		do {
			try {
				System.out.println();
				System.out
						.println("please enter your checks routing, account and check #'s");

				checkNo = scan.nextLine();
				cn = Integer.parseInt(checkNo);
				t = 1;
				break;
			} catch (Exception e) {
				System.out.println("invalid input. please try again.");

			}

		} while (t == 0);
		System.out.println("check no. " + cn
				+ " was accepted.\n\nPurchase of $"
				+ String.format("%.2f", total)
				+ " complete, thank you for shopping.");
		return 0;

	}

	public static double getCC(double total) {
		Scanner scan = new Scanner(System.in);
		int t = 0;
		String cn = "";

		try {
			while (cn.length() > 16 || cn.length() < 16) {
				System.out
						.println("please enter 16-digit credit card number (no dashes)");

				cn = scan.nextLine();

			}
		} catch (Exception e) {
			System.out.println("invalid input. please try again.");

		}
		DateFormat df = new SimpleDateFormat("mm/yyyy");
		String d = "";
		do {
			try {

				System.out.println("please enter exp. date MM/YYYY");

				d = scan.nextLine();
				t = 1;
				break;
				// Date exp = (java.sql.Date) df.parse(d);
			} catch (Exception e) {
				System.out.println("invalid input. please try again.");
				t = 0;
			}
		} while (t == 0);
		// String expDate = df.format(d);
		do {
			try {
				System.out.println();
				System.out.println("please enter CCV");
				int ccv = scan.nextInt();
				t = 0;
				break;
			} catch (Exception e) {
				System.out.println("invalid input. please try again.");
				t = 0;
			}
		} while (t == 0);
		System.out.println("amount of $" + String.format("%.2f", total)
				+ " charged to " + cn + ". thank you for shopping." + "");

		return 0;

	}

}
