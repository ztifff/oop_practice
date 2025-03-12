package car;

public class Vehicle {
	protected String brand, model;
	protected int year;
	protected boolean isEngineOn;
	
	
	public Vehicle(String brand, String model, int year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.isEngineOn = false;
	}
	
	public void startEngine() {
		if (!isEngineOn) {
			isEngineOn = true;
			System.out.println("Engine Started.");
		} else {
			System.out.println("Engine is already running.");
		}
	}
	
	public void stopEngine() {
		if (isEngineOn) {
			isEngineOn = false;
			System.out.println("Engine stopped.");
		} else {
			System.out.println("Engine is already off.");
		}
	}
	
	public void displayInfo() {
		System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
	}
	
	

}
