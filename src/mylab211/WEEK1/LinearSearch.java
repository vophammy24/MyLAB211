
package mylab211.WEEK1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinearSearch {
    
    private int[] array;
    
    //constructor, khởi tạo thuộc tính, noi chay dau tien
    public LinearSearch(int n) {
        this.array = new int[n]; //khởi tạo kích thước của array với n phần tử
    }
    
    //add value to array
    public void addValue(){
        Random random = new Random();
       
        for(int i = 0; i < array.length; i++){ // đưa tùng giá trị random vào array
            array[i] = random.nextInt(array.length);
        }
    }
    
    //in ra array
    public void showArray(){
        System.out.print("The array: [");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
           
        }
        System.out.println("]");
    }
    
    public int searchValue(int x){
        for(int i = 0; i < array.length; i++){
            if(array[i] == x){
                return i;
            }
        }return -1;
    }
}
