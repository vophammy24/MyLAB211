package mylab211.WEEK5;

public class FlightInformation {
    String flightNumber;
    String seatNumber;
    int timePickUp;

    public FlightInformation(String flightNumber, String seatNumber, int timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }

    
    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = 0;
    }
}
