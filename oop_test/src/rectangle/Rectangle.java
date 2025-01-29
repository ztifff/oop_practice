package rectangle;

public class Rectangle {
	private double width;
	private double height;
	private boolean isSquare;
	
	public Rectangle() {
		width = 1.0;
		height = 1.0;
	}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	public Rectangle(double rectangle) {
		this.width = rectangle;
		this.height = rectangle;
	}
	public double calculateArea() {
		return width * height;
	}
	public double calculatePerimeter() {
		return 2 * (width + height);
	}
	
	public boolean isSquare() {
		return  width == height;
	}
	
	
	public void displayDetails() {
		System.out.println("\nRectangle Details: ");
		System.out.println("Width: " + width);
		System.out.println("Height: " + height);
		System.out.println("Area: " + calculateArea());
		System.out.println("Perimeter: " + calculatePerimeter());
		System.out.println("Square?: " + isSquare());
		System.out.println();
	}
	

}
