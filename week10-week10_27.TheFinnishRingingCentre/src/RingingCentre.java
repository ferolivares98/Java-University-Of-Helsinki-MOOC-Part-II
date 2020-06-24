
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class RingingCentre {
    
    private Map<Bird, List<String>> obsPlaces;
    
    public RingingCentre(){
        this.obsPlaces = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place){
        if(!obsPlaces.containsKey(bird)){
            obsPlaces.put(bird, new ArrayList<String>()); //Por aqui pasan todos la primera vez.
        }
        obsPlaces.get(bird).add(place);
    }
    
    public void observations(Bird bird){
        System.out.print(bird + " observations: ");
        if(!obsPlaces.containsKey(bird)){
            System.out.println("0");
        }else{
            System.out.println(obsPlaces.get(bird).size());
            for(String s : obsPlaces.get(bird)){
                System.out.println(s);
            }
        }
    }
}
