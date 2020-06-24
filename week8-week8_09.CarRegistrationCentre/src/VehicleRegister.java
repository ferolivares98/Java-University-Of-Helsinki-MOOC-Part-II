
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        owners = new HashMap<RegistrationPlate, String>();    
    }
    
    public boolean add(RegistrationPlate plate, String owner){
        if(owners.get(plate) == null){
            owners.put(plate, owner);
            return true;
        }
        
        return false;
    }
    
    
    public String get(RegistrationPlate plate){
        if(owners.get(plate) == null){
            return null;
        }
        
        return owners.get(plate);
    }
    
    public boolean delete(RegistrationPlate plate){
        if(owners.get(plate) == null){
            return false;
        }
        
        owners.remove(plate);
        return true;
    }
    
    public void printRegistrationPlates(){
        for(RegistrationPlate p : owners.keySet()){
            System.out.println(p.toString());
        }
    }
    
    public void printOwners(){
        ArrayList<String> printed = new ArrayList<String>();
        for (String o : owners.values()) {
            if (!printed.contains(o)) {
                System.out.println(o);
                printed.add(o);
            }
        }
    }
}
