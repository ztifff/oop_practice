package mosnterManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<MonsterManager> monsterManagers = new ArrayList<MonsterManager>();
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		monsterManagers.add(new MonsterManager("Dino", "Healer", "Wind", 50, 50, 50, 50));



		int choices;
		do {
			System.out.println("Welcome to monster creation");
			System.out.println("[1] Create a monster");
			System.out.println("[2] Display the monster");
			System.out.println("[3] Exit the System");
			try {
				choices = scanner.nextInt();
				scanner.nextLine();

				switch (choices) {
				case 1:
					addMonster();
					break;

				case 2:
					display();

					break;

				case 3:
					System.out.println("exiting");
					break;
				default:
					break;
				}


			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter a valid number.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
				choices = -1; // Reset choices to stay in the loop
			}

		} while (choices != 3);
	}

	private static void addMonster() {
		try {
			
			String nameString = nameHelper();

			String categoryString = categoryHelper();
			
			String elementString = elementHelper();
			
			System.out.println("Enter Stats:");
			double ATK = ATK();
			double HP = HP();
			double SPEED = SPEED();
			double DEF = DEF();

			
			monsterManagers.add(new MonsterManager(nameString, categoryString, elementString, ATK, HP, SPEED, DEF));
			System.out.println("Monster Created!");
			System.out.println("Monster Summary: ");
			System.out.println(monsterManagers.getLast());


		} catch (Exception e) {
			System.out.println("Invalid Input! Please enter a valid number.");
			System.out.println();
			scanner.nextLine(); // Clear invalid input
		}
	}
	
	private static String nameHelper() {
		String nameString;
		boolean running = true;
		while (running) {
		System.out.println("Enter a name: ");
		nameString = scanner.nextLine();
		for (MonsterManager monsterManager : monsterManagers) {
			if (!monsterManager.getNameString().equalsIgnoreCase(nameString) && !nameString.isEmpty()) {
				return nameString;
			} 
				System.out.println("Invalid input!");
			
		}
		
		}
		return "";
	}

	private static String categoryHelper() {

		while (true) {
			try {
				System.out.println("Enter a Category:");
				System.out.println("[1] Guardian");
				System.out.println("[2] Hunter");
				System.out.println("[3] Healer");
				int categoryChoice = scanner.nextInt();
				scanner.nextLine();

				return switch (categoryChoice) {
				case 1 -> "Guardian";
				case 2 -> "Hunter";
				case 3 -> "Healer";
				default -> 
				throw new IllegalArgumentException("Unexpected value: " + categoryChoice);
				};

			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter a valid number.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
			}
		}
	}
	
	private static String elementHelper() {
		while (true) {
			try {
				System.out.println("Enter a Category:");
				System.out.println("[1] Fire");
				System.out.println("[2] Water");
				System.out.println("[3] Earth");
				System.out.println("[4] Wind");
				int elementChoice = scanner.nextInt();
				scanner.nextLine();

				return switch (elementChoice) {
				case 1 -> "Fire";
				case 2 -> "Water";
				case 3 -> "Earth";
				case 4 -> "Wind";
				default -> 
				throw new IllegalArgumentException("Unexpected value: " + elementChoice);
				};

			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter a valid number.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
			}
		}
	}
	
	private static double ATK() {
		while (true) {
			try {
			System.out.println("Enter ATK(50-100): ");
			double atk = scanner.nextDouble();
			scanner.nextLine();
			if (atk>100) {
				System.out.println("atk is high must be 50-100");
			} else if (atk<50) {
				System.out.println("atk is low must be 50-100");
			} else {
				return atk;
			}
			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter a valid number.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
			}
			
		}
	}
	
	private static double HP() {
		while (true) {
			try {
			System.out.println("Enter HP(50-100): ");
			double hp = scanner.nextDouble();
			scanner.nextLine();
			if (hp>100) {
				System.out.println("hp is high must be 50-100");
			} else if (hp<50) {
				System.out.println("hp is low must be 50-100");
			} else {
				return hp;
			}
			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter a valid number.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
			}
			
		}
	}
	
	private static double SPEED() {
		while (true) {
			try {
			System.out.println("Enter SPEED(50-100): ");
			double speed = scanner.nextDouble();
			scanner.nextLine();
			if (speed>100) {
				System.out.println("speed is high must be 50-100");
			} else if (speed<50) {
				System.out.println("speed is low must be 50-100");
			} else {
				return speed;
			}
			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter a valid number.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
			}
			
		}
	}
	
	private static double DEF() {
		while (true) {
			try {
			System.out.println("Enter DEF(50-100): ");
			double def = scanner.nextDouble();
			scanner.nextLine();
			if (def>100) {
				System.out.println("def is high must be 50-100");
			} else if (def<50) {
				System.out.println("def is low must be 50-100");
			} else {
				return def;
			}
			} catch (Exception e) {
				System.out.println("Invalid Input! Please enter a valid number.");
				System.out.println();
				scanner.nextLine(); // Clear invalid input
			}
			
		}
	}
	
	public static void display() {
		System.out.println("Monster Lists: ");
		for (MonsterManager monsterManager : monsterManagers) {
			System.out.println(monsterManager);
		}
	}

}
