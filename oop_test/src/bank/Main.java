package bank;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Piggy Bank");
		System.out.println("Please enter your name and Initial deposit to create an account:");
		
		System.out.print("Enter your name: " );
		String name =scanner.nextLine();
		System.out.print("Enter Initial Deposit: ");
		int initial = scanner.nextInt();
		
		BankAccount bankAccount = new BankAccount(name, initial);
		
		
		
		int choices;
		do {
			System.out.println("Check what you want to do with your account");
			
			
			
			System.out.println("[1] Check Account Balance\n"
							+ "[2] Withdraw Money\n"
							+ "[3] Deposit Money\n");
			choices =scanner.nextInt();
			switch (choices) {
			case 1:
				bankAccount.CurrentBalance();
				break;
				
			case 2:
				System.out.print("Withdraw amount: ");
				int withdraw = scanner.nextInt();
				
				
				System.out.println(bankAccount.WithdrawMoney(withdraw));
				break;
				
			case 3:
				System.out.print("Deposit amount: ");
				int deposit = scanner.nextInt();
				
				System.out.println(bankAccount.DepositMoney(deposit));
				break;
			}
		} while (choices != 4);

	}

}
