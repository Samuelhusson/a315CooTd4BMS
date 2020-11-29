package rental;

import cars.CarRentalService;
import flights.FlightService;

import java.util.List;

public class TravelOrganizer {

    private Trip trip;
    private List<Service> services;

    public TravelOrganizer() {

    }

    public Trip createATrip(Description description) {
        trip = new Trip(description);
        return trip;
    }

    public void addService(Service service) {
        services.add(service);
    }
}
