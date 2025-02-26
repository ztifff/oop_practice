package prelimProject;


public class ToyCollection {
	private static int idCount = 1;
	private int id;
	private String name;
	private int condition;
	private String manufacturer;
	private String size;
	private double weight;
	private int isBatteryOperated;
	private int hasSoundFeatures;
	private String interactiveFeatures;


	public ToyCollection(String name, int condition, String manufacturer, String size, double weight, int isBatteryOperated, int hasSoundFeatures, String interactiveFeatures) {
		id= idCount++;
		this.name = name;
		this.condition = condition;
		this.manufacturer = manufacturer;
		this.size = size;
		this.weight = weight;
		this.isBatteryOperated = isBatteryOperated;
		this.hasSoundFeatures = hasSoundFeatures;
		this.interactiveFeatures = interactiveFeatures;
	}



	//========================================================================================
	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public void setWeight(double weight) {
		this.weight = weight;                
	}

	public void setInteractiveFeatures(String interactiveFeatures) {
		this.interactiveFeatures = interactiveFeatures;

	}


	//========================================================================================
	// Getter
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public int getCondition() {
		return condition;
	}

	public String getInteractiveFeatures() {
		return interactiveFeatures;
	}


	//========================================================================================

	public String Condition() {
		return switch(condition) {
		case 1 ->  "New";
		case 2 ->  "Used";
		case 3 ->  "Refurbished";
		default ->
		throw new IllegalArgumentException("Unexpected value: " + condition);
		};

	}



	public boolean IsBatteryOperated() {
		return switch(isBatteryOperated) {
		case 1 -> true;
		case 2 -> false;
		default ->
		throw new IllegalArgumentException("Unexpected value: " + isBatteryOperated);
		};
	}

	public boolean HasSoundFeatures() {
		return switch(hasSoundFeatures) {
		case 1 ->  true;
		case 2 ->  false;
		default ->
		throw new IllegalArgumentException("Unexpected value: " + hasSoundFeatures);
		};
	}


	//========================================================================================


	// Display Details method
	public void displayDetails() { 
		String border = "+----------------------+----------------------+";

		System.out.println(border);
		System.out.printf("| %-20s : %-25d |\n", "ID", id);
		System.out.printf("| %-20s : %-25s |\n", "TOY NAME", name);
		System.out.printf("| %-20s : %-25s |\n", "MANUFACTURER", manufacturer);
		System.out.printf("| %-20s : %-25s |\n", "CONDITION", Condition());
		System.out.printf("| %-20s : %-25s |\n", "SIZE", size + " cm");
		System.out.printf("| %-20s : %-25s |\n", "WEIGHT", weight + "g");
		System.out.printf("| %-20s : %-25s |\n", "BATTERY OPERATED", (IsBatteryOperated() ? "Yes" : "No"));
		System.out.printf("| %-20s : %-25s |\n", "HAS SOUND FEATURES", (HasSoundFeatures() ? "Yes" : "No"));
		System.out.printf("| %-20s : %-25s |\n", "INTERACTIVE FEATURES", interactiveFeatures.isEmpty() ? "None" : interactiveFeatures);
		System.out.println(border);
	}// end of display method

}
