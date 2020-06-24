/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando
 */
public class Farm implements Alive{
    
    private String owner;
    private Barn barn;
    private List<Cow> cows;
    
    public Farm(String owner, Barn barn){
        this.owner = owner;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }
    
    public String getOwner(){
        return this.owner;
    }
    
    public void addCow(Cow cow){
        cows.add(cow);
    }
    
    public void manageCows(){
        barn.takeCareOf(cows);
    }
    
    public void installMilkingRobot(MilkingRobot mlk){
        this.barn.installMilkingRobot(mlk);
    }

    @Override
    public void liveHour() {
        for(Cow c : cows){
            c.liveHour();
        }
    }
    
    @Override
    public String toString(){
        String aDev = "";
        aDev = "Farm owner: " + this.owner + "\nBarn bulk tank: " + this.barn.getBulkTank();
        
        if(this.cows.isEmpty()){
            aDev += "\nNo cows.";
        }else{
            aDev += "\nAnimals:\n";
            for(Cow c : this.cows){
                aDev += "        " + c;
            }
        }
        
        return aDev;
    }
}
