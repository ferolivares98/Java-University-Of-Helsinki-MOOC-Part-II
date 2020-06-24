
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Changer {
    private ArrayList<Change> list;
    
    
    public Changer(){
        list = new ArrayList<Change>();
    }
    
    public void addChange(Change change){
        list.add(change);
    }
    
    public String change(String characterString){
        
        for(Change g : list){
            characterString = g.change(characterString);
        }
        
        return characterString;
    }
}
