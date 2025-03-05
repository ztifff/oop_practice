package company;

public class OfficeBuilding {
	//class fields
	private String ceoSecrets = "Company Plan";
	String o3iceLounge = "Break Room with Co3ee";
	protected String projectFiles = "Project file 1";
	public String receptionDesk = "Welcome to Company XYZ";

	public OfficeBuilding() {
	System.out.println("O3ice Building initialized..");
	}

	//methods
	private void accessO3ice() {
	System.out.println("Accessing CEO O3ice: " + ceoSecrets);
	}

	void useO3iceLounge() {
	System.out.println("Using o3ice lounge: " + o3iceLounge);
	}

	protected void viewProjectFiles() {
	System.out.println("Viewing project files: " + projectFiles);
	}

	public void visitReception() {
	System.out.println("Reception Desk: " + receptionDesk);
	}

	public void accessCEOO3ice() {
	accessO3ice();
	}
}
