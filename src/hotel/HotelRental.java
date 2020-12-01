package hotel;

import java.time.LocalDate;

import core.PayingItem;
import rental.Product;

public class HotelRental implements PayingItem, Product {

	private Hotel hotel;
	private LocalDate beginDate;
	private double nightPrice;
	private int duration;
	
	public HotelRental(Hotel h, LocalDate date, double price, int dur) {
		this.hotel = h;
		this.beginDate = date;
		this.nightPrice = price;
		this.duration = dur;
	}
	
	public HotelRental(Hotel h, LocalDate date, int dur) {
		this.hotel = h;
		this.beginDate = date;
		this.nightPrice = h.getNightPrice();
		this.duration = dur;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel h) {
		this.hotel = h;
	}
	
	public LocalDate getBeginDate() {
		return beginDate;
	}
	
	public void setLocalDate(LocalDate date) {
		this.beginDate = date;
	}
	
	public double getNightPrice() {
		return nightPrice;
	}
	
	public void setNightPrice(double price) {
		this.nightPrice = price;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int dur) {
		this.duration = dur;
	}
	
	@Override
	public double getPrice() {
		return nightPrice*duration;
	}
	
	@Override
	public String toString() {
		return "Réservation à l'hotel : Date de début : "+beginDate+"; durée de la réservation : "+duration+"; Prix par nuit : "+nightPrice+"; Prix : "+this.getPrice()+"\n";
	}

}
