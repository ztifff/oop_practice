package mosnterManager;

public class MonsterManager {
	private String nameString;
	private String categoryString;
	private String elementString;
	private double ATK;
	private double HP;
	private double SPEED;
	private double DEF;
	
	public MonsterManager(String nameString,String categoryString,String elementString,double ATK,double HP,double SPEED,double DEF) {
		this.nameString =nameString;
		this.categoryString = categoryString;
		this.elementString = elementString;
		this.ATK = ATK;
		this.HP = HP;
		this.SPEED = SPEED;
		this.DEF = DEF;
	}
	
	public String getNameString() {
		return nameString;
	}

	public double defValue() {
		return switch (categoryString) {
		case "Guardian" -> 0.50 * DEF + DEF;
		case "Hunter" -> -0.30 * DEF + DEF;
		case "Healer" -> DEF;
		default ->
		throw new IllegalArgumentException("Unexpected value: " + categoryString);
		};
	}
	
	
	public double atkValue() {
		return switch (categoryString) {
		case "Healer" -> -0.30 * ATK + ATK ;
		case "Hunter" -> 0.40 * ATK + ATK;
		case "Guardian" -> ATK;
		default ->
		throw new IllegalArgumentException("Unexpected value: " + categoryString);
		};
	}
	
	public double hpValue() {
		return switch (categoryString) {
		case "Guardian" -> 0.30 * HP + HP;
		case "Healer" -> 0.50 * HP + HP;
		case "Hunter" -> HP;
		default ->
		throw new IllegalArgumentException("Unexpected value: " + categoryString);
		};
	}
	public double speedValue() {
		return switch (categoryString) {
		case "Guardian" -> -0.30 * SPEED + SPEED;
		case "Hunter" -> 0.50 * SPEED + SPEED;
		case "Healer" -> SPEED;
		default ->
		throw new IllegalArgumentException("Unexpected value: " + categoryString);
		};
	}

	@Override
	public String toString() {
		return "Name: " + nameString + "\nCategory: " + categoryString + "\nElement: " + elementString + "\nAttack: " + atkValue() + "(" + ATK + ")" + "\nHp: " + hpValue() + "(" + HP + ")" + "\nSpeed: " + speedValue() + "(" + SPEED + ")" + "\nDefense: " + defValue() + "(" + DEF + ")" + "\n";
	}
	

}
