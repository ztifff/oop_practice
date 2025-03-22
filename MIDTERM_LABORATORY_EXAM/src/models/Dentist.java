package models;

import java.util.ArrayList;
import java.util.List;

public class Dentist extends Person {
    private static int idCounter = 1; // Static counter for unique ID
    private String dentistID;
    private double commissionRate;
    private List<Services> servicesOffered;

    public Dentist(String name, String address, String contactNumber, double commissionRate, List<Services> servicesOffered) {
        super(name, address, contactNumber);
        this.dentistID = String.format("%04d", idCounter++);
        this.commissionRate = commissionRate;
        this.servicesOffered = new ArrayList<>(servicesOffered); // Store passed list
    }
    
    public String getName() {
		return name;
	}

    public void addService(Services service) {
        servicesOffered.add(service);
    }

    public String getDentistID() {
        return dentistID;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public List<Services> getServicesOffered() {
        return servicesOffered;
    }

    @Override
    public String toString() {
        return "Dentist ID: " + dentistID + ", Name: " + name + ", Commission: " + commissionRate + "%";
    }
}