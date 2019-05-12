import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Airline airline;
    Plane plane;
    Flight flight;

    @Before
    public void before(){
        airline = new Airline("British Airways");
        plane = new Plane(PlaneType.BOEING737, airline);
        flight = new Flight(plane, "BA 207", AirportCode.EDI, AirportCode.VIE, new DateTime(22, 8, 2019, 20, 40), new DateTime(22, 8, 2019, 23, 0));
    }

    @Test
    public void hasPlane(){
        assertEquals(true, plane instanceof Plane);
    }

    @Test
    public void hasFlightNumber(){
        assertEquals("BA 207", flight.getFlightNumber());
    }

    @Test
    public void hasOrigin(){ assertEquals("Edinburgh", flight.getOrigin()); }

    @Test
    public void hasDestination(){ assertEquals("Edinburgh", flight.getDestination()); }

    @Test
    public void hasMaxCapacity() { assertEquals(50, flight.maxCapacity()); }

    @Test
    public void canCountTicketsIssued() { assertEquals(0, flight.ticketsIssuedCount()); }

    @Test
    public void hasDepartureDate() { assertEquals("22.8.2019 at 20.40", flight.getDeparture());}

}
