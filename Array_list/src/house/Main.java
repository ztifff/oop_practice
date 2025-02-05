package house;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		ArrayList<HouseAgent> houses = new ArrayList<>();

		



		int choices;
		do {
			System.out.println("---------------- HOUSE AGENT ----------------");
			System.out.println("Welcome to House Agent!");
			System.out.println("[1] Add Houses\n"
					+ "[2] Remove House by Its index\n"
					+ "[3] Clear Houses\n"
					+ "[4] Add House by Its index\n"
					+ "[5] Replace House by Its Index\n"
					+ "[6] Display all the Houses\n"
					+ "[7] Exit\n");
			try {
				choices = scanner.nextInt();
				scanner.nextLine();
				switch (choices) {
				case 1:
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


						houses.add(new HouseAgent(nameHouse, ageString, typeString, locationString, size,basePrice));

						System.out.println("House Added Succesfully\n");
					} catch (Exception e) {
						System.out.println("Invalid Input! Please enter numeric values where required.");
						System.out.println();
						scanner.nextLine(); // Clear invalid input
					}
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
					System.out.println("House Lists: \n");
					for (int i = 0; i < houses.size(); i++) {
						HouseAgent houseAgent = houses.get(i);
						System.out.println("Name: " + houseAgent.getName());
						System.out.println("Age: " + houseAgent.getAge());
						System.out.println("Type: " + houseAgent.getTypeString());
						System.out.println("Size: " + houseAgent.getSize());
						System.out.println("Location: " + houseAgent.getLocationString());

						System.out.println();
						System.out.println("Total Price: " + houseAgent.CalculationPrice());
						System.out.println();
					}

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


		} while (choices != 7);

	}

}
