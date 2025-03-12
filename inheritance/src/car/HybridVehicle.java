package car;

public class HybridVehicle extends NonElectricVehicle {
	private double batteryEfficiency;
    private boolean isHybridMode;
    
    
    public HybridVehicle(String brand, String model, int year, double fuelEfficiency, double batteryEfficiency) {
        super(brand, model, year, fuelEfficiency);
        this.batteryEfficiency = batteryEfficiency;
        this.isHybridMode = false;
    }
    
    public void enableHybridMode() {
        isHybridMode = true;
        System.out.println("Hybrid mode enabled.");
    }

    public void disableHybridMode() {
        isHybridMode = false;
        System.out.println("Hybrid mode disabled.");
    }
    
    public double calculateHybridCost(double distance, double fuelPrice, double electricityRate) {
		return (((distance / 2) / super.getFuelEfficiency()) * fuelPrice + (((distance / 2) / batteryEfficiency) * electricityRate));
	}
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Efficiency: " + batteryEfficiency + " km/kWh, Hybrid Mode: " + (isHybridMode ? "Enabled" : "Disabled"));
    }
}

