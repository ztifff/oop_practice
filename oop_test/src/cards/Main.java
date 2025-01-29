package cards;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Card Shop!");
        boolean running = true;
        
        Card card = new Card();
        
        String type = ""; 
        String rarity = ""; 
        String isMeta = ""; 

        while (running) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a Card");
            System.out.println("2. View Cards");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    try {
                        // Loop for valid card type
                        while (true) {
                            System.out.print("Enter card type (Monster, Magic, Trap): ");
                            type = scanner.nextLine().trim();

                            if (type.equalsIgnoreCase("Monster") ||
                                type.equalsIgnoreCase("Magic") ||
                                type.equalsIgnoreCase("Trap")) {
                                System.out.println("You selected: " + type);
                                card.setType(type);
                                break; // Exit the loop if valid
                            } else {
                                System.out.println("Invalid card type! Please try again.");
                            }
                        }

                        // Loop for valid card rarity
                        while (true) {
                            System.out.print("Enter card rarity (Common, Rare, Super Rare): ");
                            rarity = scanner.nextLine().trim();

                            if (rarity.equalsIgnoreCase("Common") ||
                                rarity.equalsIgnoreCase("Rare") ||
                                rarity.equalsIgnoreCase("Super Rare")) {
                                System.out.println("You selected: " + rarity);
                                card.setRarity(rarity);
                                break; // Exit the loop if valid
                            } else {
                                System.out.println("Invalid card rarity! Please try again.");
                            }
                        }

                        // Loop for valid "isMeta" input
                        while (true) {
                            System.out.print("Is this card meta? (yes/no): ");
                            isMeta = scanner.nextLine().trim();

                            if (isMeta.equalsIgnoreCase("Yes") ||
                                isMeta.equalsIgnoreCase("No")) {
                                System.out.println("You selected: " + isMeta);
                                card.setisMeta(isMeta);
                                break; // Exit the loop if valid
                            } else {
                                System.out.println("Invalid input! Please enter 'yes' or 'no'.");
                            }
                        }

                        System.out.println("Card added successfully!");
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }
                    break;

                case 2:
                    card.displayCard();
                    break;

                case 3:
                    running = false;
                    System.out.println("Thank you for visiting the Card Shop!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

	}

}
