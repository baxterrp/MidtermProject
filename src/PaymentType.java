import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PaymentType {
	
	public static void getType(double total){
		Scanner scan = new Scanner(System.in);
		String pType = "";
		int x = 0;
	do{
		try{	
		System.out.println("how would you like to pay? cash/check/card"	);
		pType = scan.nextLine();
		switch(pType){
		case "cash": System.out.println(PaymentType.getChange(total)); 
			break;
		case "check": System.out.print(PaymentType.getCheck(total));
			break;
		case "card": System.out.println(PaymentType.getCC(total));	
			break;
		}
	}catch (Exception e){
		System.out.println("cant do that");
	}
	}while(x == 0);
	}

	public static String getChange(double total){
		double cashPayed = 0;
		double change = 0;
		Scanner scan = new Scanner(System.in);
		boolean p = true;
	try {	
		while (p){	
		System.out.println("your total is " + (total - change) + ". How much cash are you paying with? \n");
		System.out.print("$");
		cashPayed  = scan.nextDouble();
		if (cashPayed >= total)
			{
			change = cashPayed - total;
			p = true;
			break;
			}
		else p = false;
		}
		}catch (Exception e) {
			System.out.println("try again");
		}
		String e = "your change is " + change + "$. thanks for shopping";
		return e;
	}
	
	public static String getCheck(double total){
		Scanner scan = new Scanner(System.in);
		
		String checkNo = "";
		System.out.println();
		System.out.println("please enter your checks routing, account and check #'s");
		checkNo = scan.nextLine();
		String r = "check no. " + checkNo + " was accepted. \n \n purchase of $" + total + " complete, thank you for shopping";
		return r;
	}
	
	
	public static String getCC(double total){
		Scanner scan = new Scanner(System.in);
		boolean t = true;
		String cn ="";
	while(cn.length() > 16 || cn.length() < 16){
		System.out.println("please enter 16-digit credit card number (no dashes)");
		
		cn = scan.nextLine();
//			if (cn.length() < 16) {
//				System.out.println("invalid, try again");
//				t =true;
//		}
//			else if (cn.length() > 16) {
//				System.out.println("invalid, try again");
//				t = true;
//			} else t = false;
//				break;
	}
//		System.out.println();
		System.out.println("please enter exp. date MM/YYYY");
		
		String d = scan.nextLine();
	//	DateFormat df = new SimpleDateFormat("mm/yyyy");
	//	String expDate = df.format(d);
		System.out.println();
		System.out.println("please enter CCV");
		int ccv = scan.nextInt();
		
		String c = "amount of $" + total + " charged to " + cn +
				". thank you for shopping";
	
		return c;
	
		
				
		
		
	}

}
