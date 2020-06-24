/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class MindfulDictionary {
    
    private Map<String, String> dic;
    private File f;
    
    public MindfulDictionary(){
        dic = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) throws IOException{
        f = new File(file);
        dic = new HashMap<String, String>();
    }
    
    public void add(String word, String translation){
        if(!dic.containsKey(word)){
            dic.put(word, translation);
            dic.put(translation, word);
        }
    }
    
    public String translate(String word){
        return dic.get(word);
    }
    
    public void remove(String word){
        String aux = translate(word);
        dic.remove(word);
        dic.remove(aux);
    }
    
    public boolean load(){
        Scanner reader;
        try {
            reader = new Scanner(f);
        } catch (FileNotFoundException ex) {
            return false;
        }
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String[] parts = line.split(":");
            add(parts[0], parts[1]);
        }
        
        return true;
    }
    
    public boolean save(){
        FileWriter writer;
        List<String> repeated = new ArrayList<String>();
        
        try{
            writer = new FileWriter(f);
        } catch (IOException ex) {
            return false;
        }
        
        for(String s : dic.keySet()){
            String translation = dic.get(s);
            if(!repeated.contains(s)){
                String toWrite = s + ":" + dic.get(s);
                try {
                    writer.write(toWrite + "\n");
                } catch (IOException ex) {
                    return false;
                }
                repeated.add(translation);
            }
        }
        
        try {
            writer.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
