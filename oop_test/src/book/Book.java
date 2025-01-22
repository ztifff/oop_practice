package book;

public class Book {
    private String[] title = {"Solo Leveling", "Omniscient Reader's Viewpoint", "Shadow Slave"};
    private String[] author = {"Yin and Yong", "Sing Shong", "Louise"};
    private int copies = 3; // Default number of copies for simplicity.

    public String[] getTitle() {
        return title;
    }

    public String[] getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }

    public void borrowBook() {
        if (copies > 0) {
            copies--;
            System.out.println("Book borrowed successfully! Remaining copies: " + copies);
        } else {
            System.out.println("No copies left to borrow!");
        }
    }

    public void returnBook() {
        copies++;
        System.out.println("Book returned successfully! Remaining copies: " + copies);
    }

    public void display() {
        System.out.println("All Books and their remaining copies:");
        System.out.println("Titles: ");
        for (String t : title) {
            System.out.print(t + ", ");
        }
        System.out.println("\nAuthors: ");
        for (String a : author) {
            System.out.print(a + ", ");
        }
        System.out.println("\nRemaining copies: " + copies);
    }
}
