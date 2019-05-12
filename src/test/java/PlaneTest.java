import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Passenger passenger1;

    Plane plane1;
    Plane plane2;
    Plane plane3;

    Airline airline1;
    Airline airline2;
    Airline airline3;

    @Before
    public void before() {

        passenger1 = new Passenger(100);

        airline1 = new Airline("British Airways");
        airline2 = new Airline("Ryanair");
        airline3 = new Airline("EasyJet");

        plane1 = new Plane(PlaneType.BOEING737, airline1);
        plane2 = new Plane(PlaneType.AIRBUSA320, airline2);
        plane3 = new Plane(PlaneType.HAWKER800, airline1);
    }

    @Test
    public void passengerCount(){
        assertEquals(0, plane1.passengerCount());
    }

    @Test
    public void canAddPassenger(){
        plane1.addPassenger(passenger1);
        assertEquals(1, plane1.passengerCount());
    }

    @Test
    public void canRemoveAllPassengers(){
        plane1.addPassenger(passenger1);
        plane1.removeAllPassengers();
        assertEquals(0, plane1.passengerCount());
    }
}
