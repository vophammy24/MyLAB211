package mylab211.WEEK3;

import java.util.Random;

public class QuickSort {
    
    private int[] array;

    public QuickSort(int n) {
        this.array = new int[n];
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
    
    public int[] getArray(){
        return array;// getter để lấy array ra ngoài class
    }
        
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
    
    public void quickSort(int[] array, int lowIndex, int highIndex){
        
        if (lowIndex >= highIndex){
            return;
        }
        
        int pivot = array[highIndex];//chọn pivot là phần tử cuối
        
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;
     
        while (leftPointer <= rightPointer){
            
            while (array[leftPointer] < pivot && leftPointer <= rightPointer){
                leftPointer++;
            }
            
            while (array[rightPointer] > pivot && leftPointer <= rightPointer){
                rightPointer--;
            }
            
            if (leftPointer <= rightPointer) {
                swap(array, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }       
        }
        
        swap(array, leftPointer, highIndex);
        
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }
    public void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
