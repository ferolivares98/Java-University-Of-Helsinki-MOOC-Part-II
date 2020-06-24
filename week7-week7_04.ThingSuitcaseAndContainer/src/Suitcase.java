
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
public class Suitcase {
    private ArrayList<Thing> list;
    private int maxWeight;
    
    public Suitcase(int maxWeight){
        this.list= new ArrayList<Thing>();
        this.maxWeight = maxWeight;
    }
    
    public int totalWeight(){
        int total = 0;
        for(Thing t : list){
            total += t.getWeight();
        }
        
        return total;
    }
    
    public void addThing(Thing thing){
        int total = totalWeight();
        
        if(total + thing.getWeight() <= maxWeight){
            list.add(thing);
        }
    }
    
    public void printThings(){
        for(Thing t : list){
            System.out.println(t.toString());
        }
    }
    
    public Thing heaviestThing(){
        if(list.isEmpty()){
            return null;
        }else{
            Thing maxThing = list.get(0);
            
            for(Thing t : list){
                if(t.getWeight() > maxThing.getWeight()){
                    maxThing = t;
                }
            }
            return maxThing;
        }
    }
    
    public String toString(){
        if(list.isEmpty()){
            return "empty (0 kg)";
        }else if(list.size() == 1){
            return "1 thing (" + totalWeight() + " kg)";
        }else
            return list.size() + " things (" + totalWeight() + " kg)";
    }
}
