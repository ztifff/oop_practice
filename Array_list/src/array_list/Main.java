package array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<ParagraphManager> paragraphManagers = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		

		int choices;
		do {
			System.out.println("----------  PARAGRAPH MANAGER  --------------");
			System.out.println("[1] Add a Paragraph\n"
					+ "[2] Count the Words\n"
					+ "[3] Delete a Paragraph by Its index\n"
					+ "[4] Clear List of Paragraph\n"
					+ "[5] Display all Paragraph\n"
					+ "[6] Exit");
			choices = scanner.nextInt();
			scanner.nextLine();

			switch (choices) {
			case 1:
				System.out.print("Add a Paragraph: ");
				String newParagraph = scanner.nextLine();
				paragraphManagers.add(new ParagraphManager(newParagraph));
				System.out.println("Added Sucessfully");
				break;
			case 2:
				if (paragraphManagers.isEmpty()) {
                    System.out.println("No paragraphs stored!");
                    break;
                }
                System.out.print("Enter paragraph index to count words: ");
                int indexCount = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (indexCount > 0 && indexCount <= paragraphManagers.size()) {
                    int wordCount = paragraphManagers.get(indexCount - 1).countWords();
                    System.out.println("Word Count: " + wordCount);
                } else {
                    System.out.println("Invalid index!");
                }


				break;
			case 3:
				if (paragraphManagers.isEmpty()) {
                    System.out.println("No paragraphs stored!");
                    break;
                }
                System.out.print("Enter paragraph index to delete: ");
                int indexDelete = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (indexDelete > 0 && indexDelete <= paragraphManagers.size()) {
                    paragraphManagers.remove(indexDelete - 1);
                    System.out.println("Paragraph deleted successfully!");
                } else {
                    System.out.println("Invalid index!");
                }

				break;

			case 4:
				paragraphManagers.clear();
                System.out.println("All paragraphs have been cleared!");

				break;

			case 5:
				if (paragraphManagers.isEmpty()) {
					System.out.println("No paragraph Strored");

				}
				System.out.println("Stored Paragraph:");
				for (int i = 0; i < paragraphManagers.size(); i++) {
					ParagraphManager paragraph =paragraphManagers.get(i);
					System.out.println((i + 1) + ". " + paragraph.getParagraph());
				}
				break;

			default:
				System.out.println("Invalid Output!");
				break;
			}

		} while (choices != 6);

	}
	
}
