package car;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		NonElectricVehicle car1 = new NonElectricVehicle("Toyota", "Corolla", 2022, 15);
        car1.displayInfo();
        System.out.println("Fuel Cost: " + car1.calculateFuelCost(100, 60));
        car1.refuel(10);
        System.out.println();

        ElectricVehicle car2 = new ElectricVehicle("Tesla", "Model 3", 2023, 75, 6);
        car2.displayInfo();
        System.out.println("Charging Cost: " + car2.calculateChargingCost(100, 10));
        car2.chargeBattery(20);
        System.out.println();

        HybridVehicle car3 = new HybridVehicle("Toyota", "Prius", 2021, 20, 5);
        car3.displayInfo();
        car3.enableHybridMode();
        System.out.println("Hybrid Cost: " + car3.calculateHybridCost(100, 60, 10));
        System.out.println();
		 */

		int choice;
		do {
			System.out.println("Welcome to car industry!");
			System.out.println("[1] Create Non-Electric Vehicle");
			System.out.println("[2] Create Electric Vehicle");
			System.out.println("[3] Create Hybrid Vehicle");
			System.out.println("[4] Exit");

			try {
				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					addNonElectricCar();
					break;

				case 2:
					addElectricCar();
					break;

				case 3:
					addHybridCar();
					break;

				case 4:
					System.out.println("Exiting...");
					break;

				default:
					System.out.println("Invalid choices!");
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid input choose number!");
				scanner.nextLine();
				choice = -1;
			}

		} while (choice != 4);

	}

	private static void addNonElectricCar() {
		String brand;
		while (true) {
			System.out.println("Enter brand:");
			brand = scanner.nextLine().trim();
			if (!brand.isEmpty()) {
				break;
			} else {
				System.out.println("name cannot be empty!");
			}
		}

		String model;
		while (true) {
			System.out.println("Enter model:");
			model = scanner.nextLine().trim();
			if (!model.isEmpty()) {
				break;
			} else {
				System.out.println("model cannot be empty!");
			}
		}

		int year = year();

		
		double fuelEfficiency = fuelEffieciency();

		NonElectricVehicle nonElectricVehicle = new NonElectricVehicle(brand, model, year, fuelEfficiency);
		nonElectricVehicle.displayInfo();
		nonElectricVehicle.calculateFuelCost(year, fuelEfficiency);


	} 

	private static int year() {
		
		while (true) {
			try {
				System.out.println("Enter Year: ");
				int year = scanner.nextInt();
				scanner.nextLine();
				if (year <= 2025 && year >= 2000) {
					return year;
				} else {
					System.out.println("Year must be from 2000-2025");
					

				}
			} catch (Exception e) {
				System.out.println("Invalid input choose number!");
				scanner.nextLine();
			}
		}

	}

	private static double fuelEffieciency() {
		double fuelEffieciency;
		while (true) {
			try {
				System.out.println("Enter fuelEffieciency: ");
				fuelEffieciency = scanner.nextDouble();
				scanner.nextLine();
				if (fuelEffieciency <= 100 && fuelEffieciency > 0) {
					return fuelEffieciency;
				} else {
					System.out.println("fuelEffieciency must be from 0-100");
				}
			} catch (Exception e) {
				System.out.println("Invalid input choose number!");
				scanner.nextLine();
			}
		}

	}
	
	
	private static void addElectricCar() {
		String brand;
		while (true) {
			System.out.println("Enter brand:");
			brand = scanner.nextLine().trim();
			if (!brand.isEmpty()) {
				break;
			} else {
				System.out.println("name cannot be empty!");
			}
		}

		String model;
		while (true) {
			System.out.println("Enter model:");
			model = scanner.nextLine().trim();
			if (!model.isEmpty()) {
				break;
			} else {
				System.out.println("model cannot be empty!");
			}
		}

		int year = year();
		
		double batteryCapacity = batteryCapacity();
		double batteryEfficiency = batteryEfficiency();
		
		ElectricVehicle electricVehicle = new ElectricVehicle(brand, model, year, batteryCapacity, batteryEfficiency);
		electricVehicle.displayInfo();
		electricVehicle.calculateChargingCost(batteryCapacity, batteryEfficiency);
		
		
	}
	
	private static double batteryCapacity() {
		while (true) {
			try {
				System.out.println("Enter Battery Capacity: ");
				double batteryCapacity = scanner.nextDouble();
				scanner.nextLine();
				if (batteryCapacity <= 100 && batteryCapacity > 0) {
					return batteryCapacity;
				} else {
					System.out.println("batteryCapacity must be from 0-100");
				}
			} catch (Exception e) {
				System.out.println("Invalid input choose number!");
			}
		}
		
	}
	
	private static double batteryEfficiency() {
		while (true) {
			try {
				System.out.println("Enter Battery Efficiency: ");
				double batteryEfficiency = scanner.nextDouble();
				scanner.nextLine();
				if (batteryEfficiency <= 100 && batteryEfficiency > 0) {
					return batteryEfficiency;
				} else {
					System.out.println("Battery Efficiency must be from 0-100");
				}
			} catch (Exception e) {
				System.out.println("Invalid input choose number!");
			}
		}
	}
	
	private static void addHybridCar() {
		String brand;
		while (true) {
			System.out.println("Enter brand:");
			brand = scanner.nextLine().trim();
			if (!brand.isEmpty()) {
				break;
			} else {
				System.out.println("name cannot be empty!");
			}
		}

		String model;
		while (true) {
			System.out.println("Enter model:");
			model = scanner.nextLine().trim();
			if (!model.isEmpty()) {
				break;
			} else {
				System.out.println("model cannot be empty!");
			}
		}

		int year = year();
		double fuelEfficiency = fuelEffieciency();
		double batteryEfficiency = batteryEfficiency();
		
		HybridVehicle hybridVehicle = new HybridVehicle(brand, model, year, fuelEfficiency, batteryEfficiency);
		hybridVehicle.displayInfo();
		hybridVehicle.calculateHybridCost(year, fuelEfficiency, batteryEfficiency);
		
		while (true) {
			System.out.println("You want to turn on hybrid mode?");
			System.out.println("[1] Yes");
			System.out.println("[2] No");
			try {
				int choice = scanner.nextInt();
			if (choice == 1) {
				hybridVehicle.enableHybridMode();
				hybridVehicle.displayInfo();
				hybridVehicle.calculateHybridCost(year, fuelEfficiency, batteryEfficiency);
				break;
			} else if (choice == 2) {
				hybridVehicle.displayInfo();
				hybridVehicle.calculateHybridCost(year, fuelEfficiency, batteryEfficiency);
				break;
			} else {
				System.out.println("Pick from 1-2!");
			}
			} catch (Exception e) {
			System.out.println("Invalid input choose number!");
		}
		}
		
		
		
		
		
	}
	
	


}
