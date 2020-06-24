/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Airplane {
    private String airplaneID;
    private int capacity;
    
    public Airplane(String airplaneID, int capacity){
        this.airplaneID = airplaneID;
        this.capacity = capacity;
    }

    public String getAirplaneID() {
        return airplaneID;
    }
    
    public String toString(){
        return airplaneID + " (" + capacity + " ppl)";
    }
}
