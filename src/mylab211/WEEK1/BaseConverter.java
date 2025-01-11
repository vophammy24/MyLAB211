/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylab211.WEEK1;

import java.util.Scanner;

/**
 *
 * @author MY
 */
public class BaseConverter {
    public static int getBaseChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.next());
                if (choice < 1 || choice > 3) {
                    throw new NumberFormatException();
                }
                return (choice == 1) ? 2 : (choice == 2) ? 10 : 16;
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    public static String convertBase(String value, int inputBase, int outputBase) {
        int decimalValue = Integer.parseInt(value, inputBase);
        return Integer.toString(decimalValue, outputBase).toUpperCase();
    }
}
