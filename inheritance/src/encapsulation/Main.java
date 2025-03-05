package encapsulation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		// Creating a user bank account
		BankAccount userAccount = new BankAccount("Fitzgerald Eduarte", 5000);
		int choice;
		// Banking Menu
		do {
			System.out.println("\nWelcome, " + userAccount.accountHolder);
			System.out.println("1. View Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");

			try {
				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					userAccount.showBalance();
					break;
				case 2:
					System.out.print("Enter deposit amount: ₱");
					double depositAmount = scanner.nextDouble();
					scanner.nextLine();
					userAccount.deposit(depositAmount);
					break;
				case 3:
					System.out.print("Enter withdrawal amount: ₱");
					double withdrawAmount = scanner.nextDouble();
					scanner.nextLine();
					userAccount.withdraw(withdrawAmount);
					break;
				case 4:
					System.out.println("Thank you for banking with us!");
					scanner.close();
					return;
				default:
					System.out.println("Invalid option. Please try again.");
				}
			}
			catch (Exception e) {
				scanner.nextLine();
				choice = -1;

			}


		} while(choice != 4);
	}

}
