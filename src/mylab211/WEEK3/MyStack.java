/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylab211.WEEK3;

public class MyStack {
    
    private int[] stackValues;
    private int lastIndex;
    private int capacity;

    public MyStack(int capacity) {
        this.stackValues = new int[capacity];
        this.lastIndex = -1;
        this.capacity = capacity;
    }
    
    
    public MyStack(){
        this(10);
    }
    
    boolean isEmpty(){
        return lastIndex == -1;
    }
    
    boolean isFull(){
        return lastIndex == capacity - 1;
    }
        
    public void push(int x){
        if (isFull()){
            System.out.println("Stack is full. Cannot push " + x);
        }
        stackValues[++lastIndex] = x;
        System.out.println("Pushed: " + x);
    }
    
    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty!");
        } int temp = stackValues[lastIndex--];
            System.out.println("Popped: " + temp);
            return temp;
    }
    
    public int get(int position){
        if (position < 0 || position > lastIndex ){
            System.out.println("Invalid position!");
        } else {
            System.out.println("Get " + stackValues[position] + " at: " + position);
        }
            return stackValues[position];
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= lastIndex; i++){
                System.out.print(stackValues[i] + " ");
            }
            System.out.println();
        }
    }
}
