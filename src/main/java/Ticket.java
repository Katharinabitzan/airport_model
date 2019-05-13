import java.util.ArrayList;
import java.util.HashMap;

public class Ticket {

    private double price;
    private SeatCategory seatCategory;
    private Flight flight;
    private ArrayList<Passenger> passengersOnTicket;

    public Ticket(double price, SeatCategory seatCategory, Flight flight) {
        this.price = price + seatCategory.getCost();
        this.seatCategory = seatCategory;
        this.flight = flight;
        this.passengersOnTicket = new ArrayList<>();
    }

    public double getPrice() {
        return price;
    }

    public SeatCategory getSeatcategory() {
        return seatCategory;
    }

    public Flight getFlight() {
        return flight;
    }

    public ArrayList getPassengersOnTicket() {
        return passengersOnTicket;
    }
}
