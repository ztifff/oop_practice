package car;

public class ElectricVehicle extends Vehicle{

	private double batteryCapacity;
	private double batteryEfficiency;

	public ElectricVehicle(String brand, String model, int year, double batteryCapacity, double batteryEfficiency) {
		super(brand, model, year);
		this.batteryCapacity = batteryCapacity;
        this.batteryEfficiency = batteryEfficiency;
	}
	
	public double calculateChargingCost(double distance, double electricityRate) {
		return (distance / batteryEfficiency) * electricityRate;
	}
	
	public void chargeBattery(double kWh) {
		System.err.println("Charged battery with " + kWh + " kWh.");
	}
	
	 @Override
	    public void displayInfo() {
	        super.displayInfo();
	        System.out.println("Battery Capacity: " + batteryCapacity + " kWh, Battery Efficiency: " + batteryEfficiency + " km/kWh");
	    }
}
