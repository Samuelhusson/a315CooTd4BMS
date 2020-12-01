package hotel;

public class Hotel {

	private String name;
	private double nightPrice;
	
	public Hotel(String n, double price) {
		this.name = n;
		this.nightPrice = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public double getNightPrice() {
		return nightPrice;
	}
	
	public void setNightPrice(double price) {
		nightPrice = price;
	}
	
}
