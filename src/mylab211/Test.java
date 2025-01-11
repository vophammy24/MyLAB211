package mylab211;

import java.util.Map;
import java.util.Scanner;
import static mylab211.WEEK1.BaseConverter.convertBase;
import static mylab211.WEEK1.BaseConverter.getBaseChoice;
import mylab211.WEEK1.CountWC;
import mylab211.WEEK1.LinearSearch;

public class Test {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.println("Enter number of array:");
//        int n = scanner.nextInt();
//        
//        LinearSearch linearSearch = new LinearSearch(n);
//                
//        linearSearch.addValue();
//        linearSearch.showArray();
//        
//        System.out.println("Enter search value:");
//        int x = scanner.nextInt();
//        
//        int index = linearSearch.searchValue(x);
//        if (index == -1){
//            System.out.println("Not found " + x + " in array");
//        } else {
//            System.out.println("Found " + x + " at index: " + index );
//        }
//--------------------------------------------
//        System.out.println("Enter your content:");
//        String input = scanner.nextLine();
//        
//        CountWC countWC = new CountWC(input);    
//        
//        Map<String, Integer> wordCount = countWC.countWord();
//        System.out.println(wordCount);
//        Map<Character, Integer> charCount = countWC.countCharacter();
//        System.out.println(charCount);
//--------------------------------------
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Choose the input base system:");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Hexadecimal");
            int inputBase = getBaseChoice(scanner);

            System.out.println("Choose the output base system:");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Hexadecimal");
            int outputBase = getBaseChoice(scanner);

            System.out.println("Enter the input value:");
            String inputValue = scanner.next();

            try {
                String outputValue = convertBase(inputValue, inputBase, outputBase);
                System.out.println("Equivalent output value: " + outputValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input value for the selected base system.");
            }

            System.out.println("Do you want to convert another value? (yes/no)");
            String continueResponse = scanner.next().toLowerCase();
            continueProgram = continueResponse.equals("yes");
        }

        System.out.println("Program closed.");
        scanner.close();
    }
}
