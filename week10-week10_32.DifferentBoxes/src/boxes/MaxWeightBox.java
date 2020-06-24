/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando
 */
public class MaxWeightBox extends Box{
    
    private int maxWeight;
    private List<Thing> list;
    
    public MaxWeightBox(int maxWeight){
        this.maxWeight = maxWeight;
        list = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        int totalWeight = 0;
        for (Thing t : this.list) {
            totalWeight += t.getWeight();
        }
        if (totalWeight + thing.getWeight() <= this.maxWeight) {
            this.list.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return list.contains(thing);
    }
    
}
