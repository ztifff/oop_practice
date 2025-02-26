package house;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		ArrayList<HouseAgent> houses = new ArrayList<>();
		houses.add(new HouseAgent("taro", "New", "Standard", "Laguna", 50, 3000));
		houses.add(new HouseAgent("pota", "Old", "Modern", "Cabuyao", 10, 4000));
		houses.add(new HouseAgent("yuta", "Vintage", "Local", "Cavite", 30, 2000));
		
		

		int choices;
		do {
			System.out.println("---------------- HOUSE AGENT ----------------");
			System.out.println("Welcome to House Agent!");
			System.out.println("[1] Add Houses\n"
					+ "[2] Remove House by Its index\n"
					+ "[3] Clear Houses\n"
					+ "[4] Add House by Its index\n"
					+ "[5] Replace House by Its Index\n"
					+ "[6] Search House by Its Index\n"
					+ "[7] Display all the Houses\n"
					+ "[8] Exit\n");
			try {
				choices = scanner.nextInt();
				scanner.nextLine();
				switch (choices) {
				case 1:
					addHouse(scanner, houses);
					break;

				case 2:
					if (houses.isEmpty()) {
						System.out.println("The Lists is Empty!");
					}
					try {
						System.out.print("Enter Index: ");
						int indexDel = scanner.nextInt();
						scanner.nextLine(); 
						if (indexDel > 0 && indexDel <= houses.size()) {
							houses.remove(indexDel-1);
							System.out.println("House Removed Successfully\n");
						} else {
							System.out.println("Invalid Index! Please enter a valid index.");
						}
					} catch (Exception e) {
						System.out.println("Invalid Input!");
						System.out.println();
						scanner.nextLine(); 
					}
					break;
				case 3:
					houses.clear();
					System.out.println("The lists has been emptied!");
					break;
				case 4:
					if (houses.isEmpty()) {
						System.out.println("The Lists is Empty!");
					}
					try {
						System.out.print("Enter Index: ");
						int indexAdd = scanner.nextInt();
						scanner.nextLine(); 
						if (indexAdd > 0 && indexAdd <= houses.size()) {
							try {
								System.out.print("Enter Base Price: ");
								int basePrice = scanner.nextInt();
								scanner.nextLine();
								System.out.print("Enter the name of the House: ");
								String nameHouse = scanner.nextLine();
								System.out.print("Enter Age of the House(New, Vintage, Old): ");
								String ageString = scanner.nextLine();
								System.out.print("Enter Type of House(Modern, Standard, Local):");
								String typeString = scanner.nextLine();
								System.out.print("Enter Size of the House(50 Hectares, 30 Hectares, 10 Hectares(Number only)): ");
								int size = scanner.nextInt();
								scanner.nextLine();
								System.out.print("Enter Location of the House: ");
								String locationString = scanner.nextLine();


								houses.add(indexAdd -1, new HouseAgent(nameHouse, ageString, typeString, locationString, size,basePrice));

								System.out.println("House Added Succesfully\n");
								
							} catch (Exception e) {
								System.out.println("Invalid Input! Please enter numeric values where required.");
								System.out.println();
								scanner.nextLine(); // Clear invalid input
							}
						} else {
							System.out.println("Invalid Index! Please enter a valid index.");
						}
					} catch (Exception e) {
						System.out.println("Invalid Input!");
						System.out.println();
						scanner.nextLine(); 
					}


					break;

				case 5: 
					if (houses.isEmpty()) {
						System.out.println("The Lists is Empty!");
					}
					try {
						System.out.print("Enter Index: ");
						int indexReplace = scanner.nextInt();
						scanner.nextLine(); 
						if (indexReplace > 0 && indexReplace <= houses.size()) {
							try {
								System.out.print("Enter Base Price: ");
								int basePrice = scanner.nextInt();
								scanner.nextLine();
								System.out.print("Enter the name of the House: ");
								String nameHouse = scanner.nextLine();
								System.out.print("Enter Age of the House(New, Vintage, Old): ");
								String ageString = scanner.nextLine();
								System.out.print("Enter Type of House(Modern, Standard, Local):");
								String typeString = scanner.nextLine();
								System.out.print("Enter Size of the House(50 Hectares, 30 Hectares, 10 Hectares(Number only)): ");
								int size = scanner.nextInt();
								scanner.nextLine();
								System.out.print("Enter Location of the House: ");
								String locationString = scanner.nextLine();


								houses.set(indexReplace -1, new HouseAgent(nameHouse, ageString, typeString, locationString, size,basePrice));

								System.out.println("House Replace Succesfully\n");
							} catch (Exception e) {
								System.out.println("Invalid Input! Please enter numeric values where required.");
								System.out.println();
								scanner.nextLine(); // Clear invalid input
							}
						} else {
							System.out.println("Invalid Index! Please enter a valid index.");
						}
					} catch (Exception e) {
						System.out.println("Invalid Input!");
						System.out.println();
						scanner.nextLine(); 
					}

					break;

				case 6: 
					
					if (houses.isEmpty()) {
						System.out.println("The Lists is Empty!");
					}
					 else {
						System.out.println("Enter Index: ");
						int id = scanner.nextInt();
						
						if (id > 0 && id <= houses.size()) {
							System.out.println("House Details: \n");
								HouseAgent houseAgent = houses.get(id);
								 System.out.println(houseAgent);
							}	
						
						}
					

					break;
				case 7:
					 displayHouses(houses);
					break;
				default:
					System.out.println("Invalid Number!");
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter a valid number.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
				choices = -1; // Reset choices to stay in the loop
			}


		} while (choices != 8);

		
	}
	
	public static void addHouse(Scanner scanner, ArrayList<HouseAgent> houses) {
        try {
            System.out.print("Enter Base Price: ");
            int basePrice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the name of the House: ");
            String nameHouse = scanner.nextLine();

            String ageString = getAgeInput(scanner);
            String typeString = getTypeInput(scanner);

            System.out.print("Enter Size of the House (50, 30, 10 hectares): ");
            int size = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Location of the House: ");
            String locationString = scanner.nextLine();

            houses.add(new HouseAgent(nameHouse, ageString, typeString, locationString, size, basePrice));
            System.out.println("House Added Successfully\n");
        } catch (Exception e) {
            System.out.println("Invalid Input! Please enter numeric values where required.");
            scanner.nextLine();
        }
    }
	
	public static String getAgeInput(Scanner scanner) {
        System.out.println("Select Age of the House:");
        System.out.println("[1] New\n[2] Vintage\n[3] Old");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return switch (choice) {
            case 1 -> "New";
            case 2 -> "Vintage";
            case 3 -> "Old";
            default -> "Unknown";
        };
    }

    public static String getTypeInput(Scanner scanner) {
        System.out.println("Select Type of the House:");
        System.out.println("[1] Modern\n[2] Standard\n[3] Local");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return switch (choice) {
            case 1 -> "Modern";
            case 2 -> "Standard";
            case 3 -> "Local";
            default -> "Unknown";
        };
    }
	
    public static void displayHouses(ArrayList<HouseAgent> houses) {
        if (houses.isEmpty()) {
            System.out.println("The List is Empty!");
        } else {
            System.out.println("House List: \n");
            for (HouseAgent houseAgent : houses) {
                System.out.println(houseAgent);
            }
        }
    }
    

}
