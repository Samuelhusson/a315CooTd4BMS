package flights;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import flights.Flight;

public class FlightTest {

	
	Flight f1 ;
	@BeforeEach
	public void setUp() {
		f1 = new Flight(100, LocalDate.of(2017,11,11), LocalTime.of(7, 45),"Nice","Paris");
	}


	@Test
	public void testGetPrice() {
		assertEquals(100,f1.getPrice(),0);
		f1.setPrice(-1);
		assertTrue(f1.getPrice()>=10);
		assertTrue(f1.getPrice()<=1000);
	}

}
