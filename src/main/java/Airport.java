import java.util.ArrayList;

public class Airport {

    private ArrayList<Hangar> hangars;
    private AirportCode airportCode;

    public Airport(AirportCode airportCode){
        this.airportCode = airportCode;
        this.hangars = new ArrayList<>();
    }

    public ArrayList<Hangar> getHangars() {
        return hangars;
    }

    public String getAirportCode() {
        return airportCode.getName();
    }

    public int hangarCount() {
        return hangars.size();
    }

    public void addHangar(Hangar hangar) {
        this.hangars.add(hangar);
    }

    public Plane getPlaneFromHangar(){
        return hangars.get(0).getOnePlane();
    }

    public Flight createFlight(Plane plane, String flightNumber, AirportCode origin, AirportCode destination, DateTime departure, DateTime arrival) {
        return new Flight(plane, flightNumber, origin, destination, departure, arrival);
    }

    public boolean flightFull(Flight flight) {
        return (flight.maxCapacity() <= flight.ticketsIssuedCount());
    }

    public Ticket createTicket(SeatCategory seatCategory, Flight flight) {
        double ticketPrice = setTicketPrice(seatCategory, flight);
        return new Ticket(ticketPrice, seatCategory, flight);
    }

    public double setTicketPrice(SeatCategory seatCategory, Flight flight) {
        return 100.0 + seatCategory.getCost();
    }


    public void sellTicket(Flight flight, Passenger passenger, SeatCategory seatCategory) {
        double ticketPrice = setTicketPrice(seatCategory, flight);

        if (!flightFull(flight) && !passenger.notEnoughBalance(ticketPrice)) {
            Ticket ticketCreated = createTicket(seatCategory, flight);
            passenger.buyTicket(ticketCreated);
            flight.addTicketIssued(ticketCreated);
        }

    }
}
