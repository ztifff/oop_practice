package cards;

public class Card {
	 private String type; // Monster, Magic, Trap
	    private String rarity; // Common, Rare, Super Rare
	    private boolean isMeta; // Meta status

	    public Card(String type, String rarity, boolean isMeta) {
	        this.type = type;
	        this.rarity = rarity;
	        this.isMeta = isMeta;
	    }

	    public double calculateFinalPrice() {
	        double basePrice = 0;
	        if (rarity.equals("Common")) {
	            basePrice = 100;
	        } else if (rarity.equals("Rare")) {
	            basePrice = 150;
	        } else if (rarity.equals("Super Rare")) {
	            basePrice = 200;
	        }

	        if (isMeta) {
	            basePrice *= 3; // Meta multiplier
	        }
	        return basePrice + (basePrice * 0.5); // Add 50% fee
	    }

	    public String toString() {
	        return "Type: " + type + ", Rarity: " + rarity + ", Meta: " + (isMeta ? "Yes" : "No") + ", Final Price: " + calculateFinalPrice();
	    }

}
