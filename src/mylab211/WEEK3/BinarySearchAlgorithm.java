package mylab211.WEEK3;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchAlgorithm {
    private int[] array;
    private int searchValue;

    public BinarySearchAlgorithm(int n, int x) {
        this.array = new int[n];
        this.searchValue = x;
    }
    
    public void addValues(){
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(array.length);
        }
    }
    
    public void showValues(){
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if (i < array.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public void sortValues(){
        boolean check = false;
        for (int i = 0; i < array.length - 1 && !check; i++){
            check = true;
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;    
                    check = false;
                }
            }
        }
    }
    
    public int binarySearch(){
        int low = 0;
        int high = array.length - 1;
        
        while (low <= high){
            int midPosition = (low + high) / 2;
            int midValue = array[midPosition];
            
            if (searchValue == midValue){
                return midPosition;
            } if (searchValue < midValue){
                high = midPosition - 1;
            } else {
                low = midPosition + 1;
            }
        }
        return -1;
    }

    
}
