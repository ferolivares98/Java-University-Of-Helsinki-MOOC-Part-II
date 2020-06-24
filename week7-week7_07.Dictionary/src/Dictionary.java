
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Dictionary {
    private HashMap<String, String> dic;
    
    public Dictionary(){
        this.dic = new HashMap<String, String>();
    }
    
    public String translate(String word){
        if(dic.containsKey(word)){
            return dic.get(word);
        }
        
        return null;
    }
    
    public void add(String word, String translation){
        if(!dic.containsKey(word)){
            dic.put(word, translation);
        }
    }
    
    public int amountOfWords(){
        return dic.size();
    }
    
    public ArrayList<String> translationList(){
        ArrayList<String> list = new ArrayList<String>();
        for(String k : dic.keySet()){
            list.add(k + " = " + dic.get(k));
        }
        return list;
    }
    
    
}
