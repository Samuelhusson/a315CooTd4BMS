package flights;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import core.Service4PI;

/**
 * This class allows the management of a set of flights
 * 
 * @author Mireille Blay-Fornarino
 *
 * 
 */

public class FlightService extends Service4PI<Flight> {

	public FlightService(List<Flight> flights) {
		super(flights);
	}

	/**
	 * @param aDate : {@code LocalDate}
	 * @return the list of flights available on a given date {@code LocalDate}
	 */
	public List<Flight> getFlights(LocalDate aDate) {
		Stream<Flight> parallelStream = super.payingItemList.parallelStream();
		Stream<Flight> results = parallelStream.filter(f -> (f.getDepartDate().equals(aDate)));
		return results.collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * @param d    : : {@code LocalDate}
	 * @param from : departure airport name
	 * @param to   : arrival airport name
	 * @return the list of flights available on a given date {@code LocalDate} from
	 *         a place to another place
	 */
	public List<Flight> getFlights(LocalDate d, String from, String to) {
		Stream<Flight> parallelStream = super.payingItemList.parallelStream();
		Stream<Flight> results = parallelStream.filter(f -> f.match(d, from, to));
		return results.collect(Collectors.toCollection(ArrayList::new));
	}

	public Flight bestPriceFlight() {
		return sortedByPrice().get(0);
	}

}
