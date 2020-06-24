/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author fernando
 */
public class Item implements Thing, Comparable<Item>{
    private String item;
    private int volume;
    
    public Item(String item, int volume){
        this.item = item;
        this.volume = volume;
    }
    
    public String getName(){
        return this.item;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }
    
    @Override
    public String toString(){
        return this.item + " (" + this.volume + " dm^3)";
    }

    @Override
    public int compareTo(Item t) {
        return this.getVolume() - t.getVolume();
    }
    
    
}
