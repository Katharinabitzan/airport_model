import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger1;
    Passenger passenger2;

    Ticket ticket;

    Airline airline;
    Plane plane;
    Flight flight;

    @Before
    public void before(){
        passenger1 = new Passenger(100);
        passenger2 = new Passenger(0);
        airline = new Airline("British Airways");
        plane = new Plane(PlaneType.BOEING737, airline);
        flight = new Flight("BA 207", AirportCode.EDI, AirportCode.VIE, new DateTime(22, 8, 2019, 20, 40), new DateTime(22, 8, 2019, 23, 0));
        ticket = new Ticket(100.00, SeatCategory.ECONOMY, flight);

    }

    @Test
    public void passengerStartsWithNoTickets() {
        assertEquals(0, passenger1.ticketCount());
    }

    @Test
    public void canBuyTicket() {
        passenger1.buyTicket(ticket);
        assertEquals(1, passenger1.ticketCount());}

    @Test
    public void hasEnoughBalanceForTicket(){
        assertEquals(false, passenger1.notEnoughBalance(100.0));
    }

    @Test
    public void doesntHaveEnoughBalanceForTicket(){
        assertEquals(true, passenger1.notEnoughBalance(200.0));
    }

}