package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
	private static int idCounter = 1;
	private String transactionID;
	private Date date;
	private Client client;
	private List<Dentist> dentistsInvolved;
	private List<Services> services;

	public Transaction(Client client, List<Dentist> dentists, List<Services> services) {
		this.transactionID = String.format("%04d", idCounter++);
		this.date = new Date();
		this.client = client;
		this.dentistsInvolved = new ArrayList<>(dentists);
		this.services = new ArrayList<>(services);
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void displayTransaction() {
		System.out.println("\nTransaction ID: " + transactionID);
		System.out.println("Date: " + date);
		System.out.println("Client: " + client.getClientID() + " - " + client.getName());

		double total = 0;

		System.out.println("Dentists and their Services Involved:\n");
		for (Dentist dentist : dentistsInvolved) {
			System.out.println(" -> " + dentist.getDentistID() + " - " + dentist.getName() + ":\n");


			for (Services service : services) {
				if (service.getDentists().contains(dentist)) {  
					System.out.println(" - " + service.getServiceName() + " (₱" + service.getPrice() + ")");
					total += service.getPrice();
				}
			}
			System.out.println();
		}
		System.out.println("Total Cost: ₱" + total);
	}
}
