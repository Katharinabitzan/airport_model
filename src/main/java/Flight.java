import java.util.ArrayList;

public class Flight {
    private Plane plane;
    private String flightNumber;
    private AirportCode origin;
    private AirportCode destination;
    private DateTime departure;
    private DateTime arrival;
    private ArrayList<Ticket> ticketsIssued;


    public Flight(String flightNumber, AirportCode origin, AirportCode destination, DateTime departure, DateTime arrival){
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.ticketsIssued = new ArrayList<>();
        this.plane = null;

    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination.getName();
    }

    public String getOrigin() {
        return origin.getName();
    }

    public String getDeparture() {
        return departure.getDateTime();
    }

    public String getArrival() {
        return arrival.getDateTime();
    }

    public ArrayList<Ticket> getTicketsIssued() {
        return ticketsIssued;
    }

    public int ticketsIssuedCount() { return ticketsIssued.size(); }

    public int maxCapacity() {
        return getPlane().getType().getCapacity();
    }

    public void addTicketIssued(Ticket ticket) { ticketsIssued.add(ticket); }

    public void setPlane(Plane plane) {this.plane = plane; }

    public String getRegionOfOrigin() {
        return origin.getRegion();
    }

    public String getRegionOfDestination() {
        return destination.getRegion();
    }
}

