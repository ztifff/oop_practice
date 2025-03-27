package services;

import utils.InputValidator;
import models.Dentist;
import models.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DentistService {
    private List<Dentist> dentists = new ArrayList<>();
    
    public DentistService() {
        // Predefined Dentists
        Dentist dentist1 = new Dentist("Dr. Enrique Villanueva", "Quezon City, Philippines", "09456789012", 10.0);
        Dentist dentist2 = new Dentist("Dr. Andrea Ramos", "Taguig City, Philippines", "09567890123", 12.5);

        // Assign services to dentists
        dentist1.addService(new Services("Fillings", 1000.0));
        dentist1.addService(new Services("Checkup", 600.0));

        dentist2.addService(new Services("Whitening", 500.0));
        dentist2.addService(new Services("Extraction", 700.0));

        // Add dentists to the list
        dentists.add(dentist1);
        dentists.add(dentist2);
    }

    public void addDentist(Scanner scanner) {
    	String name = InputValidator.validateNonEmptyInput(scanner, "Enter dentist name: ");
    	
    	String address = InputValidator.validateNonEmptyInput(scanner, "Enter dentist address: ");

    	String contactNumber = InputValidator.validateContactNumber(scanner, "Enter dentist contact number: ", 11);

    	double commissionRate = InputValidator.validatePositiveDouble(scanner, "Enter commission rate (%): ");
    	if (commissionRate < 0 || commissionRate > 100) {
    		System.out.println("Commission rate must be between 0% and 100%.");
    		return;
        }
    	
    	 Dentist dentist = new Dentist(name, address, contactNumber, commissionRate);

        System.out.println("Enter services offered: ");
        System.out.println("[1] Fillings");
        System.out.println("[2] Check-Up");
        System.out.println("[3] Whitening");
        System.out.println("[4] Extraction");
        
        
        int choices;
        while (true) {
			choices = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
			
			 if (choices < 1 || choices > 4) {
			        System.out.println("Invalid choice. Please select a number between 1 and 4.");
			        continue;
			    }
			 
			 dentist.addService(new Services(getServiceIndex(choices), getServicePrice(getServiceIndex(choices))));
			 break;
		}
        
        while (true) {
			
			System.out.println("Enter Another service offered?");
			System.out.println("[1] Yes");
			System.out.println("[2] No");
			int another = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
			if (another == 1) {
				while (true) {
					System.out.println("Enter services offered: ");
			        System.out.println("[1] Fillings");
			        System.out.println("[2] Check-Up");
			        System.out.println("[3] Whitening");
			        System.out.println("[4] Extraction");
					choices = InputValidator.validatePositiveInt(scanner, "Enter choice: ");
					
					 if (choices < 1 || choices > 4) {
					        System.out.println("Invalid choice. Please select a number between 1 and 4.");
					        continue;
					    }
					 
					 
					 dentist.addService(new Services(getServiceIndex(choices), getServicePrice(getServiceIndex(choices))));
					 break;
				}
			} else if (another == 2) {
				break;
			} else {
				System.out.println("Invalid input. Please enter 1 (Yes) or 2 (No).");
			}
		}
        
        System.out.println("Services selected:");
        for (Services service : dentist.getServicesOffered()) {
            System.out.println("- " + service.getServiceName() + ": " + service.getPrice());
        }
    
       
        dentists.add(dentist);

        System.out.println("Dentist added successfully! ID: " + dentist.getDentistID());
    }

    public Dentist getDentistById(String dentistID) {
    	for (Dentist dentist : dentists) {
			if (dentist.getDentistID().equalsIgnoreCase(dentistID)) {
			return dentist;
		}
		}
    	return null;
    }
    
    public List<Dentist> getDentists() {
		return dentists;
	}

    private double getServicePrice(String serviceName) {
        switch (serviceName) {
            case "Fillings": return 1000.0;
            case "Checkup": return 600.0;
            case "Whitening": return 500.0;
            case "Extraction": return 700.0;
            default: return 0.0;
        }
    }
    
    private String getServiceIndex(int services) {
    	switch (services) {
        case 1: return "Fillings";
        case 2: return "Checkup";
        case 3: return "Whitening";
        case 4: return "Extraction";
        default: return "";
    }
	}
}
