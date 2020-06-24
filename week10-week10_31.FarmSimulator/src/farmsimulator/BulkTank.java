/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author fernando
 */
public class BulkTank {
    
    private double capacity, volume;
    
    public BulkTank(){
        this.capacity = 2000; //Standard.
        this.volume = 0;
    }
    
    public BulkTank(double capacity){
        this.capacity = capacity;
        this.volume = 0;
    }
    
    public double getCapacity(){
        return this.capacity;
    }
    
    public double getVolume(){
        return this.volume;
    }
    
    public double howMuchFreeSpace(){
        return capacity - volume;
    }
    
    public void addToTank(double amount){
        if((volume + amount) >= capacity){
            volume = capacity;
        }else{
            volume += amount;
        }
    }
    
    public double getFromTank(double amount){
        if((volume - amount) <= 0){
            volume = 0;
        }else{
            volume -= amount;
        }
        return volume;
    }
    
    @Override
    public String toString(){
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}
