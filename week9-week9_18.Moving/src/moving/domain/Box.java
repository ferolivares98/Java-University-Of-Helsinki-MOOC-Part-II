/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando
 */
public class Box implements Thing{
    private int maximumCapacity;
    private List<Thing> box;
    
    public Box(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
        this.box = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing){
        if(this.getVolume() + thing.getVolume() > maximumCapacity){
            return false;
        }
        box.add(thing);
        return true;
    }

    @Override
    public int getVolume() {
        int totalVolume =0;
        for(Thing t: box){
            totalVolume += t.getVolume();
        }
        return totalVolume;
    }
}
