package models;

import java.util.ArrayList;
import java.util.List;

public class Dentist extends Person {
    private static int idCounter = 1; // Static counter for unique ID
    private String dentistID;
    private double commissionRate;
    private List<Services> servicesOffered = new ArrayList<>();

    public Dentist(String name, String address, String contactNumber, double commissionRate) {
        super(name, address, contactNumber);
        this.dentistID = String.format("%04d", idCounter++);
        this.commissionRate = commissionRate;
        
    }
    
    public String getName() {
		return name;
	}

    public void addService(Services service) {
    	if (service != null) {
    		for (Services existingService : servicesOffered) {
                if (existingService.getServiceName().equalsIgnoreCase(service.getServiceName())) {
                    System.out.println("This service is already offered.");
                    return; 
                }
            }
    		service.setDentist(this);
            servicesOffered.add(service);
        } else {
            System.out.println("This service is already offered.");
        }
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