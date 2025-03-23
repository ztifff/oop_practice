package services;

import utils.InputValidator;
import models.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientService {
    private List<Client> clients = new ArrayList<>();
    
    public ClientService() {
        // Predefined Clients
        clients.add(new Client("Juan Dela Cruz", "Manila, Philippines", "09123456789"));
        clients.add(new Client("Maria Santos", "Cebu City, Philippines", "09234567890"));
        clients.add(new Client("Pedro Reyes", "Davao City, Philippines", "09345678901"));
    }

    public void addClient(Scanner scanner) {
    	String name = InputValidator.validateNonEmptyInput(scanner, "Enter your name: ");

    	String address = InputValidator.validateNonEmptyInput(scanner, "Enter client address: ");
        
    	String contact = InputValidator.validateNonEmptyInput(scanner, "Enter client contact number: ");

        Client client = new Client(name, address, contact);
        clients.add(client);

        System.out.println("Client added successfully! ID: " + client.getClientID());
    }

    public Client getClientById(String clientID) {
    	for (Client client : clients) {
			if (client.getClientID().equalsIgnoreCase(clientID)) {
			return client;
		}
		}
    	return null;
    }
    
    public List<Client> getClients() {
		return clients;
	}

    public void listClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients registered.");
            return;
        }
        System.out.println("Registered Clients:");
        for (Client c : clients) {
            System.out.println(c);
        }
    }
}
