import java.util.ArrayList;
import java.util.Scanner;

public class Vailidator {

	//Validates first question
	public static String getUserChoice(Scanner scan, String ans){
		while(Character.toLowerCase(ans.charAt(0))!='a' && (Character.toLowerCase(ans.charAt(0)) !='p')){
			System.out.println("Invaild input. You must choose \"Add item\" or \"Purchase item\"");
			
			ans = scan.nextLine();
		}
		return ans;
	}

	public static String getAddProduct(Scanner scan, String ans) {

		while (Character.toLowerCase(ans.charAt(0)) !='c' && Character.toLowerCase(ans.charAt(0)) != 'h'
			&& Character.toLowerCase(ans.charAt(0))!='a') {
			System.out
					.println("Invalid input. You must choose \"Consumables\" or \"Housewares\" or \"Automobile\"");
			ans = scan.nextLine();
		}
		return ans;
	}
	

	public static String getIndex(Scanner scan) {
		Scanner vScan = scan;
		boolean isValid = false;
		
		String ans = scan.nextLine();

		ArrayList<String[]> products = FileOperations.getFile();

		while (!isValid) {
			
	

			if (Character.toLowerCase(ans.charAt(0)) == 'o' || Character.toLowerCase(ans.charAt(0)) == 'm'
					|| Character.toLowerCase(ans.charAt(0)) == 'c') {
				isValid = true;
			} else {
				for (String[] s : products) {
					if (ans.equals(s[0])) {
						isValid = true;
						break;
					}
				}
			}
			if (!isValid) {
				System.out
						.println("Invalid input. You must choose \"item#\" or \"view order\" or \"view menu\" or \"checkout\"");
				ans = vScan.nextLine();
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

	//Validates checkout or add item
	public static String getCheckout(Scanner scan, String ans){
		while (Character.toLowerCase(ans.charAt(0)) !='s' && Character.toLowerCase(ans.charAt(0)) !='c'){
			System.out.println("Invalid input. You must choose \"Select an item\" or \"checkout\"");
			ans=scan.nextLine();
		}
		return ans;
	}


}