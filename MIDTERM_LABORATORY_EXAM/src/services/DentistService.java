package services;

import utils.InputValidator;
import models.Dentist;
import models.Services;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DentistService {
    private List<Dentist> dentists = new ArrayList<>();

    public void addDentist(Scanner scanner) {
    	String name = InputValidator.validateNonEmptyInput(scanner, "Enter dentist name: ");
    	
    	String address = InputValidator.validateNonEmptyInput(scanner, "Enter dentist address: ");

    	String contact = InputValidator.validateNonEmptyInput(scanner, "Enter dentist contact number: ");

    	double commissionRate = InputValidator.validatePositiveDouble(scanner, "Enter commission rate (%): ");

        List<Services> servicesOffered = new ArrayList<>();
        Set<Integer> selectedOptions = new HashSet<>();
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
			 
			 servicesOffered.add(new Services(getServiceIndex(choices), getServicePrice(getServiceIndex(choices))));
			 selectedOptions.add(choices);
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
					 
					 if (selectedOptions.contains(choices)) {
					        System.out.println("You have already selected this service. Choose another.");
					        continue;
					    }
					 
					 servicesOffered.add(new Services(getServiceIndex(choices), getServicePrice(getServiceIndex(choices))));
					 selectedOptions.add(choices);
					 break;
				}
			} else if (another == 2) {
				break;
			} else {
				System.out.println("Invalid input. Please enter 1 (Yes) or 2 (No).");
			}
		}
        
        System.out.println("Services selected:");
        for (Services service : servicesOffered) {
            System.out.println("- " + service.getServiceName() + ": " + service.getPrice());
        }
    
        /*
        String input;
        do {
            System.out.print("Enter choice (comma-separated numbers, e.g., 1,3): ");
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        
        String[] selectedNumbers = input.split(",");
        for (String num : selectedNumbers) {
            try {
                int index = Integer.parseInt(num.trim()) - 1;
                if (index >= 0 && index < serviceNames.length) {
                    servicesOffered.add(new Services(serviceNames[index], getServicePrice(serviceNames[index])));
                } else {
                    System.out.println("Invalid selection: " + num);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + num);
            }
        }
*/
        Dentist dentist = new Dentist(name, address, contact, commissionRate, servicesOffered);
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
