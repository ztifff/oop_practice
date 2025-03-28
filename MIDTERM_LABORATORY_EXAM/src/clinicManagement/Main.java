package clinicManagement;

import java.util.*;
import models.*;

public class Main {
	private static final List<Client> clients = new ArrayList<>();
	private static final List<Dentist> dentists = new ArrayList<>();
	private static final List<Transaction> transactions = new ArrayList<>();
	private static final List<Transaction> archivedTransactions = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		initializeData();

		while (true) {
			System.out.println("\n==== Clinic Management System ====");
			System.out.println("1. Add Client");
			System.out.println("2. Add Dentist");
			System.out.println("3. Create Transaction");
			System.out.println("4. View Transactions");
			System.out.println("5. Archive Transaction");
			System.out.println("6. View Archived Transactions");
			System.out.println("7. Exit");
			System.out.print("Choose an option: ");

			int choice = getValidInt(scanner);

			switch (choice) {
			case 1 -> addClient(scanner);
			case 2 -> addDentist(scanner);
			case 3 -> createTransaction(scanner);
			case 4 -> viewTransactions(transactions, "Active Transactions");
			case 5 -> archiveTransaction(scanner);
			case 6 -> viewTransactions(archivedTransactions, "Archived Transactions");
			case 7 -> {
				System.out.println("Exiting...");
				scanner.close();
				return;
			}
			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void initializeData() {
		clients.addAll(Arrays.asList(
				new Client("Juan Dela Cruz", "Manila, Philippines", "09123456789"),
				new Client("Maria Santos", "Cebu City, Philippines", "09234567890"),
				new Client("Pedro Reyes", "Davao City, Philippines", "09345678901")));

		Dentist dentist1 = new Dentist("Dr. Enrique Villanueva", "Quezon City, Philippines", "09456789012", 10.0);
		Dentist dentist2 = new Dentist("Dr. Andrea Ramos", "Taguig City, Philippines", "09567890123", 12.5);

		dentist1.addService(new Services("Fillings", 1000.0));
		dentist1.addService(new Services("Checkup", 600.0));
		dentist2.addService(new Services("Whitening", 500.0));
		dentist2.addService(new Services("Extraction", 700.0));

		dentists.addAll(Arrays.asList(dentist1, dentist2));
	}

	private static void addClient(Scanner scanner) {
		System.out.print("Enter client name: ");
		String name = getValidString(scanner);

		System.out.print("Enter client address: ");
		String address = getValidString(scanner);

		System.out.print("Enter contact number (11 digits): ");
		String contactNumber = getValidPhoneNumber(scanner);

		clients.add(new Client(name, address, contactNumber));
		System.out.println("Client added successfully!");
	}

	private static void addDentist(Scanner scanner) {
		System.out.print("Enter dentist name: ");
		String name = getValidString(scanner);

		System.out.print("Enter dentist address: ");
		String address = getValidString(scanner);

		System.out.print("Enter contact number (11 digits): ");
		String contactNumber = getValidPhoneNumber(scanner);

		System.out.print("Enter commission rate (0-100%): ");
		double commissionRate = getValidDouble(scanner);

		Dentist dentist = new Dentist(name, address, contactNumber, commissionRate);
		dentists.add(dentist);
		System.out.println("Dentist added successfully!");
	}



	private static void createTransaction(Scanner scanner) {
		if (clients.isEmpty() || dentists.isEmpty()) {
			System.out.println("Cannot create transaction. No clients or dentists available.");
			return;
		}
		System.out.println("Transaction created successfully!");
	}

	private static void archiveTransaction(Scanner scanner) {
		if (transactions.isEmpty()) {
			System.out.println("No transactions available to archive.");
			return;
		}
		System.out.println("Transaction archived successfully!");
	}

	private static void viewTransactions(List<Transaction> transactionList, String header) {
		System.out.println("\n==== " + header + " ====");
		if (transactionList.isEmpty()) {
			System.out.println("No transactions recorded.");
		}
	}
	
	
	//Input Validator
	private static int getValidInt(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.print("Invalid input. Enter a number: ");
			scanner.next();
		}
		return scanner.nextInt();
	}

	private static double getValidDouble(Scanner scanner) {
		while (!scanner.hasNextDouble()) {
			System.out.print("Invalid input. Enter a valid number: ");
			scanner.next();
		}
		return scanner.nextDouble();
	}

	private static String getValidString(Scanner scanner) {
		String input;
		do {
			input = scanner.nextLine().trim();
			if (input.isEmpty()) {
				System.out.print("Input cannot be empty. Try again: ");
			}
		} while (input.isEmpty());
		return input;
	}

	private static String getValidPhoneNumber(Scanner scanner) {
		String phone;
		do {
			phone = scanner.nextLine().trim();
			if (!phone.matches("\\d{11}")) {
				System.out.print("Invalid phone number. Enter exactly 11 digits: ");
			}
		} while (!phone.matches("\\d{11}"));
		return phone;
	}
}
