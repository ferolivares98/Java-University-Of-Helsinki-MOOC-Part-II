/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author fernando
 */
public class OneThingBox extends Box{
    
    private Thing uniqueThing;

    public OneThingBox(){

    }
    
    @Override
    public void add(Thing thing) {
        if(uniqueThing == null){
            uniqueThing = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return uniqueThing != null && uniqueThing.equals(thing);
    }
    
}
