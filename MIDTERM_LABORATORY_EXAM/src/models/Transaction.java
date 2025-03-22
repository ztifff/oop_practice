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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTransaction ID: ").append(transactionID)
          .append("\nDate: ").append(date)
          .append("\nClient: ").append(client.getClientID()).append(" - ").append(client.getName())
          .append("\nDentist: ").append(dentist.getDentistID()).append(" - ").append(dentist.getName())
          .append("\nServices:\n");

        double total = 0;
        for (Services s : services) {
            sb.append(" - ").append(s.getServiceName()).append(" (₱").append(s.getPrice()).append(")\n");
            total += s.getPrice();
        }

        sb.append("Total Cost: ₱").append(total);
        return sb.toString();
    }
}
