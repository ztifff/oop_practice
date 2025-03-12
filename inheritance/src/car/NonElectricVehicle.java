package car;

public class NonElectricVehicle extends Vehicle{
	private double fuelEfficiency;

	public NonElectricVehicle(String brand, String model, int year, double fuelEfficiency) {
		super(brand, model, year);
		this.fuelEfficiency = fuelEfficiency;
	}
	
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}

	public double calculateFuelCost(double distance, double fuelPrice) {
		return (distance / fuelEfficiency) * fuelPrice;
	}
	
	public void refuel(double liters) {
		System.out.println("Refueled " + liters + " liters.");
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Fuel Efficiency: " + fuelEfficiency + " km/l");
	}
}
