package models;

import java.time.Year;

public class Client extends Person {
	private static int idCounter = 1;
	private String clientID;

	public Client(String name, String address, String contactNumber) {
		super(name, address, contactNumber);
		int currentYear = Year.now().getValue();
		this.clientID = currentYear + "-" + String.format("%04d", idCounter++);
	}

	public String getClientID() {
		return clientID;
	}

	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return super.address;
	}
	
	public String getContactNumber() {
		return super.contactNumber;
	}
}
