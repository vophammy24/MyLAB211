/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylab211.WEEK2;

import java.util.Scanner;

public class CalculatorProgram {
    
    public enum Operator {
        
        ADD("+"), SUBTRACT("-"), MULTIPLY("*"),
        DIVIDE("/"), POWER("^"), EQUALS("=");
        
        private final String symbol;

        private Operator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
        
        public static Operator fromSymbol(String symbol){
            for (Operator op: values()){
                if (op.symbol.equals(symbol)){
                    return op;
                }
            }
            return null;
        }
    }
    
    public enum BmiStatus {
        UNDER_STANDARD, STANDARD, OVERWEIGHT, 
        FAT_SHOULD_LOSE_WEIGHT,
        VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY;    }
    
    public static class NormalCalculator {
        public double calculate(double a, Operator operator, double b) {
            try {
                switch (operator) {
                    case ADD: 
                            return a + b;
                    case SUBTRACT: 
                            return a - b;
                    case MULTIPLY: 
                            return a * b;
                    case DIVIDE: 
                        if (b == 0){
                            throw new ArithmeticException("Undefined");
                       }
                            return a / b;
                    case POWER: 
                            return Math.pow(a, b);
                    default: 
                        System.out.println("Invalid operator");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
                return a;
            } catch (NullPointerException e) {
                System.out.println("Error: Operator is null.");
                return a;
            }
            return 0;
        } 
    }
    
    public static class BMICalculator {
        public static BmiStatus calculateBMI(double weight, double height) {
            double bmi = weight / (height * height);
            if (bmi < 19) {
                return BmiStatus.UNDER_STANDARD;
            } else if (bmi <= 25) {
                return BmiStatus.STANDARD;
            } else if (bmi <= 30) {
                return BmiStatus.OVERWEIGHT;
            } else if (bmi <= 40) {
                return BmiStatus.FAT_SHOULD_LOSE_WEIGHT;
            } else {
                return BmiStatus.VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY;
            }
        }
    }
    
    public static class Menu {
        private static final Scanner scanner = new Scanner(System.in);

        public static int displayMenu() {
            System.out.println("===== Calculator Program =====");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");

            while (true) {
                try {
                    return Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            }
        }

        public static void doCalculate() {
            NormalCalculator normalCalculator = new NormalCalculator();
            double memory = 0;

            System.out.print("Input first number: ");
            Double number = checkNumber();
            if (number == null) return;

            memory = number;

            while (true) {
                System.out.print("Input operator (+, -, *, /, ^, =): ");
                Operator operator = checkOperator();
                if (operator == null) continue;

                if (operator == Operator.EQUALS) {
                    System.out.println("Final Result: " + memory);
                    return;
                }

                System.out.print("Input next number: ");
                Double nextNumber = checkNumber();
                if (nextNumber == null) continue;

                memory = normalCalculator.calculate(memory, operator, nextNumber);
                System.out.println("Memory: " + memory);
            }
        }

        public static void doBMI() {
            System.out.print("Enter weight (kg): ");
            Double weight = checkNumber();
            if (weight == null) return;

            System.out.print("Enter height (cm): ");
            Double height = checkNumber();
            if (height == null) return;

            height /= 100; // Convert height to meters

            BmiStatus status = BMICalculator.calculateBMI(weight, height);
            System.out.println("BMI Status: " + status);
        }

        public static Double checkNumber() {
            while (true) {
                try {
                    return Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                }
            }
        }

        public static Operator checkOperator() {
            while (true) {
                String operatorInput = scanner.nextLine();
                Operator operator = Operator.fromSymbol(operatorInput);
                if (operator != null) {
                    return operator;
                } else {
                    System.out.println("Invalid operator. Please enter one of +, -, *, /, ^, =.");
                }
            }
        }

        public static void main(String[] args) {
            while (true) {
                int choice = displayMenu();

                switch (choice) {
                    case 1:
                        doCalculate();
                        break;
                    case 2:
                        doBMI();
                        break;
                    case 3:
                        System.out.println("Exiting program. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                }
            }
        }
    }
}