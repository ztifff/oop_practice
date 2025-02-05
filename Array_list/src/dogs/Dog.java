package dogs;

public class Dog {
	private String breedString;
	private String colorString;

	public Dog(String breedString, String colorString) {
		this.breedString = breedString;
		this.colorString = colorString;
	}

	public String getBreed() {
		return breedString;
	}
	public String getColor() {
		return colorString;
	}

	public void setBreed(String breedString) {
		this.breedString = breedString;
	}

	public void setColor(String colorString) {
		this.colorString = colorString;
	}

}
