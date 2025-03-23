package utils;

import java.util.Scanner;

public class InputValidator {
    public static String validateNonEmptyInput(Scanner scanner, String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Please enter a name!\n"); // Error message
            }
        } while (input.isEmpty());
        return input;
    }

    public static double validatePositiveDouble(Scanner scanner, String message) {
        double value;
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim(); 

            try {
                value = Double.parseDouble(input);
                if (value > 0) {
                    return value; 
                } else {
                    System.out.println("Invalid input. Please enter a positive number.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.\n");
            }
        }
    }

    
    public static int validatePositiveInt(Scanner scanner, String message) {
        int value;
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim(); 

            try {
                value = Integer.parseInt(input); 
                if (value > 0) {
                    return value; 
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.\n");
            }
        }
    }

    
    }

