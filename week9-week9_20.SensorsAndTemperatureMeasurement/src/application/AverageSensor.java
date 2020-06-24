/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando
 */
public class AverageSensor implements Sensor{
    
    private List<Sensor> listSensor;
    private List<Integer> listTemp;
    
    public AverageSensor(){
        this.listSensor = new ArrayList<Sensor>();
        this.listTemp = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional){
        listSensor.add(additional);
    }
    
    public List<Integer> readings(){
        return this.listTemp;
    }

    @Override
    public boolean isOn() {
        for(Sensor s: listSensor){
            if(!s.isOn()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for(Sensor s : listSensor){
            s.on();
        }
    }

    @Override
    public void off() {
        for(Sensor s : listSensor){
            s.off();
        }
    }

    @Override
    public int measure() {
        int average = 0;
        
        if(listSensor.isEmpty() || !this.isOn()){
            throw new IllegalStateException();
        }
        for(Sensor s: listSensor){
            average += s.measure();
        }
        average = average/listSensor.size();
        listTemp.add(average);
        
        return average;
    }
}
