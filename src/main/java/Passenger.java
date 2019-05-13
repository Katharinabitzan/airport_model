import java.util.ArrayList;

public class Passenger {
    private double balance;
    private ArrayList tickets;

    public Passenger(double balance){
        this.balance = balance;
        this.tickets = new ArrayList<Ticket>();
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList getTickets() {
        return tickets;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean notEnoughBalance(double ticketPrice) {
        return (this.balance < ticketPrice);
    }


    public void buyTicket(Ticket ticket) {
        this.tickets.add(ticket);
        this.balance -= ticket.getPrice();
    }

    public int ticketCount() {
        return tickets.size();
    }
}
