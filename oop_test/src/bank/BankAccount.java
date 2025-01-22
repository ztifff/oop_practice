package bank;

public class BankAccount {
	private String name;
	private int balance;
	
	public BankAccount(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public int DepositMoney(int deposit) {
		
		if (deposit>balance) {
			System.out.println("Error: Insufficient funds.");
		} else {
			balance += deposit;
		}
		
		
		 return balance;
	
	}
	
	public int WithdrawMoney(int withdraw) {
		if (withdraw>balance) {
			System.out.println("Error: Insufficient funds.");
		} else {
			balance -= withdraw;
		}
		
		
		 return balance;
	}
	
	public void CurrentBalance() {
		System.out.println("Account Balance: " + balance);
	}
	
	public void AccountDetails() {
		System.out.println("Account Details:\n"
				+ "name: " + name + "\n"
				+ "Balance: " + balance +"\n");
	}


}
