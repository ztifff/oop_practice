package grade;

public class Student {
	private String name;
	private double grade;
	
	public Student(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}
	
	 public String gradeStatus() {
	        return (grade >= 75) ? "Pass" : "Fail";
	    }
	
	
	public void display() {
		System.out.println("Student name: " + name);
		System.out.println("Grade: " + grade);
		System.out.println("Status: " + gradeStatus());
	}
	
}
