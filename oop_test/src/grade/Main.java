package grade;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Student name: ");
		String name = scanner.nextLine();
		System.out.print("Enter student grade: ");
		double grade = scanner.nextDouble();
		
		Student student = new Student(name, grade);
		
		student.display();
		
		
	}
}
