package services;

import models.Client;
import models.Dentist;
import models.Services;
import models.Transaction;
import utils.InputValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionService {
	private List<Transaction> transactions = new ArrayList<>();

	public void createTransaction(Scanner scanner, ClientService clientService, DentistService dentistService) {
		System.out.print("Enter Client ID: ");
		String clientID = scanner.nextLine();
		Client client = clientService.getClientById(clientID);
		if (client == null) {
			System.out.println("Client not found.");
			return;
		}

		System.out.print("Enter Dentist ID: ");
		String dentistID = scanner.nextLine();
		Dentist dentist = dentistService.getDentistById(dentistID);
		if (dentist == null) {
			System.out.println("Dentist not found.");
			return;
		}

		List<Services> offeredServices = dentist.getServicesOffered();
		if (offeredServices.isEmpty()) {
			System.out.println("This dentist does not offer any services.");
			return;
		}

		System.out.println("\nAvailable Services:");
		for (int i = 0; i < offeredServices.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + offeredServices.get(i).getServiceName() + " (₱" + offeredServices.get(i).getPrice() + ")");
		}
		List<Services> selectedServices = new ArrayList<>();

		int choice;
		while (true) {
			choice = InputValidator.validatePositiveInt(scanner, "Enter services performed: ");

			if (choice < 1 || choice > offeredServices.size()) {
				System.out.println("Invalid choice. Please select a number between 1 to " + offeredServices.size() + ".");
				continue;
			}

			selectedServices.add(offeredServices.get(choice-1));
			break;
		}

		while (true) {

			System.out.println("Enter Another service offered?");
			System.out.println("[1] Yes");
			System.out.println("[2] No");

			int another = InputValidator.validatePositiveInt(scanner, "Enter choice: ");

			if (another == 1) {
				while (true) {
					System.out.println("\nAvailable Services:");
					for (int i = 0; i < offeredServices.size(); i++) {
						System.out.println("[" + (i + 1) + "] " + offeredServices.get(i).getServiceName() + " (₱" + offeredServices.get(i).getPrice() + ")");
					}
					choice = InputValidator.validatePositiveInt(scanner, "Enter choice: ");

					if (choice < 1 || choice > offeredServices.size()) {
						System.out.println("Invalid choice. Please select a number between 1 and " + offeredServices.size() + ".");
						continue;
					}


					selectedServices.add(offeredServices.get(choice-1));
					break;
				}
			} else if (another == 2) {
				break;
			} else {
				System.out.println("Invalid input. Please enter 1 (Yes) or 2 (No).");
			}
		}

		/*
        System.out.println("Enter services performed: ");
        String[] selectedNumbers = scanner.nextLine().split(",");


        for (String num : selectedNumbers) {
            try {
                int index = Integer.parseInt(num.trim()) - 1;
                if (index >= 0 && index < offeredServices.size()) {
                    selectedServices.add(offeredServices.get(index));
                } else {
                    System.out.println("Invalid selection: " + num);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + num);
            }
        }
		 */
		if (selectedServices.isEmpty()) {
			System.out.println("No valid services selected. Transaction not created.");
			return;
		}

		Transaction transaction = new Transaction(client, dentist, selectedServices);
		transactions.add(transaction);

		System.out.println("Transaction recorded successfully! Transaction ID: " + transaction.getTransactionID());
	}

	public void viewTransactions() {
		if (transactions.isEmpty()) {
			System.out.println("No transactions recorded.");
			return;
		}
		for (Transaction transaction : transactions) {
			transaction.displayTransaction();
		}
	}

}
