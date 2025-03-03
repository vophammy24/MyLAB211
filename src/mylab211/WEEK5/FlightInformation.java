package mylab211.WEEK5;

import java.time.LocalDateTime;

public class FlightInformation {
    String flightNumber;
    String seatNumber;
    LocalDateTime timePickUp;

    public FlightInformation(String flightNumber, String seatNumber, LocalDateTime timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }

    
    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = LocalDateTime.now();
    }

    public LocalDateTime getTimePickUp() {
        return timePickUp;
    }

    @Override
    public String toString() {
        return "Flight: " + flightNumber + " | Seat: " + seatNumber + " | Pick-up Time:" + timePickUp;
    }
    
    
}
