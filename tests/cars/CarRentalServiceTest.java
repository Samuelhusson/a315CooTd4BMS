package cars;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.*;

import util.NotPossibleCarRentalException;


public class CarRentalServiceTest {

	CarRentalService service ; 
	Car myCar0 = new Car("1111 AB 06",50);
	Car myCar1 = new Car("1111 AB 75",100);
	Car myCar2 = new Car("1111 AB 83",75);
	LocalDate currentDate;
	
	@Before
	public void setUp() {
		 myCar0 = new Car("1111 AB 06",50);
		 myCar1 = new Car("1111 AB 75",100);
		 myCar2 = new Car("1111 AB 83",75);
		 service = new CarRentalService( new ArrayList<>(Arrays.asList(myCar0, myCar1, myCar2) )  )  ;
		
	}

	@Test
	public void testGetAvailableCars() throws NotPossibleCarRentalException {
		LocalDate current = LocalDate.of(2020,9,11);
		List<Car> possibleCars = 
				service.getAvailableCars(current, 2);
		assertEquals(3, possibleCars.size());
		
		CarRental carRental = service.book(myCar0,current,2);
		assertTrue(carRental != null);
		possibleCars = 
				service.getAvailableCars(current, 1);
		assertEquals(2, possibleCars.size());
		possibleCars = 
				service.getAvailableCars(current, 2);
		assertEquals(2, possibleCars.size());
		possibleCars = 
				 service.getAvailableCars(LocalDate.of(2020,9,12), 1);
		assertEquals(2, possibleCars.size());
		possibleCars = 
				service.getAvailableCars(LocalDate.of(2020,9,13), 1);
		assertEquals(3, possibleCars.size());
		
	}
	
	
	@Test
	public void testBookAnAvalaibleCar() throws NotPossibleCarRentalException {
		CarRental carRental = service.book(myCar0,LocalDate.of(2018,9,11), 2);
		assertFalse(carRental==null);
		List<Car> possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,11), 1);
		assertEquals(2, possibleCars.size());

		possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,12), 3);
		assertEquals(2, possibleCars.size());
		
		possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,13), 3);
		assertEquals(3, possibleCars.size());
		
		possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,9), 4);
		assertEquals(2, possibleCars.size());
		
		possibleCars =  service.getAvailableCars(LocalDate.of(2018,9,19), 7);
		assertEquals(3, possibleCars.size());
		
	}
	
	
	@Test
	public void testBookANonAvalaibleCar() throws NotPossibleCarRentalException {
		CarRental carRental = service.book(myCar0,LocalDate.of(2020,9,11), 2);
		assertFalse(carRental==null);
		carRental = service.book(myCar0,LocalDate.of(2020,9,12), 2);
		assertTrue(carRental==null);
	}
	
	@Test
	public void testGetNotAvailableCars() throws NotPossibleCarRentalException {
		service.book(myCar0,LocalDate.of(2020,9,11), 2);
		List<Car> possibleCars = service.getAvailableCars(LocalDate.of(2020,9,11), 2);
		assertEquals(2, possibleCars.size());
		possibleCars = service.getAvailableCars(LocalDate.of(2020,9,12), 2);
		assertEquals(2, possibleCars.size());
		possibleCars = service.getAvailableCars(LocalDate.of(2020,9,13), 2);
		assertEquals(3, possibleCars.size());
	}

	@Test
	public void testSortedCars() throws NotPossibleCarRentalException {
		LocalDate current = LocalDate.of(2020,11,17);
		CarRental carRental0 = service.book(myCar0,current,2);
		CarRental carRental1 = service.book(myCar1,current,2);
		CarRental carRental2 = service.book(myCar2,current,2);

		//Test des fonctions pour trier par prix les différentes voitures et locations
		//Etape 0: 2)
		assertEquals(new ArrayList<>(Arrays.asList(myCar0, myCar2, myCar1)), service.sortedCarsByPrice());
		assertEquals(new ArrayList<>(Arrays.asList(carRental0, carRental2, carRental1)), service.sortedCarRentalsByPrice());
		assertEquals(myCar0,service.bestPriceCar());
		assertEquals(carRental0,service.bestPriceCarRental());
	}

}
