package prelimProject;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<ToyCollection> toys = new ArrayList<>();

	public static void main(String[] args) {
		showIntroductionAndTutorial();

		toys.add(new ToyCollection("Gundam", 1, "Bandai", "4x9x6", 3.4, 1, 1, "Controller"));
		toys.add(new ToyCollection("Kirby", 3, "Bandila", "2x4x5", 2.3, 1, 2, "Lights"));
		toys.add(new ToyCollection("Kirby", 2, "Toyolab", "23x32x12", 12.4, 1, 1, "Controller"));
		toys.add(new ToyCollection("Kirby", 3, "Bandila", "2x4x5", 2.3, 1, 2, "Lights"));

		int choice;
		do {
			System.out.println("\n====== TOY MENU ======");
			System.out.println("[1] Add Toy");
			System.out.println("[2] Display All Toys");
			System.out.println("[3] Remove Toy by ID");
			System.out.println("[4] Search Toy by Name");
			System.out.println("[5] Filter Toys by Condition");
			System.out.println("[6] Search Toy by Interactive Feature");
			System.out.println("[7] Exit");
			System.out.print("Enter your choice: ");
			try {
				choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					addToy();
					break;
				case 2:
					displayDetails();
					break;
				case 3:
					removeToyByID();
					break;
				case 4:
					searchToyUsingName();
					break;

				case 5: 
					filterByCondition();
					break;
				case 6: 
					searchByInteractiveFeature();
					break;
				case 7:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid Number!");
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter a valid number.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
				choice = -1; // Reset choices to stay in the loop
			}
		} while (choice != 7);
	}

	public static void addToy() {
		System.out.println("--------ADD A TOY----------");
		// Validate Toy Name
		String Name;
	    while (true) {
	        System.out.print("Enter a Toy Name: ");
	        Name = scanner.nextLine().trim();
	        if (!Name.isEmpty()) {
	            break;
	        }
	        System.out.println("Invalid input! Toy name cannot be empty.");
	    }

		int condition = getConditionInput(scanner);

		 // Validate Manufacturer
	    String manufacturer;
	    while (true) {
	        System.out.print("Enter Manufacturer: ");
	        manufacturer = scanner.nextLine().trim();
	        if (!manufacturer.isEmpty()) {
	            break;
	        }
	        System.out.println("Invalid input! Manufacturer cannot be empty.");
	    }

		System.out.println("Enter Size: ");
		String size = getSpecifiedSize(scanner); // 
		scanner.nextLine(); // Consume newline

		double weight = getWeightInput(scanner);

		int batteryOperated = getYesNoInput("Is Battery Operated?");

		int SoundOperated = getYesNoInput("Has Sound Features?");

		String interactiveFeatures = getInteractiveFeaturesInput();

		toys.add(new ToyCollection(Name, condition, manufacturer, size, weight, batteryOperated, SoundOperated, interactiveFeatures));
		System.out.println("Toy Added Successfully!");
	}

	//addToy Helper methods
	//========================================================================================

	//method to get the condition
	private static int getConditionInput(Scanner scanner) {
		int condition = 0;
		while (true) {
			System.out.println("Enter Condition: ");
			System.out.println("[1] New");
			System.out.println("[2] Used");
			System.out.println("[3] Refurbished");
			if (scanner.hasNextInt()) {
				condition = scanner.nextInt();
				scanner.nextLine();

				switch (condition) {
				case 1:
				case 2:
				case 3:
					return condition; 
				default:
					System.out.println("Invalid choice! Please enter 1, 2, or 3.");
					break;
				}
			} else {
				System.out.println("Invalid input! Please enter a number.");
				scanner.next(); 
			}
		}
	}//end of the condition method

	// method to get the size in the format of(length x width x height)
	public static String getSpecifiedSize(Scanner scanner) {
		while (true) {
			try {
				System.out.print("\nEnter length: ");
				int length = scanner.nextInt();
				scanner.nextLine();
				System.out.print("\nEnter width: ");
				int width = scanner.nextInt();
				scanner.nextLine();
				System.out.print("\nEnter height: ");
				int height = scanner.nextInt();

				if (length > 0 && width > 0 && height > 0) {
					return length + "x" + width + "x" + height;
				} else {
					System.out.println("Invalid Input! All values must be positive numbers greater than zero.");
				}

			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter values required.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
			}
		}
	} // end of size method

	// method to get the weight input
	private static double getWeightInput(Scanner scanner) {
		double weight = 0;
		while (true) {
			System.out.print("Enter Weight in grams: ");
			if (scanner.hasNextDouble()) {
				weight = scanner.nextDouble();
				scanner.nextLine();
				if (weight > 0) {
					return weight;
				} else {
					System.out.println("Invalid input! Weight must be a positive number greater than zero.");
				}
			} else {
				System.out.println("Invalid input! Please enter a valid number.");
				scanner.nextLine(); 
			}
		}

	}  

	//method to get the battery and sound operated input
	private static int getYesNoInput(String prompt) {
		int input = 0;
		while (true) {
			System.out.println(prompt);
			System.out.println("[1] Yes");
			System.out.println("[2] No");
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
				if (input == 1 || input == 2) {
					scanner.nextLine(); 
					break;
				} else {
					System.out.println("Invalid choice! Please enter 1 or 2.");
				}
			} else {
				System.out.println("Invalid input! Please enter a number.");
				scanner.next();
			}
		}
		return input;
	}

	//method to get the interactive features input
	private static String getInteractiveFeaturesInput() {
		ArrayList<String> selectedFeatures = new ArrayList<>();
		boolean addMore = true;

		while (addMore) {
			System.out.println("Enter Interactive Features: ");
			System.out.println("[1] Lights");
			System.out.println("[2] Movement");
			System.out.println("[3] Voice Activated");
			System.out.println("[4] None");
			System.out.println("[5] Others");

			int choice = getValidChoice(1, 5);

			switch (choice) {
			case 1:
				selectedFeatures.add("Lights");
				break;
			case 2:
				selectedFeatures.add("Movement");
				break;
			case 3:
				selectedFeatures.add("Voice Activated");
				break;
			case 4:
				selectedFeatures.clear();
				selectedFeatures.add("None");
				addMore = false;
				break;
			case 5:
				System.out.print("Enter Custom Interactive Feature: ");
				selectedFeatures.add(scanner.nextLine());
				break;
			}

			if (choice != 4) {
				System.out.println("Want to add another Interactive Feature? (Yes/No)");
				System.out.println("[1] Yes");
				System.out.println("[2] No");

				int input = getValidChoice(1, 2);
				if (input == 2) {
					addMore = false;
				}
			}
		}

		return String.join(", ", selectedFeatures);
	}

	private static int getValidChoice(int min, int max) {
		while (true) {
			if (scanner.hasNextInt()) {
				int choice = scanner.nextInt();
				scanner.nextLine();
				if (choice >= min && choice <= max) {
					return choice;
				} else {
					System.out.println("Invalid choice! Please enter a number between " + min + " and " + max + ".");
				}
			} else {
				System.out.println("Invalid input! Please enter a number.");
				scanner.next();
			}
		}
	}

	//========================================================================================

	public static void removeToyByID() {
		if (toys.isEmpty()) {
			System.out.println("No toys in the Collection!");
		} else {
			try {
				System.out.print("Enter Toy ID to Remove: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				boolean removed = false;

				for (int i = 0; i < toys.size(); i++) {
					if (toys.get(i).getId() == id) {
						toys.remove(i);
						removed = true;
						System.out.println("Toy with ID " + id + " removed successfully!");
						break;
					}
				}

				if (!removed) {
					System.out.println("Toy with ID " + id + " not found.");
				}
			} catch (Exception e) {
				System.out.println(" error occurred while removing the toyID.");
			}
		}

	} // end of remove method

	//========================================================================================

	//method to filter collection by condition
	public static void filterByCondition() {
		if (toys.isEmpty()) {
			System.out.println("No toys in the Collection!");
		} else {
			try {
				System.out.println("Enter Condition: ");
				System.out.println("[1] New");
				System.out.println("[2] Used");
				System.out.println("[3] Refurbished");
				int condition = scanner.nextInt();
				scanner.nextLine();

				System.out.println("Toys in '" + getConditionString(condition) + "' condition:");
				boolean found = false;
				for (ToyCollection toy : toys) {
					if (toy.getCondition() == condition) {
						toy.displayDetails();
						found = true;
					}
				}
				if (!found) {
					System.out.println("No toys found in this condition.");
				}
			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter values required.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
			}
		}

	} // end of filter by condition method

	//method for getting string condition for Interactive features
	public static String getConditionString(int condition) {
		return switch (condition) {
		case 1 -> "New";
		case 2 -> "Used";
		case 3 -> "Refurbished";
		default -> "Unknown Condition";
		};
	}

	//========================================================================================

	//method to search collection by Interactive features
	public static void searchByInteractiveFeature() {
		if (toys.isEmpty()) {
			System.out.println("No toys in the Collection!");
			return;
		}

		System.out.println("Select Interactive Features (You can choose multiple features):");
		String selectedFeatures = getInteractiveFeaturesInput();
		String[] featuresArray = selectedFeatures.split(", ");

		System.out.println("\nToys with interactive features: " + selectedFeatures);
		boolean found = false;

		for (ToyCollection toy : toys) {
			for (String feature : featuresArray) {
				if (toy.getInteractiveFeatures().contains(feature)) {
					toy.displayDetails();
					found = true;
					break;
				}
			}
		}

		if (!found) {
			System.out.println("No toys found with these interactive features.");
		}

	}// end of search method for interactive features

	//========================================================================================

	//method to search the collection by its name
	public static void searchToyUsingName(){
		if (toys.isEmpty()) {
			System.out.println("No toys in the Collection!");
		} else {
			System.out.print("Enter toy name to search: ");
			String searchNameOfToy = scanner.nextLine().toLowerCase();

			boolean found = false;
			for (ToyCollection toy : toys) {
				if (toy.getName().toLowerCase().contains(searchNameOfToy.toLowerCase())){
					toy.displayDetails();
					found = true;
				}
			}

			if (!found) {
				System.out.println("No toy found with the name " + searchNameOfToy);
			}
		}
	}

	//========================================================================================

	//method to display the toys collection
	public static void displayDetails() {
		System.out.println("\n-----------Toy Collection Details-----------");
		if (toys.isEmpty()) {
			System.out.println("No toys in the Collection!");
		}else {
			for (ToyCollection toy : toys) {
				toy.displayDetails();
			}
		}
	}

	//========================================================================================

	public static void showIntroductionAndTutorial() {
		System.out.println("**************************************************************");
		System.out.println("*                                                            *");
		System.out.println("*       WELCOME TO THE TOY COLLECTOR SYSTEM                  *");
		System.out.println("*                                                            *");
		System.out.println("**************************************************************");
		System.out.println();

		// Introduction Section
		System.out.println("Introduction:");
		System.out.println("Welcome to the Toy Collector System. This platform has been");
		System.out.println("designed to efficiently manage and showcase your toy inventory.");
		System.out.println("Whether for personal or professional use, our system provides a");
		System.out.println("streamlined, user-friendly experience to keep your collection up-to-date.");
		System.out.println();

		// Tutorial Section
		System.out.println("System Tutorial:");
		System.out.println("   [1] Add Toy                  : Register a new toy into the system.");
		System.out.println("   [2] Display All Toys         : View your complete inventory.");
		System.out.println("   [3] Remove Toy by ID         : Delete a toy using its unique identifier.");
		System.out.println("   [4] Search Toy by Name       : Locate a toy by its name.");
		System.out.println("   [5] Filter Toys by Condition : Filter toys based on their condition.");
		System.out.println("   [6] Search by Interactive Feature");
		System.out.println("                              : Find toys with specific interactive features.");
		System.out.println("   [7] Exit                     : Conclude your session.");
		System.out.println();
		System.out.print("Please press [ENTER] to continue... ");
		scanner.nextLine();  // Wait for user confirmation
	}
}
