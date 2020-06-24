
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start(){
        
        System.out.println("Statement: ");
        System.out.println("    add - adds a word pair to the dictionary");
        System.out.println("    translate - asks a word and prints its translation");
        System.out.println("    quit - quits the text user interface");
        System.out.println("");
        
        while(true){
            System.out.println("Statement: ");
            String st = reader.nextLine();
            st = stringCleaner(st);
            
            if(st.equals("quit")){
                System.out.println("Cheers!");
                break;
            }else if(st.equals("add")){
                add();
            }else if(st.equals("translate")){
                translate();
            }else{
                System.out.println("Unknown statement");
            }
            
            System.out.println("");
        }

    }
    
    public String stringCleaner(String st){
        if(st == null){
            return null;
        }
        
        return st.toLowerCase().trim();
    }
    
    public void add(){
        System.out.print("In finnish: ");
        String k = reader.nextLine();
        System.out.print("Translation: ");
        String v = reader.nextLine();
        
        dictionary.add(k, v);
    }
    
    public void translate(){
        System.out.print("Give a word: ");
        String k = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(k));
    }
}
