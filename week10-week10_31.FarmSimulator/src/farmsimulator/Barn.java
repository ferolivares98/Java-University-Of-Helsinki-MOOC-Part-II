/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author fernando
 */
public class Barn {
    
    private BulkTank tank;
    private MilkingRobot mlk;
    
    public Barn(BulkTank tank){
        this.tank = tank;
        this.mlk = null;
    }
    
    public BulkTank getBulkTank(){
        return this.tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.mlk = milkingRobot;
        this.mlk.setBulkTank(tank); //Asignar robot a tanque o falla.
    }
    
    public void takeCareOf(Cow cow){
        if(mlk == null){
            throw new IllegalStateException("Milking robot not installed.");
        }
        this.mlk.milk(cow);
    }
    
    public void takeCareOf(Collection<Cow> cows){
        if(mlk == null){
            throw new IllegalStateException("Milking robot not installed.");
        }
        for(Cow c : cows){
            this.mlk.milk(c);
        }
    }
    
    @Override
    public String toString(){
        return Math.ceil(this.tank.getVolume()) + "/" + this.tank.getCapacity();
    }
    
}
