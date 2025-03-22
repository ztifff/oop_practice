package utils;

import java.util.Scanner;

public class InputValidator {
    public static String validateNonEmptyInput(Scanner scanner, String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Please enter a name!"); // Error message
            }
        } while (input.isEmpty());
        return input;
    }

    public static double validatePositiveDouble(Scanner scanner, String message) {
        double value;
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim(); // Read full line & remove spaces

            try {
                value = Double.parseDouble(input); // Convert input to double
                if (value > 0) {
                    return value; // Return if positive number
                } else {
                    System.out.println("Invalid input. Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    
    public static int validatePositiveInt(Scanner scanner, String message) {
        int value;
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim(); // Read full line & remove spaces

            try {
                value = Integer.parseInt(input); // Convert input to an integer
                if (value > 0) {
                    return value; // Return if positive integer
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    
    }

