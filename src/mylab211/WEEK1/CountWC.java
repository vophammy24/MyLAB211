/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylab211.WEEK1;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;


public class CountWC {
    private String input;

    public CountWC(String input) {//điền đối số
        this.input = input;
    }
    
    public Map<String, Integer> countWord(){
        Map<String, Integer> countWord = new HashMap<>();
        String[] words = input.split("\\s+");
        for (String word : words ){
            countWord.put(word, countWord.getOrDefault(word, 0) + 1);
        }
        return countWord;
    } 
    
    public Map<Character, Integer> countCharacter(){
        Map<Character, Integer> countCharacter = new HashMap<>();
        for (char character : input.toCharArray()){
            if(Character.isLowerCase(character));
            countCharacter.put(character, countCharacter.getOrDefault(character, 0) + 1);
        }
        return countCharacter;
    } 
}
