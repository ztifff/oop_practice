package array_list;

public class ParagraphManager {
	private String paragraphString;
	
	public ParagraphManager(String paragraphString) {
		this.paragraphString = paragraphString;
	}
	
	public String getParagraph() {
		return paragraphString;
	}

	public int countWords() {
        if (paragraphString.isEmpty()) {
            return 0;
        }
        String[] words = paragraphString.trim().split("\\s+");
        return words.length;
    }
}
