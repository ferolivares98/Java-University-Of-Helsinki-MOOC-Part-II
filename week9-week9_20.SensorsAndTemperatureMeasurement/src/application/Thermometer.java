/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author fernando
 */
public class Thermometer implements Sensor{
    private boolean state;
    
    public Thermometer(){
        state = false;
    }

    @Override
    public boolean isOn() {
        return state;
    }

    @Override
    public void on() {
        state = true;
    }

    @Override
    public void off() {
        state = false;
    }

    @Override
    public int measure() {
        Random r = new Random();
        
        if(this.isOn()){
            return r.nextInt(61) - 30;
        }else{
            throw new IllegalArgumentException();
        }
    }
}
