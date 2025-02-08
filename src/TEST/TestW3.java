package TEST;

import Utilizer.Utilizer;
import java.util.Scanner;
import mylab211.WEEK3.BinarySearchAlgorithm;
import mylab211.WEEK3.BubbleSort;
import mylab211.WEEK3.MyStack;
import mylab211.WEEK3.QuickSort;

public class TestW3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("---- Menu ----");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Binary Search Algorithm");
            System.out.println("4. Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                        int input = Utilizer.checkNumber1();
                        BubbleSort bbs = new BubbleSort(input);
                        bbs.addValues();
                        bbs.showValues();
                        bbs.sortValues();
                        bbs.showValues();
                        break;
                case 2:   
                        input = Utilizer.checkNumber2();
                        QuickSort qs = new QuickSort(input);
                        qs.addValues();
                        System.out.print("Unsorted array: ");
                        qs.showValues();
                        qs.quickSort(qs.getArray(), 0, input - 1);
                        System.out.print("Sorted array: ");
                        qs.showValues();
                        break;
                case 3:
                        input = Utilizer.checkNumber2();
                        int searchValue = Utilizer.checkPositiveNumber();
                        BinarySearchAlgorithm bSearch = new BinarySearchAlgorithm(input, searchValue);
                        bSearch.addValues();

                        System.out.print("Sorted Array: ");
                        bSearch.sortValues();
                        bSearch.showValues();

                        int index = bSearch.binarySearch();
                        if (index != -1) {
                            System.out.println("Found " + searchValue+ " at index: " + index);
                        } else {
                            System.out.println("Number " + searchValue+ " not found in the array.");
                        }
                        break;
                case 4:
                        MyStack stack = new MyStack(10);
                        stack.push(10);
                        stack.push(11);
                        stack.push(9);
                        stack.display();

                        stack.pop();
                        stack.display();

                        stack.get(1);
                        stack.display();
                        break;
                case 5: 
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