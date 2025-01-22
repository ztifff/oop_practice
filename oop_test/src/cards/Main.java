package cards;

import java.util.Scanner;

public class Main {
	private static Card[] cards = new Card[100]; // Maximum of 100 cards
    private static int cardCount = 0;

    public static void addCard(String type, String rarity, boolean isMeta) {
        cards[cardCount++] = new Card(type, rarity, isMeta);
    }

    public static void displayCards() {
        if (cardCount == 0) {
            System.out.println("No cards available.");
            return;
        }

        System.out.println("Available Cards:");
        for (int i = 0; i < cardCount; i++) {
            System.out.println(cards[i].toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Card Shop!");
        boolean running = true;

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
                    System.out.print("Enter card type (Monster, Magic, Trap): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter card rarity (Common, Rare, Super Rare): ");
                    String rarity = scanner.nextLine();
                    System.out.print("Is this card meta? (true/false): ");
                    boolean isMeta = scanner.nextBoolean();
                    addCard(type, rarity, isMeta);
                    System.out.println("Card added successfully!");
                    break;
                case 2:
                    displayCards();
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
