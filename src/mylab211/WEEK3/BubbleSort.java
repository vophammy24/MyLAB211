package mylab211.WEEK3;

import java.util.Random;

public class BubbleSort {
    
    private int[] array;

    public BubbleSort(int n) {
        this.array = new int[n];
    }

    public int[] getArray() {
        return array;
    }
      
    public void addValues(){
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(array.length);
        }
    }
    
    public void showValues(){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }
    public void sortValues(){
        int count = 0;
        boolean check = false;
        for (int i = 0; i < array.length - 1 && !check; i++){
            check = true;
            for (int j = 0; j < array.length - 1; j++){
                count++;
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;    
                    check = false;
                }
            }
        }
        System.out.println("Count: " + count);
    }
    
    public int partition(int[] array, int left, int right){
        int i = left;
        int j = right;
        
        int pivot = array[ (left + right) / 2];
        
        while (i <= j){
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
    
    public void quickSort(int[] array, int left, int right){
        int i = partition(array, left, right);
        
        if(i < right) quickSort(array, i, right);
        if(left < i - 1) quickSort(array, left, i - 1);
    }
    
    public int findBinary(int[] array, int value){
        int left = 0; int right = array.length - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (array[middle] == value) return middle;
            if (array[middle] < value) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
    
}
