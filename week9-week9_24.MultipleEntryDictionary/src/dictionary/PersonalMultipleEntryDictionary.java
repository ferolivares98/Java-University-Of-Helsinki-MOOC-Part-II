/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author fernando
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary{
    private Map<String, Set<String>> dic;
    
    public PersonalMultipleEntryDictionary(){
        dic = new HashMap<String, Set<String>>();
    }

    @Override
    public void add(String word, String entry) {
        if(!dic.containsKey(word)){
            dic.put(word, new HashSet<String>());
        }
        
        dic.get(word).add(entry);
        
        /*Set<String> translations = dictionary.get(word);

        if (translations == null) {

            translations = new HashSet<String>();

            dictionary.put(word, translations);

        }

        translations.add(entry); Igual a lo que hecho pero comprobando el HashSet en lugar de la palabra.*/
    }

    @Override
    public Set<String> translate(String word) {
        Set<String> meanings = new HashSet<String>();
        
        if(dic.containsKey(word)){
            meanings = dic.get(word);
        }else{
            return null;
        }
        
        //Sería tan fácil como return dictionary.get(word);
        
        return meanings;
    }

    @Override
    public void remove(String word) {
        if(dic.containsKey(word)){
            dic.remove(word);
        }
    }
    
}
