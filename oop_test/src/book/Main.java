package book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.println("Welcome to the Library");
        int choice;
        do {
            System.out.println("\nPlease state your business:");
            System.out.println("[1] Borrow a Book");
            System.out.println("[2] Return a Book");
            System.out.println("[3] View Book Details");
            System.out.println("[4] Exit the Library");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    book.borrowBook();
                    break;
                case 2:
                    book.returnBook();
                    break;
                case 3:
                    book.display();
                    break;
                case 4:
                    System.out.println("Thank you for visiting the library. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
