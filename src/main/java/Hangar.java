import java.util.ArrayList;

public class Hangar {
    private ArrayList<Plane> planes;

    public Hangar(){
        this.planes = new ArrayList<>();
    }

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public int planeCount() {
        return planes.size();
    }

    public void addPlane(Plane plane){
        this.planes.add(plane);
    }

    public boolean removePlane(Plane plane) {
        return planes.remove(plane);
    }

    public Plane getOnePlane() {
        return planes.get(0);
    }

    public Plane findPlaneByCapacity(int maxCapacity) {
        Plane chosenPlane = null;
        for (Plane plane : this.planes) {
            if (plane.getCapacity() <= maxCapacity) {
                {
                    chosenPlane = plane;
                }
            }
        }
        if (chosenPlane != null) {
            removePlane(chosenPlane);
            return chosenPlane;

        } else {
            for (Plane plane : this.planes) {
                if (plane.getCapacity() <= maxCapacity + 100) {
                    chosenPlane = plane;
                    removePlane(chosenPlane);
                    return chosenPlane;
                }
            }
            if (chosenPlane != null) {
                removePlane(chosenPlane);
                return chosenPlane;
            }
        }
    }

    public Plane getPlaneBySize(String planeSize) {
        if (planeSize == "Small") {
            return findPlaneByCapacity(100);
        }
        else if (planeSize == "Medium") {
            return findPlaneByCapacity(200);
        }
            return findPlaneByCapacity(300);
    }

}
