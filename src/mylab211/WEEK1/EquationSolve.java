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
public class EquationSolve {
    
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("========== Equation Program ==========");
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.print("Please choice one option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    EquationSolver.calculateEquation(scanner);
                    break;
                case 2:
                    EquationSolver.calculateQuadraticEquation(scanner);
                    break;
                case 3:
                    System.out.println("Exit.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public class EquationSolver {
        public static void calculateEquation(Scanner scanner) {
            System.out.println("----- Calculate Equation -----");
            System.out.print("Enter A: ");
            float a = validateInput(scanner);
            System.out.print("Enter B: ");
            float b = validateInput(scanner);

            if (a == 0) {
                System.out.println("A cannot be 0");
                return;
            }

            float x = -b / a;
            System.out.println("Solution: x = " + x);
            displayNumberProperties(a, b);
        }

        public static void calculateQuadraticEquation(Scanner scanner) {
            System.out.println("----- Calculate Quadratic Equation -----");
            System.out.print("Enter A: ");
            float a = validateInput(scanner);
            System.out.print("Enter B: ");
            float b = validateInput(scanner);
            System.out.print("Enter C: ");
            float c = validateInput(scanner);

            if (a == 0) {
                System.out.println("A cannot be 0");
                calculateEquation(scanner);
                return;
            }

            float discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                float x1 = (-b + (float) Math.sqrt(discriminant)) / (2 * a);
                float x2 = (-b - (float) Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
            } else if (discriminant == 0) {
                float x = -b / (2 * a);
                System.out.println("Solution: x = " + x);
            } else {
                System.out.println("No real solution.");
            }
            displayNumberProperties(a, b, c);
        }

        public static float validateInput(Scanner scanner) {
            while (true) {
                try {
                    return scanner.nextFloat();
                } catch (Exception e) {
                    System.out.print("Please input number ");
                    scanner.next();
                }
            }
        }

        public static void displayNumberProperties(float... numbers) {
            System.out.print("Number is Odd: ");
            for (float number : numbers) {
                if (number % 2 != 0) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

            System.out.print("Number is Even: ");
            for (float number : numbers) {
                if (number % 2 == 0) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

            System.out.print("Number is Perfect Square: ");
            for (float number : numbers) {
                if (isPerfectSquare(number)) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();
        }

        public static boolean isPerfectSquare(float number) {
            if (number < 0) return false;
            int sqrt = (int) Math.sqrt(number);
            return sqrt * sqrt == number;
        }
    }
}
