package house;

public class HouseAgent {
	private String name;
	private String Age;
	private String typeString;
	private String locationString;
	private int size;
	private int basePrice;

	public HouseAgent(String name, String Age, String typeString, String locationString, int size, int basePrice) {
		this.name = name;
		this.Age = Age;
		this.typeString = typeString;
		this.locationString = locationString;
		this.size = size;
		this.basePrice = basePrice;
	}

	public double CalculationPrice() {

		double ageIncrease =  basePrice * ageIncreasedValue();
		double typeIncrease = basePrice * typeIncreasedvalue();
		double sizeIncrease = basePrice * sizeIncreasedValue();

		return ageIncrease + typeIncrease + sizeIncrease + basePrice;

	}

	public double ageIncreasedValue() {

		return switch (Age) {
		case "New", "new" -> 0.20; 
		case "Vintage", "vintage" -> 0.10;
		case "Old", "old" -> -0.10;
		default ->
		throw new IllegalArgumentException("Unexpected value: " + Age);
		};

	}
	public double typeIncreasedvalue() {

		return switch (typeString) {
		case "Modern", "modern" -> 0.20;
		case "Standard", "standard" -> 0.10;
		case "Local", "local" -> -0.10;
		default ->
		throw new IllegalArgumentException("Unexpected value: " + typeString);
		};
	}

	public double sizeIncreasedValue() {

		return switch (size) {
		case 50 -> 0.30;
		case 30 -> 0.20;
		case 10 -> 0.10;
		default ->
		throw new IllegalArgumentException("Unexpected value: " + size);
		};
	}

	public String getName() {
		return name;
	}
	public String getAge() {
		return Age;
	}
	public String getTypeString() {
		return typeString;
	}
	public String getLocationString() {
		return locationString;
	}
	public int getSize() {
		return size;
	}

}
