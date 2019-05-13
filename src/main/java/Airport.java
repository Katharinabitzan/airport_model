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

    public Plane getPlaneFromHangar(String size){
        Hangar hangar =  hangars.get(0);
        Plane plane = hangar.getPlaneBySize(size);
    }

    public Flight createFlight(String flightNumber, AirportCode origin, AirportCode destination, DateTime departure, DateTime arrival) {
        return new Flight(flightNumber, origin, destination, departure, arrival);
    }

    public void assignPlane(Flight flight){
        String size = null;
        if (flight.getRegionOfOrigin() == flight.getRegionOfDestination() ){
            size = "Small";
        } else { size = "Medium"; }

        Plane plane = getPlaneFromHangar(size);
        flight.setPlane(plane);
    }

    public boolean flightFull(Flight flight) {
        return (flight.maxCapacity() <= flight.ticketsIssuedCount());
    }

    public double setTicketPrice(Flight flight) {
        return 100.0;
    }

    public Ticket createTicket(SeatCategory seatCategory, Flight flight) {
        double ticketPrice = setTicketPrice(flight);
        return new Ticket(ticketPrice, seatCategory, flight);
    }


    public void sellTicket(Flight flight, Passenger passenger, SeatCategory seatCategory) {
        double ticketPrice = setTicketPrice(flight);
        double upgradePrice = seatCategory.getCost();
        double totalPrice = ticketPrice + upgradePrice;
        if (!flightFull(flight) && !passenger.notEnoughBalance(totalPrice)) {
            Ticket ticketCreated = createTicket(seatCategory, flight);
            passenger.buyTicket(ticketCreated);
            flight.addTicketIssued(ticketCreated);
        }

    }
}
