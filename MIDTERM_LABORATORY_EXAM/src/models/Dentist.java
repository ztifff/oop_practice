package models;

import java.util.ArrayList;
import java.util.List;

public class Dentist extends Person {
	private static int idCounter = 1; // Static counter for unique ID
	private String dentistID;
	private double commissionRate;
	private List<Services> servicesOffered;

	public Dentist(String name, String address, String contactNumber, double commissionRate) {
		super(name, address, contactNumber);
		this.dentistID = String.format("%04d", idCounter++);
		this.commissionRate = commissionRate;
		this.servicesOffered = new ArrayList<>();
	}

	public String getName() {
		return name;
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

	public void addService(Services service) {
		if (service != null) {
			for (Services existingService : servicesOffered) {
				if (existingService.getServiceName().equalsIgnoreCase(service.getServiceName())) {
					System.out.println("This service is already offered.");
					return; 
				}
			}
			service.addDentist(this);
			servicesOffered.add(service);
		} 
	}

	public double getServicePrice(String serviceName) {
		switch (serviceName) {
		case "Fillings": return 1000.0;
		case "Checkup": return 600.0;
		case "Whitening": return 500.0;
		case "Extraction": return 700.0;
		default: return 0.0;
		}
	}

	public String getServiceIndex(int services) {
		switch (services) {
		case 1: return "Fillings";
		case 2: return "Checkup";
		case 3: return "Whitening";
		case 4: return "Extraction";
		default: return "";
		}
	}

	@Override
	public String toString() {
		return "Dentist ID: " + dentistID + ", Name: " + name + ", Commission: " + commissionRate + "%";
	}
}