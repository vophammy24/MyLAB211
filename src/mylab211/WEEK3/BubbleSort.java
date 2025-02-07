package mylab211.WEEK3;

import java.util.Random;

public class BubbleSort {
    
    private int[] array;

    public BubbleSort(int n) {
        this.array = new int[n];
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
    
}
