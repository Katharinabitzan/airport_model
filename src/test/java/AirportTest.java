import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    Hangar hangar;
    Plane plane;
    Plane smallPlane;
    Airline airline;
    Passenger passenger1;
    Passenger passenger2;

    Flight flight1;
    Flight flight2;

    @Before
    public void before(){
        airline = new Airline("British Airways");
        plane = new Plane(PlaneType.BOEING737, airline);
        smallPlane = new Plane (PlaneType.HAWKER800, airline);

        hangar = new Hangar();
        airport = new Airport(AirportCode.EDI);

        airport.addHangar(hangar);
        hangar.addPlane(plane);

        passenger1 = new Passenger(200.0);
        passenger2 = new Passenger(400.0);
        flight1 = airport.createFlight(plane, "BA 207", AirportCode.EDI, AirportCode.VIE, new DateTime(22, 8, 2019, 20, 40), new DateTime(22, 8, 2019, 23, 0));
        flight2 = airport.createFlight(smallPlane, "BA 207", AirportCode.EDI, AirportCode.VIE, new DateTime(22, 8, 2019, 20, 40), new DateTime(22, 8, 2019, 23, 0));

    }

    @Test
    public void canAddHangars(){
        assertEquals(1, airport.hangarCount());
    }

    @Test
    public void hasName() {assertEquals("Edinburgh", airport.getAirportCode()); }

    @Test
    public void canGetFirstPlaneFromHangar(){
        Plane plane1 = airport.getPlaneFromHangar();
        assertEquals(true, plane1 instanceof Plane);
    }

//    @Test
//    public void canGetSpecifiedPlaneFromHangar(){
//        Plane foundPlane = airport.findPlaneFromHangar(plane);
//        assertEquals(true, foundPlane instanceof Plane);
//    }

    @Test
    public void canCreateFlight(){
        assertEquals(true, flight1 instanceof Flight);
    }

    @Test
    public void cantSellTicketForTooExpensiveFlight() {
        airport.sellTicket(flight1, passenger1, SeatCategory.BUSINESS);
        assertEquals(0, passenger1.ticketCount());
    }

    @Test
    public void cantSellTicketForFullFlight() {
        airport.sellTicket(flight2, passenger1, SeatCategory.ECONOMY);
        airport.sellTicket(flight2, passenger2, SeatCategory.ECONOMY);
        airport.sellTicket(flight2, passenger2, SeatCategory.ECONOMY);

        assertEquals(2, flight2.ticketsIssuedCount());
    }

    @Test
    public void canSellTicketForFlight(){
        airport.sellTicket(flight1, passenger1, SeatCategory.ECONOMY);
        assertEquals(1, passenger1.ticketCount());
        assertEquals(90.0, passenger1.getBalance(), 0.01);
    }

}
