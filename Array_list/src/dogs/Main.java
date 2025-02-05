package dogs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choices;
		Scanner scanner = new Scanner(System.in);

		ArrayList<Dog> dogs = new ArrayList<>();

		do {
			System.out.println("Welcome to Dogs Shop!");
			System.out.println("[1] Add a Dog\n"
					+ "[2] Remove a Dog by Its Index\n"
					+ "[3] Clear List\n"
					+ "[4] Display all Dogs\n"
					+ "[5] Replace a Dog By Its Index\n"
					+ "[6] Add a Dog By Its Index\n"
					+ "[7] Exit\n");
			choices = scanner.nextInt();
			switch (choices) {
			case 1:
				System.out.println("Enter Breed: ");
				String breed = scanner.next();
				System.out.println("Enter Color: ");
				String color = scanner.next();
				dogs.add(new Dog(breed, color));

				break;

			case 2:
				if (dogs.isEmpty()) {
					System.out.println("The List is Empty!\n");
					return;
				}
				System.out.print("Select The Index: ");
				int indexDelete = scanner.nextInt();
				if (indexDelete > 0 && indexDelete <= dogs.size()) {
					dogs.remove(indexDelete - 1);
					System.out.println("Success Deletion!");
				} else {
					System.out.println("Invalid Index!");
				}

				break;

			case 3:
				if (dogs.isEmpty()) {
					System.out.println("The List is Empty!\n");
					return;
				}
				dogs.clear();
				System.out.println("The Lists is Clear!");

				break;

			case 4:
				if (dogs.isEmpty()) {
					System.out.println("The List is Empty!\n");
				return;
				}
				System.out.println("Dog lists: ");
				for (int i = 0; i < dogs.size(); i++) {
					Dog dog = dogs.get(i);
					System.out.println("Breed: " + dog.getBreed());
					System.out.println("Color: " + dog.getColor());
					System.out.println();
				}

				break;

			case 5:
				if (dogs.isEmpty()) {
					System.out.println("The List is Empty!\n");
				return;
				}
				System.out.print("Select The Index: ");
				int indexReplace = scanner.nextInt();
				if (indexReplace > 0 && indexReplace <= dogs.size()) {
					System.out.println("Enter Breed: ");
					 breed = scanner.next();
					System.out.println("Enter Color: ");
					 color = scanner.next();
					dogs.set(indexReplace -1,new Dog(breed, color) );
				} else {
					System.out.println("Invalid Index!");
				}

				break;

			case 6:
				if (dogs.isEmpty()) {
					System.out.println("The List is Empty!\n");
				return;
				}
				System.out.print("Select The Index: ");
				int indexAdd = scanner.nextInt();
				if (indexAdd > 0 && indexAdd <= dogs.size()) {
					System.out.println("Enter Breed: ");
					 breed = scanner.next();
					System.out.println("Enter Color: ");
					 color = scanner.next();
					dogs.add(indexAdd -1,new Dog(breed, color) );
				} else {
					System.out.println("Invalid Index!");
				}

				break;



			default:
				break;
			}

		} while (choices != 7);

	}

}
