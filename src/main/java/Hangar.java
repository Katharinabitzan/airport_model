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
}
