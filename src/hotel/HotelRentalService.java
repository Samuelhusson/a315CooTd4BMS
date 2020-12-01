package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import core.Service4PI;
import rental.Description;
import rental.Product;
import rental.Service;
import util.NotPossibleHotelRentalException;

public class HotelRentalService extends Service4PI<HotelRental> implements Service {

	private List<Hotel> hotels;
	
	public HotelRentalService(List<Hotel> hotels) {
		super(new ArrayList<HotelRental>());
		this.hotels = hotels;
	}
	
	public HotelRental book(Hotel h, LocalDate fromDate, int numberofNights) throws NotPossibleHotelRentalException {
		HotelRental hotelRental = null;
		if (hotels == null || !(hotels.contains(h))) {
			throw new NotPossibleHotelRentalException("Not known hotel");
		}
		hotelRental = new HotelRental(h, fromDate, numberofNights);
		super.payingItemList.add(hotelRental);
		return hotelRental;
	}

	@Override
	public Product find(Description desc) {
		if (desc.getDuration() != 1) {
			this.hotels.forEach(hotel -> {
				try {
					book(hotel, desc.getDepartDate(), desc.getDuration());
				} catch (NotPossibleHotelRentalException e) {
					e.printStackTrace();
				}
			});
			List<HotelRental> hr = sortedByPrice();
			return hr.get(0);
		}
		return null;
	}
	
}
