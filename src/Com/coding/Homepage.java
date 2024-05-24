package Com.coding;
import java.util.Scanner;
public class Homepage {
    private static int id;
    private String name;
    private String cardNo;
    private int PIN;
    private int balance;
    private static Scanner sc = new Scanner(System.in);
    public static void detailsadd() {
        System.out.print("Enter NAME    : ");
        String name = sc.nextLine();
        System.out.print("CARD NUMBER   : ");
        String card = sc.next(); 
        System.out.print("Enter PIN : ");
        int pin = sc.nextInt(); 
        Homepage u = new Homepage(name, card, pin);
        if (Dao.detailsadd(u)) {
            System.out.println(" Added Success!");
            System.out.println("Welcome! " + u.getName());
        } else {
            System.out.println("Failed To Add customer!");
        }
    }
    public static void login() {
		System.out.print("Enter a cardno : ");
		String cardno = sc.next();
		System.out.println("Enter a PIN :  ");
		int pin =sc.nextInt();
		Homepage u = Dao.login(cardno,pin);
		if(u!=null) {
			while(true) {
			Dashboard(u);
			        System.out.println("|~~~~~~~~~~ATM Panal~~~~~~~~~~~~~~~|");
			        System.out.println("|******* 1.check Balance **********|");
			        System.out.println("|******* 2.Change PIN *************|");
			        System.out.println("|******* 3.Withdrawl***************|");
			        System.out.println("|******* 4.Deposit*****************|");
			        System.out.println("|******* 5. Exit ******************|");
			        System.out.println("          Enter your choice :       ");
			        int choice =sc.nextInt();
			        switch(choice) {
			            case 1 :
			            	checkbalance(u);
			                break;
			            case 2 :
			                   changepin(u); 
			                break;
			            case 3 :
			            	withamo(u);
			            	break;
			            case 4 :
			            	depositamo(u);
			                break;
			            case 5:
			            	
			                System.out.println("\n******Bye__Bye user********");
			                System.exit(0);
			                
			                break;
			            default :
			                System.out.println("*****try Again!*****");
			        }
			        }
			    } else {
			        System.out.println("User is Not Available");
			    }
		
	}
    public static void depositamo(Homepage u) {
    	System.out.print("Enter Balance To Deposit : ");
    	int bal = sc.nextInt();
    	UpdateBalance(u,bal);
    }
    public static void withamo(Homepage u) {
    	System.out.print("Enter Balance To Withdrawl : ");
    	int bal = sc.nextInt();
    	UpdateBalance(u,-bal);
    }
    public static void changepin(Homepage u) {
        System.out.print("Enter New PIN: ");
        int newPin = sc.nextInt();
        u.setPIN(newPin); // Update the PIN in the object
        
        if (Dao.updatePin(u)) {
            System.out.println("PIN changed successfully!");
        } else {
            System.out.println("Failed to change PIN.");
        }
    }

    public static void Dashboard(Homepage u) {
		
    	System.out.println("Welcome, "+u.getName());
	}
    
    // deposit amount
    
    public static boolean UpdateBalance(Homepage u,int balance) {
    	 u.setBalance(u.getBalance()+balance);
    	 if (Dao.depositamo(u)) {
             System.out.println("Amount Update succesfull !");
         } else {
             System.out.println("Failed To amount!");
         }
		return false;
    	    	
    }
    // view checkbalance 
    
    public static void checkbalance(Homepage u) {
    	System.out.println("User Id : "+u.getId());
    	System.out.println("Balance : "+u.getBalance());    	
    }
    
    
	public Homepage(String name, String cardNo, int PIN) {
        this.name = name;
        this.cardNo = cardNo;
        this.PIN = PIN;
       
    }
	public Homepage(int balance) {
		this.balance =balance;
	}

    public Homepage() {
		
	}
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
