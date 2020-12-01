package flights;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import core.PayingItem;
import rental.Product;

/**
 * 
 * 
 * Simplified definition of a flight 
 * departing from a given airport on a given date. 
 * It is assumed that the flight arrives at the destination airport on the same day.
 * 
 * @author Mireille Blay-Fornarino
 *
 *
 */
public class Flight implements PayingItem, Product {

	private static final int NOT_ASSIGNED = -1;
	private static final String DEFAULT_DESTINATION= "Paris";
	private double price = NOT_ASSIGNED;
	private LocalDate departDate;
	private String departureAirport;
	private String arrivalAirport;
	private LocalTime departureTime;

	public LocalTime getDepartTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departTime) {
		this.departureTime = departTime;
	}

	public Flight(String departureAirport) {
		this(NOT_ASSIGNED, LocalDate.now(), LocalTime.now(), departureAirport, DEFAULT_DESTINATION);
	}

	public Flight(double price, LocalDate departDate, LocalTime departTime, String departAirport, String arrivalAirport) {
		super();
		this.price = price;
		this.departDate = departDate;
		this.departureAirport = departAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureTime= departTime;
	}

	public LocalDate getDepartDate() {
		return departDate;
	}

	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}


	public String getDepartAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	/**
	 * @return the price of the flight.  If the price is not affected, the price is calculated randomly, almost as in reality 
	 */
	public double getPrice() {
		if (price == NOT_ASSIGNED) {
			double start = 10;
			double end = 1000;
			double random = new Random().nextDouble();
			price = start + (random * (end - start));
		}
		return price;
	}

	/**
	 * @param d date for the flight
	 * @param from name of the departure airport
	 * @param to name of the arrival airport
	 * @return true if the different parameters match with the current flight
	 */
	public boolean match(LocalDate d, String from, String to) {
		return getDepartDate().equals(d) && getDepartAirport().equals(from) && getArrivalAirport().equals(to);

	}
	
	@Override
	public String toString() {
		return "Vol d'avion : Date de d�part : "+departDate+"; A�roport de d�part : "+departureAirport+"; A�roport d'arriv� : "+arrivalAirport+"; Heure de d�part : "+departureTime+"; Prix : "+this.getPrice()+"\n";
	}
}
