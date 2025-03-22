package clinicManagement;

import services.*;
import utils.InputValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientService clientService = new ClientService();
        DentistService dentistService = new DentistService();
        TransactionService transactionService = new TransactionService();
        
        while (true) {
            System.out.println("\nClinic Management System");
            System.out.println("1. Add Client");
            System.out.println("2. Add Dentist");
            System.out.println("3. Create Transaction");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            
            int choice = InputValidator.validatePositiveInt(scanner, "Choose an option: ");
            
            switch (choice) {
                case 1:
                    clientService.addClient(scanner);
                    break;
                case 2:
                    dentistService.addDentist(scanner);
                    break;
                case 3:
                    transactionService.createTransaction(scanner, clientService, dentistService);
                    break;
                case 4:
                    transactionService.viewTransactions();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
