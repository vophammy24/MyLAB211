/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

import Utilizer.Utilizer;
import java.util.Scanner;
import mylab211.WEEK4.StudentManagement;

/**
 *
 * @author MY
 */
public class TestW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("---- Menu ----");
            System.out.println("1. Student Management.");
            System.out.println("2. Student and Teacher Information.");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                        StudentManagement sm = new StudentManagement();
                        sm.display();
                        break;
                case 2:   
                        
                        break;
                case 3:
                        System.out.println("Exiting the program.");
                        sc.close();
                        return;
                default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                } 
            System.out.println(" ");
        }
    }
}
