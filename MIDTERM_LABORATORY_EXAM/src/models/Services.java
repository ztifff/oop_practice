package models;

public class Services {
	private String serviceName;
    private double price;
    private Dentist dentist;
    
    public Services(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }
    
    public String getServiceName() {
        return serviceName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
    
    @Override
    public String toString() {
        return serviceName + " - ₱" + price;
    }

}
