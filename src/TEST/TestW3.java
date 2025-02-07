package TEST;

import Utilizer.Utilizer;
import java.util.Scanner;
import mylab211.WEEK3.BinarySearchAlgorithm;
import mylab211.WEEK3.BubbleSort;
import mylab211.WEEK3.QuickSort;

public class TestW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Utilizer.checkNumber2();
        int searchValue = Utilizer.checkPositiveNumber();
//        BubbleSort bbs = new BubbleSort(input);
//        bbs.addValues();
//        bbs.showValues();
//        bbs.sortValues();
//        bbs.showValues();
        
//        QuickSort qs = new QuickSort(input);
//        qs.addValues();
//        System.out.print("Unsorted array: ");
//        qs.showValues();
//        qs.quickSort(qs.getArray(), 0, input - 1);
//        System.out.print("Sorted array: ");
//        qs.showValues();

        BinarySearchAlgorithm bSearch = new BinarySearchAlgorithm(input, searchValue);
        bSearch.addValues();
        
        System.out.print("Sorted Array: ");
        bSearch.sortArray();
        bSearch.showValues();
        
        int index = bSearch.binarySearch();
        if (index != -1) {
            System.out.println("Found " + searchValue+ " at index: " + index);
        } else {
            System.out.println("Number " + searchValue+ " not found in the array.");
        }
    }
}