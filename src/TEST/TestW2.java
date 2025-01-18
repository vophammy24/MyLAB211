/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

import java.util.Scanner;
import mylab211.WEEK2.CalculatorProgram;
import mylab211.WEEK2.CalculatorShapeProgram;
import mylab211.WEEK2.Matrix;

/**
 *
 * @author MY
 */
public class TestW2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.println("---- Menu ----");
            System.out.println("1. Calculator Program");
            System.out.println("2. Calculator Shape Program");
            System.out.println("3. Matrix");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    CalculatorProgram.Menu.main(null);
                        break;
                case 2:   
                    CalculatorShapeProgram.main(null);
                        break;
                case 3:
                    Matrix.main(null);
                        break;
                case 4: 
                        System.out.println("Exiting the Program.");
                        scanner.close();
                        return;
                default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); 
                }
        }
    }
}
