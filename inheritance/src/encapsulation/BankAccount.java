package encapsulation;

public class BankAccount {
	 String accountHolder; // Name of the user (Encapsulated)
	private double balance; // Balance (Encapsulated)

	// Constructor
	public BankAccount(String accountHolder, double balance) {
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	// Method to display account holder name
	public String getAccountHolder() {
		return accountHolder;
	}

	// Method to display balance (secure access)
	public void showBalance() {
		System.out.println("Current Balance: ₱" + balance);
	}

	// Method to deposit money
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Successfully deposited ₱" + amount);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	// Method to withdraw money
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Successfully withdrawn ₱" + amount);
		} else {
			System.out.println("Invalid withdrawal amount or insufficient funds.");
		}
	}
}
