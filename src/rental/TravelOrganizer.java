package rental;

import cars.CarRentalService;
import flights.FlightService;

import java.util.ArrayList;
import java.util.List;

public class TravelOrganizer implements Service{

    private List<Service> services;

    public TravelOrganizer() {
    	services = new ArrayList<Service>();
    }
    
    public TravelOrganizer(List<Service> serv) {
    	services = serv;
    }

    public Trip createATrip(Description description) {
        Trip tr = new Trip(description);
        services.forEach(service -> {
        	if (service.find(description) != null) {
        		tr.addItem(service.find(description));
        	}
        });
        return tr;
    }

    public void addService(Service service) {
        services.add(service);
    }

	@Override
	public Product find(Description desc) {
		return null;
	}
    
}
