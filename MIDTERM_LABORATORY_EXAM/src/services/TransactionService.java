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
	private List<Transaction> archivedTransactions = new ArrayList<>();

	public void createTransaction(Scanner scanner, ClientService clientService, DentistService dentistService) {
		
			Client client = selectedClient(scanner, clientService);
			
			Dentist dentist = selectedDentist(scanner, dentistService);
			
			List<Services> selectedServices = selectedServices(scanner, dentist);

		Transaction transaction = new Transaction(client, dentist, selectedServices);
		transactions.add(transaction);

		System.out.println("Transaction recorded successfully! Transaction ID: " + transaction.getTransactionID());
		
	}
	
	public Client selectedClient(Scanner scanner, ClientService clientService) {
		List<Client> clients =  clientService.getClients();
		if (clients.isEmpty()) {
			System.out.println("Client is Empty.");
			
		}
		while (true) {
			System.out.println("\nSelect a Client: ");
		for (int i = 0; i < clients.size(); i++) {
			System.out.println((i+1)+ ". " + clients.get(i).getClientID() + " - " + clients.get(i).getName());
		}
		int clientChoice = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
		if (clientChoice < 1 || clientChoice > clients.size()) {
			System.out.println("Invalid Choices! Please Select from 1 to " + clients.size() + ".");
		} else {
			Client client = clients.get(clientChoice -1);
			return client;
		}
			
		}
		
	}
	
	public Dentist selectedDentist(Scanner scanner, DentistService dentistService) {
		List<Dentist> dentists = dentistService.getDentists();
        if (dentists.isEmpty()) {
            System.out.println("No dentists available.");
        }

        while (true) {
			System.out.println("\nSelect a Dentist:");
        for (int i = 0; i < dentists.size(); i++) {
            System.out.println((i + 1) + ". " + dentists.get(i).getDentistID() + " - " + dentists.get(i).getName());
        }
        int dentistChoice = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
        if (dentistChoice < 1 || dentistChoice > dentists.size()) {
            System.out.println("Invalid choice! Please select between 1 and " + dentists.size() + ".");
        }else {
			Dentist dentist = dentists.get(dentistChoice - 1); 
			return dentist;
		}
        
		}
        
	}
	
	public List<Services> selectedServices(Scanner scanner, Dentist dentistoffered) {
	    List<Services> offeredServices = dentistoffered.getServicesOffered();
	    List<Services> selectedServices = new ArrayList<>();

	    if (offeredServices.isEmpty()) {
	        System.out.println("This dentist does not offer any services.");
	        return selectedServices; // Return an empty list if no services available
	    }

	    while (true) {
	        System.out.println("\nAvailable Services:");
	        for (int i = 0; i < offeredServices.size(); i++) {
	            System.out.println("[" + (i + 1) + "] " + offeredServices.get(i).getServiceName() + " (₱" + offeredServices.get(i).getPrice() + ")");
	        }

	        int choice = InputValidator.validatePositiveInt(scanner, "Enter services performed (or 0 to finish): ");

	        if (choice == 0) break; // Allow user to finish selecting services

	        if (choice < 1 || choice > offeredServices.size()) {
	            System.out.println("Invalid choice. Please select a number between 1 and " + offeredServices.size() + ".");
	            continue;
	        }

	        Services selectedService = offeredServices.get(choice - 1);
	        selectedServices.add(selectedService);
	        System.out.println("Service added: " + selectedService.getServiceName());
	    }

	    if (selectedServices.isEmpty()) {
	        System.out.println("No valid services selected. Transaction not created.");
	    }

	    return selectedServices; // Ensure method always returns a list
	}
	
	public void archiveTransaction(Scanner scanner) {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available to archive.");
            return;
        }
        
        System.out.println("Select a transaction to archive:");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + ". Transaction ID: " + transactions.get(i).getTransactionID());
        }
        
        int choice = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
        if (choice < 1 || choice > transactions.size()) {
            System.out.println("Invalid choice.");
            return;
        }
        
        Transaction transactionToArchive = transactions.remove(choice - 1);
        archivedTransactions.add(transactionToArchive);
        System.out.println("Transaction ID " + transactionToArchive.getTransactionID() + " archived successfully!");
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
	
	public void viewArchivedTransactions() {
        if (archivedTransactions.isEmpty()) {
            System.out.println("No archived transactions.");
            return;
        }
        for (Transaction transaction : archivedTransactions) {
            transaction.displayTransaction();
        }
    }



}
