package mylab211;

import java.util.Map;
import java.util.Scanner;
import mylab211.WEEK1.BaseConvert;
import mylab211.WEEK1.CountWC;
import mylab211.WEEK1.EquationSolve;
import mylab211.WEEK1.LinearSearch;

public class Test {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("---- Menu ----");
            System.out.println("1. LinearSearch");
            System.out.println("2. CountWC");
            System.out.println("3. BaseConvert");
            System.out.println("4. EquationSolve");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                        System.out.println("Enter number of array:");
                        int n = scanner.nextInt();

                        LinearSearch linearSearch = new LinearSearch(n);

                        linearSearch.addValue();
                        linearSearch.showArray();

                        System.out.println("Enter search value:");
                        int x = scanner.nextInt();

                        int index = linearSearch.searchValue(x);
                        if (index == -1){
                            System.out.println("Not found " + x + " in array");
                        } else {
                            System.out.println("Found " + x + " at index: " + index );
                        }
                        break;
                case 2:   
                        System.out.println("Enter your content:");
                        String input = scanner.nextLine();

                        CountWC countWC = new CountWC(input);    

                        Map<String, Integer> wordCount = countWC.countWord();
                        System.out.println("Word Count: " + wordCount);
                        Map<Character, Integer> charCount = countWC.countCharacter();
                        System.out.println("Character Count: " + charCount);
                        break;
                case 3:
                        BaseConvert.showMenu();
                        break;
                case 4:
                        EquationSolve.displayMenu();
                        break;
                case 5: 
                        System.out.println("Exiting the program.");
                        scanner.close();
                        return;
                default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
        }
    }
}