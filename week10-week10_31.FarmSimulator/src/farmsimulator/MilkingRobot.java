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
public class MilkingRobot {
    
    private BulkTank tank;
    
    public MilkingRobot(){
        tank = null;
    }
    
    public BulkTank getBulkTank(){
        return this.tank;
    }
    
    public void setBulkTank(BulkTank tank){
        this.tank = tank;
    }
    
    public void milk(Milkable milkable){
        if(this.tank == null){
            throw new IllegalStateException("The milking robot hasn't been installed.");
        }
        
        this.tank.addToTank(milkable.milk());
    }
}
