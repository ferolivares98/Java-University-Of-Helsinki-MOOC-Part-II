
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
public class Container {
    private int maxWeightLimit;
    private ArrayList<Suitcase> sc;
    
    public Container(int mWeLi){
        this.sc = new ArrayList<Suitcase>();
        this.maxWeightLimit = mWeLi;
    }
    
    public int totalWeight(){
        int total = 0;
        for(Suitcase s : sc){
            total += s.totalWeight();
        }
        
        return total;
    }
    
    public void addSuitcase(Suitcase suitcase){
        int total = totalWeight();
        
        if(total + suitcase.totalWeight() <= maxWeightLimit){
            sc.add(suitcase);
        }
    }
    
    public void printThings(){
        for(Suitcase s : sc){
            s.printThings();
        }
    }
    
    public String toString(){
        return sc.size() + " suitcases (" + totalWeight() + " kg)";
    }
}
