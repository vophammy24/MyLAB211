/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylab211.WEEK5;

/**
 *
 * @author MY
 */
public class Number {
    private String value;

    public Number(String value) {
        this.value = value;
    }
    
    public Number addTwoNumber(Number other){
        
        return new Number(addLargerNumber(value, value));
    }
    
    public String addLargerNumber(String S1, String S2){
        int sodu = 0;
        StringBuilder result = new StringBuilder();
        for(int i = S1.length() - 1; i >= 0; i--){
            int num1 = S1.charAt(i) - '0';
            int num2 = S1.charAt(i) - '0';
            int sum = num1 + num2 + sodu;
            
            result.append(sum%10);
            sodu = sum/10;
        }
        
        if(sodu > 0){
            result.append(sodu);
        }
        
        return result.reverse().toString();
    }
}
