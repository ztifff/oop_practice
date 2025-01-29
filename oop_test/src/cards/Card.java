package cards;

public class Card {
	 private String type; // Monster, Magic, Trap
	    private String rarity; // Common, Rare, Super Rare
	    private String isMeta; // Meta status
	    
	    public void setType(String type) {
			this.type = type;
		}
	    
	    public void setRarity(String rarity) {
			this.rarity = rarity;
		}
	    
	    public void setisMeta(String isMeta) {
			this.isMeta = isMeta;
		}

	    public double calculateFinalPrice() {
	        double basePrice = 0;
	        if (rarity.equalsIgnoreCase("Common")) {
	            basePrice = 100;
	        } else if (rarity.equalsIgnoreCase("Rare")) {
	            basePrice = 150;
	        } else if (rarity.equalsIgnoreCase("Super Rare")) {
	            basePrice = 200;
	        }

	        if (isMeta.equalsIgnoreCase("yes")) {
	            basePrice *= 3; // Meta multiplier
	        } else if (isMeta.equalsIgnoreCase("No")) {
				basePrice += basePrice;
				basePrice *= 0.5; // Add 50% fee
			}
	        return basePrice; 
	    }
	    
	    public void displayCard() {
	    	System.out.println("Card Details:\n");
			System.out.println("Card Type: " + type);
			System.out.println("Card Rarity: " + rarity);
			System.out.println("Card Meta: " + isMeta);
			System.out.println("Card Price: " + calculateFinalPrice());
		}
	    

}
