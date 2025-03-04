package mylab211.WEEK6;

import java.util.Scanner;

public class CMMain {
    public static void main(String[] args) {
        ContactManagement cm = new ContactManagement();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add a contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Delete a contact");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter Group: ");
                    String group = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    cm.addContact(firstName, lastName, group, address, phone);
                    break;
                case 2:
                    cm.displayAll();
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    cm.deleteContact(id);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
