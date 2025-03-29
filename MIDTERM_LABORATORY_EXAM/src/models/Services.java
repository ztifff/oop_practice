package models;

import java.util.ArrayList;
import java.util.List;

public class Services {
	private String serviceName;
	private double price;
	private List<Dentist> dentists;

	public Services(String serviceName, double price) {
		this.serviceName = serviceName;
		this.price = price;
		this.dentists =  new ArrayList<>();
	}

	public String getServiceName() {
		return serviceName;
	}

	public double getPrice() {
		return price;
	}

	public List<Dentist> getDentists() {
		return dentists;
	}

	public void addDentist(Dentist dentist) {
		if (!dentists.contains(dentist)) {
			dentists.add(dentist);
		}
	}

	@Override
	public String toString() {
		return serviceName + " - ₱" + price;
	}
}
