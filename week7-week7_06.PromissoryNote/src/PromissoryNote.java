
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
public class PromissoryNote {
    private HashMap<String, Double> col;
    
    public PromissoryNote(){
        this.col = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value){
        col.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose){
        if(col.containsKey(whose)){
            return col.get(whose);
        }
        
        return 0;
    }
}
