package mylab211.WEEK5;

import java.time.LocalDateTime;

public class Reservation {
    String bookingID;
    String customerName;
    String phoneNumber;
    String roomNumber;
    LocalDateTime bookingDate;
    FlightInformation flightInformation;

    public Reservation(String bookingID, String customerName, String phoneNumber,
                String roomNumber, LocalDateTime bookingDate, FlightInformation flightInformation) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.flightInformation = flightInformation;
    }

    public String getBookingID() {
        return bookingID;
    }

    public LocalDateTime getTimePickup(){
        return flightInformation.getTimePickUp();
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }
    
    

    @Override
    public String toString() {
        return "BookingID: " + bookingID + " | Customer Name: " + customerName + " | Phone Number: " + phoneNumber 
                + " | Room Number: " + roomNumber + " | Booking Date: " + bookingDate 
                + " | Flight Information: " + flightInformation;
    }
}
