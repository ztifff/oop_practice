package rectangle;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		char choices;
		
		Rectangle defaultRectangle = new Rectangle();
		defaultRectangle.displayDetails();
		
		boolean running =true;
		
		while(running) {
			System.out.print("Do you want to customize the card?(Y/N): ");
			choices = scanner.next().charAt(0);
			
			if (choices == 'Y' || choices == 'y') {
				
				System.out.println("Enter Customization:\n"
								+ "[1] Custom Width & Height\n"
								+ "[2] Square\n");
				int choiceCustom = scanner.nextInt();
				switch (choiceCustom) {
				case 1:
					System.out.print("Enter Width: ");
					double width = scanner.nextDouble();
					System.out.print("Enter Height: ");
					double height = scanner.nextDouble();
					
					Rectangle customRectangle = new Rectangle(width, height);
					customRectangle.displayDetails();
					break;
					
				case 2:
					System.out.println("Enter value for both: ");
					double square = scanner.nextDouble();
					Rectangle squareRectangle = new Rectangle(square);
					squareRectangle.displayDetails();
					break;

				default:
					System.out.println("Invalid Output!");
					break;
				}
			
			} else if (choices == 'N' || choices == 'n') {
				running = false;
			} else {
				System.out.println("Invalid Output!");
			}
			
			
			
		} 

	}

}
