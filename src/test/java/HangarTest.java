import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HangarTest {

    Hangar hangar;
    Plane plane;
    Plane smallPlane;
    Plane mediumPlane;
    Airline airline;

    @Before
    public void before(){
        hangar = new Hangar();
        airline = new Airline("British Airways");
        plane = new Plane(PlaneType.BOEING737, airline);
        mediumPlane = new Plane(PlaneType.BOEING747, airline);
        smallPlane = new Plane(PlaneType.AIRBUSA320, airline);
        hangar.addPlane(plane);
        hangar.addPlane(smallPlane);
        hangar.addPlane(mediumPlane);

    }

    @Test
    public void canAddPlane(){
        assertEquals(3, hangar.planeCount());
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

    @Test
    public void canGetPlaneBySize(){
        Plane foundPlane = hangar.getPlaneBySize("Small");
        assertEquals(true, foundPlane instanceof Plane);
        assertEquals(2, hangar.planeCount());
    }

    @Test
    public void cantGetNonExistantPlaneBySize(){
        Plane foundPlane = hangar.getPlaneBySize("Tiny");
        assertEquals(false, foundPlane instanceof Plane);
    }

    @Test
    public void canGetNextSuitablePlane(){
        Plane firstPlane = hangar.getPlaneBySize("Small");
        Plane secondPlane = hangar.getPlaneBySize("Small");
        assertEquals(1, hangar.planeCount());
    }


}