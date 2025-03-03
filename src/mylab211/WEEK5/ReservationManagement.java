package mylab211.WEEK5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReservationManagement {
    List<Reservation> reservations = new ArrayList<>();
    
    public boolean addReservation(Reservation reservation){
        for(Reservation re: reservations){
            if(re.getBookingID().equals(reservation.getBookingID())){
                return false;
            }
        }
        reservations.add(reservation);
        return true;
    }
    
    public Reservation searchReservation(String bookingID){
        for(Reservation re: reservations){
            if(re.getBookingID().equals(bookingID))
                return re;
        }
        return null;
    }
    
    public boolean updateReservation(String bookingID, String newCusName,
            String newPhoneNumber, String newRoomNumber, LocalDateTime newBookingDate,
            FlightInformation newFlightInfo, Reservation reservation){
        for(Reservation re: reservations){
            if(re.getBookingID().equals(bookingID)){
                re.setCustomerName(newCusName);
                re.setPhoneNumber(newPhoneNumber);
                re.setRoomNumber(newRoomNumber);
                re.setBookingDate(newBookingDate);
                re.setFlightInformation(newFlightInfo);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteReservation(String bookingID){
        for(Reservation re: reservations){
            if(re.getBookingID().equals(bookingID)){
                reservations.remove(re);
                return true; 
            }
        } 
        return false;
    }
    
    public List<Reservation> getReservation(){
        return reservations;
    }
    
    public List<Reservation> getReservationByPickUp(){
        List<Reservation> sortedList = new ArrayList<>(reservations);
        sortedList.sort(Comparator.comparing(Reservation :: getTimePickup));
        return sortedList;
    }
}
