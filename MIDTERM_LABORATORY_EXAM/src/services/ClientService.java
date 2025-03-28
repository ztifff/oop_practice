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
        
    	String contactNumber = InputValidator.validateContactNumber(scanner, "Enter client contact number: ", 11);


        Client client = new Client(name, address, contactNumber);
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

}
