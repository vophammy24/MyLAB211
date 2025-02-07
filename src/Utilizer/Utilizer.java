package Utilizer;

import java.util.Scanner;

public class Utilizer {
    public static int checkNumber1(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{              
                System.out.println("Enter a number: ");
                int input = Integer.parseInt(sc.nextLine());
                if (input < 2){ 
                    throw new IllegalArgumentException("Enter a number more than 2.");
                }
                return input;
            } catch (Exception e){
                System.out.println("Error. Please try again!");
            } 
        }
    }
    
    public static int checkNumber2(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println("Enter number of array: ");
                int input = Integer.parseInt(sc.nextLine());
                if (input < 2){
                    throw new IllegalArgumentException("Enter a number more than 2.");
                }
                return input;
            } catch (Exception e){
                System.out.println("Error. Please try again!");
            } 
        }
    }
    
    public static int checkPositiveNumber(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                System.out.println("Enter search value: ");
                int searchValue = Integer.parseInt(sc.nextLine());
                if (searchValue <= 0){
                    throw new IllegalArgumentException("Enter a positive number.");
                }
                return searchValue;
            } catch (Exception e){
                System.out.println("Error. Please try again!");
            }
        }
    }
}
