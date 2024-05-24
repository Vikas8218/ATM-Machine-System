package Com.coding;
import java.util.Scanner;

public class indexpage {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(true) {
			System.out.println("****Welcome to ATM Project****");
			System.out.println(" |****1.Add New Customer Details**|");
			System.out.println(" |****2.Swipe a card*******|");
			System.out.println(" |**********Exit**********|");
			System.out.println("    Enter a your choice");
			int choice =sc.nextInt();
			switch(choice) {
			case 1 :
				Homepage.detailsadd();
				break;
			case 2 :
				Homepage.login();
			 break;
			case 3 :
		        System.exit(0);
		        System.out.println("Bye_Bye_Customer");
				break; 
			case 4 :
				default :
					System.out.println("worng details");
				
			
			}
			
			
		}

	}

}
