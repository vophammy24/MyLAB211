package mylab211.WEEK5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RMMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationManagement manager = new ReservationManagement();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Reservation");
            System.out.println("2. View All Reservations");
            System.out.println("3. Search Reservation");
            System.out.println("4. Update Reservation");
            System.out.println("5. Delete Reservation");
            System.out.println("6. View Reservations by Pickup Time");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addReservation(scanner, manager);
                    break;
                case 2:
                    viewReservations(manager);
                    break;
                case 3:
                    searchReservation(scanner, manager);
                    break;
                case 4:
                    updateReservation(scanner, manager);
                    break;
                case 5:
                    deleteReservation(scanner, manager);
                    break;
                case 6:
                    viewReservationsByPickup(manager);
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 7.");
            }
        }
    }

    private static void addReservation(Scanner scanner, ReservationManagement manager) {
        System.out.print("Enter Booking ID (6 digits): ");
        String bookingID = scanner.nextLine();
        if (!bookingID.matches("\\d{6}")) {
            System.out.println("Invalid ID! Must be 6 digits.");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        if (!customerName.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid Name! Only alphabets and spaces allowed.");
            return;
        }

        System.out.print("Enter Phone Number (12 digits): ");
        String phoneNumber = scanner.nextLine();
        if (!phoneNumber.matches("\\d{12}")) {
            System.out.println("Invalid Phone Number! Must be 12 digits.");
            return;
        }

        System.out.print("Enter Room Number (4 digits): ");
        String roomNumber = scanner.nextLine();
        if (!roomNumber.matches("\\d{4}")) {
            System.out.println("Invalid Room Number! Must be 4 digits.");
            return;
        }

        System.out.print("Enter Booking Date (YYYY-MM-DD): ");
        LocalDateTime bookingDate = LocalDateTime.parse(scanner.nextLine().trim());
        if (bookingDate.isBefore(LocalDateTime.now())) {
            System.out.println("Booking Date must be in the future!");
            return;
        }

        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter Seat Number: ");
        String seatNumber = scanner.nextLine();
        System.out.print("Enter Pickup Date (YYYY-MM-DD): ");
        LocalDateTime timePickUp = LocalDateTime.parse(scanner.nextLine().trim());
        if (timePickUp.isBefore(LocalDateTime.now()) || timePickUp.isAfter(bookingDate)) {
            System.out.println("Invalid Pickup Date! Must be after today and before booking date.");
            return;
        }

        FlightInformation flightInfo = new FlightInformation(flightNumber, seatNumber, timePickUp);
        Reservation reservation = new Reservation(bookingID, customerName, phoneNumber, roomNumber, bookingDate, flightInfo);
        if (manager.addReservation(reservation)) {
            System.out.println("Reservation added successfully!");
        } else {
            System.out.println("Booking ID must be unique!");
        }
    }

    private static void viewReservations(ReservationManagement manager) {
        List<Reservation> reservations = manager.getReservation();
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation res : reservations) {
                System.out.println(res);
            }
        }
    }

    private static void searchReservation(Scanner scanner, ReservationManagement manager) {
        System.out.print("Enter Booking ID to search: ");
        String bookingID = scanner.nextLine();
        Reservation res = manager.searchReservation(bookingID);
        if (res != null) {
            System.out.println("Reservation Found:\n" + res);
        } else {
            System.out.println("No reservation found with ID: " + bookingID);
        }
    }

    private static void updateReservation(Scanner scanner, ReservationManagement manager) {
        System.out.print("Enter Booking ID to update: ");
        String bookingID = scanner.nextLine();
        Reservation existingReservation = manager.searchReservation(bookingID);
        if (existingReservation == null) {
            System.out.println("No reservation found with ID: " + bookingID);
            return;
        }

        System.out.println("Enter new details (leave blank to keep current value):");

        System.out.print("Enter Customer Name (" + existingReservation.getBookingID() + "): ");
        String customerName = scanner.nextLine();
        if (customerName.isEmpty()) customerName = existingReservation.getBookingID();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.isEmpty()) phoneNumber = existingReservation.getBookingID();

        System.out.print("Enter Room Number: ");
        String roomNumber = scanner.nextLine();
        if (roomNumber.isEmpty()) roomNumber = existingReservation.getBookingID();

        System.out.print("Enter Booking Date (YYYY-MM-DD): ");
        LocalDateTime bookingDate = LocalDateTime.parse(scanner.nextLine().trim());
        if (bookingDate.isBefore(LocalDateTime.now())) {
            System.out.println("Booking Date must be in the future!");
            return;
        }

        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter Seat Number: ");
        String seatNumber = scanner.nextLine();
        System.out.print("Enter Pickup Date (YYYY-MM-DD): ");
        LocalDateTime timePickUp = LocalDateTime.parse(scanner.nextLine().trim());
        if (timePickUp.isBefore(LocalDateTime.now()) || timePickUp.isAfter(bookingDate)) {
            System.out.println("Invalid Pickup Date!");
            return;
        }

        FlightInformation flightInfo = new FlightInformation(flightNumber, seatNumber, timePickUp);
        Reservation updatedReservation = new Reservation(bookingID, customerName, phoneNumber, roomNumber, bookingDate, flightInfo);

        if (manager.updateReservation(bookingID, seatNumber, phoneNumber, roomNumber, bookingDate, flightInfo, updatedReservation)) {
            System.out.println("Reservation updated successfully!");
        } else {
            System.out.println("Failed to update reservation.");
        }
    }

    private static void deleteReservation(Scanner scanner, ReservationManagement manager) {
        System.out.print("Enter Booking ID to delete: ");
        String bookingID = scanner.nextLine();
        if (manager.deleteReservation(bookingID)) {
            System.out.println("Reservation deleted successfully!");
        } else {
            System.out.println("No reservation found with ID: " + bookingID);
        }
    }

    private static void viewReservationsByPickup(ReservationManagement manager) {
        List<Reservation> reservations = manager.getReservationByPickUp();
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation res : reservations) {
                System.out.println(res);
            }
        }
    }
}
