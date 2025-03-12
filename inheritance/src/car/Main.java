package car;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NonElectricVehicle car1 = new NonElectricVehicle("Toyota", "Corolla", 2022, 15);
        car1.displayInfo();
        System.out.println("Fuel Cost: " + car1.calculateFuelCost(100, 60));
        car1.refuel(10);

        ElectricVehicle car2 = new ElectricVehicle("Tesla", "Model 3", 2023, 75, 6);
        car2.displayInfo();
        System.out.println("Charging Cost: " + car2.calculateChargingCost(100, 10));
        car2.chargeBattery(20);

        HybridVehicle car3 = new HybridVehicle("Toyota", "Prius", 2021, 20, 5);
        car3.displayInfo();
        car3.enableHybridMode();
        System.out.println("Hybrid Cost: " + car3.calculateHybridCost(100, 60, 10));
	}

}
