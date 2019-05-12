import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HangarTest {

    Hangar hangar;
    Plane plane;
    Airline airline;

    @Before
    public void before(){
        hangar = new Hangar();
        airline = new Airline("British Airways");
        plane = new Plane(PlaneType.BOEING737, airline);
        hangar.addPlane(plane);

    }

    @Test
    public void canAddPlane(){
        assertEquals(1, hangar.planeCount());
    }

    @Test
    public void canRemovePlane(){
        assertEquals(true, hangar.removePlane(plane));
    }

    @Test
    public void cantRemoveNonExistancePlane(){
        hangar.removePlane(plane);
        assertEquals(false, hangar.removePlane(plane));
    }



}