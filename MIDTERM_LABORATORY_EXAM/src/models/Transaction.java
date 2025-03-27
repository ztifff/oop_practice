package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
	private static int idCounter = 1;
    private final String transactionID;
    private Date date;
    private Client client;
    private Dentist dentist;
    private List<Services> services;
    
    public Transaction(Client client, Dentist dentist, List<Services> services) {
        this.transactionID = String.format("%04d", idCounter++);
        this.date = new Date();
        this.client = client;
        this.dentist = dentist;
        this.services = new ArrayList<>(services);
        
    }
    
    
    public String getTransactionID() {
		return transactionID;
	}
    
    
    public void displayTransaction() {
    	System.out.println("\nTransaction ID: " + transactionID);
    	System.out.println("Date: " + date);
    	System.out.println("Client: " + client.getClientID() + " - " + client.getName());
    	System.out.println("Dentist: " + dentist.getDentistID() + " - " + dentist.getName());
    	System.out.println("Services:");

    	double total = 0;
    	for (Services s : services) {
    	    System.out.println(" - " + s.getServiceName() + " (₱" + s.getPrice() + ")");
    	    total += s.getPrice();
    	}

    	System.out.println("Total Cost: ₱" + total);
    }
}
