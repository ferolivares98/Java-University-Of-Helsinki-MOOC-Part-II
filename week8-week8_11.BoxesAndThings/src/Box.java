
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
public class Box implements ToBeStored{
    private double mWeight;
    private ArrayList<ToBeStored> list;
    
    public Box(double weight){
        this.mWeight = weight;
        this.list = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored ob){
        if(weight() + ob.weight() <= this.mWeight){
            list.add(ob);
        }
    }
    
    @Override
    public double weight() {
        double weight = 0;
        
        for(ToBeStored i : list){
            weight += i.weight();
        }
        
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: " + list.size() + " things, total weight " + weight() + " kg";
    }
    
}
