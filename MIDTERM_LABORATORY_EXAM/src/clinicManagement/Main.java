package clinicManagement;

import utils.InputValidator;
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

			int choice = scanner.nextInt();
			scanner.nextLine();

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
		clients.addAll(Arrays.asList(new Client("Juan Dela Cruz", "Manila, Philippines", "09123456789"),
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
		String name = InputValidator.validateNonEmptyInput(scanner, "Enter client name: ");
		String address = InputValidator.validateNonEmptyInput(scanner, "Enter client address: ");
		String contactNumber = InputValidator.validateContactNumber(scanner, "Enter contact number: ", 11);

		Client client = new Client(name, address, contactNumber);
		clients.add(client);
		System.out.println("Client added successfully! ID: " + client.getClientID());
	}

	private static void addDentist(Scanner scanner) {
		String name = InputValidator.validateNonEmptyInput(scanner, "Enter dentist name: ");
		String address = InputValidator.validateNonEmptyInput(scanner, "Enter dentist address: ");
		String contactNumber = InputValidator.validateContactNumber(scanner, "Enter contact number: ", 11);
		double commissionRate = InputValidator.validatePositiveDouble(scanner, "Enter commission rate (%): ");

		Dentist dentist = new Dentist(name, address, contactNumber, commissionRate);

		System.out.println("Enter services offered: ");
		System.out.println("[1] Fillings");
		System.out.println("[2] Check-Up");
		System.out.println("[3] Whitening");
		System.out.println("[4] Extraction");

		int choices;
		while (true) {
			choices = InputValidator.validatePositiveInt(scanner, "Enter choice: ");

			if (choices < 1 || choices > 4) {
				System.out.println("Invalid choice. Please select a number between 1 and 4.");
				continue;
			}

			dentist.addService(new Services(dentist.getServiceIndex(choices),
					dentist.getServicePrice(dentist.getServiceIndex(choices))));
			break;
		}

		while (true) {

			System.out.println("Enter Another service offered?");
			System.out.println("[1] Yes");
			System.out.println("[2] No");
			int another = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
			if (another == 1) {
				while (true) {
					System.out.println("Enter services offered: ");
					System.out.println("[1] Fillings");
					System.out.println("[2] Check-Up");
					System.out.println("[3] Whitening");
					System.out.println("[4] Extraction");
					choices = InputValidator.validatePositiveInt(scanner, "Enter choice: ");

					if (choices < 1 || choices > 4) {
						System.out.println("Invalid choice. Please select a number between 1 and 4.");
						continue;
					}

					dentist.addService(new Services(dentist.getServiceIndex(choices),
							dentist.getServicePrice(dentist.getServiceIndex(choices))));
					break;
				}
			} else if (another == 2) {
				break;
			} else {
				System.out.println("Invalid input. Please enter 1 (Yes) or 2 (No).");
			}
		}
		System.out.println("Services selected:");
		for (Services service : dentist.getServicesOffered()) {
			System.out.println("- " + service.getServiceName() + ": " + service.getPrice());
		}
		dentists.add(dentist);
		System.out.println("Dentist added successfully! ID: " + dentist.getDentistID());
	}

	private static void createTransaction(Scanner scanner) {
		Client client = selectClient(scanner);
		Dentist dentist = selectDentist(scanner);
		List<Services> selectedServices = selectServices(scanner, dentist);

		if (selectedServices.isEmpty()) {
			System.out.println("No services selected. Transaction canceled.");
			return;
		}

		Transaction transaction = new Transaction(client, dentist, selectedServices);
		transactions.add(transaction);
		System.out.println("Transaction recorded successfully! Transaction ID: " + transaction.getTransactionID());
	}

	private static Client selectClient(Scanner scanner) {
		if (clients.isEmpty()) {
			System.out.println("No clients available.");
			return null;
		}
		System.out.println("\nSelect a Client:");
		for (int i = 0; i < clients.size(); i++) {
			System.out.println((i + 1) + ". " + clients.get(i).getClientID() + " - " + clients.get(i).getName());
		}
		int choice = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
		return clients.get(choice - 1);
	}

	private static Dentist selectDentist(Scanner scanner) {
		if (dentists.isEmpty()) {
			System.out.println("No dentists available.");
			return null;
		}
		System.out.println("\nSelect a Dentist:");
		for (int i = 0; i < dentists.size(); i++) {
			System.out.println((i + 1) + ". " + dentists.get(i).getDentistID() + " - " + dentists.get(i).getName());
		}
		int choice = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
		return dentists.get(choice - 1);
	}

	private static List<Services> selectServices(Scanner scanner, Dentist dentist) {
		List<Services> selectedServices = new ArrayList<>();
		List<Services> offeredServices = dentist.getServicesOffered();

		System.out.println("\nAvailable Services:");
		for (int i = 0; i < offeredServices.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + offeredServices.get(i).getServiceName() + " (₱"
					+ offeredServices.get(i).getPrice() + ")");
		}
		while (true) {
			int choice = InputValidator.validatePositiveInt(scanner, "Enter service number (or 0 to finish): ");
			if (choice == 0)
				break;
			if (choice > 0 && choice <= offeredServices.size()) {
				selectedServices.add(offeredServices.get(choice - 1));
				System.out.println("Service added: " + offeredServices.get(choice - 1).getServiceName());
			} else {
				System.out.println("Invalid choice. Try again.");
			}
		}
		return selectedServices;
	}

	private static void archiveTransaction(Scanner scanner) {
		if (transactions.isEmpty()) {
			System.out.println("No transactions available to archive.");
			return;
		}
		viewTransactions(transactions, "Select a transaction to archive:");
		int choice = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
		archivedTransactions.add(transactions.remove(choice - 1));
		System.out.println("Transaction archived successfully!");
	}

	private static void viewTransactions(List<Transaction> transactionList, String header) {
		System.out.println("\n==== " + header + " ====");
		if (transactionList.isEmpty()) {
			System.out.println("No transactions recorded.");
			return;
		}
		transactionList.forEach(Transaction::displayTransaction);
	}
}
