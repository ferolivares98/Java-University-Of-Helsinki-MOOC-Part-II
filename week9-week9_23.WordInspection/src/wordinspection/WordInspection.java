/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fernando
 */
public class WordInspection {
    
    private List<String> words;
    private Scanner tdst;
    
    public WordInspection(File file) throws FileNotFoundException{
        words = new ArrayList<String>();
        tdst = new Scanner(file);
        
        while(tdst.hasNext()){
            words.add(tdst.next());
        }
    }
    
    public int wordCount(){
        return words.size();
    }
    
    public List<String> wordsContainingZ(){
        List<String> wordsWithZ = new ArrayList<String>();
        
        for(String s : words){
            if(s.contains("z")){
                wordsWithZ.add(s);
            }
        }
        return wordsWithZ;
    }
    
    public List<String> wordsEndingInL(){
        List<String> wordsEndingL = new ArrayList<String>();
        
        for(String s : words){
            if(s.endsWith("l")){
                wordsEndingL.add(s);
            }
        }
        return wordsEndingL;
    }
    
    public List<String> palindromes(){
        List<String> palindromes = new ArrayList<String>();
        
        for(String s : words){
            String inverted = "";
            for(int i = s.length()-1; i >= 0; i--){
                inverted += s.charAt(i);
            }
            if(inverted.equals(s)){
                palindromes.add(s);
            }
        }
        return palindromes;
    }
    
    /*    private String reverse(String str) {

        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString();

    }*/
    
    public List<String> wordsWhichContainAllVowels(){
        List<String> WWCAV = new ArrayList<String>();
        
        for(String s : words){
            if(cAll(s)){
                WWCAV.add(s);
            }
        }
        return WWCAV;
    }
    
    private boolean cAll(String s){
        String vowels = "aeiouyäö";
        
        for(int i = 0; i < vowels.length(); i++){
            if(!s.contains("" + vowels.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    /*    private boolean containsAllVowels(String word) {

        for (char vowel: this.vowels.toCharArray()) {

            if (!word.contains("" + vowel)) {

                return false;

            }

        }

        return true;

    }*/
}
