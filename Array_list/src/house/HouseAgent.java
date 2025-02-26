package house;

public class HouseAgent {
    private final String name;
    private final String age;
    private final String type;
    private final String location;
    private final int size;
    private final int basePrice;

    public HouseAgent(String name, String age, String type, String location, int size, int basePrice) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.location = location;
        this.size = size;
        this.basePrice = basePrice;
    }

    public double calculatePrice() {
        double ageIncrease = basePrice * ageIncreaseValue();
        double typeIncrease = basePrice * typeIncreaseValue();
        double sizeIncrease = basePrice * sizeIncreaseValue();
        return basePrice + ageIncrease + typeIncrease + sizeIncrease;
    }

    public double ageIncreaseValue() {
        return switch (age) {
            case "New" -> 0.20;
            case "Vintage" -> 0.10;
            case "Old" -> -0.10;
            default -> 0;
        };
    }

    public double typeIncreaseValue() {
        return switch (type) {
            case "Modern" -> 0.20;
            case "Standard" -> 0.10;
            case "Local" -> -0.10;
            default -> 0;
        };
    }

    public double sizeIncreaseValue() {
        return switch (size) {
            case 50 -> 0.30;
            case 30 -> 0.20;
            case 10 -> 0.10;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nType: " + type + "\nSize: " + size + " hectares" +
                "\nLocation: " + location + "\nTotal Price: " + calculatePrice() + "\n";
    }
}
