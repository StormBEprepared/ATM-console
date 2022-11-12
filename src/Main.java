import java.util.Scanner;
import java.text.MessageFormat;
import java.util.HashMap;


public class Main {
	    public static HashMap<String, String> Accounts = new HashMap<String, String>();	
	    public static HashMap<String, Integer> Balances = new HashMap<String, Integer>();
	    public static boolean Logged = false; 
	    public static String LoggedUsername;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Accounts.put("stefan", "password");
	    Accounts.put("paula", "pass");
	    Accounts.put("Kevin", "psswrd");
	    Accounts.put("Umar", "pswrd1");
	    //System.out.println(Accounts);
	    
	    Balances.put("stefan", 5000);
	    Balances.put("paula", 6000);
	    Balances.put("Kevin", 3500);
	    Balances.put("Umar",2000);
	    
	    //System.out.println(Accounts);
	    
	    LRmenu();
	    
	}
	public static void LRmenu()
	{
		 Scanner s = new Scanner(System.in);
		 System.out.println("Choose 1 for Login");
         System.out.println("Choose 2 for Register");
         System.out.println("Choose 3 to Exit");

         int n = s.nextInt();
         switch(n)
         {
         case 1:
        	 Login();
        	 break;
         case 2:
        	 Register();
        	 break;
         case 3:
        	 System.exit(0);
         }
	}
	public static void Menu(String account, int balance )
	{
		int withdraw, deposit;
		 Scanner s = new Scanner(System.in);
	        while(true)
	        {
	            System.out.println("Automated Teller Machine");
	            System.out.println("Choose 1 for Withdraw");
	            System.out.println("Choose 2 for Deposit");
	            System.out.println("Choose 3 for Check Balance");
	            System.out.println("Choose 4 for Password Change");
	            System.out.println("Choose 5 for EXIT");
	            System.out.print("Choose the operation you want to perform:");
	            int n = s.nextInt();
	            switch(n)
	            {
	                case 1:
	                System.out.print("Enter money to be withdrawn:");
	                withdraw = s.nextInt();
	                if(balance >= withdraw)
	                {
	                    balance = balance - withdraw;
	                    System.out.println("Please collect your money");
	                }
	                else
	                {
	                    System.out.println("Insufficient Balance");
	                }
	                System.out.println("");
	                break;
	 
	                case 2:
	                System.out.print("Enter money to be deposited:");
	                deposit = s.nextInt();
	                balance = balance + deposit;
	                System.out.println("Your Money has been successfully depsited");
	                System.out.println("");
	                break;
	 
	                case 3:
	                System.out.println("Balance : "+balance);
	                System.out.println("");
	                break;

	                case 4:
	                System.out.println("Enter your current password:");
	                String password = Accounts.get(account);
	                String InputPass= s.next();
	                if(InputPass.equalsIgnoreCase(password))
	                {
	                	System.out.println("Password OK. Now enter the new password:");
	                	String newPass= s.next();
	                	Accounts.put(account, newPass);
	                	System.out.println("Password changed succesfull.");
	                }
	                else
	                {
	                	System.out.println("Wrong password.");
	                }
	                System.out.println("");
	                break;
	                
	                case 5:
	                System.exit(0);
	            }
	        }
	}
	public static void Login()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your username:");
		String username = s.next();
		if(Accounts.containsKey(username))
		{
			System.out.println("Enter your password:");
			String password = s.next();			
			if(Accounts.get(username).equalsIgnoreCase(password))//something goes wrong here It DOES NOT read the HashMap properly.
			{
				LoggedUsername=username;
				Logged=true;
				System.out.println(MessageFormat.format("Login successfull. Welcome back {0}.", username));
				Menu(username, Balances.get(username));
			}
			else
			{
				System.out.println("Wrong password.");
				LRmenu();
			}
		}
		else
		{
			System.out.println("User not found!");
			LRmenu();
		}
		
	}
	public static void Register()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your desired username:");
		String uName= s.next();
		if(Accounts.containsKey(uName) | uName.length()<4)
		{
			System.out.println("Username already registered or too short (Min. 4 characters). Try again.");
			Register();
		}
		else
		{
			System.out.println("User available! Choose a password:");
			String uPass= s.next();
			if(uPass.length()<4)
			{
				System.out.println("Password is too short. (Min. 4 characters) Going back...");
				Register();
			}
			else
			{
				Accounts.put(uName, uPass);
				int input;
				do
				{
					System.out.println("Please insert the deposit that you want to start your account with. (Minimum 500)");
					input= s.nextInt();
					
				}while(input<500);
				
				
				if(input>=500)
				{				
					Balances.put(uName, input);
					System.out.println("Account created successfully!");
					LRmenu();
				}
			}
		}		
	}
	public static void ChangePassword()
	{
		
	}

}
