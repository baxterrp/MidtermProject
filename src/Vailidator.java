import java.util.ArrayList;
import java.util.Scanner;
public class Vailidator {
	//Validates first question
	public static String getUserChoice(Scanner scan, String ans){
		while(!ans.equalsIgnoreCase("Add item") && !ans.equalsIgnoreCase("Purchase item")){
			System.out.println("Invaild input. You must choose \"Add item\" or \"Purchase item\"");
			ans = scan.nextLine();
		}
		return ans;
	}

	public static String getAddProduct(Scanner scan, String ans) {
		while (!ans.equalsIgnoreCase("Consumables") || !ans.equalsIgnoreCase("Housewares")
				|| !ans.equalsIgnoreCase("Automobile")) {
			System.out
					.println("Invalid input. You must choose \"Consumables\" or \"Housewares\" or \"Automobile\"");
			ans = scan.nextLine();
		}
		return ans;
	}
		public static String getIndex(Scanner scan, String ans){
			boolean isValid = false;
			ArrayList<String[]> products = FileOperations.getFile();
				while(!isValid){
					for(String [] s : products){
						if (ans.equals(s[0])){
							isValid = true;
						}else
						System.out.println("Invalid input. You must choose \"item#\" or \"view order\" or \"view menu\" or \"checkout\"");
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
		while (!ans.equalsIgnoreCase("Please select an item") && !ans.equalsIgnoreCase("checkout")){
			System.out.println("Invalid input. You must choose \"Please select an item\" or \"checkout\"");
			ans=scan.nextLine();
		}
		return ans;
	}
}