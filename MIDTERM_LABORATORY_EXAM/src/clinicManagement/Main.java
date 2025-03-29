package clinicManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Client;
import models.Dentist;
import models.Transaction;
import utils.InputValidator;
import models.Services;

public class Main {
	private static List<Client> clients = new ArrayList<>();
	private static List<Dentist> dentists = new ArrayList<>();
	private static List<Transaction> transactions = new ArrayList<>();
	private static List<Transaction> archivedTransactions = new ArrayList<>();

	//=================================================================================================================================
	//Main Menu
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		initializeData();

		System.out.println("================================================================");
		System.out.println("   	    Welcome to the Clinic Management System ");
		System.out.println("================================================================");
		System.out.println("This system helps manage client records, dentist information, ");
		System.out.println("and transactions efficiently.");
		System.out.println("\nPress Enter to continue...");
		scanner.nextLine();

		while (true) {
			System.out.println("\n======================================");
			System.out.println("|              Main Menu             |");
			System.out.println("======================================");
			System.out.println("| 1. Register a New Client           |");
			System.out.println("| 2. Register a New Dentist          |");
			System.out.println("| 3. View Registered Clients         |");
			System.out.println("| 4. View Registered Dentists        |");
			System.out.println("| 5. Record a New Transaction        |");
			System.out.println("| 6. View All Transactions           |");
			System.out.println("| 7. Archive a Transaction           |");
			System.out.println("| 8. View Archived Transactions      |");
			System.out.println("| 9. Exit                            |");
			System.out.println("======================================");

			int choice = InputValidator.validatePositiveInt(scanner, "Choose an option: ");

			switch (choice) {
			case 1 -> addClient(scanner);
			case 2 -> addDentist(scanner);
			case 3 -> viewRegisteredClients(scanner);
			case 4 -> viewRegisteredDentists(scanner);
			case 5 -> createTransaction(scanner);
			case 6 -> viewTransactions(transactions, "Active Transactions");
			case 7 -> archiveTransaction(scanner);
			case 8 -> viewTransactions(archivedTransactions, "Archived Transactions");
			case 9 -> {
				System.out.println("\nThank you for using the Clinic Management System.");
				System.out.println("Exiting the system... Goodbye!");
				scanner.close();
				return;
			}
			default -> System.out.println("Invalid choice. Try again.");
			}
		}
	}
	//=================================================================================================================================
	//Initialize Data
	private static void initializeData() {
		clients.add(new Client("Juan Dela Cruz", "Manila, Philippines", "09123456789"));
		clients.add(new Client("Maria Santos", "Cebu City, Philippines", "09234567890"));
		clients.add(new Client("Pedro Reyes", "Davao City, Philippines", "09345678901"));

		Dentist dentist1 = new Dentist("Dr. Enrique Villanueva", "Quezon City, Philippines", "09456789012", 10.0);
		Dentist dentist2 = new Dentist("Dr. Andrea Ramos", "Taguig City, Philippines", "09567890123", 12.5);

		dentist1.addService(new Services("Fillings", 1000.0));
		dentist1.addService(new Services("Checkup", 600.0));
		dentist2.addService(new Services("Whitening", 500.0));
		dentist2.addService(new Services("Extraction", 700.0));

		dentists.add(dentist1);
		dentists.add(dentist2);

	}
	//=================================================================================================================================
	//Add Client
	private static void addClient(Scanner scanner) {
		String name = InputValidator.validateNonEmptyInput(scanner, "Enter client name: ");
		String address = InputValidator.validateNonEmptyInput(scanner, "Enter client address: ");
		String contactNumber = InputValidator.validateContactNumber(scanner, "Enter contact number: ", 11);

		Client client = new Client(name, address, contactNumber);
		clients.add(client);
		System.out.println("Client added successfully! ID: " + client.getClientID());
	}

	//=================================================================================================================================
	//Add Dentist
	private static void addDentist(Scanner scanner) {
		String name = InputValidator.validateNonEmptyInput(scanner, "Enter dentist name: ");
		String address = InputValidator.validateNonEmptyInput(scanner, "Enter dentist address: ");
		String contactNumber = InputValidator.validateContactNumber(scanner, "Enter contact number: ", 11);
		double commissionRate = InputValidator.validatePositiveDouble(scanner, "Enter commission rate (0% - 100%): ");

		Dentist dentist = new Dentist(name, address, contactNumber, commissionRate);

		selectServicesForDentist(dentist, scanner);

		System.out.println("\nServices selected:");
		for (Services service : dentist.getServicesOffered()) {
			System.out.println("- " + service.getServiceName() + ": " + service.getPrice());
		}
		dentists.add(dentist);
		System.out.println("Dentist added successfully! ID: " + dentist.getDentistID());
	}

	//=================================================================================================================================
	//View Registered Clients
	private static void viewRegisteredClients(Scanner scanner) {
		System.out.println("\n=========================================== Registered Clients ===========================================");
	    System.out.printf("%-15s | %-40s | %-30s | %-15s%n", "Client ID", "Client Name", "Address", "Contact No.");
	    System.out.println("----------------------------------------------------------------------------------------------------------");

	    for (Client client : clients) {
	        System.out.printf("%-15s | %-40s | %-30s | %-15s%n", 
	            client.getClientID(), client.getName(), client.getAddress(), client.getContactNumber());
	    }
	}

	//=================================================================================================================================
	//View Registered Dentists
	private static void viewRegisteredDentists(Scanner scanner) {
		System.out.println("\n=================================================== Registered Dentists ===================================================");
	    System.out.printf("%-15s | %-40s | %-30s | %-15s | %-10s%n", "Dentist ID", "Dentist Name", "Address", "Contact No.", "Commission");
	    System.out.println("---------------------------------------------------------------------------------------------------------------------------");

	    for (Dentist dentist : dentists) {
	        System.out.printf("%-15s | %-40s | %-30s | %-15s | %-10.2f%%%n", 
	            dentist.getDentistID(), dentist.getName(), dentist.getAddress(), dentist.getContactNumber(), dentist.getCommissionRate());
	    }
	}

	//=================================================================================================================================
	//Select Services for Dentist
	private static void selectServicesForDentist(Dentist dentist, Scanner scanner) {
		System.out.println("\nEnter services offered: ");
		System.out.println("[1] Fillings");
		System.out.println("[2] Check-Up");
		System.out.println("[3] Whitening");
		System.out.println("[4] Extraction");

		int choices;
		while (true) {
			choices = InputValidator.validatePositiveInt(scanner, "Enter a choice: ");

			if (choices < 1 || choices > 4) {
				System.out.println("Invalid choice. Please select a number between 1 and 4.");
				continue;
			}

			dentist.addService(new Services(dentist.getServiceIndex(choices),
					dentist.getServicePrice(dentist.getServiceIndex(choices))));
			break;
		}

		while (true) {

			System.out.println("\nEnter Another service offered?");
			System.out.println("[1] Yes");
			System.out.println("[2] No");
			int another = InputValidator.validatePositiveInt(scanner, "Enter a choice: ");
			if (another == 1) {
				while (true) {
					System.out.println("\nEnter services offered: ");
					System.out.println("[1] Fillings");
					System.out.println("[2] Check-Up");
					System.out.println("[3] Whitening");
					System.out.println("[4] Extraction");
					choices = InputValidator.validatePositiveInt(scanner, "Enter a choice: ");

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
	}

	//=================================================================================================================================
	//Create Transaction
	private static void createTransaction(Scanner scanner) {
		Client client = selectClient(scanner);
		List<Dentist> dentists = new ArrayList<>();
		List<Services> selectedServices = new ArrayList<>();

		Dentist dentist = selectDentist(scanner);
		dentists.add(dentist);

		selectedServices = selectServices(scanner, dentist);

		if (selectedServices.isEmpty()) {
			System.out.println("No services selected. Transaction canceled.");
			return;
		}

		while (true) {
			System.out.println("\nYou want to add another dentist?");
			System.out.println("[1] Yes");
			System.out.println("[2] No");

			int choice;
			while (true) {
				choice = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
				if (choice == 1 || choice == 2) {
					break;  // Valid input, exit loop
				}
				System.out.println("Invalid input! Please enter 1 or 2.\n");
			}

			if (choice == 1) {
				dentist = selectDentist(scanner);
				if (dentists.contains(dentist)) {
					System.out.println("\nYou have already selected this dentist.");
					System.out.println("Do you want to proceed with adding more services?");
					System.out.println("[1] Yes");
					System.out.println("[2] No");

					int confirm;
					while (true) {
						confirm = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
						if (confirm == 1 || confirm == 2) {
							break;  // Valid input, exit loop
						}
						System.out.println("Invalid input! Please enter 1 or 2.\n");
					}

					if (confirm == 2) {
						System.out.println("Skipping this dentist.");
						continue;
					}
				} else {
					dentists.add(dentist);
				}

				List<Services> newServices = selectServices(scanner, dentist);

				for (Services service : newServices) {
					if (selectedServices.contains(service)) {
						System.out.println("\nYou have already selected " + service.getServiceName() + " before.");
						System.out.println("Do you want to proceed with adding it again?");
						System.out.println("[1] Yes");
						System.out.println("[2] No");

						int confirm;
						while (true) {
							confirm = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
							if (confirm == 1 || confirm == 2) {
								break;  // Valid input, exit loop
							}
							System.out.println("Invalid input! Please enter 1 or 2.\n");
						}

						if (confirm == 2) {
							System.out.println(service.getServiceName() + " not added again.\n");
							continue;
						} 
					}
					selectedServices.add(service);
				}

				if (!newServices.isEmpty()) {
					System.out.println("Dentist and services added.");
				} else {
					System.out.println("No services selected for this dentist. Skipping.\n");
				}
			} else if (choice ==2) {
				break;
			} 
		}

		Transaction transaction = new Transaction(client, dentists, selectedServices);
		transactions.add(transaction);
		System.out.println("Transaction recorded successfully! Transaction ID: " + transaction.getTransactionID());

	}

	//=================================================================================================================================
	//Select Client for Create Transaction class
	private static Client selectClient(Scanner scanner) {
		if (clients.isEmpty()) {
			System.out.println("No clients available.");
			return null;
		}
		System.out.println("\nSelect a Client:");
		viewRegisteredClients(scanner);
		int choice;
		while (true) {
			choice = InputValidator.validatePositiveInt(scanner, "\nEnter Client ID(e.g., 1 for Juan Dela Cruz, 2 for Maria Santos): ");
			if (choice >= 1 && choice <= clients.size()) {
				break;  // Valid choice, exit loop
			}
			System.out.println("Invalid choice! Please select a number between 1 and " + clients.size() + "\n");
		}

		return clients.get(choice - 1);
	}

	//=================================================================================================================================
	//Select Dentist for Create Transaction class
	private static Dentist selectDentist(Scanner scanner) {
		if (dentists.isEmpty()) {
			System.out.println("No dentists available.");
			return null;
		}
		System.out.println("\nSelect a Dentist:");
		viewRegisteredDentists(scanner);
		
		int choice;
		while (true) {
			choice = InputValidator.validatePositiveInt(scanner, "\nEnter Dentist ID(e.g., 1 for Juan Dela Cruz, 2 for Maria Santos): ");
			if (choice >= 1 && choice <= dentists.size()) {
				break;  // Valid choice, exit loop
			}
			System.out.println("Invalid choice! Please select a number between 1 and " + dentists.size() + "\n");
		}

		return dentists.get(choice - 1);
	}

	//=================================================================================================================================
	//Select Services for Dentist for Create Transaction class
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
				Services selectedService = offeredServices.get(choice - 1);
				
				if (selectedServices.contains(selectedService)) {
	                System.out.println("This service is already selected. Choose a different service.\n");
	            } else {
	                selectedServices.add(selectedService);
	                System.out.println("Service added: " + selectedService.getServiceName());
	            }
			} else {
				System.out.println("Invalid choice. Try again.\n");
			}
		}
		return selectedServices;
	}

	//=================================================================================================================================
	//Archive Transaction and View Archive Transaction
	private static void archiveTransaction(Scanner scanner) {
		if (transactions.isEmpty()) {
			System.out.println("No transactions available to archive.");
			return;
		}

		// Display transactions with numbered choices
		System.out.println("==== Select a transaction to archive: ====");
		for (int i = 0; i < transactions.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + "Transaction ID: " + transactions.get(i).getTransactionID()); // Numbered list
		}

		// Get user choice
		int choice = InputValidator.validatePositiveInt(scanner, "\nEnter a choice: ") - 1;

		// Validate if the choice is within range
		if (choice < 0 || choice >= transactions.size()) {
			System.out.println("Invalid choice! Please enter a valid transaction number.");
			return;
		}

		// Move selected transaction to archivedTransactions
		archivedTransactions.add(transactions.remove(choice));
		System.out.println("Transaction archived successfully!");
	}


	//=================================================================================================================================
	//View Active Transaction
	private static void viewTransactions(List<Transaction> transactionList, String header) {
		System.out.println("\n==== " + header + " ====");
		if (transactionList.isEmpty()) {
			System.out.println("No transactions recorded.");
			return;
		}
		transactionList.forEach(Transaction::displayTransaction);
	}

}
